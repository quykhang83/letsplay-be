CREATE TABLE PUBLIC.Comments (
    commentId bigserial NOT NULL,
    commentContent VARCHAR(250) NOT NULL,
    commentRecomment BOOLEAN NOT NULL,
    productId bigint NOT NULL,
    CONSTRAINT productId FOREIGN KEY (productId) REFERENCES Products(productId),
    primary key (commentId)
);

INSERT INTO PUBLIC.Comments(commentContent, commentRecomment, productId)
VALUES ('It is really interesting! A great game!', true, '1');

SELECT * FROM PUBLIC.Comments;