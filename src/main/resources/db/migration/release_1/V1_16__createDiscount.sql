CREATE TABLE PUBLIC.Discounts (
    discountId BIGSERIAL NOT NULL,
    discountName VARCHAR(50) NOT NULL,
    discountPercent NUMERIC(5, 3) NOT NULL,
    discountDescription VARCHAR(250) NOT NULL,
    fromDate TIMESTAMP WITH TIME ZONE,
    toDate TIMESTAMP WITH TIME ZONE,
    PRIMARY KEY (discountId)
);

CREATE TABLE PUBLIC.DiscountDetails (
    discountId BIGSERIAL NOT NULL,
    productId BIGSERIAL NOT NULL,
    CONSTRAINT discountId FOREIGN KEY (discountId) REFERENCES Discounts(discountId),
    CONSTRAINT productId FOREIGN KEY (productId) REFERENCES Products(productId),
    PRIMARY KEY (discountId, productId)
);

INSERT INTO PUBLIC.Discounts(discountName, discountPercent, discountDescription, fromDate, toDate) 
VALUES ('Cool Summer', '0.25', 'https://vietabinhdinh.edu.vn/wp-content/uploads/Background-bien-%E2%80%93-Beach-dep-tuoi-mat-tran-day-nang.jpg', '2022-12-16T12:00:00+00', '2023-03-08T12:00:00+00');

INSERT INTO PUBLIC.DiscountDetails(discountId, productId) VALUES ('1', '1');
INSERT INTO PUBLIC.DiscountDetails(discountId, productId) VALUES ('1', '2');

-- SELECT * FROM PUBLIC.Discounts;
-- SELECT * FROM PUBLIC.DiscountDetails;