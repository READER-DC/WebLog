package kyiv.sehal.util;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class DBConnection {
    public static String user = "root";
    public static String psw = "root";
    public static String url = "jdbc:postgresql://localhost:5432/db1";

    public Connection connection() throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,psw);
        System.out.println("Connected to DB access");
        return connection;
    }

}
