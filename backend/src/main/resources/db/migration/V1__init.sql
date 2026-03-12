CREATE TABLE producto (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    precio NUMERIC(12,2),
    stock INT,
    categoria_id BIGINT,
    proveedor_id BIGINT,
    sku VARCHAR(255),
    imei_serial VARCHAR(255)
);

CREATE TABLE categoria (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion VARCHAR(255)
);

CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(255),
    direccion VARCHAR(255)
);

CREATE TABLE pedido (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT,
    fecha TIMESTAMP,
    estado VARCHAR(255),
    total NUMERIC(12,2)
);

CREATE TABLE pedido_detalle (
    id BIGSERIAL PRIMARY KEY,
    pedido_id BIGINT,
    producto_id BIGINT,
    cantidad INT,
    precio_unitario NUMERIC(12,2),
    subtotal NUMERIC(12,2)
);

CREATE TABLE pago (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT,
    referencia_id BIGINT,
    monto NUMERIC(12,2),
    metodo VARCHAR(255),
    fecha TIMESTAMP,
    estado VARCHAR(255),
    referencia VARCHAR(255)
);

CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(255),
    enabled BOOLEAN
);
