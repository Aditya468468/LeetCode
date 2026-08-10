# Write your MySQL query statement below

SELECT *
FROM products
WHERE REGEXP_LIKE(description,'(^|[^0-9A-Za-z])SN[0-9]{4}-[0-9]{4}([^0-9A-Za-z]{1}|$)','c')
ORDER BY product_id;
