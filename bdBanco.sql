CREATE DATABASE IF NOT EXISTS bdBanco;
USE bdBanco;
/* TABLAS */
-- TABLA Rol
CREATE TABLE IF NOT EXISTS Rol (
CodRol_Rol INT NOT NULL AUTO_INCREMENT,
Descripcion_Rol VARCHAR (50),
Estado INT NOT NULL DEFAULT 1,
CONSTRAINT PK_Rol PRIMARY KEY (CodRol_Rol)
);
-- TABLA Sexo
CREATE TABLE IF NOT EXISTS Sexo (
CodSexo_Sex CHAR(1) NOT NULL,
Descripcion_Sex VARCHAR (50),
Estado INT NOT NULL DEFAULT 1,
CONSTRAINT PK_Sexo PRIMARY KEY (CodSexo_Sex)
);
-- TABLA Usuario
CREATE TABLE IF NOT EXISTS Usuario (
DNI_Usu CHAR(8) NOT NULL,
CUIL_Usu VARCHAR(11) NOT NULL,
Nombre_Usu VARCHAR (50) NOT NULL,
Apellido_Usu VARCHAR (50) NOT NULL,
Nacionalidad_Usu VARCHAR (50) NOT NULL,
FechaNacimiento_Usu DATE NOT NULL,
Direccion_Usu VARCHAR (150) NOT NULL,
Localidad_Usu VARCHAR (50) NOT NULL,
Provincia_Usu VARCHAR (50) NOT NULL,
CorreoElectronico_Usu VARCHAR (150) NOT NULL,
Telefono_Usu VARCHAR (50) NOT NULL,
Usuario_Usu VARCHAR (50) NOT NULL,
Contrasena_Usu VARCHAR (50) NOT NULL,
Estado INT NOT NULL DEFAULT 1,
CodSexo_Usu CHAR NOT NULL DEFAULT 'M',
CodRol_Usu INT NOT NULL DEFAULT 1,
CONSTRAINT PK_Usuario PRIMARY KEY (DNI_Usu),
CONSTRAINT UK_Usuario_CUIL UNIQUE (CUIL_Usu),
CONSTRAINT FK_Usuario_Sexo FOREIGN KEY (CodSexo_Usu) REFERENCES Sexo (CodSexo_Sex),
CONSTRAINT FK_Usuario_Rol FOREIGN KEY (CodRol_Usu) REFERENCES Rol (CodRol_Rol)
);
-- TABLA EstadoPrestamo
CREATE TABLE IF NOT EXISTS EstadoPrestamo (
CodEstadoPrestamo_EstPre INT NOT NULL AUTO_INCREMENT,
Descripcion_EstPre VARCHAR (50) NOT NULL,
Estado INT NOT NULL DEFAULT 1,
CONSTRAINT PK_EstadoPrestamo PRIMARY KEY (CodEstadoPrestamo_EstPre)
);
-- TABLA Prestamo
CREATE TABLE IF NOT EXISTS Prestamo (
CodPrestamo_Pre INT NOT NULL AUTO_INCREMENT,
Fecha_Pre DATE NOT NULL,
ImportePagar_Pre DECIMAL (8,2) NOT NULL CHECK (ImportePagar_Pre >= 0),
ImportePedido_Pre DECIMAL (8,2) NOT NULL CHECK (ImportePedido_Pre >= 0),
PlazoPago_Pre INT NOT NULL CHECK (PlazoPago_Pre > 0),
MontoCuota_Pre DECIMAL (8,2) NOT NULL CHECK (MontoCuota_Pre >= 0),
Cuotas_Pre INT NOT NULL CHECK (Cuotas_Pre > 0),
Estado INT NOT NULL DEFAULT 1,
CodEstadoPrestamo_Pre INT NOT NULL DEFAULT 1, -- por defecto pendiente 1
DniCliente_Pre CHAR(8) NOT NULL,
CONSTRAINT FK_Prestamo PRIMARY KEY (CodPrestamo_Pre),
CONSTRAINT PK_Prestamo_EstadoPrestamo FOREIGN KEY (CodEstadoPrestamo_Pre) REFERENCES EstadoPrestamo (CodEstadoPrestamo_EstPre),
CONSTRAINT FK_Prestamo_Usuario FOREIGN KEY (DniCliente_Pre) REFERENCES Usuario (DNI_Usu)
);
-- TABLA TipoCuenta
CREATE TABLE IF NOT EXISTS TipoCuenta (
CodTipoCuenta_TipCue INT NOT NULL AUTO_INCREMENT,
Descripcion_TipCue VARCHAR (50) NOT NULL,
Estado INT NOT NULL DEFAULT 1,
CONSTRAINT PK_TipoCuenta PRIMARY KEY (CodTipoCuenta_TipCue)
);
-- TABLA Cuenta
CREATE TABLE IF NOT EXISTS Cuenta (
NumCuenta_Cue INT NOT NULL AUTO_INCREMENT,
FechaCreacion_Cue DATE NOT NULL,
CBU_Cue VARCHAR (22) NOT NULL,
Saldo_Cue DECIMAL (10,2) NOT NULL DEFAULT 10000,
Estado INT NOT NULL DEFAULT 1,
CodTipoCuenta_Cue INT NOT NULL DEFAULT 1, -- por defecto caja de ahorro 1
DniCliente_Cue CHAR(8) NOT NULL,
CONSTRAINT PK_Cuenta PRIMARY KEY (NumCuenta_Cue),
CONSTRAINT FK_Cuenta_TipoCuenta FOREIGN KEY (CodTipoCuenta_Cue) REFERENCES TipoCuenta (CodTipoCuenta_TipCue),
CONSTRAINT FK_Cuenta_Usuario FOREIGN KEY (DniCliente_Cue) REFERENCES Usuario (DNI_Usu)
);
-- TABLA TipoMovimiento
CREATE TABLE IF NOT EXISTS TipoMovimiento (
CodTipoMovimiento_TipMov INT NOT NULL AUTO_INCREMENT,
Descripcion_TipMov VARCHAR (50) NOT NULL,
Estado INT NOT NULL DEFAULT 1,
CONSTRAINT PK_TipoMovimiento PRIMARY KEY (CodTipoMovimiento_TipMov)
);
-- TABLA Movimiento
CREATE TABLE IF NOT EXISTS Movimiento (
CodMovimiento_Mov INT NOT NULL AUTO_INCREMENT,
Fecha_Mov DATE NOT NULL,
Detalle_Mov VARCHAR (50) NOT NULL DEFAULT 'Movimiento detalle',
Importe_Mov DECIMAL (10,2) NOT NULL CHECK (Importe_Mov >= 0),
Estado INT NOT NULL DEFAULT 1,
NumCuenta_Mov INT NOT NULL,
CodTipoMovimiento_Mov INT NOT NULL DEFAULT 1,	-- Alta de cuenta por defecto 1
CONSTRAINT PK_Movimiento PRIMARY KEY (CodMovimiento_Mov),
CONSTRAINT FK_Movimiento_Cuenta FOREIGN KEY (NumCuenta_Mov) REFERENCES Cuenta (NumCuenta_Cue),
CONSTRAINT FK_Movimiento_TipoMovimiento FOREIGN KEY (CodTipoMovimiento_Mov) REFERENCES TipoMovimiento (CodTipoMovimiento_TipMov)
);
/* PRECARGA DE DATOS */
USE bdBanco;
-- TABLA Rol
INSERT INTO Rol (Descripcion_Rol)
SELECT 'cliente' UNION
SELECT 'admin';
-- TABLA Sexo
INSERT INTO Sexo (CodSexo_Sex,Descripcion_Sex)
SELECT 'M','hombre' UNION
SELECT 'F','mujer';
-- TABLA Usuario
INSERT INTO Usuario (DNI_Usu,CUIL_Usu,Nombre_Usu,Apellido_Usu,Nacionalidad_Usu,FechaNacimiento_Usu,Direccion_Usu,Localidad_Usu,Provincia_Usu,CorreoElectronico_Usu,Telefono_Usu,Usuario_Usu,Contrasena_Usu,Estado,CodSexo_Usu,CodRol_Usu)
VALUES ('00000000','00000000000','Nombre admin','Apellido admin','Nacionalidad admin','2001-01-01','Direccion admin','Localidad admin','Provincia admin','Correo electronico admin','Telefono admin','Usuario admin','claveadmin',1,'M',2),
('1111111','1111111111','Nombre 1','Apellido 1','Nacionalidad 1','2001-01-01','Direccion 1','Localidad 1','Provincia 1','Correo electronico 1','Telefono 1','Usuario 1','clave1',1,'M',1),
('2222222','2222222222','Nombre 2','Apellido 2','Nacionalidad 2','2002-02-02','Direccion 2','Localidad 2','Provincia 2','Correo electronico 2','Telefono 2','Usuario 2','clave2',1,'M',1),
('3333333','3333333333','Nombre 3','Apellido 3','Nacionalidad 3','2003-03-03','Direccion 3','Localidad 3','Provincia 3','Correo electronico 3','Telefono 3','Usuario 3','clave3',1,'M',1),
('4444444','4444444444','Nombre 4','Apellido 4','Nacionalidad 4','2004-04-04','Direccion 4','Localidad 4','Provincia 4','Correo electronico 4','Telefono 4','Usuario 4','clave4',1,'M',1),
('5555555','5555555555','Nombre 5','Apellido 5','Nacionalidad 5','2005-05-05','Direccion 5','Localidad 5','Provincia 5','Correo electronico 5','Telefono 5','Usuario 1','clave5',1,'M',1),
('6666666','6666666666','Nombre 6','Apellido 6','Nacionalidad 6','2006-06-06','Direccion 6','Localidad 6','Provincia 6','Correo electronico 6','Telefono 6','Usuario 1','clave6',1,'M',1),
('7777777','7777777777','Nombre 7','Apellido 7','Nacionalidad 7','2007-07-07','Direccion 7','Localidad 7','Provincia 7','Correo electronico 7','Telefono 7','Usuario 1','clave7',1,'M',1),
('8888888','8888888888','Nombre 8','Apellido 8','Nacionalidad 8','2008-08-08','Direccion 8','Localidad 8','Provincia 8','Correo electronico 8','Telefono 8','Usuario 1','clave8',1,'M',1),
('9999999','9999999999','Nombre 9','Apellido 9','Nacionalidad 9','2009-09-09','Direccion 9','Localidad 9','Provincia 9','Correo electronico 9','Telefono 9','Usuario 1','clave9',1,'M',1),
('11111110','11111111101','Nombre 10','Apellido 10','Nacionalidad 10','2010-10-10','Direccion 10','Localidad 10','Provincia 10','Correo electronico 10','Telefono 10','Usuario 10','clave10',1,'M',1),
('11111111','11111111111','Nombre 11','Apellido 11','Nacionalidad 11','2011-11-11','Direccion 11','Localidad 11','Provincia 11','Correo electronico 11','Telefono 11','Usuario 11','clave11',1,'M',1),
('22222222','11222222221','Nombre 12','Apellido 12','Nacionalidad 12','2012-12-12','Direccion 12','Localidad 12','Provincia 12','Correo electronico 12','Telefono 12','Usuario 12','clave12',1,'M',1),
('33333333','11333333331','Nombre 13','Apellido 13','Nacionalidad 13','2013-01-13','Direccion 13','Localidad 13','Provincia 13','Correo electronico 13','Telefono 13','Usuario 13','clave13',1,'M',1),
('44444444','11444444441','Nombre 14','Apellido 14','Nacionalidad 14','2014-02-14','Direccion 14','Localidad 14','Provincia 14','Correo electronico 14','Telefono 14','Usuario 14','clave14',1,'M',1),
('55555555','11555555551','Nombre 15','Apellido 15','Nacionalidad 15','2015-03-15','Direccion 15','Localidad 15','Provincia 15','Correo electronico 15','Telefono 15','Usuario 15','clave15',1,'M',1);
-- Tabla 
INSERT INTO EstadoPrestamo (Descripcion_EstPre)
SELECT 'pendiente' UNION
SELECT 'aceptado' UNION
SELECT 'rechazado';
-- TABLA Prestamo
INSERT INTO Prestamo (Fecha_Pre,ImportePagar_Pre,ImportePedido_Pre,PlazoPago_Pre,MontoCuota_Pre,Cuotas_Pre,CodEstadoPrestamo_Pre,DniCliente_Pre)
VALUES ('2001-01-01',1,1,1,1,1,1,'1111111'),
('2001-01-01',2,2,2,1,2,1,'1111111'),
('2001-01-01',3,3,3,1,3,1,'1111111'),
('2001-01-01',4,4,4,1,4,1,'1111111'),
('2001-01-01',5,5,5,1,5,1,'1111111'),
('2001-01-01',6,6,6,1,6,1,'1111111'),
('2001-01-01',7,7,7,1,7,1,'1111111'),
('2001-01-01',8,8,8,1,8,1,'1111111'),
('2001-01-01',9,9,9,1,9,1,'1111111'),
('2001-01-01',10,10,10,1,10,1,'1111111'),
('2001-01-01',11,11,11,1,11,1,'1111111'),
('2001-01-01',12,12,12,1,12,1,'1111111'),
('2001-01-01',13,13,13,1,13,1,'1111111'),
('2001-01-01',14,14,14,1,14,1,'1111111'),
('2001-01-01',15,15,15,1,15,1,'1111111');
-- TABLA
INSERT INTO TipoCuenta (Descripcion_TipCue)
SELECT 'caja de ahorro' UNION
SELECT 'cuenta corriente';
-- TABLA Cuenta
INSERT INTO Cuenta (FechaCreacion_Cue,CBU_Cue,Saldo_Cue,CodTipoCuenta_Cue,DniCliente_Cue)
VALUES ('2001-01-01','1000000000000000000000',10000,1,'1111111'),
('2001-01-01','2000000000000000000000',10000,1,'2222222'),
('2001-01-01','3000000000000000000000',10000,1,'3333333'),
('2001-01-01','4000000000000000000000',10000,1,'4444444'),
('2001-01-01','5000000000000000000000',10000,1,'5555555'),
('2001-01-01','6000000000000000000000',10000,1,'6666666'),
('2001-01-01','7000000000000000000000',10000,1,'7777777'),
('2001-01-01','8000000000000000000000',10000,1,'8888888'),
('2001-01-01','9000000000000000000000',10000,1,'9999999'),
('2001-01-01','0100000000000000000000',10000,1,'11111110'),
('2001-01-01','1100000000000000000000',10000,1,'11111110'),
('2001-01-01','1222222222222222222222',10000,1,'11111111'),
('2001-01-01','1322222222222222222222',10000,1,'22222222'),
('2001-01-01','1444444444444444444444',10000,1,'44444444'),
('2001-01-01','1555555555555555555555',10000,1,'55555555');
-- TABLA TipoMovimiento
INSERT INTO TipoMovimiento (Descripcion_TipMov)
SELECT 'alta de cuenta' UNION
SELECT 'alta de prestamo' UNION
SELECT 'pago prestamo' UNION
SELECT 'transferencia';
-- TABLA Movimiento
INSERT INTO Movimiento (Fecha_Mov,Detalle_Mov,Importe_Mov,NumCuenta_Mov,CodTipoMovimiento_Mov)
VALUES ('2001-01-01','detalle movimiento 1',10000,1,1),
('2001-01-01','detalle movimiento 2',10000,2,1),
('2001-01-01','detalle movimiento 3',10000,3,1),
('2001-01-01','detalle movimiento 4',10000,4,1),
('2001-01-01','detalle movimiento 5',10000,5,1),
('2001-01-01','detalle movimiento 6',10000,6,1),
('2001-01-01','detalle movimiento 7',10000,7,1),
('2001-01-01','detalle movimiento 8',10000,8,1),
('2001-01-01','detalle movimiento 9',10000,9,1),
('2001-01-01','detalle movimiento 10',10000,10,1),
('2001-01-01','detalle movimiento 11',10000,11,1),
('2001-01-01','detalle movimiento 12',10000,12,1),
('2001-01-01','detalle movimiento 13',10000,13,1),
('2001-01-01','detalle movimiento 14',10000,14,1),
('2001-01-01','detalle movimiento 15',10000,15,1);
