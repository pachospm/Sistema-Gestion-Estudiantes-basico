/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionestudiantes.dao;

import gestionestudiantes.modelo.Estudiante;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fsamaca
 */
public interface EstudianteDAO {
    
    //Declarar una operacion para insertar estudiantes
    boolean insertar(Estudiante estudiante) throws SQLException;
    //Declaramos una operacion para consultar todos los estudiantes
    List<Estudiante> listar() throws SQLException;
    //Declaramos una operacion para buscar por documento
    Estudiante buscarPorDocumento(String documento) throws SQLException;
    //Declaramos una operacion para modificar estudiantes
    boolean actualizar(Estudiante estudiante) throws SQLException;
    //Declaramos una operacion para eliminar estudiantes
    boolean eliminar(int id) throws SQLException;
}
