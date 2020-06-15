create sequence hibernate_sequence start 1 increment 1
create table bookings (id int8 not null, comments varchar(255), created_at timestamp, date date, modified_at timestamp, status varchar(255), vehicule_brand varchar(255), vehicule_engine varchar(255), vehicule_model varchar(255), vehicule_number_plate varchar(255), primary key (id))
create table option (id int8 not null, option_value varchar(255), poll_id int8, primary key (id))
create table parts (id int8 not null, name varchar(255), price int4, primary key (id))
create table poll (id int8 not null, question varchar(255), primary key (id))
create table products (id int8 not null, category varchar(255), name varchar(255), price int4, booking_id int8, primary key (id))
create table users (id int8 not null, email varchar(255), full_name varchar(255), mobile varchar(255), password varchar(255), role varchar(255), primary key (id))
create table vote (id int8 not null, option_id int8, primary key (id))
alter table if exists option add constraint FKogie4xs6h1b59oxvxbut8s1f0 foreign key (poll_id) references poll
alter table if exists products add constraint FKjc08eq62p6gd68qppjrk0qm61 foreign key (booking_id) references bookings
alter table if exists vote add constraint FK5umi51fdy2rrua64mrmew0usu foreign key (option_id) references option
