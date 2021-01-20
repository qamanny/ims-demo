create database if not exists ims_test;
drop table if exists ims_test.customer;
drop table if exists ims_test.item;
create table ims_test.customer(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table ims_test.item(id int primary key auto_increment, item_name varchar(40), item_price double);

