SELECT
    emp.name,
    b.bonus
FROM Employee AS emp
LEFT JOIN Bonus AS b
ON emp.empId=b.empId
WHERE b.bonus IS NULL OR b.bonus<1000;

