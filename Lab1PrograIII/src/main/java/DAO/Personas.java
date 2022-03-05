/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionDB.Conexion;
import Entidades.Persona;
import com.mysql.cj.protocol.Resultset;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dead1
 */
public class Personas {
Conexion Con = new Conexion();
Connection Conexion = Con.getCon();

public ArrayList<Persona> ListadoPersonas (){
    ArrayList<Persona> listado = null;
    try {
        listado = new ArrayList<Persona>();
        CallableStatement cd = Conexion.prepareCall("Select * from contactos");
        ResultSet resultado = cd.executeQuery();
        
        while(resultado.next()){
        
            Persona p = new Persona();
            p.setId(resultado.getInt("Id"));
            p.setNombre(resultado.getString("Nombre"));
            p.setEdad(resultado.getInt("Edad"));
            p.setEmail(resultado.getString("Email"));
            p.setNumeroDeTelefono(resultado.getInt("NumeroDeTelefono"));
            listado.add(p);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "error "+e.toString());
    }
    return listado;
}

public void Agregar (Persona p){
    try {
        CallableStatement cd = Conexion.prepareCall("insert into contactos (Nombre,Edad,Email,NumeroDeTelefono)"+
                "value ('"+p.getNombre()+"','"+p.getEdad()+
                "','"+p.getEmail()+"','"+p.getNumeroDeTelefono()+"')");
          cd.execute();
         JOptionPane.showMessageDialog(null, "Contacto Agregado");
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "error "+e.toString());
    }
}

public void Actualizar(Persona p){

    try {
        CallableStatement cd = Conexion.prepareCall("Update contactos set "
                + "Nombre='"+p.getNombre()+"',Edad='"+p.getEdad()+"',"
                        + "Email='"+p.getEmail()+"',NumeroDeTelefono='"+p.getNumeroDeTelefono()+"'"
                                + "where Id='"+p.getId()+"'");
        cd.execute();
        JOptionPane.showMessageDialog(null,"Contacto Actualizado");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "error "+e.toString());
    }
}
public void Eliminar(Persona p){
try {
        CallableStatement cd = Conexion.prepareCall("delete from contactos where Id='"+p.getId()+"'");
        cd.execute();
        JOptionPane.showMessageDialog(null,"Contacto Eliminado");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "error "+e.toString());
    }
}
}
