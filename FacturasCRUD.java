import javax.swing.*;
import java.sql.*;

public class FacturasCRUD {

    public static void agregarFactura() {
        try (Connection conn = ConexionDB.getConnection()) {
            String metodoPago = JOptionPane.showInputDialog("Método de Pago:");
            String servicio = JOptionPane.showInputDialog("Servicio:");
            String fechaTransaccion = JOptionPane.showInputDialog("Fecha de Transaccion (YYYY-MM-DD):");
            String idCliente = JOptionPane.showInputDialog("ID del Cliente:");
            String idVehiculo = JOptionPane.showInputDialog("ID del Vehículo:");
            String idEmpleado = JOptionPane.showInputDialog("ID del Empleado:");

            String sql = "INSERT INTO factura (Metodo_de_pago, Servicio, fecha_transaccion, ID_Cliente, ID_Vehiculo, ID_Empleado) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, metodoPago);
                pst.setString(2, servicio);
                pst.setDate(3, Date.valueOf(fechaTransaccion));
                pst.setInt(4, Integer.parseInt(idCliente));
                pst.setInt(5, Integer.parseInt(idVehiculo));
                pst.setInt(6, Integer.parseInt(idEmpleado));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Factura agregada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar factura: " + e.getMessage());
        }
    }

    public static void editarFactura() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idFactura = JOptionPane.showInputDialog("ID de la Factura a editar:");
            String metodoPago = JOptionPane.showInputDialog("Nuevo Método de Pago:");
            String servicio = JOptionPane.showInputDialog("Nuevo Servicio:");
            String fechaTransaccion = JOptionPane.showInputDialog("Nueva Fecha de Pago (YYYY-MM-DD):");
            String idCliente = JOptionPane.showInputDialog("Nuevo ID del Cliente:");
            String idVehiculo = JOptionPane.showInputDialog("Nuevo ID del Vehículo:");
            String idEmpleado = JOptionPane.showInputDialog("Nuevo ID del Empleado:");

            String sql = "UPDATE factura SET Metodo_de_pago = ?, Servicio = ?, fecha_transaccion = ?, ID_Cliente = ?, ID_Vehiculo = ?, ID_Empleado = ? WHERE ID = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, metodoPago);
                pst.setString(2, servicio);
                pst.setDate(3, Date.valueOf(fechaTransaccion));
                pst.setInt(4, Integer.parseInt(idCliente));
                pst.setInt(5, Integer.parseInt(idVehiculo));
                pst.setInt(6, Integer.parseInt(idEmpleado));
                pst.setInt(7, Integer.parseInt(idFactura));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Factura editada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar factura: " + e.getMessage());
        }
    }

    public static void eliminarFactura() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idFactura = JOptionPane.showInputDialog("ID de la Factura a eliminar:");

            String sql = "DELETE FROM factura WHERE ID = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(idFactura));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Factura eliminada correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar factura: " + e.getMessage());
        }
    }

    public static void consultarFactura() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idFactura = JOptionPane.showInputDialog("ID de la Factura a consultar:");

            String sql = "SELECT * FROM factura WHERE ID = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(idFactura));
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "ID: " + rs.getInt("ID") +
                                "\nMétodo de Pago: " + rs.getString("Metodo_de_pago") +
                                "\nServicio: " + rs.getString("Servicio") +
                                "\nFecha de Pago: " + rs.getDate("fecha_transaccion") +
                                "\nID Cliente: " + rs.getInt("ID_Cliente") +
                                "\nID Vehículo: " + rs.getInt("ID_Vehiculo") +
                                "\nID Empleado: " + rs.getInt("ID_Empleado"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Factura no encontrada.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar factura: " + e.getMessage());
        }
    }
}
