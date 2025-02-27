import javax.swing.*;

public class MainPrincipal {
    public static void main(String[] args) {
        while (true) {
            String[] options = {"Clientes", "Vehículos", "Empleados", "Facturas", "Piezas", "Reparaciones", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    mostrarMenuClientes();
                    break;
                case 1:
                    mostrarMenuVehiculos();
                    break;
                case 2:
                    mostrarMenuEmpleados();
                    break;
                case 3:
                    mostrarMenuFacturas();
                    break;
                case 4:
                    mostrarMenuPiezas();
                    break;
                case 5:
                    mostrarMenuReparaciones();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    private static void mostrarMenuClientes() {
        String[] options = {"Agregar", "Editar", "Eliminar", "Consultar", "Volver"};
        int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestionar Clientes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                CrudeClientes.agregarCliente();
                break;
            case 1:
                CrudeClientes.editarCliente();
                break;
            case 2:
                CrudeClientes.eliminarCliente();
                break;
            case 3:
                CrudeClientes.consultarCliente();
                break;
            case 4:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
        }
    }
    
     private static void mostrarMenuVehiculos() {
        String[] options = {"Agregar", "Editar", "Eliminar", "Consultar", "Volver"};
        int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestionar Vehículos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                VehiculoCRUD.agregarVehiculo();
                break;
            case 1:
                VehiculoCRUD.editarVehiculo();
                break;
            case 2:
                VehiculoCRUD.eliminarVehiculo();
                break;
            case 3:
                VehiculoCRUD.consultarVehiculo();
                break;
            case 4:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
        }
    }
     
       private static void mostrarMenuEmpleados() {
        String[] options = {"Agregar", "Editar", "Eliminar", "Consultar", "Volver"};
        int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestionar Empleados",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                EmpleadoCrud.agregarEmpleado();
                break;
            case 1:
                EmpleadoCrud.editarEmpleado();
                break;
            case 2:
                EmpleadoCrud.eliminarEmpleado();
                break;
            case 3:
                EmpleadoCrud.consultarEmpleado();
                break;
            case 4:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida");
        }
    }
      private static void mostrarMenuFacturas() {
    String[] options = {"Agregar", "Editar", "Eliminar", "Consultar", "Volver"};
    int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestionar Facturas",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

    switch (choice) {
        case 0:
            FacturasCRUD.agregarFactura();
            break;
        case 1:
            FacturasCRUD.editarFactura();
            break;
        case 2:
            FacturasCRUD.eliminarFactura();
            break;
        case 3:
            FacturasCRUD.consultarFactura();
            break;
        case 4:
            return;
        default:
            JOptionPane.showMessageDialog(null, "Opción inválida");
    }
  }
      
      private static void mostrarMenuPiezas() {
    String[] options = {"Agregar", "Editar", "Eliminar", "Consultar", "Volver"};
    int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestionar Piezas",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

    switch (choice) {
        case 0:
            PiezasCRUD.agregarPieza();
            break;
        case 1:
            PiezasCRUD.editarPieza();
            break;
        case 2:
            PiezasCRUD.eliminarPieza();
            break;
        case 3:
            PiezasCRUD.consultarPieza();
            break;
        case 4:
            return;
        default:
            JOptionPane.showMessageDialog(null, "Opción inválida");
    }
}
      private static void mostrarMenuReparaciones() {
    String[] options = {"Agregar", "Editar", "Eliminar", "Consultar", "Volver"};
    int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestionar Reparaciones",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

    switch (choice) {
        case 0:
            ReparacionesCRUD.agregarReparacion();
            break;
        case 1:
            ReparacionesCRUD.editarReparacion();
            break;
        case 2:
            ReparacionesCRUD.eliminarReparacion();
            break;
        case 3:
            ReparacionesCRUD.consultarReparacion();
            break;
        case 4:
            return;
        default:
            JOptionPane.showMessageDialog(null, "Opción inválida");
    }

  }
      
}


