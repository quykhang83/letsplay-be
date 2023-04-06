CREATE TABLE PUBLIC.Libraries (
    userId BIGSERIAL NOT NULL,
    productId BIGSERIAL NOT NULL,
    PRIMARY KEY (userId, productId),
    CONSTRAINT userId FOREIGN KEY (userId) REFERENCES Users(userId),
    CONSTRAINT productId FOREIGN KEY (productId) REFERENCES Products(productId)
);
