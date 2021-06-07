alter table delivery owner to postgres;

create unique index delivery_id_uindex
	on delivery (id);