SELECT * FROM PUBLIC.Requests r 
INNER JOIN PUBLIC.Status s ON r.statusid = s.statusid;
