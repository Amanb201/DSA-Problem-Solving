# Write your MySQL query statement below
SELECT emp.name as Employee
FROM Employee emp
WHERE emp.salary > (
    SELECT salary FROM Employee mang
    WHERE emp.managerId = mang.id);