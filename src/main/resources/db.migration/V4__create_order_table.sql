create table orders
(
	order_id bigserial not null
		constraint orders_pk
			primary key,
	delivery_id bigint,
	phone varchar(18),
	coffee_id bigint not null,
	weight integer default 100 not null,
	cost numeric not null
);
