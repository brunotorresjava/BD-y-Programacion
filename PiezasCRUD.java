import javax.swing.*;
import java.sql.*;

public class PiezasCRUD {

    public static void agregarPieza() {
        try (Connection conn = ConexionDB.getConnection()) {
            String vehiculoCompatible = JOptionPane.showInputDialog("Vehículo Compatible:");
            String nombre = JOptionPane.showInputDialog("Nombre de la Pieza:");
            String stock = JOptionPane.showInputDialog("Stock:");
            String fabricante = JOptionPane.showInputDialog("Fabricante:");

            String sql = "INSERT INTO pieza (vehiculo_compatible, nombre, Stock, Fabricante) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, vehiculoCompatible);
                pst.setString(2, nombre);
                pst.setInt(3, Integer.parseInt(stock));
                pst.setString(4, fabricante);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pieza agregada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar pieza: " + e.getMessage());
        }
    }

    public static void editarPieza() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idPieza = JOptionPane.showInputDialog("ID de la Pieza a editar:");
            String vehiculoCompatible = JOptionPane.showInputDialog("Nuevo Vehículo Compatible:");
            String nombre = JOptionPane.showInputDialog("Nuevo Nombre de la Pieza:");
            String stock = JOptionPane.showInputDialog("Nuevo Stock:");
            String fabricante = JOptionPane.showInputDialog("Nuevo Fabricante:");

            String sql = "UPDATE pieza SET vehiculo_compatible = ?, nombre = ?, Stock = ?, Fabricante = ? WHERE ID = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, vehiculoCompatible);
                pst.setString(2, nombre);
                pst.setInt(3, Integer.parseInt(stock));
                pst.setString(4, fabricante);
                pst.setInt(5, Integer.parseInt(idPieza));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pieza editada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar pieza: " + e.getMessage());
        }
    }

    public static void eliminarPieza() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idPieza = JOptionPane.showInputDialog("ID de la Pieza a eliminar:");

            String sql = "DELETE FROM pieza WHERE ID = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(idPieza));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pieza eliminada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar pieza: " + e.getMessage());
        }
    }

    public static void consultarPieza() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idPieza = JOptionPane.showInputDialog("ID de la Pieza a consultar:");

            String sql = "SELECT * FROM pieza WHERE ID = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(idPieza));
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "ID: " + rs.getInt("ID") +
                                "\nVehículo Compatible: " + rs.getString("vehiculo_compatible") +
                                "\nNombre: " + rs.getString("nombre") +
                                "\nStock: " + rs.getInt("Stock") +
                                "\nFabricante: " + rs.getString("Fabricante"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Pieza no encontrada.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar pieza: " + e.getMessage());
        }
    }
}
