CREATE TABLE PUBLIC.Carts (
    userId BIGSERIAL NOT NULL,
    cartTotal BIGINT NOT NULL,
    cartPrice NUMERIC(10, 2) NOT NULL,
    CONSTRAINT userId FOREIGN KEY (userId) REFERENCES Users(userId),
    PRIMARY KEY (userId)
);

CREATE TABLE PUBLIC.CartDetails (
    cartId BIGSERIAL NOT NULL,
    productId BIGSERIAL NOT NULL,
    CONSTRAINT cartId FOREIGN KEY (cartId) REFERENCES Carts(userId),
    CONSTRAINT productId FOREIGN KEY (productId) REFERENCES Products(productId),
    PRIMARY KEY (cartId, productId)
);

-- ALTER TABLE PUBLIC.Users
-- ADD COLUMN cartId BIGINT NOT NULL;

INSERT INTO PUBLIC.Carts(userId, cartTotal, cartPrice) VALUES ('1', '0', '0');
INSERT INTO PUBLIC.Carts(userId, cartTotal, cartPrice) VALUES ('2', '0', '0');

-- INSERT INTO PUBLIC.CartDetails(cartId, productId) VALUES ('1', '1');

SELECT * FROM PUBLIC.Carts;