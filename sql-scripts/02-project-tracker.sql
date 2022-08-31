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
  `phone_number` varchar(32) DEFAULT NULL,
  `supervisor_id` varchar(64) DEFAULT NULL,
  `performance` varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default null,
  PRIMARY KEY (`uuid`),
  KEY `FK_supervisor_id` (`supervisor_id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`supervisor_id`) 
  REFERENCES `employee` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `uuid` varchar(64) NOT NULL,
  `project_id` varchar(64) NOT NULL,
  `emp_id` varchar(64) NOT NULL,
  `project_status` varchar(64) DEFAULT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default null,
  PRIMARY KEY (`uuid`),
  KEY `fk_emp_id` (`emp_id`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`emp_id`) 
  REFERENCES `employee` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `uuid` varchar(64) NOT NULL,
  `supplier_id` varchar(64) NOT NULL,
  `supplier_name` varchar(64) NOT NULL,
  `supplier_address` varchar(64) NOT NULL,
  `contact_name` varchar(64) NOT NULL,
  `contact_mobile` varchar(64) NOT NULL,
  `contact_email` varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default null,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `uuid` varchar(64) NOT NULL,
  `product_id` varchar(64) NOT NULL,
  `product_name` varchar(64) NOT NULL,
  `supplier_id` varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default null,
  PRIMARY KEY (`uuid`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`supplier_id`) 
  REFERENCES `supplier` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `uuid` varchar(64) NOT NULL,
  `inventory_id` varchar(64) NOT NULL,
  `project_id`  varchar(64) NOT NULL,
  `product_id` varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default null,
  PRIMARY KEY (`uuid`),
  KEY `project_ID` (`project_id`),
  CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`project_id`) 
  REFERENCES `project` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `product_id` (`product_id`),
  CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `sheet`;
CREATE TABLE `sheet` (
  `uuid` varchar(64) NOT NULL,
  `sheet_id` varchar(64) NOT NULL,
  `sheet_type` varchar(15) NOT NULL,
  `project_id` varchar(64) NOT NULL,
  `product_id` varchar(64) NOT NULL,
  `supplier_id` varchar(64) NOT NULL,
  `volume` int unsigned NOT NULL,
  `unit_price` int unsigned NOT NULL,
  `total_price` int unsigned NOT NULL,
  `yield` varchar(64) default null,
  `signature` boolean NOT NULL DEFAULT false,
  `supervisor_id` varchar(64) NOT NULL,
  `esd_date` date NOT NULL DEFAULT (date_format(curdate(),_utf8mb4'%Y-%m-%d')),
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default null,
  PRIMARY KEY (`uuid`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `sheet_ibfk_1` FOREIGN KEY (`project_id`) 
  REFERENCES `project` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `supervisor_id` (`supervisor_id`),
  CONSTRAINT `sheet_ibfk_2` FOREIGN KEY (`supervisor_id`) 
  REFERENCES `employee` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `sheet_ibfk_3` FOREIGN KEY (`supplier_id`) 
  REFERENCES `supplier` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `product_id` (`product_id`),
  CONSTRAINT `sheet_ibfk_4` FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`uuid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

DROP TABLE IF EXISTS `Definition`;
CREATE TABLE `Definition` (
  `key_def` varchar(64) NOT NULL,
  `value_def`  varchar(64) NOT NULL,
  `create_time` timestamp default current_timestamp,
  `modify_time` timestamp default null,
  PRIMARY KEY (`key_def`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1  COLLATE latin1_general_ci;

SET FOREIGN_KEY_CHECKS = 1;