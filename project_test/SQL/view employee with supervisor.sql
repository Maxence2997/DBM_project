CREATE VIEW VIEW_EMPLOYEE_SUPERVISOR (Emp_ID , E_name , Address , Phone_num , Perf , Supervisor_ID , Supervior) AS
    SELECT 
        emp.Emp_ID,
        CONCAT(emp.First_name, ' ', emp.Last_name) AS Name,
        emp.Address,
        emp.Phone_number,
        emp.Performance,
        emp.Supervisor_ID,
        CONCAT(s.First_name, ' ', s.Last_name) AS Supervisor
    FROM
        EMPLOYEE AS emp
            INNER JOIN
        EMPLOYEE AS s ON emp.Supervisor_ID = s.Emp_ID;
        
SELECT * FROM EMPLOYEE_WITH_SUPERVISOR;