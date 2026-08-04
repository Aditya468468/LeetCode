WITH consecutive_seat AS 
(
    SELECT
    s1.id,
    CASE 
        WHEN s1.id%2=0 THEN (SELECT s2.id FROM Seat s2 WHERE s2.id=s1.id-1) 
        ELSE (SELECT s2.id FROM Seat s2 WHERE s2.id=s1.id+1) 
    END AS cons_id
    FROM Seat s1 
)

SELECT 
    COALESCE(c.id,s.id) AS id,
    s.student
FROM Seat s 
LEFT JOIN consecutive_seat c
ON s.id=c.cons_id
ORDER BY id;