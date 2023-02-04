CREATE TABLE PUBLIC.Status (
    statusId SERIAL NOT NULL,
    statusName VARCHAR(50) NOT NULL,
    statusDescription VARCHAR(250) NOT NULL,
    primary key (statusId)
);

INSERT INTO PUBLIC.Status(statusName, statusDescription)
VALUES ('pending', 'Request is being processed');

INSERT INTO PUBLIC.Status(statusName, statusDescription)
VALUES ('approved', 'Request was approved');

INSERT INTO PUBLIC.Status(statusName, statusDescription)
VALUES ('rejected', 'Request was rejected');

ALTER TABLE PUBLIC.Requests
DROP COLUMN "status";

ALTER TABLE PUBLIC.Requests
ADD COLUMN "statusid" INT NOT NULL DEFAULT 1;

ALTER TABLE PUBLIC.Requests
ADD CONSTRAINT status_id_fk FOREIGN KEY (statusid) REFERENCES Status (statusid);