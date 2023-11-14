package UserAuthentication;
import APIs.*;
import DataBase.DBHandle;
import User.User;
import Account.*;
import Provider.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <pre>
 * This class {@code register} its role is register the user
 * </pre>
 * <blockquote></blockquote>
 *
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version <strong style="color:'white'"> 1.0</strong>
 */
public class RegisterUsingBankAccount implements Registration {

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
    public Account register() {
        System.out.println("================= Register Stage =================");
        Scanner scanner = new Scanner(System.in);
        String input;
        BankAccount account = new BankAccount();

        // Provider part
        {
            Provider provider;
            System.out.print("""
                    Choose method to register
                    1- Masr Bank
                    2- Elahly Bank
                    3- CIB Bank
                    ->""");

            int choice = scanner.nextInt();

            while (choice != 2 && choice != 1 && choice != 3) {
                System.err.print("wrong choice\n->");
                choice = scanner.nextInt();
            }

            if (choice == 1) {
                provider = new MasrBank();
            } else if (choice == 2) {
                provider = new ElahlyBank();
            } else {
                provider = new CIBBank();
            }

            provider.setAPI(new BankAPI());
            account.setProvider(provider);
        }

        // Check its provider part
        {
            scanner.nextLine();

            do {
                System.out.print("Type your mobile number\n->");
                input = scanner.nextLine();
                account.setMobileNumber(input);
                System.out.print("Type your account number\n->");
                input = scanner.nextLine();
                account.setAccountNumber(input);
                if (!account.getProvider().getAPI().validate(new User(account))) {
                    System.out.println("Your account number doesn't exist in the bank provider or doesn't related to the mobile number");
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
        }

        // Username and Password part
        {
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

        }

        account.setBalance(0);
        User user = new User(account);
        DBHandle.addUser(user);

        return account;
    }
}