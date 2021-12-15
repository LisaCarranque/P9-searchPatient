

create database IF NOT EXISTS test;
use test;
create table if not exists patient(
 id int PRIMARY KEY AUTO_INCREMENT,
 address varchar(255),
 birthdate timestamp,
 genre varchar(255),
 phone varchar(255),
 firstname varchar(255),
 lastname varchar(255));
insert ignore into patient (id, address, birthdate, genre, phone, firstname, lastname) values
  (1000, '1509 Culver St', '1980-10-02', 'F', '841-874-6512', 'leonie', 'ki');

use P9;
--insert ignore into patient (id, address, birthdate, family, genre, given, phone, firstname, lastname) values
--  (1, '1509 Culver St', '02/10/1980', 'test', 'F', ' ', '841-874-6512', 'jon', 'smith');

--CREATE USER 'test'@'172.23.0.1' IDENTIFIED BY 'Test@2021';
--GRANT ALL PRIVILEGES ON test . * TO 'test'@'172.23.0.1';