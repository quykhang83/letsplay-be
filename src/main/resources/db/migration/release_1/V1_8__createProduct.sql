CREATE TABLE PUBLIC.Products (
    productId bigserial NOT NULL,
    productName VARCHAR(250) NOT NULL,
    productPrice NUMERIC(10, 2) NOT NULL,
    productDescription VARCHAR(250) NOT NULL,
    productTypeId bigint NOT NULL,
    productCapacity NUMERIC(10, 2) NOT NULL,
    productDownloads bigint NOT NULL DEFAULT 0,
    primary key (productId)
);

CREATE TABLE PUBLIC.ProductTypes (
    productTypeId bigserial NOT NULL,
    productTypeName VARCHAR(250) NOT NULL,
    productTypeDescription VARCHAR(250) NOT NULL,
    primary key (productTypeId)
);

ALTER TABLE PUBLIC.Products
ADD CONSTRAINT producttype_id_fk FOREIGN KEY (productTypeId) REFERENCES ProductTypes (productTypeId);

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('Null', 'It demonstrates for a product which dont have any type');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('Sport', 'Sports games have expanded in variety, offering full-fledged partnerships with major sporting organizations');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('Shooter', 'The shooter is another long-standing genre that developed several early offshoots');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('Puzzler', 'Puzzlers and party games also have a significant overlap, with both emphasizing game mechanics');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('FIFA Simulator', '123000','A demo sport game', '1', '200.5', '100');