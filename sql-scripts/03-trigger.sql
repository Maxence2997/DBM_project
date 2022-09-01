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
		UPDATE definition set param_value = new.emp_id where param_key='emp_id';
    END IF;
END$$

DELIMITER ;