package DataBase;

import APIs.API;
import APIs.BankAPI;
import APIs.WalletAPI;
import Account.*;
import Provider.*;
import User.*;

import java.sql.*;
import java.util.List;
import java.util.Vector;

public class SQLite implements DBConnection {
    Connection connection = null;

    public void initializeDB() {
        String currentDir = java.lang.System.getProperty("user.dir");
        String url = "jdbc:sqlite:" + currentDir + "\\identifier.sqlite";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> fillUsersList() {
        List<User> users = new Vector<>();
        User retrievedUser = null;
        String getUser = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(getUser)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Account account = null;
                Provider provider = null;
                if (resultSet.getString("provider").contains("Wallet")) {
                    API api = new WalletAPI();
                    provider.setAPI(api);
                    if (resultSet.getString("provider").equals("EtisalatWallet")) {
                        provider = new EtisalatWallet();
                    } else if (resultSet.getString("provider").equals("VodafoneWallet")) {
                        provider = new VodafoneWallet();
                    }
                    account = new WalletAccount(resultSet.getDouble("balance"),
                            resultSet.getString("password"),
                            resultSet.getString("username"),
                            resultSet.getString("mobile_number"),
                            provider);

                } else if (resultSet.getString("provider").contains("Bank")) {
                    API api = new BankAPI();
                    provider.setAPI(api);
                    if (resultSet.getString("provider").equals("ElahlyBank")) {
                        provider = new EtisalatWallet();
                    } else if (resultSet.getString("provider").equals("MisrBank")) {
                        provider = new VodafoneWallet();
                    } else if (resultSet.getString("provider").equals("CIBBank")) {
                        provider = new CIBBank();
                    }
                    account = new BankAccount(resultSet.getDouble("balance"),
                            resultSet.getString("password"),
                            resultSet.getString("username"),
                            resultSet.getString("mobile_number"),
                            provider,
                            resultSet.getString("accountNumber")
                    );

                }

                retrievedUser = new User(
                        account
                );
                users.add(retrievedUser);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean ifUserExist(String userName) {
        User retrievedUser = null;
        String getUser = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(getUser)) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void increaseBalance(User user, double amount) {
        String updateUserBalance = "update users set balance=balance + ? where username = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateUserBalance)) {
            statement.setDouble(1, amount);
            statement.setString(2, user.getUsername());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void decreaseBalance(User user, double amount) {
        String updateUserBalance = "update users set balance = balance + ? where username=?";
        try (PreparedStatement statement = connection.prepareStatement(updateUserBalance)) {
            statement.setDouble(1, amount);
            statement.setString(2, user.getUsername());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isWalletExist(String mobileNumber) {

        String isWalletExist = "select * from walletUsers where mobileNumber=?";
        try (PreparedStatement statement = connection.prepareStatement(isWalletExist)) {
            statement.setString(1, mobileNumber);
            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean ifMobileNumberLocateToAccount(String accountNumber, String mobileNumber) {

        String isWalletExist = "select * from users where accountNumber=? and mobileNumber=?";
        try (PreparedStatement statement = connection.prepareStatement(isWalletExist)) {
            statement.setString(1, accountNumber);
            statement.setString(2, mobileNumber);
            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean ifPasswordCorrect(String userName, String Password) {

        String isWalletExist = "select * from users where username=? and password=?";
        try (PreparedStatement statement = connection.prepareStatement(isWalletExist)) {
            statement.setString(1, userName);
            statement.setString(2, Password);
            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void addUser(User user) {
        String insertUser = "insert into users (username, mobile_number, balance, password, provider, account_number) values(?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(insertUser)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getMobileNumber());
            statement.setDouble(3, user.getBalance());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getProvider());
            statement.setString(6, user.accountNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User loadUser(String userName) {
        User retrievedUser = null;
        String getUser = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(getUser)) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                retrievedUser = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getDouble("balance"),
                        resultSet.getString("mobile_number")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return retrievedUser;
    }

}
