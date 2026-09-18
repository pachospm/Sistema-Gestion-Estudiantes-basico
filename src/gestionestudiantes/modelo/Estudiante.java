/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionestudiantes.modelo;

/**
 *
 * @author fsamaca
 */
public class Estudiante {
    
    private int id;
    private String documento;
    private String nombre;
    private String apellido;
    private String correo;
    private String programa;
    private int semestre;
    
    // Creamos constructor vacio
    public Estudiante(){
        /**
         * El cosntructor vacio permite crear el objeto
         * sin necesidad de enviar todos los datis inmediatamente
         * 
         */
    }

    public Estudiante(int id, String documento, String nombre, String apellido, String correo, String programa, int semestre) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.programa = programa;
        this.semestre = semestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return documento + " - " + nombre + " - " + apellido;
    }
    
}
