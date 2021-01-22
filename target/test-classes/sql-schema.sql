create database if not exists ims_test;
drop table if exists ims_test.customer;
drop table if exists ims_test.item;
drop table if exists ims_test.order;
drop table if exists ims_test.orderline;
create table if not exists ims_test.customer(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims_test.item(id int primary key auto_increment, item_name varchar(40), item_price double);
create table if not exists ims_test.order(orderId int primary key auto_increment, customerId int, address varchar(40), postcode varchar(40), foreign key(customerId) references customer(id));
create table if not exists ims_test.orderline(orderlineId int primary key auto_increment, orderId int, itemID int, stock int, foreign key(orderId) references order(orderId), foreign key(itemID) references item(id));