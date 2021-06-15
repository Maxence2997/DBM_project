CREATE VIEW VIEW_EMPLOYEE_PROJECT (Emp_ID, E_Name, Project_ID, P_status, Est_date) AS

SELECT 
    emp.Emp_ID,
    CONCAT(emp.First_name, ' ', emp.Last_name) AS Name,
    pj.Project_ID,
    pj.Project_status,
    pj.Established_date AS Est_date
FROM
    EMPLOYEE AS emp
        INNER JOIN
    PROJECT AS pj ON emp.Emp_ID = pj.Emp_ID;