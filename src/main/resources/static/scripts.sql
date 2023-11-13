CREATE TABLE IF NOT EXISTS PRODUCT (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DOUBLE NOT NULL,
    qty INT NOT NULL
);

INSERT INTO PRODUCT (id, name, description, price, qty) VALUES
(1, 'Book', 'Book Homo Deus', 49.99, 100),
(2, 'Xbox game', 'Xbox game CyberPunk2077', 209.99, 50),
(3, 'Movie CD', 'Movie Equilibrium', 39.99, 75);

CREATE TABLE MANAGER (
    id serial,
    first_name varchar(200),
    last_name varchar(200),
    bonus integer
);

CREATE TABLE CUSTOMER (
    id  serial,
    first_name varchar(200),
    last_name varchar(200),
    birth_date varchar(50),
    phone text,
    email text,
    manager_id integer
);