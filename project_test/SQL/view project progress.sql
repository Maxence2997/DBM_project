CREATE VIEW VIEW_PROJECT_PROGRESS (Project_ID,P_status, Emp_ID, Responsable, Module, Delivery, ESD, Receiving_Date, Contract, Date_diff) AS 
SELECT 
     pj.Project_ID,
    pj.Project_status,
    pj.Emp_ID,
    emp.Last_name AS Responsable,
    PUR.Module_type,
	CONCAT(FORMAT(((RCPT.Vol*100)/Pur.Vol),0),'%') AS Product_Delivery,
    PUR.ESD,
    RCPT.Date,
    (CASE
        WHEN
            (CASE
                WHEN ((RCPT.Vol*100)/Pur.Vol) < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)
                ELSE DATEDIFF(RCPT.Date, PUR.ESD)
            END) >= 29
        THEN
            'Violated'
        WHEN
            ((CASE
                WHEN ((RCPT.Vol*100)/Pur.Vol) < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)
                ELSE DATEDIFF(RCPT.Date, PUR.ESD)
            END) < 29
                && (CASE
                WHEN ((RCPT.Vol*100)/Pur.Vol) < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)
                ELSE DATEDIFF(RCPT.Date, PUR.ESD)
            END) >= 15)
        THEN
            'Delayed'
        ELSE 'In Time'
    END) AS Contract,
    (CASE
        WHEN ((RCPT.Vol*100)/Pur.Vol) < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)
        ELSE DATEDIFF(RCPT.Date, PUR.ESD)
    END) AS Date_difference
FROM
    PROJECT AS pj
        LEFT JOIN
    EMPLOYEE AS emp ON emp.Emp_ID = pj.Emp_ID
        LEFT JOIN
    PURCHASE AS PUR ON (PUR.Project_ID = pj.Project_ID)
        LEFT JOIN
    RECEIPT AS RCPT ON (RCPT.Project_ID = PUR.Project_ID
        AND RCPT.Module_type = PUR.MOdule_type)
ORDER BY Date_difference DESC;







SELECT * FROM view_project_progress;
    