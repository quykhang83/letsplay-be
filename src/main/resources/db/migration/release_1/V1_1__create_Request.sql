CREATE TABLE PUBLIC.Requests (
    reqId bigserial NOT NULL,
    createdTime DATE NOT NULL,
    employeeId int8 NOT NULL,
    fromDate DATE NOT NULL,
    reason VARCHAR(250) NOT NULL,
    requestType VARCHAR(50) NOT NULL,
    toDate DATE NOT NULL,
    primary key (reqId)
);
INSERT INTO PUBLIC.Requests(createdTime, employeeId, fromDate, reason, requestType,toDate)
VALUES ('2022-12-04T02:07:01', '123', '2022-12-05T07:07:07','test reason', 'leave', '2022-12-06T07:07:07');