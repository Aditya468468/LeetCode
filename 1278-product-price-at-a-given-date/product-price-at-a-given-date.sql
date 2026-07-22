WITH updated AS
(
    SELECT 
    product_id,
    MAX(change_date) AS max_change_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
)
SELECT 
    u.product_id,
    p.new_price AS price
FROM Products as p
JOIN updated u
ON p.product_id=u.product_id AND u.max_change_date=p.change_date


UNION

SELECT 
    p.product_id,
    10 AS price 
FROM Products as p
LEFT JOIN updated u
ON p.product_id=u.product_id 
WHERE u.product_id IS NULL;





   
