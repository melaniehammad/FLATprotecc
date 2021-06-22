/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.de.frauas.progex.flatprotecc;

import java.sql.*;

/**
 *
 * 
 */
public class Connect2DB {
    
    public Connection StartConnection () 
    {
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flat_protecc?user=root&password=ADshYWri9F&useLegacyDatetimeCode=false&serverTimezone=UTC");
            if(conn!=null){
                System.out.println("Verbindung war erfolgreich!");
            }
            return conn;
        }
        catch (SQLException ex) 
        {
            System.out.println("Fehler in METHODS/Connect2DB/StartConnection");
            System.out.println("Auszug Fehlercode: " +ex);
            return null;
        }
    }
}
