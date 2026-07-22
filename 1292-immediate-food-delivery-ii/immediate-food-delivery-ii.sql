
SELECT
    ROUND(
        (SUM(CASE WHEN order_date=customer_pref_delivery_date THEN 1 ELSE 0 END)/COUNT(*))*100,2) 
        AS immediate_percentage
FROM(
    SELECT
    d1.customer_id,
    d1.delivery_id,
    d1.order_date,
    d1.customer_pref_delivery_date
    FROM Delivery d1
    WHERE d1.order_date= (
        SELECT
        MIN(order_date)
        FROM Delivery d2
        WHERE d1.customer_id=d2.customer_id
    )
 ) AS first_order

    

