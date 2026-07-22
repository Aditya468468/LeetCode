SELECT 
    a1.sell_date,
    COUNT(DISTINCT a1.product) num_sold,
    GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',') AS products
FROM Activities a1
GROUP BY a1.sell_date
