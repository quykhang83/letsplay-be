CREATE TABLE PUBLIC.Receipts (
    receiptId BIGSERIAL NOT NULL,
    receiptTax NUMERIC(10, 2) NOT NULL,
    userId BIGINT NOT NULL,
    receiptDate TIMESTAMP WITH TIME ZONE,
    receiptTotal NUMERIC(10, 2) NOT NULL,
    CONSTRAINT userId FOREIGN KEY (userId) REFERENCES Users(userId),
    PRIMARY KEY (receiptId)
);

CREATE TABLE PUBLIC.ReceiptDetails (
    receiptId BIGSERIAL NOT NULL,
    productId BIGSERIAL NOT NULL,
    CONSTRAINT receiptId FOREIGN KEY (receiptId) REFERENCES Receipts(receiptId),
    CONSTRAINT productId FOREIGN KEY (productId) REFERENCES Products(productId),
    PRIMARY KEY (receiptId, productId)
);