create database if not exists ims_test;
drop table if exists ims_test.customer;
create table ims_test.customer(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
