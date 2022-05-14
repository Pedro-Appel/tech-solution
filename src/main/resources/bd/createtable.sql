CREATE TABLE users (
  uid uuid NOT NULL,
  password VARCHAR(255) NULL,
  name VARCHAR(255) NULL,
  PRIMARY KEY(uid)
);


CREATE TABLE product (
  uid uuid NOT NULL,
  description VARCHAR(255) NULL,
  name VARCHAR(45) NULL,
  price INTEGER NULL,
  PRIMARY KEY(uid)
);
