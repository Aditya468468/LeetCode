WITH DailyTotals AS 
(
    SELECT
    visited_on,
    SUM(amount) as total
    FROM Customer
    GROUP BY visited_on
)

SELECT
    t1.visited_on,
    SUM(t2.total) AS amount,
    ROUND(AVG(t2.total),2) AS average_amount
FROM DailyTotals AS t1
INNER JOIN DailyTotals AS t2
ON t2.visited_on BETWEEN DATE_SUB(t1.visited_on,INTERVAL 6 DAY) AND t1.visited_on
GROUP BY t1.visited_on
HAVING COUNT(*)=7
ORDER BY t1.visited_on ASC;
