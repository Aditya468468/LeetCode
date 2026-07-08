SELECT 
    e.name AS Employee
FROM Employee AS e
INNER JOIN Employee AS m
ON m.id=e.managerId AND e.salary>m.salary;
