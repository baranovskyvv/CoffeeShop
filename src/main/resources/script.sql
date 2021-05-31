create table coffee
(
	product_id bigserial not null,
	name varchar(150) not null,
	manufacturer varchar(100),
	description varchar(250),
	price int not null,
	type_of_coffee varchar(50),
	weight int
);

create unique index coffee_product_id_uindex
	on coffee (product_id);

alter table coffee
	add constraint coffee_pk
		primary key (product_id);



-- ---------------------------------------------
create table cart
(
	cart_id bigserial not null,
	order_id bigint not null,
	quantity int not null,
	product_id bigint not null
);

create unique index cart_cart_id_uindex
	on cart (cart_id);

alter table cart
	add constraint cart_pk
		primary key (cart_id);

---------------------------------------------------------------
create table users
(
	id bigserial not null,
	phone varchar(15) not null,
	name varchar(150) not null
);

create unique index users_id_uindex
	on users (id);

create unique index users_phone_uindex
	on users (phone);

alter table users
	add constraint users_pk
		primary key (id);

----------------------------------------------------------
create table orders
(
	order_id bigserial not null,
	user_id bigint not null,
	status varchar(15)
);

create unique index orders_order_id_uindex
	on orders (order_id);

alter table orders
	add constraint orders_pk
		primary key (order_id);

