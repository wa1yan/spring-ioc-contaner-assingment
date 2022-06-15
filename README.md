# Spring IOC container Assignment

This project is sample CRUD application with sample JDBC Stateent and write with JSP, JSTL, Servlet and MySQL database.
The main point of this project is like doing spring ioc container after creating spring bean with application.xml.

#### This project is maven project and used Java 17.

## To run this project need to create database and table.

      create database assignment_one;
      use assignment_one;

      create table course (
	      id int not null auto_increment,
	      name varchar(45),
	      duration int,
	      fees int,
	      description varchar(255),
	      primary key (id)
      );

      create table open_class (
	      id int not null auto_increment,
	      course_id int not null,
	      start_date Date,
	      teacher varchar(45),
	      primary key (id),
	      foreign key (course_id) references course(id)
      );

      create table registration (
	      id int not null auto_increment,
	      open_class_id int not null,
	      student varchar(45),
	      phone varchar(45),
	      email varchar(45),
	      primary key (id),
	      foreign key (open_class_id) references open_class(id)
      );
