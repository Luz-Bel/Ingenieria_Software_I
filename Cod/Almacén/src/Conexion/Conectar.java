package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    private Connection conectar = null;
    
    public Conectar() {
        String user = "Sebas";
        String password = "12345";
        String BD = "BD_ING_SOF";
        String puerto = "1433";
        String cadena = "jdbc:sqlserver://localhost:" + puerto + ";databaseName=" + BD + ";trustServerCertificate=true";

        try {
            conectar = DriverManager.getConnection(cadena, user, password);
            System.out.println("Se conectó correctamente a la base de datos");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos, error: " + e.getMessage());
        }
    }

    public Connection obtenerConexion() {
        return conectar;
    }

    public void cerrarConexion() {
        if (conectar != null) {
            try {
                conectar.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
