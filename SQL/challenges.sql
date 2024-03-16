WITH data /*creating the dataset we will need to filter*/
AS
(
SELECT h.hacker_id h_id, h.name name, COUNT(c.challenge_id) counter /*have to add alies keywords otherwise can not call outside of the WITH CLAUSE*/
FROM Hackers h
    JOIN Challenges c ON h.hacker_id = c.hacker_id
GROUP BY h.hacker_id, h.name
)

SELECT h_id, name, counter
FROM data
WHERE counter = (SELECT MAX(counter) FROM data) /*We want to show all the hackers with the maximum amount of challanges*/
OR
counter IN (SELECT counter 
                  FROM data
                  GROUP BY counter
                  HAVING COUNT(counter) = 1) /*If a 'specific' number of challanges did not brought to the table show. IF ALREADY DID pass*/
ORDER BY counter desc, h_id