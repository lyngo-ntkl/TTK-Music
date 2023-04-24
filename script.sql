USE master
GO
CREATE DATABASE TTK_music
GO
USE TTK_music
GO

/*
DROP DATABASE IF EXISTS TTK_Music
DROP TABLE roles
DROP TABLE courses
DROP TABLE categories
DROP TABLE accounts
*/


/****** Object:  Table [dbo].[roles] ******/
CREATE TABLE roles(
	role_id INT IDENTITY(1,1) NOT NULL,
	role_name VARCHAR(50) NOT NULL,
	CONSTRAINT PK_roles PRIMARY KEY CLUSTERED (role_id ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO
SET IDENTITY_INSERT roles ON
INSERT roles(role_id,role_name) VALUES (1,'ADMIN');
INSERT roles(role_id,role_name) VALUES (2,'USER');
SET IDENTITY_INSERT roles OFF


/****** Object:  Table [dbo].[accounts] ******/
CREATE TABLE accounts(
	account_id VARCHAR(36) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(32) NOT NULL,
	username NVARCHAR(50)  NOT NULL,
	role_id INT NOT NULL,
	status BIT,
	CONSTRAINT UNQ_accounts UNIQUE (email),
	CONSTRAINT FK_accounts_roles FOREIGN KEY (role_id) REFERENCES roles,
	CONSTRAINT PK_accounts PRIMARY KEY CLUSTERED (account_id ASC) 
	WITH (IGNORE_DUP_KEY = OFF, PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO
INSERT accounts (account_id, email, password, username, role_id, status) VALUES ('c39034a5-0334-3d8b-94d8-7be2f88f8c0d', 'admin@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Admin', 1, 1);
INSERT accounts (account_id, email, password, username, role_id, status) VALUES ('e58ed763-928c-4155-bee9-fdbaaadc15f3', 'ins@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'Instructor', 2, 1);
INSERT accounts (account_id, email, password, username, role_id, status) VALUES ('438eaaee-4d0f-3ac3-ad54-76c1002a42cc', 'meow@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b', 'A Flying Cat', 2, 1);
GO


/****** Object:  Table [dbo].[categories] ******/
CREATE TABLE categories(
	category_id INT IDENTITY(1,1) NOT NULL,
	category_name VARCHAR(50) NOT NULL,
	CONSTRAINT PK_categories PRIMARY KEY CLUSTERED (category_id ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] 
GO
SET IDENTITY_INSERT categories ON
INSERT categories(category_id,category_name) VALUES (1,'INSTRUMENTS');
INSERT categories(category_id,category_name) VALUES (2,'MUSIC_PRODUCTION');
INSERT categories(category_id,category_name) VALUES (3,'MUSIC_FUNDAMENTALS');
INSERT categories(category_id,category_name) VALUES (4,'VOCAL');
INSERT categories(category_id,category_name) VALUES (5,'MUSIC_TECHNIQUES');
INSERT categories(category_id,category_name) VALUES (6,'MUSIC_SOFTWARE');
INSERT categories(category_id,category_name) VALUES (7,'OTHERS');
SET IDENTITY_INSERT categories OFF


/****** Object:  Table [dbo].[courses] ******/
CREATE TABLE courses(
	course_id VARCHAR(36) NOT NULL,
	course_name VARCHAR(50) NOT NULL,
	image VARCHAR(50),
	description TEXT,
	tuition_fee MONEY NOT NULL,
	category_id INT NOT NULL,
	created_date
	start_date DATE,
	end_date DATE,
	last_updated_date DATETIME,
	last_updated_user_id VARCHAR(36),
	active_status BIT NOT NULL,

	quantity INT NOT NULL,

	CONSTRAINT FK_courses_categories FOREIGN KEY (category_id) REFERENCES categories,
	CONSTRAINT FK_courses_accounts FOREIGN KEY (last_updated_user_id) REFERENCES accounts,
	CONSTRAINT PK_courses PRIMARY KEY CLUSTERED(course_id ASC)
	WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
)
GO


/****** Object:  Table [dbo].[carts] ******/
CREATE TABLE carts(
	cart_id VARCHAR(36) NOT NULL,
	account_id VARCHAR(36) NOT NULL,
	total MONEY,
	CONSTRAINT FK_carts FOREIGN KEY (account_id) REFERENCES accounts,
	CONSTRAINT PK_carts PRIMARY KEY CLUSTERED (cart_id ASC) 
	WITH (IGNORE_DUP_KEY = OFF, PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
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