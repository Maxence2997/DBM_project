CREATE VIEW VIEW_INVENTORY_INFOS (Inv_ID, Name, Module, Project_ID, Emp_ID, E_Name) AS




SELECT inv.Inv_ID, inv.Item_name, inv.Module_type, inv.Project_ID, pj.Emp_ID,  CONCAT(emp.First_name, ' ', emp.Last_name) AS NAME FROM test.INVENTORY AS inv LEFT JOIN test.PROJECT AS pj ON pj.Project_ID=inv.Project_ID LEFT JOIN test.EMPLOYEE AS emp ON emp.Emp_ID=pj.Emp_ID;

SELECT * FROM VIEW_INVENTORY_INFOS;