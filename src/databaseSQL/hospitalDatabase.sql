create database hospital_management_system;
use hospital_management_system;

-- for login--
create table login(ID varchar(40),pass varchar(40));
select * from login;
insert into login value("anish","anish");

-- Patient info--

create table patient_info(ID varchar(20),Name varchar(20),Number varchar(20),Gender varchar(20),Patient_Disease varchar(20),Room_Number varchar(20),Time varchar(100),Deposit varchar(20)); 
select * from patient_info;

-- ROOM Number--

create table Room(room_no varchar(20),Availability varchar(20), Price varchar(20),Room_Type varchar(100));
insert into Room values("100","Available","500","G Bed 1");
insert into Room values("101","Available","500","G Bed 2");
insert into Room values("102","Available","500","G Bed 3");
insert into Room values("103","Available","500","G Bed 4");
insert into Room values("200","Available","1500","Private Bed 1");
insert into Room values("201","Available","1500","Private Bed 2");
insert into Room values("202","Available","1500","Private Bed 3");
insert into Room values("203","Available","1500","Private Bed 4");
insert into Room values("300","Available","3500","ICU Bed 1");
insert into Room values("301","Available","3500","ICU Bed 2");
insert into Room values("302","Available","3500","ICU Bed 3");
insert into Room values("303","Available","3500","ICU Bed 4");
insert into Room values("304","Available","3500","ICU Bed 5");
insert into Room values("305","Available","3500","ICU Bed 6");

select * from room;

-- department--
create table department(Department varchar(100),Phone_no varchar(20));
select * from department;

insert into department values("Surgical Department","1234567890");
insert into department values("Nursing Department","1234567890");
insert into department values("Operation Theatre Complex (OT)","1234567890");
insert into department values("Paramedical Department","1234567890");

-- Employee Info table --
create table EMP_INFO(Name varchar(20),Age varchar(20),Phone_Number varchar(20),Salary varchar(20),Gmail varchar(20),Aadhar_Number varchar(20));
select * from EMP_INFO;

insert into EMP_INFO values("Doctor1 (Orthopedic)","30","1234567890","80000","dr@gmail.com","3289854858578");
insert into EMP_INFO values("Doctor2 (ENT)","50","1234567890","110000","dr@gmail.com","3289854858578");
insert into EMP_INFO values("Doctor3 (Neurology)","50","1234567890","98000","dr@gmail.com","3289854858578");
insert into EMP_INFO values("Doctor4 (Gastrology)","40","1234567890","68000","dr@gmail.com","3289854858578");

-- Ambulance --

create table ambulance(Name varchar(20), Gender varchar(20), Car_name varchar(20),Available varchar(20),Location varchar(20));
select * from ambulance;
insert into Ambulance values("Syam","Male","Zen","Available","area 19");
insert into Ambulance values("Ramu","Male","Sumo","Available","area 15");
insert into Ambulance values("Rajesh","Male","Force Traveller","Available","area 25");
insert into Ambulance values("Sonu","Male","Mini Bus","Available","area 92");