-- Initialize table BOOK

CREATE TABLE BOOK
(
    id    serial PRIMARY KEY,
    title VARCHAR(200) UNIQUE NOT NULL
);

INSERT INTO BOOK(title)
VALUES ('The Little Prince');

INSERT INTO BOOK(title)
VALUES ('Harry Potter and the Philosopher''s Stone');

INSERT INTO BOOK(title)
VALUES ('Odyssey');

INSERT INTO BOOK(title)
VALUES ('Clean Code');

-- Initialize table CUSTOMER

CREATE TABLE CUSTOMER
(
    id   serial PRIMARY KEY,
    name VARCHAR(200) UNIQUE NOT NULL
);

INSERT INTO CUSTOMER(name)
VALUES ('John Doe');

INSERT INTO CUSTOMER(name)
VALUES ('Jane Doe');