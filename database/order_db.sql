CREATE DATABASE IF NOT EXISTS order_db;
USE order_db;

CREATE TABLE orders (
    order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    product_id BIGINT,
    quantity INT NOT NULL,
    total_amount DOUBLE NOT NULL,
    status VARCHAR(255)
);
