CREATE TABLE `entechpi`.`motion_event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `occurred_ts` VARCHAR(45) NOT NULL,
  `received_ts` VARCHAR(45) NOT NULL,
  `sensor_id` VARCHAR(45) NOT NULL,
  `raw_data` TEXT NOT NULL,
  `img` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `entechpi`.`temp_event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `occurred_ts` VARCHAR(45) NOT NULL,
  `received_ts` VARCHAR(45) NOT NULL,
  `sensor_id` VARCHAR(45) NOT NULL,
  `raw_data` TEXT NOT NULL,
  `temp` DOUBLE NOT NULL,
  `humidity` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);
