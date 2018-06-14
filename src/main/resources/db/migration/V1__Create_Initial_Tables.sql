CREATE TABLE `entechpi`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `occurred_ts` VARCHAR(45) NOT NULL,
  `received_ts` VARCHAR(45) NOT NULL,
  `pi_type` VARCHAR(45) NOT NULL,
  `sensor_id` VARCHAR(45) NOT NULL,
  `raw_data` TEXT NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `entechpi`.`motion_event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `img` BLOB NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`event_id`) REFERENCES event (`id`)
);
CREATE TABLE `entechpi`.`temp_event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `temp` DOUBLE NOT NULL,
  `humidity` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`event_id`) REFERENCES event (`id`)
);
