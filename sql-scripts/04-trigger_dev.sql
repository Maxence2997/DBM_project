DROP TRIGGER IF EXISTS before_employee_insert;
DELIMITER $$
CREATE TRIGGER before_employee_insert
Before INSERT ON employee FOR EACH ROW 
BEGIN
	DECLARE key_d varchar(64);
    DECLARE value_d varchar(64);
    DECLARE inipos int unsigned default 3;
    DECLARE length int unsigned default 6;
    DECLARE num_part int unsigned;
    DECLARE new_id varchar(64);
    select param_key,param_value into key_d,value_d from definition where definition.param_key='emp_id';
    IF key_d IS NULL THEN
		SET new.emp_id='EP000001';
        INSERT INTO definition(param_key, param_value) VALUES('emp_id',new.emp_id);
    ELSE
		set num_part = (CAST(SUBSTRING(value_d,inipos,length) AS UNSIGNED)+1);
        set new_id = CONCAT('EP', LPAD(CAST(num_part as CHAR),6,'0'));
		set new.emp_id = new_id;
		UPDATE definition set param_value = new.emp_id, modify_time=current_time() where param_key='emp_id';
    END IF;
    SET new.create_time =current_time(), new.modify_time=current_time();
END$$
DELIMITER ;