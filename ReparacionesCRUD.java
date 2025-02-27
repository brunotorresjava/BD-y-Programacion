import javax.swing.*;
import java.sql.*;

public class ReparacionesCRUD {

    public static void agregarReparacion() {
        try (Connection conn = ConexionDB.getConnection()) {
            String costoEstimado = JOptionPane.showInputDialog("Costo Estimado:");
            String estado = JOptionPane.showInputDialog("Estado:");
            String idVehiculo = JOptionPane.showInputDialog("ID del Vehículo:");

            String sql = "INSERT INTO reparacion (costo_estimado, estado, ID_Vehiculo) VALUES (?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(costoEstimado));
                pst.setString(2, estado);
                pst.setInt(3, Integer.parseInt(idVehiculo));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reparación agregada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar reparación: " + e.getMessage());
        }
    }

    public static void editarReparacion() {
        try (Connection conn = ConexionDB.getConnection()) {
            String numServicio = JOptionPane.showInputDialog("Número de Servicio a editar:");
            String costoEstimado = JOptionPane.showInputDialog("Nuevo Costo Estimado:");
            String estado = JOptionPane.showInputDialog("Nuevo Estado:");
            String idVehiculo = JOptionPane.showInputDialog("Nuevo ID del Vehículo:");

            String sql = "UPDATE reparacion SET costo_estimado = ?, estado = ?, ID_Vehiculo = ? WHERE num_servicio = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(costoEstimado));
                pst.setString(2, estado);
                pst.setInt(3, Integer.parseInt(idVehiculo));
                pst.setInt(4, Integer.parseInt(numServicio));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reparación editada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar reparación: " + e.getMessage());
        }
    }

    public static void eliminarReparacion() {
        try (Connection conn = ConexionDB.getConnection()) {
            String numServicio = JOptionPane.showInputDialog("Número de Servicio a eliminar:");

            String sql = "DELETE FROM reparacion WHERE num_servicio = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(numServicio));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reparación eliminada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar reparación: " + e.getMessage());
        }
    }

    public static void consultarReparacion() {
        try (Connection conn = ConexionDB.getConnection()) {
            String numServicio = JOptionPane.showInputDialog("Número de Servicio a consultar:");

            String sql = "SELECT * FROM reparacion WHERE num_servicio = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(numServicio));
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Número de Servicio: " + rs.getInt("num_servicio") +
                                "\nCosto Total: " + rs.getBigDecimal("costo_estimado") +
                                "\nEstado: " + rs.getString("estado") +
                                "\nID del Vehículo: " + rs.getInt("ID_Vehiculo"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Reparación no encontrada.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar reparación: " + e.getMessage());
        }
    }
}
