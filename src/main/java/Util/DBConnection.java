//package Util;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnection {
//    private static Connection connection;
//
//    private static final String URL = "jdbc:h2:tcp://localhost/~/h2s/AccountProfile";
//    private static final String USER = "";
//    private static final String PASS = "";
//
//    private DBConnection() {
//    }
//
//    public static Connection getConnection() throws SQLException {
//        if (connection == null) {
//            connection = DriverManager.getConnection(URL, USER, PASS);
//        }
//        return connection;
//    }
//}
