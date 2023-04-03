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

INSERT INTO PUBLIC.Users(userName, email)
VALUES ('hqkhang', 'khang.huynhquy@axonactive.com');
INSERT INTO PUBLIC.Users(userName, email)
VALUES ('lca', 'ca.luu@axonactive.com');

ALTER TABLE PUBLIC.Devices
ADD CONSTRAINT user_id_devices_fk FOREIGN KEY (userId) REFERENCES Users (userId);