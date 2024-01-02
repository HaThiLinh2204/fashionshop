use fashionshop;
create table categories(
 id varchar(25) primary key not null,
 name varchar(255) not null,
 description text,
 type integer,
 image_url varchar(255) not null
);

create table products(
id varchar(25) primary key not null,
id_category varchar(25) not null,
name varchar(255) ,
price integer,
quantity integer,
color varchar(255),
size_name varchar(255),
image_url varchar(255) not null,
FOREIGN KEY (id_category)
      REFERENCES categories (id)
	
);
SELECT * FROM users;
select * from products;
select * from categories;

drop table categories;
drop table products;