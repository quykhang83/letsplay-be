CREATE TABLE PUBLIC.ProductDemos (
    productDemoId bigserial NOT NULL,
    productDemoTitle VARCHAR(250) NOT NULL,
    productDemoUrl VARCHAR(250) NOT NULL,
    productId bigint NOT NULL,
    CONSTRAINT productId FOREIGN KEY (productId) REFERENCES Products(productId),
    primary key (productDemoId)
);

INSERT INTO PUBLIC.ProductDemos(productDemoTitle, productDemoUrl, productId)
VALUES ('Demo Sport', 'https://fms-laravel-images.s3.ap-southeast-1.amazonaws.com/images/logoAxonActive.png', '1');

SELECT * FROM PUBLIC.ProductDemos;