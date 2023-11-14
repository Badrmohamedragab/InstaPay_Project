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
            System.out.print("""
                    Choose your process
                    1- Register
                    2- Login
                    ->""");

            Scanner scanner = new Scanner(System.in);
            int option = Integer.parseInt(scanner.nextLine());

            if (option == 1) {
                System.out.print("""
                        Choose method to register
                        1- Wallet
                        2- Bank
                        ->""");
                Registration registration = null;
                do {
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 -> registration = new RegisterUsingWalletAccount();
                        case 2 -> registration = new RegisterUsingBankAccount();
                        default -> System.out.println("Invalid Input");
                    }
                }
                while (option != 1 && option != 2);
                user = new User(registration.register());
            } else if (option == 2) {
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
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    TransferTo transferTo = new TransferToWallet();
                    System.out.print("Enter Mobile Number that You want to transfer to\n->");
                    String mobile = scanner.nextLine();
                    System.out.print("Enter amount that You want to transfer it\n->");
                    double amount = Double.parseDouble(scanner.nextLine());
                    transferTo.transfer(user, mobile, amount);
                }
                case 2 -> {
                    System.out.print("Enter User Name that You want to transfer to\n->");
                    String UserName = scanner.nextLine();
                    System.out.print("Enter the amount which you want to transfer\n->");
                    double amount = Double.parseDouble(scanner.nextLine());

                    if (DBHandle.ifUserExist(UserName)) {
                        if (DBHandle.getProvider(UserName).contains("Bank")) {
                            TransferToInstapayAccount transferToInstapayAccount = new TransferToBankAccount();
                            transferToInstapayAccount.transfer(user, DBHandle.loadUser(UserName), amount);
                        } else {
                            TransferToInstapayAccount transferToInstapayAccount = new TransferToWalletAccount();
                            transferToInstapayAccount.transfer(user, DBHandle.loadUser(UserName), amount);
                        }
                    } else {
                        System.out.println("The userName doesn't exist");
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
                    int select = Integer.parseInt(scanner.nextLine());

                    switch (select) {
                        case 1 -> {
                            Bill bill = new Gas(3, 100, "126341", new Date(), PaymentStatus.PENDING);
                            BillPayment.payBill(bill, user);
                        }
                        case 2 -> {
                            Bill bill = new Water(3, 500, "125648", new Date(), PaymentStatus.PAYED);
                            BillPayment.payBill(bill, user);
                        }
                        case 3 -> {
                            Bill bill = new Electricity(8, 250, "8425025", new Date(), PaymentStatus.PENDING);
                            BillPayment.payBill(bill, user);
                        }
                    }
                }
                case 5 -> {
                    break Here;
                }
                default -> System.out.println("Invalid Option");
            }
        }
    }
}