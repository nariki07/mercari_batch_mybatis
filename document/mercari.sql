-- Project Name : noname
-- Date/Time    : 2018/02/01 15:42:46
-- Author       : y.kimura
-- RDBMS Type   : Oracle Database
-- Application  : A5:SQL Mk-2


-- big_category
create table big_category(
	id serial not null
	, name character varying(255)
	, constraint category_PKC primary key (id)
);


-- medium_category
create table medium_category(
	id serial not null
	, big_category_id integer
	, name character varying(255)
	, constraint medium_category_PKC primary key (id)
	, FOREIGN KEY (big_category_id) REFERENCES big_category (id) on delete cascade
);

-- small_category
create table small_category(
	id serial not null
	, medium_category_id integer
	, name character varying(255)
	, name_all character varying(255)
	, constraint small_category_PKC primary key (id)
	, FOREIGN KEY (medium_category_id) REFERENCES medium_category (id) on delete cascade
);


-- items
create table items (
  id serial not null
  , name character varying(255)
  , condition integer
  , category integer
  , brand character varying(255)
  , price double precision
  , shipping integer
  , description text
  , constraint items_PKC primary key (id)
) ;

create index items_brand_index
  on items(brand);

create index items_category_index
  on items(category);

create unique index items_pki
  on items(id);

-- original
create table original (
  id integer not null
  , name character varying(255)
  , condition_id integer
  , category_name character varying(255)
  , brand character varying(255)
  , price double precision
  , shipping integer
  , description text
  , constraint original_PKC primary key (id)
) ;

create index brand_index
  on original(brand);

create unique index original_pki
  on original(id);

-- users
create table users (
  id serial not null
  , name varchar(255)
  , password varchar(255)
  , authority integer
  , constraint users_PKC primary key (id)
) ;

create unique index users_pki
  on users(id);

comment on table category is 'category';
comment on column category.name_all is 'name_all';
comment on column category.id is 'id';
comment on column category.parent is 'parent';
comment on column category.name is 'name';

comment on table items is 'items';
comment on column items.id is 'id';
comment on column items.name is 'name';
comment on column items.condition is 'condition';
comment on column items.category is 'category';
comment on column items.brand is 'brand';
comment on column items.price is 'price';
comment on column items.shipping is 'shipping';
comment on column items.description is 'description';

comment on table original is 'original';
comment on column original.id is 'id';
comment on column original.name is 'name';
comment on column original.condition_id is 'condition_id';
comment on column original.category_name is 'category_name';
comment on column original.brand is 'brand';
comment on column original.price is 'price';
comment on column original.shipping is 'shipping';
comment on column original.description is 'description';

comment on table users is 'users';
comment on column users.id is 'id';
comment on column users.name is 'name';
comment on column users.password is 'password';
comment on column users.authority is 'authority';


