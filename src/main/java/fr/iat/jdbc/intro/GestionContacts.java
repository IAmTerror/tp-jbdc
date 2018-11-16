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

            // SELECT --------------------------------------------------------------------------------------------------
            Statement statement1 = conn.createStatement();
            ResultSet rs = statement1.executeQuery(
                    "select * from articles where art_coul = 'ROUGE'");
            while (rs.next()) {
                String articleNum  = rs.getString(1);
                String articleNom = rs.getString(2);
                String articleCouleur = rs.getString("art_coul");
                System.out.println(articleNum + " - " + articleNom + " - " + articleCouleur);
            }
            rs.close();
            statement1.close();
            System.out.println("\n");

            // INSERT --------------------------------------------------------------------------------------------------
//            Statement statement2 = conn.createStatement();
//            int nbInsert = statement2.executeUpdate(
//                    "INSERT INTO articles VALUES " +
//                            "('A16','HAND SPINNER','30.000', 'JAUNE', '100', '6', '12', 'F01', '2')");
//            System.out.println("Nombre d'insertions dans la BDD = " + nbInsert);
//            System.out.println("\n");
//            statement2.close();

            // DELETE --------------------------------------------------------------------------------------------------
//            Statement statement3 = conn.createStatement();
//            int nbDelete = statement3.executeUpdate(
//                    "DELETE from articles where art_num = 'A16'");
//            System.out.println("Nombre de suppressions dans la BDD = " + nbDelete);
//            System.out.println("\n");
//            statement3.close();

            // UPDATE --------------------------------------------------------------------------------------------------
//            Statement statement4 = conn.createStatement();
//            int nbUpdate = statement4.executeUpdate(
//                    "UPDATE articles set art_pv = art_pv / 1.2 where art_coul = 'ROUGE' ");
//            System.out.println("Nombre d'updates dans la BDD = " + nbUpdate);
//            statement4.close();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
