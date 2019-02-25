package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final static String path = "jdbc:mysql://danit.cukm9c6zpjo8.us-west-2.rds.amazonaws.com:3306/fs5";
    private final static String user = "fs5_user";
    private final static String pass = "bArceloNa";
    private Connection connection;

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(path, user, pass);
    }

    public Connection connection() {
        if (connection == null) {
            try {
                connection = connect();
            } catch (SQLException e) {
                throw new IllegalStateException("Something wrong with connect", e);
            }
        }
        return this.connection;
    }
}
