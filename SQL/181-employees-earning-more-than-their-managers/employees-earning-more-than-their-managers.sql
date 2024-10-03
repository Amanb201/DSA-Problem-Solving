# Write your MySQL query statement below
SELECT emp.name as Employee
FROM Employee emp JOIN Employee mang
ON emp.managerId = mang.id
WHERE emp.salary > mang.salary 