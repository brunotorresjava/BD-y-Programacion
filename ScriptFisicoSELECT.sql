use TallerMecanico;

/* Clientes con nombres que contienen la letra "a" (usando LIKE): */
SELECT * 
FROM clientes
WHERE nombre LIKE '%a%';

/* Contar cuántos clientes tienen "Tranqueras" como dirección: */
SELECT Direccion, COUNT(*) AS TotalClientes
FROM clientes
WHERE Direccion = 'Tranqueras';

/* Buscar empleados cuyo cargo contiene "Mecánico" */
SELECT *
FROM empleado
WHERE cargo LIKE '%Mecanico%';

/* Salarios promedio de los empleados: */
SELECT AVG(salario) AS SalarioPromedio
FROM empleado;

/* Mostrar los empleados con los salarios más altos: */
SELECT nombre, cargo, salario
FROM empleado
ORDER BY salario DESC
LIMIT 3;

/* Buscar facturas cuyo servicio incluye "Cambio": */
SELECT *
FROM factura
WHERE Servicio LIKE '%Cambio%';

/* Listar las facturas más recientes: */
SELECT *
FROM factura
ORDER BY fecha_transaccion DESC
LIMIT 5;

/* Buscar piezas compatibles con "SUV": */
SELECT *
FROM pieza
WHERE vehiculo_compatible LIKE '%Fiat%';

/* Cantidad total de piezas en stock por ID: */
SELECT ID, SUM(stock_actual) AS TotalEnStock
FROM stock_piezas
GROUP BY ID;

/* Reparaciones completadas: */
SELECT *
FROM reparacion
WHERE estado = 'Completado';

/* Costo promedio de reparaciones: */
SELECT AVG(costo_estimado) AS CostoPromedio
FROM reparacion;

/* Reparaciones agrupadas por estado con costo total mayor a 3000: */
SELECT estado, SUM(costo_estimado) AS costo_estimado
FROM reparacion
GROUP BY estado
HAVING SUM(costo_estimado) > 3000;

/* Vehículos fabricados después de 2020 */
SELECT *
FROM vehiculo
WHERE ano > 2020;

/* Contar vehículos por marca: */
SELECT marca, COUNT(*) AS TotalVehiculos
FROM vehiculo
GROUP BY marca;


/* Clientes y los vehículos que poseen: */
SELECT c.nombre AS Cliente, v.matricula AS Vehiculo
FROM clientes c
JOIN vehiculo v ON c.ID_Cliente = v.ID_Cliente;

/* Empleados encargados de cada factura: */
SELECT f.Servicio, e.nombre AS Empleado
FROM factura f
JOIN empleado e ON f.ID_Empleado = e.ID_Empleado;

