package lk.sliit.customerservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static lk.sliit.customerservice.constants.DatabaseConstant.*;


public class DatabaseHandler extends PropertyHandler {
    private static DatabaseHandler handler;
    private Connection connection;


    private DatabaseHandler() {
        super();
    }

    public static DatabaseHandler getInstance() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }

    public Connection open() throws SQLException, ClassNotFoundException {

        if (connection == null) {
            Class.forName(properties.getProperty(DATABASE_DRIVER_NAME));
            connection = DriverManager.getConnection(properties.getProperty(DATABASE_URL), properties.getProperty(DATABASE_USERNAME), properties.getProperty(DATABASE_PASSWORD));
        }
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
        connection = null;
    }
}
