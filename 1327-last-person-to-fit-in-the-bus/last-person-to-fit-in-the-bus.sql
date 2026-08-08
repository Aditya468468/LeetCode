WITH running_sum AS
(
    SELECT 
        turn,
        person_id,
        person_name,
        weight,
        SUM(weight) OVER(ORDER BY turn) AS running_weight
    FROM Queue
)
SELECT
person_name
FROM running_sum
WHERE running_weight<=1000
ORDER BY turn DESC 
LIMIT 1;
