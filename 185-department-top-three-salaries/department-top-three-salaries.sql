WITH first_max AS (
    SELECT departmentId,
           MAX(salary) AS first
    FROM Employee
    GROUP BY departmentId
),
second_max AS (
    SELECT e.departmentId,
           MAX(e.salary) AS second_max
    FROM Employee e
    WHERE salary != (
        SELECT first
        FROM first_max f
        WHERE f.departmentId = e.departmentId
    )
    GROUP BY e.departmentId
),
third_max AS (
    SELECT e.departmentId,
           MAX(e.salary) AS third_max
    FROM Employee e
    WHERE salary != (
              SELECT first
              FROM first_max f
              WHERE f.departmentId = e.departmentId
          )
      AND salary != (
              SELECT second_max
              FROM second_max s
              WHERE s.departmentId = e.departmentId
          )
    GROUP BY e.departmentId
),
top_salary AS
(
       SELECT f.departmentId,
           f.first AS first_max,
           s.second_max,
           t.third_max
    FROM first_max f
    LEFT JOIN second_max s
        ON f.departmentId = s.departmentId
    LEFT JOIN third_max t
        ON f.departmentId = t.departmentId
)
SELECT 
    dept.name AS Department ,
    emp.name AS Employee,
    emp.salary AS Salary
FROM Employee AS emp
JOIN Department AS dept
ON dept.id=emp.departmentId
JOIN top_salary t
ON t.departmentId=emp.departmentId
WHERE emp.salary=t.first_max 
    OR emp.salary=t.second_max
    OR emp.salary=t.third_max
