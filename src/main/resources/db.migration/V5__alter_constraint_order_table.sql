alter table orders owner to postgres;

create unique index orders_order_id_uindex
	on orders (order_id);

