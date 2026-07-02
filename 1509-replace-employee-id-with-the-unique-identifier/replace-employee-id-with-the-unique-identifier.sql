SELECT empUni.unique_id,emp.name
FROM Employees AS emp
LEFT JOIN EmployeeUNI As empUNI
ON empUni.id=emp.id;
