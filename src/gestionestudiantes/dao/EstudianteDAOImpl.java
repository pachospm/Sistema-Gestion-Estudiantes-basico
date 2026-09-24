/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionestudiantes.dao;

import gestionestudiantes.conexion.Conexion;
import gestionestudiantes.modelo.Estudiante;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author fsamaca
 */
public class EstudianteDAOImpl implements EstudianteDAO{

    @Override
    public boolean insertar(Estudiante estudiante) throws SQLException {
        // Cremaos la instrucción SQL
        // Los sigenos ? serán reemplazados posteriormente
        String sql = "INSERT INTO estudiantes" 
                + "(documento, nombre, apellido, correo, programa, semestre)"
                + "VALUES (?,?,?,?,?,?)";
        // Utilizar un try-with-resources
        // java cerrará automaticamente los recursos al finalizar
        try(
            Connection conexion = Conexion.getInstancia().conectar();
            //Prepara la sentencia SQL
            PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            ps.setString(1, estudiante.getDocumento());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getApellido());
            ps.setString(4, estudiante.getCorreo());
            ps.setString(5, estudiante.getPrograma());
            ps.setInt(6, estudiante.getSemestre());
            
            // Ejecutamos el ISNERT.
            // executeUpdate retorna cuantas filas fueron afectadas
            int filasAfectadas = ps.executeUpdate();
            // Si se afectó por lo menos una fila, retornamos true.
            return filasAfectadas > 0;
        }
    }

    @Override
    public List<Estudiante> listar() throws SQLException {
        List<Estudiante> estudiantes = new ArrayList<>();
        //Creamos consulta SQL SELECT
        String sql = "SELECT id,documento,nombre,apellido,correo,programa,semestre FROM estudiantes ORDER BY id DESC";
        try(
            Connection conexion = Conexion.getInstancia().conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ){
            while(rs.next()){
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setDocumento(rs.getString("documento"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setCorreo(rs.getString("correo"));
                estudiante.setPrograma(rs.getString("programa"));
                estudiante.setSemestre(rs.getInt("semestre"));
                estudiantes.add(estudiante);
            }
        }
        return estudiantes;
    }

    @Override
    public Estudiante buscarPorDocumento(String documento) throws SQLException {
        // Creamos una consulta parametrizada
        String sql = "SELECT id, documento, nombre, apellido, "
                     + "correo, programa, semestre"
                     + "FROM estudiantes WHERE documento = ?";
        // Abrimos conexión y PreparedStatement
        try(
            Connection conexion = Conexion.getInstancia().conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            ps.setString(1, documento);
            
            // Ejecutamos el SELECT
            try( ResultSet rs = ps.executeQuery()){
                // rs.next() retorna true si existe un resultado
                if(rs.next()){
                    Estudiante estudiante = new Estudiante(
                            rs.getInt("id"),
                            rs.getString("documento"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("correo"),
                            rs.getString("programa"),
                            rs.getInt("Semestre")
                    );
                    // Retornamos el estudiante encontrado
                    return estudiante;
                }
            }
        }
        return null;
    }

    @Override
    public boolean actualizar(Estudiante estudiante) throws SQLException {
        String sql = "UPDATE estudiantes "
                    + "SET docuento = ?, "
                    + "nombre = ?, apellido = ?, correo = ?, programa = ?"
                    + "semestre = ? WHERE id = ?";
        
        // Abrimos nuestros recursos JDBC
        try(
            Connection conexion = Conexion.getInstancia().conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            ps.setString(1, estudiante.getDocumento());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getApellido());
            ps.setString(4, estudiante.getCorreo());
            ps.setString(5, estudiante.getPrograma());
            ps.setInt(6, estudiante.getSemestre());
            ps.setInt(7, estudiante.getId());
            
            int filasAfectadas = ps.executeUpdate();
            // retornamos true si se modifica alguna fila
            return filasAfectadas > 0;
        }
    }

    @Override
    public boolean eliminar(int id) throws SQLException {
        
        String sql = "DELETE FROM estudiantes WHERE id = ?";
        
        try(
            Connection conexion = Conexion.getInstancia().conectar();
            PreparedStatement ps = conexion.prepareStatement(sql);
        ){
            // Asignamos el identificador
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        }
    }
    
    
    
}
