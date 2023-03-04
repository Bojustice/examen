CREATE TABLE if NOT EXISTS cliente (
    id SERIAL,
    nombres VARCHAR (100) NOT NULL,
    email VARCHAR (50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE if NOT EXISTS factura (
    id SERIAL,
    fecha DATE NOT NULL,
    total FLOAT NOT NULL,
    cliente_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cliente_id)
    REFERENCES cliente(id)
);
