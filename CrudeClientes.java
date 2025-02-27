import javax.swing.*;
import java.sql.*;

public class CrudeClientes {

    public static void agregarCliente() {
        try (Connection conn = ConexionDB.getConnection()) {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String dni = JOptionPane.showInputDialog("DNI:");
            String direccion = JOptionPane.showInputDialog("Dirección:");
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            String correo = JOptionPane.showInputDialog("Correo Electrónico:");
            String tipoVehiculo = JOptionPane.showInputDialog("Tipo de Vehículo:");
            String fechaRegistro = JOptionPane.showInputDialog("Fecha de Registro:");
            
            String sql = "INSERT INTO clientes (nombre, DNI, Direccion, Telefono, Correo_Electronico, Tipo_Vehiculo, fecha_registro) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, nombre);
                pst.setString(2, dni);
                pst.setString(3, direccion);
                pst.setString(4, telefono);
                pst.setString(5, correo);
                pst.setString(6, tipoVehiculo);
                pst.setDate(7, Date.valueOf(fechaRegistro));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar cliente: " + e.getMessage());
        }
    }

 public static void editarCliente() {
    try (Connection conn = ConexionDB.getConnection()) {
        String iD_Cliente = JOptionPane.showInputDialog("ID del Cliente a editar:");

        String nombre = JOptionPane.showInputDialog("Nuevo Nombre:");
        String dni = JOptionPane.showInputDialog("Nuevo DNI:");
        String direccion = JOptionPane.showInputDialog("Nueva Dirección:");
        String telefono = JOptionPane.showInputDialog("Nuevo Teléfono:");
        String correo = JOptionPane.showInputDialog("Nuevo Correo Electrónico:");
        String tipoVehiculo = JOptionPane.showInputDialog("Nuevo Tipo de Vehículo:");
        String fechaRegistro = JOptionPane.showInputDialog("Fecha de Registro (yyyy-MM-dd):");

        String sql = "UPDATE clientes SET nombre = ?, DNI = ?, Direccion = ?, Telefono = ?, Correo_Electronico = ?, Tipo_Vehiculo = ?, fecha_registro = ? WHERE ID_Cliente = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, dni);
            pst.setString(3, direccion);
            pst.setString(4, telefono);
            pst.setString(5, correo);
             pst.setString(6, tipoVehiculo);
            pst.setDate(7, Date.valueOf(fechaRegistro));
            pst.setString(8, iD_Cliente);

           }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al editar cliente: " + e.getMessage());
        } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use el formato yyyy-MM-dd.");
    }
}


    public static void eliminarCliente() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idCliente = JOptionPane.showInputDialog("ID del Cliente a eliminar:");

            String sql = "DELETE FROM clientes WHERE ID_Cliente = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, idCliente);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.getMessage());
        }
    }

    public static void consultarCliente() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idCliente = JOptionPane.showInputDialog("ID del Cliente a consultar:");

            String sql = "SELECT * FROM clientes WHERE ID_Cliente = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, idCliente);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "ID: " + rs.getInt("ID_Cliente") +
                                "\nNombre: " + rs.getString("nombre") +
                                "\nDNI: " + rs.getString("DNI") +
                                "\nDirección: " + rs.getString("Direccion") +
                                "\nTeléfono: " + rs.getString("Telefono") +
                                "\nCorreo: " + rs.getString("Correo_Electronico") +
                                "\nTipo Vehículo: " + rs.getString("Tipo_Vehiculo") +
                                "\nFecha de Registro: " + rs.getDate("fecha_registro"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar cliente: " + e.getMessage());
        }
    }
}
