SELECT
    s1.id,
    CASE 
    WHEN s1.id%2!=0 THEN COALESCE((SELECT student FROM Seat s2 WHERE s2.id=s1.id+1),s1.student)
    WHEN s1.id%2=0 THEN (SELECT student FROM Seat s2 WHERE
    s2.id=s1.id-1)
    END student
FROM Seat s1




