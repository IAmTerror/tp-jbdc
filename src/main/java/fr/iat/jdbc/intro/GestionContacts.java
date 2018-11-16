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

    private Connection con;

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
            this.con = DriverManager.getConnection(url, props);
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

            // SELECT --------------------------------------------------------------------------------------------------
            Statement statement1 = con.createStatement();
            ResultSet rs = statement1.executeQuery(
                    "select * from articles where art_coul = 'ROUGE'");
            while (rs.next()) {
                String articleNum  = rs.getString(1);
                String articleNom = rs.getString(2);
                String articleCouleur = rs.getString("art_coul");
                System.out.println(articleNum + " - " + articleNom + " - " + articleCouleur);
            }
            System.out.println("\n");

            // INSERT --------------------------------------------------------------------------------------------------
            Statement statement2 = con.createStatement();
            int nbMaj = statement2.executeUpdate(
                    "INSERT INTO articles VALUES " +
                            "('A16','HAND SPINNER','30.000', 'JAUNE', '100', '6', '12', 'F01', '2')");
            System.out.println("Nombre de mises à jour dans la BDD = " + nbMaj);
            System.out.println("\n");

            // DELETE --------------------------------------------------------------------------------------------------

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
