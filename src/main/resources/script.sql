create table if not exists orders
(
	order_id bigserial not null
		constraint orders_pk
			primary key,
	delivery_id bigint,
	phone varchar(13),
	coffee_id bigint not null,
	weight integer default 100 not null,
	cost numeric not null,
	column_7 integer
);

alter table orders owner to postgres;

create unique index if not exists orders_order_id_uindex
	on orders (order_id);

create unique index coffee_name_uindex
	on coffee (name);

-----------------------------------------------
create table delivery
(
	id bigserial not null,
	address int,
	timeFrom timestamp,
	timeTo timestamp
);

create unique index delivery_id_uindex
	on delivery (id);

alter table delivery
	add constraint delivery_pk
		primary key (id);

-------------------------------------------------
create table coffee
(
	id bigserial not null,
	name varchar(200) not null,
	manufacturer varchar(50),
	description varchar(300),
	price decimal,
	type_of_coffee varchar(50)
);

create unique index coffee_id_uindex
	on coffee (id);

alter table coffee
	add constraint coffee_pk
		primary key (id);
