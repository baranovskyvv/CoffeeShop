create table delivery
(
	id bigserial not null
		constraint delivery_pk
			primary key,
	address varchar,
	timefrom timestamp,
	timeto timestamp
);


