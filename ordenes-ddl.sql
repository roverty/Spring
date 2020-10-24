create sequence orden_compra_seq start with 100;
create sequence articulo_seq start with 100;

create table status_orden(
  status_orden_id decimal(2,0) constraint status_orden_pk primary key,
  clave varchar2(50) not null,
  descripcion varchar2(500) not null
);

create table orden_compra(
  orden_compra_id decimal(10,0) constraint orden_compra_pk primary key,
  fecha_compra date not null,
  status_orden_id decimal (2,0) not null constraint orden_compra_status_fk
    references status_orden(status_orden_id),
  fecha_status date not null
);

create table articulo (
  articulo_id decimal(10,0) constraint articulo_pk primary key,
  nombre varchar2(100) not null,
  precio decimal(10,2) not null 
);

create table detalle_orden(
  orden_compra_id decimal(10,0) not null,
  articulo_id decimal(10,0) not null,
  cantidad decimal (5,0) not null,
  constraint detalle_orden_orden_id_fk foreign key(orden_compra_id)
    references orden_compra(orden_compra_id),
  constraint detalle_orden_art_id_fk foreign key(articulo_id)
    references articulo(articulo_id),
  constraint detalle_orden_pk primary key(orden_compra_id,articulo_id)
);
