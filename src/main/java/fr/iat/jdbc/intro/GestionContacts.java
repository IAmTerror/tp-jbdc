package fr.iat.jdbc.intro;

import java.sql.*;
import java.util.Properties;

/**
 * Projet jdbctuto
 * Pour LAERCE SAS
 * <p>
 * Créé le  04/12/2017.
 *
 * @author fred
 * @author student : IAmTerror
 */
public class GestionContacts {
    private Connection conn;
    private void loadDriver(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Impossible de charger le driver PosgreSQL");
            System.exit(1);
        }

    }

    private void openConnection(){
        Properties props = new Properties();
        String url = "jdbc:postgresql://192.168.99.100/exemple";
        props.setProperty("user","postgres");
        props.setProperty("password","secret");
        try {
            this.conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Base exemple indiponible");
            System.exit(2);
        }
    }

    public void run(){
        loadDriver();
        openConnection();
        try {

            Statement stm = conn.createStatement();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
