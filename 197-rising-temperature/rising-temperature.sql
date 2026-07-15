SELECT
    currDate.id
FROM Weather AS currDate
INNER JOIN Weather AS prevDate
ON currDate.recordDate - prevDate.recordDate = 1
AND currDate.temperature>prevDate.temperature;
