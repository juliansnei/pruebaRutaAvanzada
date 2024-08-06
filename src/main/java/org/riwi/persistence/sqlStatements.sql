create database RiwiAcademyDB;

use RiwiAcademyDB;

create table student (
	id int auto_increment primary key,
    age float not null,
    name varchar(50) not null,
    email varchar(50) not null,
    status boolean
);

create table courses(
	id int auto_increment primary key,
    name varchar(50)
);

create table inscriptions(
	id int auto_increment primary key,
    id_course int not null,
    id_student int not null,
    foreign key(id_course)  references courses(id),
    foreign key(id_student) references student(id)
);