With min_table AS
(
    SELECT product_id,
    MIN(year) AS year
    FROM Sales
    GROUP BY product_id
)
SELECT 
    s.product_id ,
    s.year AS first_year,
    s.quantity,
    s.price
FROM Sales s
INNER JOIN min_table
ON s.product_id=min_table.product_id AND s.year=min_table.year;
