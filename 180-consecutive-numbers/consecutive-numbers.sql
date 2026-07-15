
SELECT 
    DISTINCT currLog.num ConsecutiveNums
FROM Logs as currLog
JOIN Logs as prevLog
ON currLog.id=prevLog.id-1
JOIN Logs as nextLog
On currLog.id=nextLog.id+1
WHERE prevLog.num=currLog.num AND currLog.num=nextLog.num;


