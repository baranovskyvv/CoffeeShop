alter table coffee owner to postgres;

create unique index coffee_id_uindex
	on coffee (id);

create unique index coffee_name_uindex
	on coffee (name);

