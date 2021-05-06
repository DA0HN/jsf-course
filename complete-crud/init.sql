CREATE DATABASE IF NOT EXISTS student_db;

USE `student_db`;

DROP TABLE IF EXISTS `student`;

create table student
(
    id        int auto_increment primary key,
    firstName varchar(45) null,
    lastName  varchar(45) null,
    email     varchar(45) null
);

INSERT INTO student_db.student (id, firstName, lastName, email) VALUES (1, 'Mary', 'Public', 'mary@gmail.com');
INSERT INTO student_db.student (id, firstName, lastName, email) VALUES (2, 'John', 'Doe', 'john@gmail.com');
INSERT INTO student_db.student (id, firstName, lastName, email) VALUES (3, 'Ajay', 'Rao', 'ajay@gmail.com');
INSERT INTO student_db.student (id, firstName, lastName, email) VALUES (4, 'Bill', 'Neely', 'bill@gmail.com');
INSERT INTO student_db.student (id, firstName, lastName, email) VALUES (5, 'Maxwell', 'Dixon', 'max@gmail.com');