/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author goryc
 */
public class JohariDatabase {

    public ArrayList<String> getArena(String id_johari_window) {
        ArrayList<String> arena_traits = new ArrayList();

        try {

            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();

            // Create a SQL query to insert data into demo table
            PreparedStatement st = con.prepareStatement("SELECT distinct owner_table.adjective FROM owner_table join partner_table on id_johari_window_1=id_johari_window_2 where id_johari_window_1= ? and owner_table.adjective=partner_table.adjective;");

            st.setString(1, id_johari_window);

            // Execute the insert command using executeUpdate()
            // to make changes in database
            ResultSet rs = st.executeQuery();

            System.out.println("Arena: ");
            while (rs.next()) {
                arena_traits.add(rs.getString("adjective"));

                System.out.println(rs.getString("adjective"));
            }

            // Close all the connections
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error happend: " + e.getMessage());
        }

        return arena_traits;
    }

    public ArrayList<String> getFacade(String id_johari_window) {
        ArrayList<String> facade_traits = new ArrayList();

        try {

            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();

            // Create a SQL query to insert data into demo table
            PreparedStatement st = con.prepareStatement("SELECT distinct owner_table.adjective FROM owner_table join partner_table on id_johari_window_1=id_johari_window_2 where id_johari_window_1= ? and owner_table.adjective not in (SELECT distinct partner_table.adjective FROM partner_table join owner_table on id_johari_window_1=id_johari_window_2 where id_johari_window_1= ?);");

            st.setString(1, id_johari_window);
            st.setString(2, id_johari_window);

            // Execute the insert command using executeUpdate()
            // to make changes in database
            ResultSet rs = st.executeQuery();

            System.out.println("Facade: ");
            while (rs.next()) {
                facade_traits.add(rs.getString("adjective"));
                System.out.println(rs.getString("adjective"));
            }

            // Close all the connections
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error happend: " + e.getMessage());
        }

        return facade_traits;
    }

    public ArrayList<String> getBlindspot(String id_johari_window) {
        ArrayList<String> blindspot_traits = new ArrayList();

        try {

            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();

            // Create a SQL query to insert data into demo table
            PreparedStatement st = con.prepareStatement("SELECT distinct partner_table.adjective FROM partner_table join owner_table on id_johari_window_1=id_johari_window_2 where id_johari_window_1= ? and partner_table.adjective not in (SELECT distinct owner_table.adjective FROM owner_table join partner_table on id_johari_window_1=id_johari_window_2 where id_johari_window_1= ?); ");

            st.setString(1, id_johari_window);
            st.setString(2, id_johari_window);

            // Execute the insert command using executeUpdate()
            // to make changes in database
            ResultSet rs = st.executeQuery();

            System.out.println("Blindspot: ");
            while (rs.next()) {
                blindspot_traits.add(rs.getString("adjective"));

                System.out.println(rs.getString("adjective"));
            }

            // Close all the connections
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error happend: " + e.getMessage());
        }

        return blindspot_traits;
    }

    public int getUnknownAmount(String id_johari_window) {
        String unknown_amount_string = null;
        int unknown_amount = 0;

        try {

            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();

            // Create a SQL query to insert data into demo table
            PreparedStatement st = con.prepareStatement("SELECT count(*) as sum_of_traits from (SELECT distinct owner_table.adjective FROM owner_table join partner_table on id_johari_window_1=id_johari_window_2 where id_johari_window_1= ? union SELECT distinct partner_table.adjective FROM partner_table join owner_table on id_johari_window_1=id_johari_window_2 where id_johari_window_1= ? ) number_of_rows;  ");

            st.setString(1, id_johari_window);
            st.setString(2, id_johari_window);

            // Execute the insert command using executeUpdate()
            // to make changes in database
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                unknown_amount_string = rs.getString("sum_of_traits");
                System.out.println("Sum of unknown: ");
                System.out.println(rs.getString("sum_of_traits"));
            }
            
            unknown_amount = Integer.getInteger(unknown_amount_string);

            // Close all the connections
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error happend: " + e.getMessage());
        }

        

        return unknown_amount;
    }

}
