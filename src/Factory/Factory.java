package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    public static Connection getConnection() {
        try {
            final String url = "jdbc:mysql://localhost:3306/client?verifyServerCertificate=false&useSSL=true";
            final String user = "developer";
            final String password = "31415926";

            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
