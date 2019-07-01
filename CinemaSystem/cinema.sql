create database cinemasystem;

use cinemasystem

/**
�û���
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
��Ӱ��
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

/**
��Ӱϲ�ñ��߼������
**/
CREATE TABLE filmlike  (
id int primary key auto_increment,
uid int,
fid int,
time varchar(255)
);

/**
��Ӱ���ű�
**/
create table filmSchedule(
id int primary key auto_increment,
date varchar(255),
startTime varchar(255),
endTime varchar(255),
fid varchar(255),#ӰƬid
filmRoom varchar(255),#ӰԺ
price varchar(255),#�۸�
visiableTimeStart varchar(255),#�ɼ���ʼʱ��
visiableTimeEnd varchar(255),#�ɼ�����ʱ��
view varchar(255) #�ӽ�
)ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/**
��Ա����
**/
create table clubCard(
id int primary key auto_increment,
uid int,#�����û���
price decimal(5,2)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
