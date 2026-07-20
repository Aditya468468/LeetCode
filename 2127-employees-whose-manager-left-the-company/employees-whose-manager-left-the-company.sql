SELECT employee_id
FROM Employees e
WHERE salary<30000 AND manager_id IS NOT NULL
AND NOT EXISTS (SELECT 1 FROM Employees emp WHERE e.manager_id=emp.employee_id)
ORDER BY employee_id
