SELECT
    w1.id
FROM Weather AS w1 -- today
JOIN Weather AS w2 -- Yesterday
ON DATEDIFF(w1.recordDate,w2.recordDate)=1
AND w1.temperature>w2.temperature;