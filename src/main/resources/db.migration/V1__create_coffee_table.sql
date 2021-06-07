create table coffee
(
	id bigserial not null
		constraint coffee_pk
			primary key,
	name varchar(200) not null,
	manufacturer varchar(50),
	description varchar(300),
	price numeric,
	type_of_coffee varchar(50)
);

