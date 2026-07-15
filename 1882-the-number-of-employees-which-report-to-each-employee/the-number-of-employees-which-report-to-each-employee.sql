SELECT
    manager.employee_id,
    manager.name,
    COUNT(*) reports_count,
    ROUND(AVG(emp.age)) average_age
FROM Employees AS manager
JOIN Employees AS emp
ON manager.employee_id=emp.reports_to
GROUP BY manager.employee_id,manager.name
ORDER BY manager.employee_id;





