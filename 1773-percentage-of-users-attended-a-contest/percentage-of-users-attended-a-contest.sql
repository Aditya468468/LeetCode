WITH total AS
(
    SELECT
    COUNT(*) totalCand
    FROM Users
)
SELECT
    r.contest_id,
    ROUND((COUNT(r.user_id)/total.totalCand)*100,2)AS percentage
FROM Users u
INNER JOIN Register r
ON u.user_id=r.user_id
CROSS JOIN total 
GROUP BY r.contest_id
ORDER BY percentage DESC,r.contest_id ASC;

