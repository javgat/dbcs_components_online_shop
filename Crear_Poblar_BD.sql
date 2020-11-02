create table USUARIO
(
	NIFCIF VARCHAR(9) not null primary key,
	NOMBRE VARCHAR(30) not null,
	DIRECCIONPOSTAL VARCHAR(30),
	DIRECCIONELECTRONICA VARCHAR(30),
	TELEFONO VARCHAR(9),
	PASSWORD VARCHAR(20) not null
);
insert into usuario (nifcif,nombre,direccionpostal,direccionelectronica,telefono,password) values
    ('111111U','primero','calle primero','primero@','111111','111'),
    ('222222U','segundo','calle segundo','segundo@','222222','222'),
    ('333333U','tercero','calle tercero','tercero@','333333','333'),
    ('444444U','cuarto','calle cuarto','cuarto@','444444','444'),
    ('555555U','cinco','calle cinco','cinco@','555555','555');

create table ROLEMPLEADO
(
	IDROL SMALLINT not null primary key,
	NOMBREROL VARCHAR(20) not null
);
INSERT INTO ROLEMPLEADO VALUES 
        (1,'EncargadoAlmacen'),
        (2,'TecnicoTaller'),
        (3,'GerenteVentas');

create table EMPLEADO
(
	NIFCIF VARCHAR(9) not null primary key,
	FECHACONTRATACION DATE not null,
	ROL SMALLINT not null,
                   FOREIGN KEY(NIFCIF) REFERENCES USUARIO(NIFCIF),
                   FOREIGN KEY(ROL) REFERENCES ROLEMPLEADO(IDROL)
);
insert into empleado (nifcif,fechacontratacion,rol) values
    ('222222U','01/01/2001',1),
    ('444444U','02/02/2002',3);

create table EMPRESA
(
	NIFCIF VARCHAR(9) not null primary key,
	ESCLIENTE SMALLINT,
	ESPROVEEDOR SMALLINT,
                    FOREIGN KEY(NIFCIF) REFERENCES USUARIO(NIFCIF)
);
insert into empresa (nifcif,escliente,esproveedor) values
    ('111111U',1,0),
    ('333333U',0,1),
    ('555555U',1,0);

create table CPU 
(
	IDTIPOCPU SMALLINT not null primary key,
	NOMBRETIPOCPU VARCHAR(20) not null
);
INSERT INTO CPU VALUES  
        (1,'AMD'),
        (2,'IntelCore');

create table CONFIGURACIONPC
(
	IDCONFIGURACION NUMERIC(5) not null primary key,
	TIPOCPU SMALLINT not null,
	VELOCIDADCPU NUMERIC(5) not null,
	CAPACIDADRAM NUMERIC(5) not null,
	CAPACIDADDD NUMERIC(5) not null,
	VELOCIDADTARJETAGRAFICA NUMERIC(5),
	MEMORIATARJETAGRAFICA NUMERIC(5),
                  FOREIGN KEY(TIPOCPU) REFERENCES CPU(IDTIPOCPU)
);
insert into configuracionpc (idconfiguracion,tipocpu,velocidadcpu,capacidadram,capacidaddd,velocidadtarjetagrafica,memoriatarjetagrafica) values
    (1111,1,1,1,1,1,1),
    (2222,2,2,2,2,2,2),
    (3333,1,3,3,3,3,3),
    (4444,1,4,4,4,4,4);

create table TIPOCOMPONENTE
(
	IDTIPOCOMPONENTE SMALLINT not null primary key,
	NOMBRETIPOCOMPONENTE VARCHAR(20) not null
);
INSERT INTO TIPOCOMPONENTE VALUES  
        (1,'TarjetaGrafica'),
        (2,'DiscoDuro'),
        (3,'PlacaBase'),
        (4,'Caja'),
        (5,'Procesador'),
        (6,'RAM');

create table DESCRIPCIONCOMPONENTE
(
	IDDESCRIPCION NUMERIC(5) not null primary key,
	TIPO SMALLINT not null,
	MARCA VARCHAR(30) not null,
	MODELO VARCHAR(30),
	PRECIO NUMERIC(5),
	CARACTERISTICASTECNICAS VARCHAR(50),
                  FOREIGN KEY(TIPO) REFERENCES TIPOCOMPONENTE(IDTIPOCOMPONENTE)
);

insert into descripcioncomponente (iddescripcion,tipo,marca,modelo,precio,caracteristicastecnicas) values
    (111,1,'marca1','modelo1',11,'caract 1'),
    (222,2,'marca1','modelo2',24,'caract 2'),
    (333,3,'marca2','modelo3',457,'caract 3'),
    (444,4,'marca5','modelo4',5555,'caract 4'),
    (555,5,'marca5','modelo5',678,'caract 5'),
    (666,6,'marca6','modelo6',66,'caract 6'),
    (777,1,'marca7','modelo7',778,'caract 7'),
    (888,2,'marca5','modelo8',234,'caract 8'),
    (999,3,'marca8','modelo8',88,'caract 9');


create table COMPONENTESENCONFIGURACION
(
	IDDESCRIPCION NUMERIC(5) not null,
	IDCONFIGURACION NUMERIC(5) not null,
                 FOREIGN KEY(IDCONFIGURACION) REFERENCES CONFIGURACIONPC(IDCONFIGURACION),
                 FOREIGN KEY(IDDESCRIPCION) REFERENCES DESCRIPCIONCOMPONENTE(IDDESCRIPCION)
);
insert into componentesenconfiguracion (iddescripcion,idconfiguracion) values
    (111,1111),
    (222,1111),
    (999,1111),
    (444,1111),
    (555,1111),
    (666,1111),
    (777,2222),
    (222,2222),
    (333,2222),
    (444,2222),
    (555,2222),
    (111,2222),
    (666,3333),
    (888,3333),
    (999,3333),
    (444,3333),
    (555,3333),
    (666,3333);

create table ESTADOVENTAPCS
(
	IDESTADOVENTA SMALLINT not null primary key,
	NOMBREESTADOVENTA VARCHAR(20) not null
);
INSERT INTO ESTADOVENTAPCs VALUES  
        (1,'Solicitado'),
        (2,'EnProceso'),
        (3,'Completado'),
        (4,'Enviado'),
        (5,'Entregado');


create table PEDIDOPC
(
	IDPEDIDO NUMERIC(5) not null primary key,
	CANTIDADSOLICITADA NUMERIC(5) not null,
              ESTADO SMALLINT not null,
	CONFIGURACIONSOLICITADA NUMERIC(5) not null,
	ENCARGADOPOR VARCHAR(9) not null,
                  FOREIGN KEY(CONFIGURACIONSOLICITADA) REFERENCES CONFIGURACIONPC(IDCONFIGURACION),
                  FOREIGN KEY(ENCARGADOPOR) REFERENCES EMPRESA(NIFCIF),
                  FOREIGN KEY(ESTADO) REFERENCES ESTADOVENTAPCS(IDESTADOVENTA)
);
insert into pedidopc (idpedido,cantidadsolicitada,estado,configuracionsolicitada,encargadopor) values
    (1,11,3,2222,'111111U'),
    (2,22,1,1111,'555555U'),
    (3,33,1,3333,'111111U'),
    (4,44,2,2222,'555555U');
