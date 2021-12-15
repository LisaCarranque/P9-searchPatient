
create database IF NOT EXISTS test;
use test;
insert ignore into patient (id, address, birthdate, genre, phone, firstname, lastname) values
  (1000, '1509 Culver St', '1980-10-02', 'F', '841-874-6512', 'jon', 'smith');