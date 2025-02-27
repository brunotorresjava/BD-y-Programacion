
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1/TallerMecanico"; 
        String user = "bruno"; 
        String password = "bancodedados"; 
        return DriverManager.getConnection(url, user, password);
    }
}
