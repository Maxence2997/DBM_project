CREATE VIEW VIEW_PROJECT (Project_ID,Emp_ID, E_name, P_status, Product, RFQ, QUOT, REQ, PUR, EXAM, RCPT, Est_date) AS
SELECT 
    pj.Project_ID,
    pj.Emp_ID,
    emp.Last_name AS E_name,
    pj.Project_status AS P_status,
    rfq.Inquiring_product AS Product,
    rfq.RFQ_Sheet_ID,
    quo.QUO_Sheet_ID,
    req.REQ_Sheet_ID,
    pur.PUR_Sheet_ID,
    exam.EX_Sheet_ID,
    rcpt.REC_Sheet_ID,
    pj.Established_date AS Est_date
FROM
    test.PROJECT AS pj
        LEFT JOIN
    test.RFQ AS rfq ON rfq.Project_ID = pj.Project_ID
        LEFT JOIN
    test.QUOTATION AS quo ON (quo.Project_ID = rfq.Project_ID
        AND quo.Inquiring_product = rfq.Inquiring_product)
        LEFT JOIN
    test.REQUISITION AS req ON (req.Project_ID = quo.Project_ID
        AND req.Inquiring_product = quo.Inquiring_product)
        LEFT JOIN
    test.PURCHASE AS pur ON (pur.Project_ID = req.Project_ID
        AND req.Inquiring_product = pur.Module_type)
        LEFT JOIN
    test.EXAMINATION AS exam ON (exam.Project_ID = pur.Project_ID
        AND exam.Module_type = pur.Module_type)
        LEFT JOIN
    test.RECEIPT AS rcpt ON (rcpt.Project_ID = exam.Project_ID
        AND rcpt.Module_type = exam.Module_type)
        LEFT JOIN
    test.EMPLOYEE AS emp ON pj.Emp_ID = emp.Emp_ID;