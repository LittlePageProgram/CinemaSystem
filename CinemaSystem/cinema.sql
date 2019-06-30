create database cinemasystem;

use cinemasystem

/**
用户表
*/
create table user(
id int primary key auto_increment,
loginName varchar(255),
password varchar(255),
role varchar(255)
)ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;;

insert user values(null,'root','root','administrator');
insert user values(null,'aa','aa','common');

select * from user;
/**
电影表
**/
create table film(
id int primary key auto_increment,
name varchar(255),
posterLink LONGBLOB,
director varchar(255),
scriptWriter varchar(255),
actor varchar(255),
type varchar(255),
location varchar(255),
language varchar(255),
releaseDate varchar(255),
length varchar(255),
reflectDate varchar(255)
)ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;;

select * from film


CREATE TABLE filmlike  (
id int primary key auto_increment,
uid int,
fid int,
time varchar(255)
);


