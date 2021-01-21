create database if not exists ims_test;
drop table if exists ims_test.customer;
drop table if exists ims_test.item;
create table ims_test.customer(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table ims_test.item(id int primary key auto_increment, item_name varchar(40), item_price double);
create table if not exists ims_test.order(order_id int primary key auto increment, customer_id int NOT NULL, address varchar(40), postcode varchar(40), foreign key(customer_id) references customer(id));
create table if not exists ims_test.orderline(orderline_id int primary key auto_increment, order_id int NOT NULL, item_id int NOT NULL, stock int NOT NULL, foreign key(order_id) references order(order_id), foreign key(item_id) references item(id));

