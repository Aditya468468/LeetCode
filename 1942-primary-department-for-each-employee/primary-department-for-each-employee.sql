-- Lets Handle Single Dept
WITH temp AS (
    SELECT 
        employee_id
    FROM Employee
    GROUP BY employee_id
    HAVING COUNT(department_id) = 1
)
SELECT 
    e.employee_id,
    e.department_id
FROM Employee e
INNER JOIN temp ON temp.employee_id = e.employee_id

UNION ALL

-- Lets Handle Multiple Dept
SELECT 
    employee_id,
    department_id
FROM Employee
WHERE primary_flag = 'Y';