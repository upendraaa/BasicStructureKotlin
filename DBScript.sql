drop database basicDatabase;
create database basicDatabase;

	use basicDatabase;

	create table if not exists person(
          
          _id int AUTO_INCREMENT PRIMARY KEY,
          userId varchar(50) UNIQUE,
          firstName varchar(100),
          lastName varchar(50),
          email varchar(100),
          password varchar(100),
          address varchar(1000),
          mobileNumber varchar(20),
          updatedTime int
		);

	describe person;

	create table  if not exists company(
          
          _id int AUTO_INCREMENT PRIMARY KEY,
          userId varchar(50),
          companyId varchar(50),
          companyName varchar(200),
          numOfEmployee int,
          registeredTime int,
          address varchar(1000),
          FOREIGN KEY (userId) REFERENCES person(userId)

		);

	describe company;