package UserAuthentication;
import APIs.*;
import DataBase.DBHandle;
import User.User;
import Account.*;
import Provider.*;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *<pre>
 *This class {@code register} its role is register the user
 *</pre>
 * <blockquote></blockquote>
 * @author <strong style="color:'white'"> Mohamed Amir</strong>
 * @version  <strong style="color:'white'"> 1.0</strong>
 */
public class RegisterHandle {

	/**
	 *<pre>
	 *This method {@code register} its role is register the user
	 *it has 3 parts
	 *		1- <strong style="color:'white'"> Provider</strong>
	 *			It handle the provider which user want to select
	 *		2- 	<strong style="color:'white'"> Checking</strong>
	 *			It handle checking the information {@code mobile Number}
	 *			and {@code Account Bank} in the provider
	 *		3- 	<strong style="color:'white'"> Username and Password</strong>
	 *			It handle the {@code userName} of user to be unique
	 *			and the {@code password} of the user to be strong
	 *</pre>
	 * @return User <strong style="color:'white'"> The registered user</strong>
	 */
	public static User register() {
		System.out.println("================= Register Stage =================");
		Scanner scanner = new Scanner(System.in) ;
		String input ;
		boolean bankAccount = false ;
		Account account = null ;

		// Provider part
		{
			Provider provider;

			System.out.print("""
                    Choose method to register
                    1- Wallet
                    2- Bank
                    ->""");

			int choice = scanner.nextInt() ;
			while (choice != 2 && choice != 1){
				System.err.print("wrong choice\n->");
				choice = scanner.nextInt() ;
			}

			if (choice == 1){
				System.out.print("""
                    Choose method to register
                    1- Etisalat
                    2- Vodafone
                    ->""");

				choice = scanner.nextInt() ;

				while (choice != 2 && choice != 1){
					System.err.print("wrong choice\n->");
					choice = scanner.nextInt() ;
				}

				if (choice == 1){
					provider = new EtisalatWallet() ;
				}
				else{
					provider = new VodafoneWallet() ;
				}

				account = new WalletAccount() ;
				provider.setAPI(new WalletAPI());
				account.setProvider(provider);
			}
			else {
				System.out.print("""
                    Choose method to register
                    1- Masr Bank
                    2- Elahly Bank
                    3- CIB Bank
                    ->""");

				choice = scanner.nextInt() ;

				while (choice != 2 && choice != 1 && choice != 3){
					System.err.print("wrong choice\n->");
					choice = scanner.nextInt() ;
				}

				if (choice == 1){
					provider = new MasrBank() ;
				}
				else if (choice == 2){
					provider = new ElahlyBank() ;
				}
				else{
					provider = new CIBBank() ;
				}

				account = new BankAccount() ;
				provider.setAPI(new BankAPI());
				account.setProvider(provider);
				bankAccount = true;
			}
		}

		// Check its provider part
		{
			System.out.print("Type your mobile number\n->");
			input = scanner.nextLine() ;
			account.setMobileNumber(input);

			if (bankAccount){
				System.out.print("Type your account number\n->");
				input = scanner.nextLine() ;
				account.setAccountNumber(input);
			}

			if(!account.getProvider().getAPI().validate(new User(account)) && !bankAccount){
				System.err.println("Your mobile doesn't exist in the wallet provider");
				return null;
			} else if (!account.getProvider().getAPI().validate(new User(account))) {
				System.err.println("Your mobile or account number doesn't exist in the bank provider");
				return null;
			}
		}

		// Username and Password part
		{
			System.out.print("Type your user name\n->");
			input = scanner.nextLine();

			// if exist try again
			while(DBHandle.ifUserExist(input)){
				System.out.print("The Username is token\nType your user name\n->");
				input = scanner.nextLine();
			}
			account.setUserName(input);

			System.out.print("Type strong password\n->");
			input = scanner.nextLine();
			Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

			while (!pattern.matcher(input).find()) {
				System.err.print("week password\nType strong password\n->");
				input = scanner.nextLine();
			}
			account.setPassword(input);
		}

		account.setBalance(0);
		User user = new User(account) ;
		DBHandle.addUser(user);
		return user ;
	}
}