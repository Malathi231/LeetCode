SELECT
    emp.reports_to AS employee_id,
    manager.name,
    COUNT(*) AS reports_count,
    ROUND(AVG(emp.age)) AS average_age
FROM Employees emp
JOIN Employees manager
    ON emp.reports_to = manager.employee_id
GROUP BY emp.reports_to, manager.name
ORDER BY emp.reports_to;