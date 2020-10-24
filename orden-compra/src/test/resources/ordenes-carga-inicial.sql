--carga inicial status_orden
insert into status_orden(status_orden_id,clave,descripcion) values(1, 'Registrada', 'Registrada');
insert into status_orden(status_orden_id,clave,descripcion) values(2, 'Pagada', 'Pagada');
insert into status_orden(status_orden_id,clave,descripcion) values(3,'En envio', 'En envio');
insert into status_orden(status_orden_id,clave,descripcion) values(4, 'Entregada','Entrada');
insert into status_orden(status_orden_id,clave,descripcion) values(5, 'Cancelada', 'Cancelada');

--carga en artículo
insert into articulo(articulo_id,nombre,precio) values(1,'Laptop',23500.45);
insert into articulo(articulo_id,nombre,precio) values(2,'Tablet',3500.25);

