use TallerMecanico;

INSERT INTO clientes (nombre, DNI_NIF, Direccion, Telefono, Correo_Electronico)
VALUES
('Juan Pérez', 12345678, 'Calle Principal 123', 987654321, 'juan.perez@example.com'),
('María López', 23456789, 'Av. Libertad 456', 987654322, 'maria.lopez@example.com'),
('Carlos García', 34567890, 'Calle Secundaria 789', 987654323, 'carlos.garcia@example.com'),
('Ana Martínez', 45678901, 'Plaza Central 101', 987654324, 'ana.martinez@example.com'),
('Luis Rodríguez', 56789012, 'Av. Siempre Viva 202', 987654325, 'luis.rodriguez@example.com');

INSERT INTO vehiculo (matricula, marca, color, ano, modelo, ID_Cliente)
VALUES
('ABC-1234', 'Toyota', 'Rojo', 2020, 'Corolla', 1),
('DEF-5678', 'Honda', 'Azul', 2019, 'CR-V', 2),
('GHI-9012', 'Ford', 'Negro', 2018, 'Focus', 3),
('JKL-3456', 'Chevrolet', 'Blanco', 2021, 'Silverado', 4),
('MNO-7890', 'Nissan', 'Gris', 2022, 'Frontier', 5);

INSERT INTO empleado (nombre, DNI, cargo, salario, Especializacion, fecha_ingreso)
VALUES
('Pedro González', 67890123, 'Mecánico', 35000, 'Motor' , '2005-12-01'),
('Laura Fernández', 78901234, 'Supervisor', 25000, 'Diagnostico', '2005-01-01'),
('Jorge Ramírez', 89012345, 'Gerente', 50000, 'Administracion', '2005-02-01'),
('Sofía Torres', 90123456, 'Mecánico', 30000, 'Pintura', '2005-03-01'),
('Diego Ortiz', 12345067, 'Marketing', 28000, 'Redes Sociales', '2005-04-01');

INSERT INTO factura (Metodo_de_pago, Servicio, Fecha_transaccion, ID_Cliente, ID_Vehiculo, ID_Empleado)
VALUES
('Efectivo', 'Cambio de aceite', '2024-11-20', 1, 1, 1),
('Tarjeta de crédito', 'Reparación de frenos', '2024-11-21', 2, 2, 2),
('Transferencia bancaria', 'Alineación de ruedas', '2024-11-22', 3, 3, 3),
('Efectivo', 'Cambio de batería', '2024-11-23', 4, 4, 4),
('Tarjeta de débito', 'Reparación de motor', '2024-11-24', 5, 5, 5);

INSERT INTO pieza (valor, vehiculo_compatible, nombre, Fabricante)
VALUES
('1000', 'Sedán', 'Filtro de aceite', 'Bosch'),
('2000', 'SUV', 'Pastilla de frenos', 'TRW'),
('2500','Pickup', 'Amortiguador',  'Monroe'),
('500','Camioneta', 'Filtro de aire', 'Mann Filter'),
('450','Hatchback', 'Bujía', 'NGK');

INSERT INTO stock_piezas (ID, stock_actual, fecha_entrada, fecha_salida)
VALUES 
(1, 50, '2023-11-25', '2024-11-28'),
(2, 30, '2023-11-20', '2024-11-25'),
(3, 100, '2023-11-15', '2024-11-20'),
(4, 20, '2023-11-27', '2024-11-30'),
(5, 70, '2023-11-10', '2024-11-17');


INSERT INTO reparacion (costo_estimado, estado, fecha_inicio, fecha_estimada_finalizacion, ID_Vehiculo)
VALUES
(1500, 'Completado', '2024-05-01', '2024-05-20', 1),
(3000, 'En Proceso', '2024-05-02', '2024-05-10', 2),
(500, 'Pendiente', '2024-05-03', '2024-05-11', 3),
(2500, 'Completado', '2024-05-04', '2024-05-23', 4),
(4500, 'Cancelado', '2024-05-05', '2024-05-25', 5);
