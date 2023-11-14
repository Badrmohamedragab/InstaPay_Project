package UserAuthentication;

import APIs.*;
import Account.*;
import DataBase.DBHandle;
import Provider.*;
import User.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterUsingWalletAccount implements Registration {

    @Override
    public Account register() {
        System.out.println("================= Register Stage =================");
        Scanner scanner = new Scanner(System.in);
        Account account = new WalletAccount();
        Provider provider;
        System.out.print("""
                Choose method to register
                1- Etisalat
                2- Vodafone
                ->""");
        int choice;
        choice = scanner.nextInt();

        while (choice != 2 && choice != 1) {
            System.err.print("wrong choice\n->");
            choice = scanner.nextInt();
        }

        if (choice == 1) {
            provider = new EtisalatWallet();
        } else {
            provider = new VodafoneWallet();
        }

        provider.setAPI(new WalletAPI());
        account.setProvider(provider);
        scanner.nextLine();
        String input;
        do {
            System.out.print("Type your mobile number\n->");
            input = scanner.nextLine();
            account.setMobileNumber(input);
            if (!account.getProvider().getAPI().validate(new User(account))) {
                System.out.println("Your Mobile number doesn't exist in the Wallet provider");
            }
        } while (!account.getProvider().getAPI().validate(new User(account)));


        String otp;
        String OTPInput;
        do {
            otp = account.getProvider().getAPI().sendOTP(account.getMobileNumber());
            System.out.print("\nEnter the OTP\n->");
            OTPInput = scanner.nextLine();

            if (!otp.equals(OTPInput)) {
                System.out.println("Invalid OTP");
            }
        } while (!otp.equals(OTPInput));

        System.out.print("Type your user name\n->");
        input = scanner.nextLine();

        // if exist try again
        while (DBHandle.ifUserExist(input)) {
            System.out.print("The Username is token\nType your user name\n->");
            input = scanner.nextLine();
        }
        account.setUserName(input);

        System.out.print("Type strong password\n->");
        input = scanner.nextLine();
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

        while (!pattern.matcher(input).find()) {
            System.out.print("week password\nType strong password\n->");
            input = scanner.nextLine();
        }
        account.setPassword(input);
        account.setBalance(0);
        User user = new User(account);
        DBHandle.addUser(user);
        return account;
    }
}