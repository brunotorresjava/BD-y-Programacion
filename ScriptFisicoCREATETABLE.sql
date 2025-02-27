Create DATABASE TallerMecanico;

use TallerMecanico;
CREATE TABLE clientes (
    ID_Cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    DNI_NIF INT(8) NOT NULL UNIQUE,
    Direccion VARCHAR(100) NOT NULL,
    Telefono INT(10) NOT NULL,
    Correo_Electronico VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE vehiculo (
    ID_Vehiculo INT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(50) NOT NULL UNIQUE,
    marca VARCHAR(50) NOT NULL,
    color VARCHAR(50) NOT NULL,
    ano INT(4) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    ID_Cliente INT NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES clientes(ID_Cliente)
);

CREATE TABLE empleado (
    ID_Empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    DNI INT(8) NOT NULL UNIQUE,
    cargo VARCHAR(100) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL,
    Especializacion VARCHAR(100),
    fecha_ingreso DATE
);

CREATE TABLE factura (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Metodo_de_pago VARCHAR(50) NOT NULL,
    Servicio VARCHAR(500) NOT NULL,
    Fecha_transaccion DATE NOT NULL,
    ID_Cliente INT NOT NULL,
    ID_Vehiculo INT NOT NULL,
    ID_Empleado INT NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES clientes(ID_Cliente),
    FOREIGN KEY (ID_Vehiculo) REFERENCES vehiculo(ID_Vehiculo),
    FOREIGN KEY (ID_Empleado) REFERENCES empleado(ID_Empleado)
);

CREATE TABLE pieza (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    valor INT(100) NOT NULL,
    vehiculo_compatible VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    Fabricante VARCHAR(100) NOT NULL
);

CREATE TABLE Stock_Piezas (
    ID INT NOT NULL,
    FOREIGN KEY(ID) REFERENCES pieza(ID),
    stock_actual INT NOT NULL,
    fecha_entrada DATE,
    fecha_salida DATE 
);

CREATE TABLE reparacion (
    num_servicio INT AUTO_INCREMENT PRIMARY KEY,
    costo_estimado DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    fecha_inicio DATE,
    fecha_estimada_finalizacion DATE,
    ID_Vehiculo INT NOT NULL,
    FOREIGN KEY (ID_Vehiculo) REFERENCES vehiculo(ID_Vehiculo)
);



