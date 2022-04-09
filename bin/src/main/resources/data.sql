SELECT * FROM p2.poke_table;CREATE TABLE `box_table` (
  `box_id` int(11) NOT NULL AUTO_INCREMENT,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`box_id`),
  KEY `table_id_idx` (`table_id`),
  CONSTRAINT `table_id` FOREIGN KEY (`table_id`) REFERENCES `catch_table` (`catch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `catch_table` (
  `catch_id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `pokemon_id` int(11) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`catch_id`),
  KEY `UserId_idx` (`UserId`),
  CONSTRAINT `UserId` FOREIGN KEY (`UserId`) REFERENCES `users_table` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `poke_table` (
  `poke_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `species` varchar(45) DEFAULT NULL,
  `sprite` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `capture_rate` varchar(45) DEFAULT NULL,
  `flavor_town` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`poke_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users_table` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;