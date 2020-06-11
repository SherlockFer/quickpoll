insert into poll (id, question) values (1, 'What is your favorite color?');
insert into option (id, option_value, poll_id) values (1, 'Red', 1);
insert into option (id, option_value, poll_id) values (2, 'Black', 1);
insert into option (id, option_value, poll_id) values (3, 'Blue', 1);
insert into option (id, option_value, poll_id) values (4, 'White', 1);

insert into poll (id, question) values (2, 'What is your favorite Credit Card?');
insert into option (id, option_value, poll_id) values (5, 'American Express', 2);
insert into option (id, option_value, poll_id) values (6, 'Visa', 2);
insert into option (id, option_value, poll_id) values (7, 'Master Card', 2);
insert into option (id, option_value, poll_id) values (8, 'Discover', 2);	

insert into poll (id, question) values (3, 'What is your favorite Sport?');
insert into option (id, option_value, poll_id) values (9, 'Football', 3);
insert into option (id, option_value, poll_id) values (10, 'Basketball', 3);
insert into option (id, option_value, poll_id) values (11, 'Cricket', 3);
insert into option (id, option_value, poll_id) values (12, 'Baseball', 3);

insert into user_entity (id, full_name, mobile, email, role, password) values (1, 'Mechanic-1' , '123456789' , 'mechanic-1@garage.com' , 'mechanic1' , '123456');
insert into user_entity (id, full_name, mobile, email, role, password) values (2, 'Mechanic-2' , '123456789' , 'mechanic-2@garage.com' , 'mechanic2' , '123456');
insert into user_entity (id, full_name, mobile, email, role, password) values (3, 'Mechanic-3' , '123456789' , 'mechanic-3@garage.com' , 'mechanic3' , '123456');