create database raj;
\c raj;

create table admin (uname varchar(20), pass varchar(20));
insert into admin values ('admin','admin');

create table userinfo (id varchar,pass varchar);
insert into userinfo values ('nsg','password');


create table enquiry (enqno integer primary key,custid integer,date_of_enquiry varchar,enqveh varchar );

insert into enquiry values (1,1,'9-11-2016','Pulsar');
insert into enquiry values (2,2,'18-11-2016','CT-100');
insert into enquiry values (3,3,'27-11-2016','Wave DTS-i');


create table vehicle (maname varchar primary key,cap integer,engine integer ,bhp integer ,volts integer , rpm integer , weight integer ,gears integer,color varchar);

insert into vehicle values ('Pulsar',180,4,25,12,150,130,5,'Black');
insert into vehicle values ('Wave DTS-i',125,4,20,12,120,100,3,'Blue');
insert into vehicle values ('Discover DTS-i',200,4,25,12,180,140,5,'Red');
insert into vehicle values ('CT-100',190,4,25,12,150,130,5,'Grey');


create table order1 (odno integer primary key ,qno integer ,date_of_order varchar,cno integer ,cname varchar ,age  integer ,add varchar,tno integer , oveh varchar ,color varchar , vprice integer ,addprno varchar ,exadd varchar ,pmode varchar);

insert into order1 values(1,1,'10-11-2016',1,'Suresh Agarwal',32,'Sadashiv Peth',98237,'Pulsar','Black',61000,'Ration card','12-11-2016','cheque');
insert into order1 values(2,2,'18-11-2016',2,'Raj Hawaldar',20,'Sinhagad Road',70737,'CT-100','Black',58000,'Ration card','21-11-2016','cheque');
insert into order1 values(3,3,'10-11-2016',1,'Mukesh Jain',32,'Sadashiv Peth',98237,'Wave DTS-i','White',56000,'Ration card','29-11-2016','cheque');


create table quotation (qno integer primary key,date_of_quotation varchar ,eno integer references  enquiry (enqno), veh varchar references vehicle(maname),pri integer ,tax integer ,ins integer ,acc integer, tpri integer);
insert into quotation values (1,'9-11-2016',1,'Pulsar',56000,3000,56000,3,59000);
insert into quotation values (2,'18-11-2016',2,'CT-100',56000,3000,56000,3,59000);
insert into quotation values (3,'27-12-2016',3,'Wave DTS-i',56000,3000,56000,3,59000);



create table bill (ino integer primary key,ono integer references order1(odno), date_of_bill varchar ,cname varchar ,vname varchar ,chno varchar ,egno varchar ,amt integer,pmode varchar );

insert into bill values(1,1,'11-11-2016','Suresh Agarwal','Pulsar','C5432','e5433',61000,'cheque');
insert into bill values(2,2,'20-11-2016','Raj Hawaldar','CT-100','C5432','e5433',58000,'cheque');
insert into bill values(3,3,'29-11-2016','Mukesh Jain','Wave DTS-i','C5544','e5444',55000,'cash');

create table cheque (chkno integer primary key ,date_of_cheque varchar ,bhkname varchar ,amt integer);
insert into cheque values(1,'10-11-2016','Janata Bank','61000');
insert into cheque values(2,'20-11-2016','Maharashtra Bank','58000');

create table cust ( custid integer primary key,cname varchar ,address varchar ,age integer ,telr integer ,telo integer, telmo integer,email varchar);
insert into cust values(1,'Sursh Agarwal','Sadashiv Peth',32,0,0,98237,'sa@gmail.com');
insert into cust values(2,'Raj Hawaldar','Sinhagad Road',20,0,0,70737,'rajhawaldar@gmail.com');
insert into cust values(3,'Mukesh Jain','Wadgaon',32,0,0,98237,'mukeshj@gmail.com');

create table priceinfo (vehile varchar references vehicle(maname) ,exshowpri integer ,rtotax integer ,insur integer ,essenacc integer ,totpri integer );


insert into priceinfo values('Pulsar',50000,5000,50000,1000,51000);
insert into priceinfo values('Wave DTS-i',58000,3000,10000,5000,61000);
insert into priceinfo values('CT-100',49000,4000,70000,2000,53000);
insert into priceinfo values('Discover DTS-i',45000,3000,2000,10000,46000);

