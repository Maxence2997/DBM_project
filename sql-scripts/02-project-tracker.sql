CREATE SCHEMA  IF NOT EXISTS `project_tracker`;
USE `project_tracker`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `uuid` varchar(64) NOT NULL,
  `emp_id` varchar(64) NOT NULL,
  `first_name` varchar(64) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  `address` varchar(64) DEFAULT NULL,
  `phone_numb` varchar(32) DEFAULT NULL,
  `supervisor_id` varchar(64) DEFAULT NULL,
  `performance` varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default current_timestamp,
  PRIMARY KEY (`uuid`),
  KEY `FK_supervisor_id` (`supervisor_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`supervisor_id`) 
  REFERENCES `employee` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `uuid` varchar(64) NOT NULL,
  `proj_id` varchar(64) NOT NULL,
  `emp_id` varchar(64) NOT NULL,
  `status` varchar(64) DEFAULT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default current_timestamp,
  PRIMARY KEY (`uuid`),
  KEY `fk_emp_id` (`emp_id`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`emp_id`) 
  REFERENCES `employee` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `uuid` varchar(64) NOT NULL,
  `sup_id` varchar(64) NOT NULL,
  `sup_name` varchar(64) NOT NULL,
  `sup_address` varchar(64) NOT NULL,
  `contact_name` varchar(64) NOT NULL,
  `contact_mobile` varchar(64) NOT NULL,
  `contact_email` varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default current_timestamp,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `uuid` varchar(64) NOT NULL,
  `prod_id` varchar(64) NOT NULL,
  `prod_name` varchar(64) NOT NULL,
  `sup_id` varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default current_timestamp,
  PRIMARY KEY (`uuid`),
  KEY `supplier_id` (`sup_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`sup_id`) 
  REFERENCES `supplier` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `uuid` varchar(64) NOT NULL,
  `inv_id` varchar(64) NOT NULL,
  `proj_id`  varchar(64) NOT NULL,
  `prod_id` varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default current_timestamp,
  PRIMARY KEY (`uuid`),
  KEY `project_ID` (`proj_id`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`proj_id`) 
  REFERENCES `project` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `product_id` (`product_id`),
  CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`prod_id`) 
  REFERENCES `product` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `sheet`;
CREATE TABLE `sheet` (
  `uuid` varchar(64) NOT NULL,
  `sheet_id` varchar(64) NOT NULL,
  `sheet_type` varchar(15) NOT NULL,
  `proj_id` varchar(64) NOT NULL,
  `prod_id` varchar(64) NOT NULL,
  `sup_id` varchar(64) NOT NULL,
  `volume` int unsigned default NULL,
  `unit_price` int unsigned default NULL,
  `total_price` int unsigned default NULL,
  `yield` varchar(64) default null,
  `signature` boolean NOT NULL DEFAULT false,
  `supervisor_id` varchar(64) NOT NULL,
  `esd_date` date DEFAULT NULL (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default current_timestamp,
  PRIMARY KEY (`uuid`),
  KEY `proj_id` (`proj_id`),
  CONSTRAINT `sheet_ibfk_1` FOREIGN KEY (`proj_id`) 
  REFERENCES `project` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `supervisor_id` (`supervisor_id`),
  CONSTRAINT `sheet_ibfk_2` FOREIGN KEY (`supervisor_id`) 
  REFERENCES `employee` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `sup_id` (`sup_id`),
  CONSTRAINT `sheet_ibfk_3` FOREIGN KEY (`sup_id`) 
  REFERENCES `supplier` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `prod_id` (`prod_id`),
  CONSTRAINT `sheet_ibfk_4` FOREIGN KEY (`prod_id`) 
  REFERENCES `product` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `Definition`;
CREATE TABLE `Definition` (
  `param_key` varchar(64) NOT NULL,
  `param_value`  varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default current_timestamp,
  PRIMARY KEY (`param_key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

SET FOREIGN_KEY_CHECKS = 1;