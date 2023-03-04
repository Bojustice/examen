CREATE VIEW factura_view as
 select f.*,c.nombres cliente
 from factura f JOIN cliente c
 ON f.cliente_id = c.id;