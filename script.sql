USE master
GO
CREATE DATABASE TTK_music
GO
USE TTK_music
GO


/****** Object:  Table [dbo].[accounts] ******/
CREATE TABLE accounts(
	account_id VARCHAR(36) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(32) NOT NULL,
	username NVARCHAR(50)  NOT NULL,
	role_id VARCHAR(5) NOT NULL CHECK(role_id='ADMIN' OR role_id='USER'),
	status BIT,
	CONSTRAINT UNQ_tblAccounts UNIQUE (email),
	CONSTRAINT PK_tblAccounts PRIMARY KEY CLUSTERED (account_id ASC) 
	WITH (IGNORE_DUP_KEY = OFF, PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO
INSERT accounts (account_id, email, password, username, role_id, status) VALUES ('Admin1', 'admin@gmail.com', '1', 'Administrator', 'AD', '012345678')
GO


/****** Object:  Table [dbo].[tblContacts] ******/
CREATE TABLE tblContacts(
	contactId VARCHAR(32) NOT NULL,
	accountId VARCHAR(32) NOT NULL,
	phone VARCHAR(15),
	city VARCHAR(20),
	district VARCHAR(20),
	ward VARCHAR(20),
	CONSTRAINT FK_tblContacts FOREIGN KEY (accountId) REFERENCES tblAccounts,
	CONSTRAINT PK_tblContacts PRIMARY KEY CLUSTERED (contactId ASC) 
	WITH (IGNORE_DUP_KEY = OFF, PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO


/****** Object:  Table [dbo].[tblCategories] ******/
CREATE TABLE tblCategories(
	categoryId INT IDENTITY(1,1) NOT NULL,
	categoryName VARCHAR(50) NOT NULL,
	CONSTRAINT PK_tblCategory PRIMARY KEY CLUSTERED (categoryId ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO
SET IDENTITY_INSERT tblCategories ON
INSERT tblCategories(categoryId,categoryName) VALUES (1,'Tea')
INSERT tblCategories(categoryId,categoryName) VALUES (2,'Coffee')
INSERT tblCategories(categoryId,categoryName) VALUES (3,'Milk tea')
INSERT tblCategories(categoryId,categoryName) VALUES (4,'Dessert')
SET IDENTITY_INSERT tblCategories OFF


/****** Object:  Table [dbo].[courses] ******/
CREATE TABLE courses(
	course_id VARCHAR(36) NOT NULL,
	course_name VARCHAR(50) NOT NULL,
	price MONEY NOT NULL,
	quantity INT NOT NULL,
	categoryId INT,
	imgPath VARCHAR(50),
	description TEXT,
	CONSTRAINT FK_tblProducts FOREIGN KEY (categoryId) REFERENCES tblCategories,
	CONSTRAINT PK_tblProducts PRIMARY KEY CLUSTERED(productId ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO


/****** Object:  Table [dbo].[tblOrders] ******/
CREATE TABLE tblOrders(
	orderId VARCHAR(32) NOT NULL,
	contactId VARCHAR(32) NOT NULL,
	status VARCHAR(2) CHECK(status = 'PR' or status = 'CO' or status = 'CA'), -- PR: processing, CO: completed, CA: cancel
	orderDate DATETIME,
	shipDate DATETIME,
	total MONEY,
	CONSTRAINT FK_tblOrders FOREIGN KEY (contactId) REFERENCES tblContacts,
	CONSTRAINT PK_tblOrders PRIMARY KEY CLUSTERED (orderId ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO


/****** Object:  Table [dbo].[tblOrderDetails] ******/
CREATE TABLE tblOrderDetails(
	detailId VARCHAR(32) NOT NULL,
	orderId VARCHAR(32) NOT NULL,
	productId INT,
	price MONEY,
	quantity INT,
	total MONEY,
	CONSTRAINT FK_tblOrderDetail_Order FOREIGN KEY (orderId) REFERENCES tblOrders,
	CONSTRAINT FK_tblOrderDetail_Product FOREIGN KEY (productId) REFERENCES tblProducts,
	CONSTRAINT PK_tblOrderDetail PRIMARY KEY CLUSTERED (detailID ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO

--SET IDENTITY_INSERT PlantShop ON

SET IDENTITY_INSERT Accounts ON
INSERT INTO Accounts(accID,email,password,fullname,phone,role,status) VALUES (1, 'admin@gmail.com', '123456', 'My Tam', '123456', 1, 1);
INSERT INTO Accounts(accID,email,password,fullname,phone,role,status) VALUES (2, 'tung@gmail.com', '123456', 'Tung dep trai', '123', 1, 0);
INSERT INTO Accounts(accID,email,password,fullname,phone,role,status) VALUES (3,'meow@gmail.com', '1', 'A Flying Cat', '12302', 0, 0);
INSERT INTO Accounts(accID,email,password,fullname,phone,role,status) VALUES (4,'lanhhangiatoc@gmail.com', '1', 'A Flying Cat', '12302', 0, 1);
SET IDENTITY_INSERT Accounts OFF



USE [master]
GO
drop database MilkTeaShopManagement
go
/****** Object:  Database [MilkTeaShopManagement]    Script Date: 11/27/2021 13:04:02 ******/
CREATE DATABASE [MilkTeaShopManagement] ON  PRIMARY 
( NAME = N'MilkTeaShopManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\MilkTeaShopManagement.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MilkTeaShopManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\MilkTeaShopManagement_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MilkTeaShopManagement] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MilkTeaShopManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MilkTeaShopManagement] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET ANSI_NULLS OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET ANSI_PADDING OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET ARITHABORT OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [MilkTeaShopManagement] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [MilkTeaShopManagement] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [MilkTeaShopManagement] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET  DISABLE_BROKER
GO
ALTER DATABASE [MilkTeaShopManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [MilkTeaShopManagement] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [MilkTeaShopManagement] SET  READ_WRITE
GO
ALTER DATABASE [MilkTeaShopManagement] SET RECOVERY SIMPLE
GO
ALTER DATABASE [MilkTeaShopManagement] SET  MULTI_USER
GO
ALTER DATABASE [MilkTeaShopManagement] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [MilkTeaShopManagement] SET DB_CHAINING OFF
GO
USE [MilkTeaShopManagement]
GO
drop table tblUsers
go

/****** Object:  Table [dbo].[tblUsers]    Script Date: 11/27/2021 13:04:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE tblUsers(
	[userID] [nvarchar](50) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL, 
	[roleID] [nvarchar](50) NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status]) VALUES (N'admin', N'Toi la admin', N'1', N'AD', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status]) VALUES (N'Hoadnt', N'Hoa Doan', N'1', N'US', 1)


INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('T01','Lemon Tea',15,20,'B1')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('T02','Chamomile Tea',32,20,'B1')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('T03','Hibiscus Tea',15,20,'B1')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('T04','Ginger Tea',69,20,'B1')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('T05','Earl Grey Tea',15,20,'B1')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('T06','Ceylons Tea',15,20,'B1')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('C01','Espresso',15,20,'B2')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('C02','Americano',20,20,'B2')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('C03','Latte',67,20,'B2')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('C04','Machiato',15,20,'B2')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('C05','Affogato',35,20,'B2')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('M01','Brown Sugar Boba Milktea',15,20,'B3')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('M02','Matcha Milktea',15,20,'B3')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('M03','Original Milktea',50,20,'B3')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('M04','Taro Milktea',15,20,'B3')
INSERT tblProduct(productID, productName, price, quantity, categoryID) VALUES ('M05','Almond Milktea',29,20,'B3')