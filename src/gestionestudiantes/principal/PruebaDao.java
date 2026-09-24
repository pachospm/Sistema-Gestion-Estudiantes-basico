/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionestudiantes.principal;

import gestionestudiantes.dao.EstudianteDAO;
import gestionestudiantes.dao.EstudianteDAOImpl;
import gestionestudiantes.modelo.Estudiante;
import java.sql.SQLException;

/**
 *
 * @author fsamaca
 */
public class PruebaDao {
    
    public static void main(String[] args) {
        EstudianteDAO estudianteDAO = new EstudianteDAOImpl();
        Estudiante estudiante = new Estudiante(
                0,
                "1089121004",
                "Francisco",
                "Samaca",
                "fsamaca@unisalle.edu.co",
                "Ingeniería de software",
                3
        );
        
        try{
            boolean registrado = estudianteDAO.insertar(estudiante);
            System.out.println("Registrado: " + registrado);
            for(Estudiante item : estudianteDAO.listar()){
                System.out.println(item);
            }
        }catch(SQLException e){
            System.out.println("ERROR" + e.getMessage());
        }
    }
    
}
