WITH cat_table AS
(
   SELECT "Low Salary" AS category
   UNION
   SELECT "Average Salary" AS category
   UNION
   SELECT "High Salary" AS category

),
new_table AS
(
    SELECT
    account_id,
    (CASE 
    WHEN income<20000 THEN 'Low Salary'
    WHEN income>=20000 AND income<=50000 THEN 'Average Salary'
    WHEN income>50000 THEN 'High Salary'
    END ) as category
    FROM Accounts
)

SELECT 
    c.category,
    COUNT(t.account_id) AS accounts_count 
FROM cat_table c
LEFT JOIN new_table t
ON c.category=t.category
GROUP BY c.category




