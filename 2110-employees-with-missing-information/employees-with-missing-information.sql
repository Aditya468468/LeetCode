SELECT
    emp.employee_id
FROM Employees emp
LEFT JOIN Salaries s
ON emp.employee_id = s.employee_id
WHERE s.employee_id IS NULL

UNION

SELECT
    s.employee_id
FROM Employees emp
RIGHT JOIN Salaries s
ON emp.employee_id = s.employee_id
WHERE emp.employee_id IS NULL

ORDER BY employee_id;
