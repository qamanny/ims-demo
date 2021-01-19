create database if not exists ims;
create table if not exists ims.customer(id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(id int primary key auto_increment, item_name varchar(40), item_price double);
