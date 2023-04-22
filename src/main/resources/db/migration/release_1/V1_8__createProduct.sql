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
VALUES ('#', 'Product with no type');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('On Sale', 'Sports games have expanded in variety, offering full-fledged partnerships with major sporting organizations');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('Feature & Recommended', 'The shooter is another long-standing genre that developed several early offshoots');

INSERT INTO PUBLIC.ProductTypes(productTypeName, productTypeDescription)
VALUES ('Best With Friends', 'Puzzlers and party games also have a significant overlap, with both emphasizing game mechanics');



INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Among Us', '49000','An online and local party game of teamwork and betrayal for 4-15 players...in space!', '2', '80', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('DORAEMON STORY OF SEASONS', '550000','Japan''s adored Doraemon meets Story of Seasons in this new, fresh take on farming, now on Let''s Play! The setting is Natura, and the theme is creating bonds. While doing so, enjoy the heartwarming interactions through each character in the story!', '4', '300.2', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('DRAGON BALL Z: KAKAROT', '800000','Relive the story of Goku and other Z Fighters in DRAGON BALL Z: KAKAROT! Beyond the epic battles, experience life in the DRAGON BALL Z world as you fight, fish, eat, and train with Goku, Gohan, Vegeta and others.', '3', '12000', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('EA SPORTS FIFA 23', '1090000','FIFA 23 brings The World''s Game to the pitch, with HyperMotion2 Technology, men''s and women''s FIFA World Cup™coming during the season, women''s club teams, cross-play features*, and more.', '4', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('God of War', '1139000','His vengeance against the Gods of Olympus years behind him, Kratos now lives as a man in the realm of Norse Gods and monsters. It is in this harsh, unforgiving world that he must fight to survive… and teach his son to do the same.', '3', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Little Nightmares', '298000','Immerse yourself in Little Nightmares, a dark whimsical tale that will confront you with your childhood fears! Help Six escape The Maw - a vast, mysterious vessel inhabited by corrupted souls looking for their next meal.', '3', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Ori and the Will of the Wisps', '250000','Play the critically acclaimed masterpiece. Embark on a new journey in a vast, exotic world where you''ll encounter towering enemies and challenging puzzles on your quest to unravel Ori''s destiny.', '2', '300', '100');

INSERT INTO PUBLIC.Products(productName, productPrice, productDescription, productTypeId, productCapacity, productDownloads)
VALUES ('Oxygen Not Included', '220000','Oxygen Not Included is a space-colony simulation game. Deep inside an alien space rock your industrious crew will need to master science, overcome strange new lifeforms, and harness incredible space tech to survive, and possibly, thrive.', '4', '300', '100');