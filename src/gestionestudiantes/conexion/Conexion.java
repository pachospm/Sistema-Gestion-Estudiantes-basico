package gestionestudiantes.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Dirección del servidor MySQL
    private final String URL = "jdbc:mysql://localhost:3306/";

    // Nombre de la base de datos que vamos a utilizar
    private final String DB = "gestion_estudiantes";

    // Usuario de MySQL
    private final String USER = "root";

    // Contraseña de MySQL
    // Si usa XAMPP normalmente root no tiene contraseña
    private final String PASSWORD = "";

    // Única instancia de la clase Conexion
    private static Conexion instancia;

    // Constructor privado para aplicar Singleton
    private Conexion() {

    }

    // Método para obtener la única instancia
    public static Conexion getInstancia() {

        if (instancia == null) {
            instancia = new Conexion();
        }

        return instancia;
    }

    // Método que realiza la conexión con MySQL
    public Connection conectar() throws SQLException {

        // Aquí estaba el error.
        // Debemos concatenar URL + DB
        return DriverManager.getConnection(
                URL + DB,
                USER,
                PASSWORD
        );
    }
}