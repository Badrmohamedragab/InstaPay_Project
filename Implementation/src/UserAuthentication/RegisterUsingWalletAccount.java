package UserAuthentication;
import APIs.*;
import Account.*;
import DataBase.DBHandle;
import Provider.*;
import User.User;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <pre>
 * This class {@code RegisterUsingWalletAccount} its role is register the user
 * by wallet account
 * </pre>
 * <blockquote></blockquote>
 *
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version <strong style="color:'white'"> 1.2</strong>
 */
public class RegisterUsingWalletAccount implements Registration {

    /**
     * <pre>
     * This method {@code register} its role is register the user
     * it has 3 parts
     * 		1- <strong style="color:'white'"> Provider</strong>
     * 			It handle the provider which user want to select
     * 		2- 	<strong style="color:'white'"> Checking</strong>
     * 			It handle checking the information {@code mobile Number}
     * 			and {@code Account Bank} in the provider
     * 		3- 	<strong style="color:'white'"> Username and Password</strong>
     * 			It handle the {@code userName} of user to be unique
     * 			and the {@code password} of the user to be strong
     * </pre>
     *
     * @return User <strong style="color:'white'"> The registered user</strong>
     */
    @Override
    public Account register() {
        System.out.println("================= Register Stage =================");
        Scanner scanner = new Scanner(System.in);
        WalletAccount account = new WalletAccount();
        Provider provider;
        System.out.print("""
                Choose method to register
                1- Etisalat
                2- Vodafone
                ->""");
        String choice;
        choice = scanner.nextLine();

        while (!Objects.equals(choice, "2") && !Objects.equals(choice, "1")) {
            System.err.print("wrong choice\n->");
            choice = scanner.nextLine();
        }

        if (choice.equals("1")) {
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