import javax.swing.*;
import java.sql.*;

public class EmpleadoCrud {

    public static void agregarEmpleado() {
        try (Connection conn = ConexionDB.getConnection()) {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String dni = JOptionPane.showInputDialog("DNI:");
            String cargo = JOptionPane.showInputDialog("Cargo:");
            String salario = JOptionPane.showInputDialog("Salario:");
            String fechaContratacion = JOptionPane.showInputDialog("Fecha de Contratación:");

            String sql = "INSERT INTO empleado (nombre, DNI, cargo, salario, fecha_contratacion) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, nombre);
                pst.setString(2, dni);
                pst.setString(3, cargo);
                pst.setInt(4, Integer.parseInt(salario));
                pst.setDate(5, Date.valueOf(fechaContratacion));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado agregado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar empleado: " + e.getMessage());
        }
    }

    public static void editarEmpleado() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idEmpleado = JOptionPane.showInputDialog("ID del Empleado a editar:");
            String nombre = JOptionPane.showInputDialog("Nuevo Nombre:");
            String dni = JOptionPane.showInputDialog("Nuevo DNI:");
            String cargo = JOptionPane.showInputDialog("Nuevo Cargo:");
            String salario = JOptionPane.showInputDialog("Nuevo Salario:");

            String sql = "UPDATE empleado SET nombre = ?, DNI = ?, cargo = ?, salario = ? WHERE ID_Empleado = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, nombre);
                pst.setString(2, dni);
                pst.setString(3, cargo);
                pst.setInt(4, Integer.parseInt(salario));
                pst.setInt(5, Integer.parseInt(idEmpleado));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado editado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar empleado: " + e.getMessage());
        }
    }

    public static void eliminarEmpleado() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idEmpleado = JOptionPane.showInputDialog("ID del Empleado a eliminar:");

            String sql = "DELETE FROM empleado WHERE ID_Empleado = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(idEmpleado));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage());
        }
    }

    public static void consultarEmpleado() {
        try (Connection conn = ConexionDB.getConnection()) {
            String idEmpleado = JOptionPane.showInputDialog("ID del Empleado a consultar:");

            String sql = "SELECT * FROM empleado WHERE ID_Empleado = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, Integer.parseInt(idEmpleado));
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "ID: " + rs.getInt("ID_Empleado") +
                                "\nNombre: " + rs.getString("nombre") +
                                "\nDNI: " + rs.getString("DNI") +
                                "\nCargo: " + rs.getString("cargo") +
                                "\nSalario: " + rs.getBigDecimal("salario") +
                                "\nFecha de contratacion: " + rs.getDate("fecha_contratacion"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar empleado: " + e.getMessage());
        }
    }
}
