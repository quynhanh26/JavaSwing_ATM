use master
go 

drop database if exists BaithiJava 
create database BaithiJava
go

use BaithiJava
go
--TABLE ACCOUNT

create table Account
(
accid int identity,
numcardacc varchar(8) primary key,
fullname nvarchar(50),
gender varchar(6),
dob date,
pinNum nvarchar(max),
balance int,
IsAdmin nvarchar(6) DEFAULT 'Client'
)


--ISERT ADMIN
insert into Account(numcardacc,fullname,gender,dob,pinNum,IsAdmin) values (1,'admin','female','2001-02-26','$2a$10$psZQnxbEfhW0tEwH2qLTpeEUsVryHILhcNNH21.tJRJIMlB5FTnAW','Admin') 
go
				
insert into Account(numcardacc,fullname,gender,dob,pinNum,IsAdmin)values (11111111,'quynhanh','female','2001-02-02','$2a$10$atuGm3.AMuo18PDAOs2it.97qdVuAaU3YR8XcSVtZJpQqqByqXuNm','Client')
go

insert into Account(numcardacc,fullname,gender,dob,pinNum,IsAdmin)values( 11111112,'nhathuy','male','2001-12-16','$2a$10$aI8sI4KYv9OkQ14MklKkLOtH6sYqXQGJNuJ8X7ci1iMCJNce9wvuW','Client')
go


--CREATE TABLE TRANSACTION
create table [Transaction]
(
transid int primary key identity,
numcardacc varchar(8),
numcardtrans varchar(8),
amount int,
dispatchDate date,
deliveryTime time
)
go

alter table [Transaction]
add constraint FK_Transaction_Account
foreign key (numcardacc) references Account(numcardacc)
go
--SELECT ACCOUNT
create proc selAllAcc
as
begin
select * from Account where IsAdmin = 'Client'
end
go

--STORED LOGIN
create proc selecAdmin
@fullname nvarchar(50)
as
begin
select * from Account where fullname = @fullname
end
go

--CHANGE PASSWORD
create proc uppass
@numcardacc varchar(8),@fullname nvarchar(50),@pinNum nvarchar(max)
as
begin
Update Account set pinNum=@pinNum,fullname=@fullname where numcardacc=@numcardacc
end
go

--SELCT INFOR ACCOUNT
create proc selInfor
@numcardacc varchar(8)
as
begin
select fullname,numcardacc,balance from Account where numcardacc= @numcardacc
end
go

----
create proc checkAcc
@numcardacc varchar(8)
as
begin
select count(*) from Account where numcardacc= @numcardacc
end
go


--INSERT ACCOUNT
create proc insertAcc
@numcardacc varchar(8),
@fullname nvarchar(50),
@gender varchar(7),
@dob date,
@pinNum nvarchar(max)
as
begin
insert into Account(numcardacc, fullname, gender, dob, pinNum) values (@numcardacc, @fullname, @gender, @dob, @pinNum)
end
go 

--DELETE ACCOUNT
create proc delAcc
@numcardacc varchar(8)
as
begin
		delete Account where numcardacc= @numcardacc
end
go


--UPDATE BALANCE
create proc updateAcc
@numcardacc varchar(8),
@fullname nvarchar(50)
as
begin
update Account set 
fullname =@fullname
where numcardacc =@numcardacc
end
go

--WIT ACCOUNT
create proc updatebalance
@numcardacc varchar(8),
@balance int
as
begin
update Account set
balance = @balance
where numcardacc =@numcardacc
end
go
create proc updateAccbalance
@numcardacc varchar(8),
@balance int
as
begin
update Account set
balance += @balance
where numcardacc =@numcardacc
end
go
 
 --RECHARGE ACCOUNT
create proc recharge
@numcardacc varchar(8),@balance int
as
begin
Update Account set balance = balance - @balance -1100 where numcardacc= @numcardacc
end
go
 --SELECT TRANSACTION
create proc selAllTrans
as
begin
select * from [Transaction]
end
go

--INSERT TRANSACTION
create proc insertTran
@numcardacc varchar(8),
@numcardtrans varchar(8),
@amount int,
@dispatchDate date,
@deliveryTime time
as
begin
insert into [Transaction] values (@numcardacc, @numcardtrans, @amount, @dispatchDate, @deliveryTime)
end
go

-----transfer
create proc transTo
 @numcardacc varchar(8), @numcardtrans varchar(8), @amount int,@amounttrans int
as
begin
	update Account set balance = @amount where numcardacc = @numcardacc

	update Account set balance = @amounttrans where numcardacc = @numcardtrans
end
go

