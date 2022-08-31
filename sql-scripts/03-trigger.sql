DELIMITER $$

CREATE TRIGGER after_employee_insert
AFTER INSERT
ON employee FOR EACH ROW
BEGIN
	DECLARE key_d varchar(64);
    select key_def into key_d from definition where definition.key='emp_id';
    IF key_d IS NULL THEN
        INSERT INTO definition(key_def, value_def) VALUES('emp_id',new.emp_id);
    ELSE
		UPDATE definition set value_def = new.emp_id where key_def='emp_id';
    END IF;
END$$

DELIMITER ;