import javax.swing.*;
import java.sql.*;

public class VehiculoCRUD {

    public static void agregarVehiculo() {
        try (Connection conn = ConexionDB.getConnection()) {
            String matricula = JOptionPane.showInputDialog("Matrícula:");
            String marca = JOptionPane.showInputDialog("Marca:");
            String color = JOptionPane.showInputDialog("Color:");
            String ano = JOptionPane.showInputDialog("Año:");
            String modelo = JOptionPane.showInputDialog("Modelo:");
            String idCliente = JOptionPane.showInputDialog("ID del Cliente:");

            String sql = "INSERT INTO vehiculo (matricula, marca, color, ano, modelo, ID_Cliente) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, matricula);
                pst.setString(2, marca);
                pst.setString(3, color);
                pst.setInt(4, Integer.parseInt(ano));
                pst.setString(5, modelo);
                pst.setInt(6, Integer.parseInt(idCliente));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar vehículo: " + e.getMessage());
        }
    }

    public static void editarVehiculo() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idVehiculo = JOptionPane.showInputDialog("ID del Vehículo a editar:");
            String matricula = JOptionPane.showInputDialog("Nueva Matrícula:");
            String marca = JOptionPane.showInputDialog("Nueva Marca:");
            String color = JOptionPane.showInputDialog("Nuevo Color:");
            String ano = JOptionPane.showInputDialog("Nuevo Año:");
            String modelo = JOptionPane.showInputDialog("Nuevo Modelo:");
            String idCliente = JOptionPane.showInputDialog("Nuevo ID del Cliente:");

            String sql = "UPDATE vehiculo SET matricula = ?, marca = ?, color = ?, ano = ?, modelo = ?, ID_Cliente = ? WHERE ID_Vehiculo = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, matricula);
                pst.setString(2, marca);
                pst.setString(3, color);
                pst.setInt(4, Integer.parseInt(ano));
                pst.setString(5, modelo);
                pst.setInt(6, Integer.parseInt(idCliente));
                pst.setInt(7, Integer.parseInt(idVehiculo));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Vehículo editado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar vehículo: " + e.getMessage());
        }
    }

    public static void eliminarVehiculo() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idVehiculo = JOptionPane.showInputDialog("ID del Vehículo a eliminar:");

            String sql = "DELETE FROM vehiculo WHERE ID_Vehiculo = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(idVehiculo));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Vehículo eliminado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar vehículo: " + e.getMessage());
        }
    }

    public static void consultarVehiculo() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idVehiculo = JOptionPane.showInputDialog("ID del Vehículo a consultar:");

            String sql = "SELECT * FROM vehiculo WHERE ID_Vehiculo = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(idVehiculo));
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "ID: " + rs.getInt("ID_Vehiculo") +
                                "\nMatrícula: " + rs.getString("matricula") +
                                "\nMarca: " + rs.getString("marca") +
                                "\nColor: " + rs.getString("color") +
                                "\nAño: " + rs.getInt("ano") +
                                "\nModelo: " + rs.getString("modelo") +
                                "\nID Cliente: " + rs.getInt("ID_Cliente"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar vehículo: " + e.getMessage());
        }
    }
}
