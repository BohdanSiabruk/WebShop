DROP TABLE users;
CREATE TABLE shop.users (
  id INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(46) NULL,
  lastName VARCHAR(46) NULL,
  email VARCHAR(46) NULL,
  password VARCHAR(46) NULL,
  avatar VARCHAR(70) NULL,
  PRIMARY KEY (id));


INSERT INTO users(id, firstName, lastName, email, password, avatar) VALUES( DEFAULT, 'Bohdan', 'Siabruk', 'Bohdan_Siabruk@epam.com', 'siabruk86', 'Bohdan_Siabruk@epam.com.png');
INSERT INTO users(id, firstName, lastName, email, password) VALUES( DEFAULT, 'Oleksii', 'Linnyk', 'Oleksii_Linnyk@epam.com', 'oleksii97');



DROP TABLE products;
CREATE TABLE products (
  id INT NOT NULL AUTO_INCREMENT,
  firm VARCHAR(46) NOT NULL,
  model VARCHAR(46) NOT NULL,
  purpose VARCHAR(46) NOT NULL,
  price DECIMAL NULL,
  picture VARCHAR(46) NULL,
  PRIMARY KEY (id));

INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'spark', 'mtb', 30000, 'images/product/29er.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'scale', 'street', 50000, '/images/product/citybike.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', 'habbit', 'mtb', 80000, '/images/product/downhill.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Trek', 'team', 'street', 40000, '/images/product/fullsusp.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'epic', 'mtb', 60000, '/images/product/mtb.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', '', 'cyclocross', 30000, '/images/product/road.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'stumpjumper', 'cyclocross', 30000, '/images/product/trial.jpg');

INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'spark', 'mtb', 28000, 'images/product/29er.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'scale', 'street', 48000, '/images/product/citybike.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', 'habbit', 'mtb', 78000, '/images/product/downhill.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Trek', 'team', 'street', 38000, '/images/product/fullsusp.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'epic', 'mtb', 58000, '/images/product/mtb.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', '', 'cyclocross', 28000, '/images/product/road.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'stumpjumper', 'cyclocross', 26000, '/images/product/trial.jpg');

INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'spark', 'mtb', 26000, 'images/product/29er.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'scale', 'street', 44000, '/images/product/citybike.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', 'habbit', 'mtb', 74000, '/images/product/downhill.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Trek', 'team', 'street', 36000, '/images/product/fullsusp.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'epic', 'mtb', 56000, '/images/product/mtb.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', '', 'cyclocross', 22000, '/images/product/road.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'stumpjumper', 'cyclocross', 23000, '/images/product/trial.jpg');

INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'spark', 'mtb', 25000, 'images/product/29er.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'scale', 'street', 45000, '/images/product/citybike.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', 'habbit', 'mtb', 75500, '/images/product/downhill.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Trek', 'team', 'street', 35500, '/images/product/fullsusp.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'epic', 'mtb', 55550, '/images/product/mtb.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', '', 'cyclocross', 20450, '/images/product/road.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'stumpjumper', 'cyclocross', 23500, '/images/product/trial.jpg');

INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'spark', 'mtb', 29600, 'images/product/29er.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'scale', 'street', 45200, '/images/product/citybike.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', 'habbit', 'mtb', 78965, '/images/product/downhill.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Trek', 'team', 'street', 36552, '/images/product/fullsusp.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'epic', 'mtb', 60000, '/images/product/mtb.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', '', 'cyclocross', 25896, '/images/product/road.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'stumpjumper', 'cyclocross', 14587, '/images/product/trial.jpg');

INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'spark', 'mtb', 36987, 'images/product/29er.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'scale', 'street', 45698, '/images/product/citybike.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', 'habbit', 'mtb', 69877, '/images/product/downhill.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Trek', 'team', 'street', 39875, '/images/product/fullsusp.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'epic', 'mtb', 51478, '/images/product/mtb.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', '', 'cyclocross', 30125, '/images/product/road.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'stumpjumper', 'cyclocross', 29874, '/images/product/trial.jpg');

INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'spark', 'mtb', 25874, 'images/product/29er.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Scott', 'scale', 'street', 36987, '/images/product/citybike.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', 'habbit', 'mtb', 78545, '/images/product/downhill.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Trek', 'team', 'street', 36521, '/images/product/fullsusp.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'epic', 'mtb', 54126, '/images/product/mtb.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Cannondale', '', 'cyclocross', 29852, '/images/product/road.jpg');
INSERT INTO products(id, firm, model, purpose, price, picture) VALUES( DEFAULT, 'Specialized', 'stumpjumper', 'cyclocross', 26958, '/images/product/trial.jpg');

DROP TABLE orders;
CREATE TABLE orders (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NOT NULL,
  `status_info` VARCHAR(100) NULL,
  `date` DATETIME NOT NULL,
  `login_user` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

  DROP TABLE basket_products;
  CREATE TABLE basket_products (
    `id` INT NOT NULL AUTO_INCREMENT,
    `idProd` INT NOT NULL ,
    `firm` VARCHAR(45) NOT NULL,
    `model` VARCHAR(45) NOT NULL,
    `price` DECIMAL ZEROFILL NOT NULL,
    `amountl` INT NOT NULL,
    PRIMARY KEY (`id`));
