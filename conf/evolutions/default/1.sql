# --- !Ups

CREATE TABLE country (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE city (
  id INT PRIMARY KEY,
  country_id INT NOT NULL,
  name VARCHAR(255) NOT NULL,
  population INT NOT NULL,
  FOREIGN KEY(country_id) REFERENCES country
);

 
# --- !Downs
 
DROP TABLE city;

DROP TABLE country;
