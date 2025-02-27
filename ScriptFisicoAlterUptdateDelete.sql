use TallerMecanico;

UPDATE clientes
SET Direccion = 'Av. Nueva 456'
WHERE DNI_NIF = 67890123;

UPDATE clientes
SET Telefono = 987654331
WHERE DNI_NIF = 78901234;

ALTER TABLE clientes MODIFY COLUMN Telefono BIGINT(15);

UPDATE vehiculo
SET color = 'Amarillo'
WHERE matricula = 'PQR-1234';

UPDATE vehiculo
SET modelo = 'Sorento'
WHERE ID_Vehiculo = 2;

DELETE FROM vehiculo WHERE matricula = 'BCD-7890';

UPDATE empleado
SET salario = salario + 5000
WHERE ID_Empleado IN (3, 5);

UPDATE empleado
SET cargo = 'Supervisor'
WHERE ID_Empleado = 2;

ALTER TABLE empleado MODIFY COLUMN salario DECIMAL(12, 2);

UPDATE factura
SET Metodo_de_pago = 'Efectivo'
WHERE ID = 1;

UPDATE factura
SET Servicio = 'Reparación de motor'
WHERE ID_Cliente = 3;

DELETE FROM factura WHERE ID = 5;

UPDATE pieza
SET valor = valor - 10
WHERE ID = 1;

UPDATE pieza
SET Fabricante = 'NGK'
WHERE ID IN (2, 5);

UPDATE reparacion
SET estado = 'Cancelado'
WHERE num_servicio = 1;
