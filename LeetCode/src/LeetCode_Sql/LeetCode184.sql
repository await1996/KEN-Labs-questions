select d.name as Department,e.name as Employee,e.Salary from
(select DepartmentId,max(salary) as maxS from Employee group by DepartmentId) t,
Employee e,Department d
where t.DepartmentId=d.id and t.DepartmentId=e.DepartmentId and t.maxS=e.salary;