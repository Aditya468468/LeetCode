WITH updated AS  -- Find the Latest Dates which updated before 16th as after 16th its irrelevant as they will stay 10 always
(
    SELECT 
    product_id,
    MAX(change_date) AS max_change_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)
SELECT  --  Now check are they got updated before 16th if yes give there new price
    u.product_id,
    p.new_price AS price
FROM Products as p
JOIN updated u
ON p.product_id=u.product_id AND u.max_change_date=p.change_date

UNION

SELECT  --  If Not the Just give there price as 10
    p.product_id,
    10 AS price 
FROM Products as p
LEFT JOIN updated u
ON p.product_id=u.product_id 
WHERE u.product_id IS NULL;


   
