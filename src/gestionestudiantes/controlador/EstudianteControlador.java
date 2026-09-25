/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionestudiantes.controlador;

import gestionestudiantes.dao.EstudianteDAO;
import gestionestudiantes.dao.EstudianteDAOImpl;
import gestionestudiantes.modelo.Estudiante;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fsamaca
 */
public class EstudianteControlador {
    //Declarmaos la dependencia hacia DAO
    private final EstudianteDAO estudianteDAO;
    
    public EstudianteControlador(){
        // Creamos la implementación concreta del DAO
        estudianteDAO = new EstudianteDAOImpl();
    }
    
    //Creamos el método encargado de registrar
    public boolean registrar(Estudiante estudiante)throws SQLException{
        //Validamos primero los datos
        validarEstudiante(estudiante);
        //Buscamos si ya existe el documento
        Estudiante encontrado = estudianteDAO.buscarPorDocumento(estudiante.getDocumento());
        if(encontrado != null){
            throw new IllegalArgumentException("Ya existe un estudiante con ese documento");
        }
        return estudianteDAO.insertar(estudiante);
    }
    
    // Creamos método para listar
    public List<Estudiante> listar() throws SQLException{
        return estudianteDAO.listar();
    }
    
    public Estudiante buscar(String documento) throws SQLException{
        if(documento == null){
            throw new IllegalArgumentException("Debe ingresar un documento");
        }
        
        //Eliminamos espacios laterales
        documento = documento.trim();
        
        if(documento.isEmpty()){
            throw new IllegalArgumentException("Debe ingresar un documento");
        }
        
        return estudianteDAO.buscarPorDocumento(documento);
    }
    
    // Creamos método actulizar
    public boolean actualizar(Estudiante estudiante) throws SQLException{
        //Validamos los datos
        validarEstudiante(estudiante);
        //Validamos que exista un identificador
        if(estudiante.getId() <= 0){
            throw new IllegalArgumentException("Debe seleccionar un estudiante");
        }
        Estudiante existente = estudianteDAO.buscarPorDocumento(estudiante.getDocumento());
        
        //Comprobamos si pertenece a otro estudiante
        if(existente != null && existente.getId() != estudiante.getId()){
            throw new IllegalArgumentException("El documento ya pertenece a otro estudiante");
        }
        return estudianteDAO.actualizar(estudiante);
    }
    
    public boolean eliminar(int id) throws SQLException{
        if(id <= 0){
            throw new IllegalArgumentException("Debe seleccionar un estudiante");
        }
        
        return estudianteDAO.eliminar(id);
    }
    
    private void validarEstudiante( Estudiante estudiante){
        //Validamos el documento
        if(estudiante.getDocumento() == null || estudiante.getDocumento().trim().isEmpty()){
            throw new IllegalArgumentException("El documento es obligatorio");
        }
        
        // Validamos el nombre
        if(estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()){
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        
        // Validamos el apellido
         if(estudiante.getApellido() == null || estudiante.getApellido().trim().isEmpty()){
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
         
         // validamos el correo
         if(estudiante.getCorreo()== null || estudiante.getCorreo().trim().isEmpty()){
            throw new IllegalArgumentException("El correo es obligatorio");
        }
        
        if(!estudiante.getCorreo().contains("@")){
            throw new IllegalArgumentException("El correo no tiene un formato valido");
        }
        
        // Validamos programa
        if(estudiante.getPrograma()== null || estudiante.getPrograma().trim().isEmpty()){
            throw new IllegalArgumentException("El programa es obligatorio");
        }
        
        // Validamos el semestre
        if(estudiante.getSemestre() < 1 || estudiante.getSemestre() > 10){
            throw new IllegalArgumentException("El semestre debe estar entre 1 a 10");
        }
    }
    
}
