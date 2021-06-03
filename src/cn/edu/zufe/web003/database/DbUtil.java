package cn.edu.zufe.web003.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    public static final String DRIVE_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
//    public static final String URL = "jdbc:mysql://localhost:3306/web001?useSSL=false";
    public static final String URL = "jdbc:mysql://localhost:3306/db_180110910723?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Aa09170314";

    static{
        try {
            Class.forName(DRIVE_CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void main (String[] args) throws SQLException{
        System.out.println(DbUtil.getConnection());
    }
}
