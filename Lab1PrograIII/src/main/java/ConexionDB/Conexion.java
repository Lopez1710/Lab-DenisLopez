/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dead1
 */
public class Conexion {
    public static Connection Con=null;
    public Connection getCon(){
        try {
            String url="jdbc:mysql://localhost:3306/lab";
            String user="Lopez";
            String password = "root";
            
            Con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error"+e.toString());
        }
        return Con;
    }
}
