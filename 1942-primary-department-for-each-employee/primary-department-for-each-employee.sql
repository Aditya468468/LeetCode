-- Lets Handle Single Dept
SELECT
    employee_id,
    department_id
FROM Employee
GROUP BY employee_id 
HAVING COUNT(department_id)=1

UNION ALL
-- Lets Handle Multiple Dept 
SELECT
    employee_id,
    department_id
FROM Employee
WHERE primary_flag='Y'







