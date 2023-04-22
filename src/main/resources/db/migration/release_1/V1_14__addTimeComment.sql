ALTER TABLE PUBLIC.Comments
ADD COLUMN createdTime TIMESTAMP WITH TIME ZONE;

SET TIME ZONE 'UTC';
INSERT INTO PUBLIC.Comments(commentContent, commentRecomment, productId, userId, createdTime)
VALUES ('It is really interesting! A great game!', true, '1', '1', '2023-12-16T12:00:00+07');