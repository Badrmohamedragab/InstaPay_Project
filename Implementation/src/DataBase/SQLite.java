package DataBase;

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
		List<User> users=new Vector<>();
        User retrievedUser = null;
        String getUser = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(getUser)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Account account = null;
                Provider provider = null;
                if (resultSet.getString("provider").contains("Wallet")) {


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
    public User ifUserExist(String userName) {
        return null;
    }


}
