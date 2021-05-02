CREATE DATABASE student_db;

USE `student_db`;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `first_name` varchar(45) DEFAULT NULL,
                           `last_name` varchar(45) DEFAULT NULL,
                           `email` varchar(45) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

LOCK TABLES `student` WRITE;

INSERT INTO `student` VALUES (1,'Mary','Public','mary@gmail.com'),
                             (2,'John','Doe','john@gmail.com'),
                             (3,'Ajay','Rao','ajay@gmail.com'),
                             (4,'Bill','Neely','bill@gmail.com'),
                             (5,'Maxwell','Dixon','max@gmail.com');
UNLOCK TABLES;