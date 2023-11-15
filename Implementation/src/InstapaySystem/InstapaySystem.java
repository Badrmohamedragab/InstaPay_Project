package InstapaySystem;
import Bills.*;
import DataBase.*;
import Transfer.*;
import User.*;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import UserAuthentication.*;

public class InstapaySystem {
    public static void main(String[] args) {
        DBHandle.setDB(new ListDB());
        System.out.println("============== welcome ==============");
        User user = null;

        while (user == null) {
            System.out.print("""
                    Choose your process
                    1- Register
                    2- Login
                    ->""");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            if (Objects.equals(option, "1")) {
                System.out.print("""
                        Choose method to register
                        1- Wallet
                        2- Bank
                        ->""");
                Registration registration = null;
                do {
                    option = scanner.nextLine();
                    switch (option) {
                        case "1" -> registration = new RegisterUsingWalletAccount();
                        case "2" -> registration = new RegisterUsingBankAccount();
                        default -> System.out.println("Invalid Input");
                    }
                }
                while (!option.equals("1") && !option.equals("2"));

                user = new User(registration.register());
            } else if (Objects.equals(option, "2")) {
                System.out.print("Enter your userName\n->");
                String userName = scanner.nextLine();
                System.out.print("Enter your password\n->");
                String password = scanner.nextLine();

                user = LoginHandle.login(userName, password);
            }
        }
        System.out.println(user.getAccount().getUserName() + " Login Successfully");

        Here:
        while (true) {
            System.out.println("============== Choose Option ==============");
            System.out.println(
                    """
                            1. Transfer to Wallet using the mobile number
                            2. Transfer to Another instapay account
                            3. Inquire about my balance
                            4. Pay bills
                            5. exist""");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> {
                    TransferTo transferTo = new TransferToWallet();
                    System.out.print("Enter Mobile Number that You want to transfer to\n->");
                    String mobile = scanner.nextLine();

                    System.out.print("Enter amount that You want to transfer it\n->");
                    String amount = scanner.nextLine();

                    while (!amount.matches("^[0-9]*$")){
                        System.out.print("Invalid number\nEnter amount that You want to transfer it\n->");
                        amount = scanner.nextLine();
                    }

                    transferTo.transfer(user, mobile, Double.parseDouble(amount));
                }
                case "2" -> {
                    System.out.print("Enter User Name that You want to transfer to\n->");
                    String UserName = scanner.nextLine();

                    System.out.print("Enter amount that You want to transfer it\n->");
                    String amount = scanner.nextLine();

                    while (!amount.matches("^[0-9]*$")){
                        System.out.print("Invalid number\nEnter amount that You want to transfer it\n->");
                        amount = scanner.nextLine();
                    }

                    if (DBHandle.ifUserExist(UserName)) {
                        if (DBHandle.getProvider(UserName).contains("Bank")) {
                            TransferToInstapayAccount transferToInstapayAccount = new TransferToBankAccount();
                            transferToInstapayAccount.transfer(user, DBHandle.loadUser(UserName), Double.parseDouble(amount));
                        } else {
                            TransferToInstapayAccount transferToInstapayAccount = new TransferToWalletAccount();
                            transferToInstapayAccount.transfer(user, DBHandle.loadUser(UserName), Double.parseDouble(amount));
                        }
                    } else {
                        System.out.println("The userName doesn't exist");
                    }
                }
                case "3" -> System.out.println("Your balance is " + user.getAccount().getBalance());

                case "4" -> {
                    String select;
                    do {
                        System.out.print("""
                                Select the type of the bill
                                1- Gas
                                2- Water
                                3- Electricity
                                ->""");
                        select = scanner.nextLine();

                        switch (select) {
                            case "1" -> {
                                Bill bill = new Gas("3", 100, "126341", new Date(), PaymentStatus.PENDING);
                                BillPayment.payBill(bill, user);
                            }
                            case "2" -> {
                                Bill bill = new Water("3", 500, "125648", new Date(), PaymentStatus.PAYED);
                                BillPayment.payBill(bill, user);
                            }
                            case "3" -> {
                                Bill bill = new Electricity("8", 250, "8425025", new Date(), PaymentStatus.PENDING);
                                BillPayment.payBill(bill, user);
                            }
                            default -> System.out.println("Invalid Option");
                        }
                    }while (!select.equals("1") && !select.equals("2") && !select.equals("3")) ;
                }
                case "5" -> {
                    break Here;
                }
                default -> System.out.println("Invalid Option");
            }
        }
    }
}