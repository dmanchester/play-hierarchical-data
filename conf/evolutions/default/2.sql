# --- !Ups

INSERT INTO country VALUES (1, 'Germany');
INSERT INTO country VALUES (2, 'France');
INSERT INTO country VALUES (3, 'Spain');

INSERT INTO city VALUES (1, 1, 'Berlin', 3462000);
INSERT INTO city VALUES (2, 1, 'Hamburg', 1796000);
INSERT INTO city VALUES (3, 1, 'Cologne', 1006000);
INSERT INTO city VALUES (4, 2, 'Lyon', 1488000);
INSERT INTO city VALUES (5, 2, 'Marseille', 1489000);
INSERT INTO city VALUES (6, 2, 'Paris', 10620000);
INSERT INTO city VALUES (7, 3, 'Barcelona', 5570000);
INSERT INTO city VALUES (8, 3, 'Madrid', 6574000);

 
# --- !Downs
 
DELETE FROM city;

DELETE FROM country;
