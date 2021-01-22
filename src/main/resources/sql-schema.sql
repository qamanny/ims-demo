drop database if exists ims;
create database if not exists ims;
create table if not exists ims.customer(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.item(id int primary key auto_increment, item_name varchar(40), item_price double);
create table if not exists ims.order(orderId int primary key auto_increment, customerId int, address varchar(40), postcode varchar(40), foreign key(customerId) references customer(id));
create table if not exists ims.orderline(orderlineId int primary key auto_increment, orderId int, itemID int, stock int, foreign key(orderId) references order(orderId), foreign key(itemID) references item(id));