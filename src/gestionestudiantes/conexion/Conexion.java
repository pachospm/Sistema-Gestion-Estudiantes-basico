/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionestudiantes.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author OMEN
 */
public class Conexion {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/";
     private final String DB = "dbsistema";
    private final String USER = "root";
    private final String PASSWORD = "";
    
    // Declarar una variable que almacerá la única instancia de Conexion
    private static Conexion instancia;
    
    // Creamos un constructor privado
    // Al ser private ningua otra clase podrá escribir new Conexion()
    private Conexion(){
        
    }
    
    // Creamos un método público y estático para obtener la instacia.
    public static Conexion getInstancia(){
        // Verificamos si todavía no hemos creado una instancia
        if(instancia == null){
            // Creamos la isntancia únicamente la primera vez
            instancia = new Conexion();
        }
        return instancia;
    }
    
    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}
