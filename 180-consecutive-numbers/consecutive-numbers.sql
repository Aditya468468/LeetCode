SELECT DISTINCT c1.num ConsecutiveNums 
FROM Logs AS c1
INNER JOIN Logs AS c2
ON c2.id=c1.id+1
INNER JOIN Logs c3 ON c3.id=c1.id+2
WHERE c1.num=c2.num AND c2.num=c3.num;

