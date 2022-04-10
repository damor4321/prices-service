CREATE SCHEMA IF NOT EXISTS pos;

DROP TABLE IF EXISTS pos.prices;
CREATE TABLE pos.prices (
	id serial NOT NULL,
	brand_id integer NOT NULL,
	start_date datetime NULL,
	end_date datetime NULL,
	price_list_id integer NOT NULL,
	product_id int8 NOT NULL,
	priority int4 NULL,
	price numeric(16,2) NOT NULL,
	currency varchar(10) NOT NULL,
	last_update datetime NULL,
	last_update_by varchar(10) NULL,
	CONSTRAINT price_pk PRIMARY KEY (id)
);

INSERT INTO pos.prices (
	id,
	brand_id,
	start_date,
	end_date,
	price_list_id,
	product_id,
	priority,
	price,
	currency,
	last_update,
	last_update_by
)
VALUES(
	1,
	1,
	'2020-06-14 00:00:00',
	'2020-12-31 23:59:59',
	1,
	35455,
	0,
	35.50,
	'EUR',
	'2020-03-26 14:49:07',
	'user1'
);

INSERT INTO pos.prices (
	id,
	brand_id,
	start_date,
	end_date,
	price_list_id,
	product_id,
	priority,
	price,
	currency,
	last_update,
	last_update_by	
)
VALUES(
	2,
	1,
	'2020-06-14 15:00:00',
	'2020-06-14 18:30:00',
	2,
	35455,
	1,
	25.45,
	'EUR',
	'2020-05-26 15:38:22',
	'user1'
);

INSERT INTO pos.prices (
	id,
	brand_id,
	start_date,
	end_date,
	price_list_id,
	product_id,
	priority,
	price,
	currency,
	last_update,
	last_update_by
)
VALUES(
	3,
	1,
	'2020-06-15 00:00:00',
	'2020-06-15 11:00:00',
	3,
	35455,
	1,
	30.50,
	'EUR',
	'2020-05-26 15:39:22',
	'user2'
);

INSERT INTO pos.prices (
	id,
	brand_id,
	start_date,
	end_date,
	price_list_id,
	product_id,
	priority,
	price,
	currency,
	last_update,
	last_update_by	
)
VALUES(
	4,
	1,
	'2020-06-15 16:00:00',
	'2020-12-31 23:59:59',
	4,
	35455,
	1,
	38.95,
	'EUR',
	'2020-06-02 10:14:00',
	'user1'
);
