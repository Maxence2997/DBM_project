CREATE VIEW VIEW_6_SHEETS (RFQ_ID , RFQ ,RFQ_pj_ID, RFQ_Supplier , RFQ_sup_name , RFQ_pd ,
 RFQ_vol , RFQ_date , QUOT_ID , QUOT ,QUOT_pj_ID, QUOT_Supplier , QUOT_sup_name , QUOT_pd , QUOT_vol , QUOT_unit_price , 
 QUOT_total_price , QUOT_ESD , QUOT_Date , REQ_ID , REQ, REQ_pj_ID , REQ_pd , pd_name , REQ_vol , REQ_unit_price ,
 REQ_total_price , REQ_sign , REQ_supervisor , sup_name , REQ_date , PUR_ID , PUR, PUR_pj_ID , PUR_pd , PUR_vol , 
 PUR_unit_price , PUR_total_price , PUR_ESD , PUR_date , EXAM_ID , EXAM, EXAM_pj_ID , EXAM_pd , EXAM_vol , EXAM_result ,
 EXAM_date , RCPT_ID , RCPT, RCPT_pj_ID , RCPT_pd , RCPT_vol , RCPT_date) AS

SELECT 
    RFQ.RFQ_Sheet_ID,
    RFQ.Sheet_type,
    RFQ.Project_ID,
    RFQ.Supplier_ID,
    sup.Supplier_name,
    RFQ.Inquiring_product,
    RFQ.Vol,
    RFQ.Date,
    QUOT.QUO_Sheet_ID,
    QUOT.Sheet_type,
    QUOT.Project_ID,
    QUOT.Supplier_ID,
    sup.Supplier_name,
    QUOT.Inquiring_product,
    QUOT.Vol,
    QUOT.Unit_price,
    QUOT.Total_price,
    QUOT.ESD,
    QUOT.Date,
    REQ.REQ_Sheet_ID,
    REQ.Sheet_type,
    REQ.Project_ID,
    REQ.Inquiring_product,
    REQ.Item_name,
    REQ.Vol,
    REQ.Unit_price,
    REQ.Total_price,
    REQ.Signature,
    REQ.Supervisor_ID,
    CONCAT(emp.First_name, ' ', emp.Last_name) AS Name,
    REQ.Date,
    PUR.PUR_Sheet_ID,
    PUR.Sheet_type,
    PUR.Project_ID,
    PUR.Module_type,
    PUR.Vol,
    PUR.Unit_price,
    PUR.Total_price,
    PUR.ESD,
    PUR.Date,
    EXAM.EX_Sheet_ID,
    EXAM.Sheet_type,
    EXAM.Project_ID,
    EXAM.Module_type,
    EXAM.Vol,
    EXAM.Result,
    EXAM.Date,
    RCPT.REC_Sheet_ID,
    RCPT.Sheet_type,
    RCPT.Project_ID,
    RCPT.Module_type,
    RCPT.Vol,
    RCPT.Date
FROM
    test.RFQ
        LEFT JOIN
    test.QUOTATION AS QUOT ON (RFQ.Project_ID = QUOT.Project_ID
        AND RFQ.Inquiring_product = QUOT.Inquiring_product)
        LEFT JOIN
    test.REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID
        AND REQ.Inquiring_product = QUOT.Inquiring_product)
        LEFT JOIN
    test.PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID
        AND PUR.Module_type = REQ.Inquiring_product)
        LEFT JOIN
    test.EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID
        AND EXAM.Module_type = PUR.Module_type)
        LEFT JOIN
    test.RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID
        AND RCPT.Module_type = EXAM.MOdule_type)
        LEFT JOIN
    test.SUPPLIER AS SUP ON (sup.Supplier_ID = RFQ.Supplier_ID
        AND sup.Supplier_ID = QUOT.Supplier_ID)
        LEFT JOIN
    EMPLOYEE AS emp ON emp.Emp_ID = REQ.Supervisor_ID;
    
SELECT * FROM VIEW_6_SHEETS;