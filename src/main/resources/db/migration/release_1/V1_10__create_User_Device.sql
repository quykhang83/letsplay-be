CREATE TABLE PUBLIC.Users (
    userId BIGSERIAL NOT NULL,
    userName VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    userPhone VARCHAR(50),
    userAvt TEXT,
    userDisplayname VARCHAR(50),
    userBio VARCHAR(255),
    primary key (userId)
);

CREATE TABLE PUBLIC.Devices (
    deviceId BIGSERIAL NOT NULL,
    deviceName VARCHAR(50),
    deviceOS VARCHAR(50),
    fcmToken VARCHAR(250) NOT NULL,
    userId BIGINT NOT NULL,
    primary key (deviceId)
);

INSERT INTO PUBLIC.Users(userName, email, userAvt)
VALUES ('hqkhang', 'quykhang831@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Users%2Favatar2.jpg?alt=media&token=587d4c1e-769a-42c3-852d-cb8139a8ce46');
INSERT INTO PUBLIC.Users(userName, email, userAvt)
VALUES ('lca', 'luuca792@gmail.com', 'https://firebasestorage.googleapis.com/v0/b/ctu-letsplay.appspot.com/o/Users%2Favatar.jpg?alt=media&token=be0f169d-0b04-4ca6-b8bc-bbe7f64d2e8c');

ALTER TABLE PUBLIC.Devices
ADD CONSTRAINT user_id_devices_fk FOREIGN KEY (userId) REFERENCES Users (userId);