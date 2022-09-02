DROP TRIGGER IF EXISTS after_employee_insert;
DELIMITER $$
CREATE TRIGGER after_employee_insert
AFTER INSERT
ON employee FOR EACH ROW
BEGIN
	DECLARE key_d varchar(64);
    select param_key into key_d from definition where definition.param_key='emp_id';
    IF key_d IS NULL THEN
        INSERT INTO definition(param_key, param_value) VALUES('emp_id',new.emp_id);
    ELSE
		UPDATE definition set param_value = new.emp_id, modify_time=current_time() where param_key='emp_id';
    END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS after_inventory_insert;
DELIMITER $$
CREATE TRIGGER after_inventory_insert
AFTER INSERT
ON inventory FOR EACH ROW
BEGIN
	DECLARE key_d varchar(64);
    select param_key into key_d from definition where definition.param_key='inv_id';
    IF key_d IS NULL THEN
        INSERT INTO definition(param_key, param_value) VALUES('inv_id',new.inv_id);
    ELSE
		UPDATE definition set param_value = new.inv_id, modify_time=current_time() where param_key='inv_id';
    END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS after_product_insert;
DELIMITER $$
CREATE TRIGGER after_product_insert
AFTER INSERT
ON product FOR EACH ROW
BEGIN
	DECLARE key_d varchar(64);
    select param_key into key_d from definition where definition.param_key='prod_id';
    IF key_d IS NULL THEN
        INSERT INTO definition(param_key, param_value) VALUES('prod_id',new.prod_id);
    ELSE
		UPDATE definition set param_value = new.prod_id, modify_time=current_time() where param_key='prod_id';
    END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS after_project_insert;
DELIMITER $$
CREATE TRIGGER after_project_insert
AFTER INSERT
ON project FOR EACH ROW
BEGIN
	DECLARE key_d varchar(64);
    select param_key into key_d from definition where definition.param_key='proj_id';
    IF key_d IS NULL THEN
        INSERT INTO definition(param_key, param_value) VALUES('proj_id',new.proj_id);
    ELSE
		UPDATE definition set param_value = new.proj_id, modify_time=current_time() where param_key='proj_id';
    END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS after_supplier_insert;
DELIMITER $$
CREATE TRIGGER after_supplier_insert
AFTER INSERT
ON supplier FOR EACH ROW
BEGIN
	DECLARE key_d varchar(64);
    select param_key into key_d from definition where definition.param_key='sup_id';
    IF key_d IS NULL THEN
        INSERT INTO definition(param_key, param_value) VALUES('sup_id',new.sup_id);
    ELSE
		UPDATE definition set param_value = new.sup_id, modify_time=current_time() where param_key='sup_id';
    END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS after_sheet_insert;
DELIMITER $$
CREATE TRIGGER after_sheet_insert
AFTER INSERT
ON sheet FOR EACH ROW
BEGIN
	DECLARE key_d varchar(64);
    select param_key into key_d from definition where definition.param_key=new.sheet_type;
    IF key_d IS NULL THEN
        INSERT INTO definition(param_key, param_value) VALUES(new.sheet_type,new.sheet_id);
    ELSE
		UPDATE definition set param_value = new.sheet_id, modify_time=current_time() where param_key=new.sheet_type;
    END IF;
END$$
DELIMITER ;

