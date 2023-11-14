package InstapaySystem;
import Bills.*;
import DataBase.DBHandle;
import DataBase.ListDB;
import Transfer.*;
import User.*;

import java.util.Date;
import java.util.Scanner;

import UserAuthentication.*;

public class InstapaySystem {
    public static void main(String[] args) {
        DBHandle.setDB(new ListDB());
        System.out.println("============== welcome ==============");
        User user = null;

        while (user == null) {
            System.out.println("""
                    Choose your process
                    1- Register
                    2- Login
                    ->""");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            if (option == 1) {
                user = RegisterHandle.register();
            } else if (option == 2) {
                System.out.println("Enter your userName\n->");
                String userName = scanner.nextLine();
                System.out.println("Enter your password\n->");
                String password = scanner.nextLine();

                user = LoginHandle.login(userName, password);
                if (user == null) {
                    System.out.println("User Name or Password are incorrect");
                } else {
                    System.out.println(userName + " Login Successfully");
                    while (true) {
                        System.out.println("============== Choose Option ==============");
                        System.out.println(
                                """
                                        1. Transfer to Wallet using the mobile number
                                        2. Transfer to Another instapay account
                                        3. Inquire about his balance
                                        4. Pay bills
                                        5. exist""");
                        option = scanner.nextInt();

                        switch (option) {
                            case 1 -> {
                                TransferTo transferTo = new TransferToWallet();
                                System.out.print("Enter Mobile Number that You want to transfer to\n->");
                                String mobile = scanner.nextLine();
                                System.out.print("Enter amount that You want to transfer it\n->");
                                double amount = scanner.nextInt();
                                transferTo.transfer(user, mobile, amount);

                            }
                            case 2 -> {
                                System.out.print("Enter User Name that You want to transfer to\n->");
                                String UserName = scanner.nextLine();
                                System.out.print("Enter the amount which you want to transfer\n->");
                                double amount = scanner.nextInt();
                                if (DBHandle.ifUserExist(UserName)) {
                                    if (DBHandle.getProvider(userName).contains("Bank")) {
                                        TransferToInstapayAccount transferToInstapayAccount = new TransferToBankAccount();

                                        transferToInstapayAccount.transfer(user, DBHandle.loadUser(UserName), amount);
                                    } else {
                                        TransferToInstapayAccount transferToInstapayAccount = new TransferToWalletAccount();

                                        transferToInstapayAccount.transfer(user, DBHandle.loadUser(UserName), amount);
                                    }
                                }
                            }
                            case 3 -> System.out.println("Your balance is " + user.getAccount().getBalance());

                            case 4 -> {
                                System.out.print("""
                                        Select the type of the bill
                                        1- Gas
                                        2- Water
                                        3- Electricity
                                        ->""");
                                int select = scanner.nextInt() ;

                                switch (select) {
                                    case 1 -> {
                                        Bill bill = new Gas(3, 100, "126341", new Date(), PaymentStatus.PENDING);
                                        bill.showBill();
                                        BillPayment.payBill(bill, user);
                                    }
                                    case 2 -> {
                                        Bill bill = new Water(3, 500, "125648", new Date(), PaymentStatus.PAYED);
                                        bill.showBill();
                                        BillPayment.payBill(bill, user);

                                    }
                                    case 3 -> {
                                        Bill bill = new Electricity(8, 250, "8425025", new Date(), PaymentStatus.PENDING);
                                        bill.showBill();
                                        BillPayment.payBill(bill, user);
                                    }
                                }
                            }
                            default -> System.out.println("Invalid Option");
                        }
                    }
                }
            }
        }
    }
}
