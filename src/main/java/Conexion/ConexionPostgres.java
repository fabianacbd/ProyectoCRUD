package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgres {

    private static final String url = "jdbc:postgresql://localhost:5432/cines";
    private static final String user = "postgres";
    private static final String password = "postgres";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a PostgreSQL: " + e.getMessage());
            return null;
        }
    }
}
