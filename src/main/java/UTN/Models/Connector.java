package UTN.Models;

import java.sql.*;

public class Connector {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_HOST = "//192.168.64.2/";
    static final String DB_NAME = "labvtp1";
    static final String DB_USER = "admin";
    static final String DB_PASS = "1234";

    private Connection connection;
    private Statement st;

    public Connector(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection("jdbc:mariadb:"+ DB_HOST + DB_NAME, DB_USER, DB_PASS);
            this.st = this.connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
