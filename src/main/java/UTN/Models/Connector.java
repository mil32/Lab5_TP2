package UTN.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connector {

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_HOST = "//192.168.64.2/";
    static final String DB_NAME = "ahorcado";
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

    public List<String> getWords(){
        List<String> words = new ArrayList<>();
        String query = "select * from words";
        try {
            ResultSet rs = st.executeQuery(query);


            while(rs.next()) {
                words.add( rs.getString("word"));
            }

        } catch(SQLException e){
            e.printStackTrace();
        }

        return words;

    }

    public Integer save (String word, String name) {
        // fecha y hora lo inserta la base de datos antes de la insersion
        System.out.println("GUARDANDO... ");
        String query = "insert into log(word, winner) values('"+word+"', '"+name+"');";
        try {
            ResultSet rs = st.executeQuery(query);
            return 1;
        } catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }



}
