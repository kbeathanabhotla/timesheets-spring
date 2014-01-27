use timesheets;

insert into persons (name,isAdmin) values ('Ravi Thalupula','true');
insert into persons (name,isAdmin) values ('Vijayaprasad Pala','true');
insert into persons (name,isAdmin) values ('Gopi Thumati');
insert into persons (name,isAdmin) values ('Kiran Putcha','true');
insert into persons (name,isAdmin) values ('Rajeshwaran Krishnamoorthy');
insert into persons (name,isAdmin) values ('Mohan Panchireddy');
insert into persons (name,isAdmin) values ('Sudheer Gowlikar');
insert into persons (name,isAdmin) values ('Madhusudhana Reddy');
insert into persons (name,isAdmin) values ('Pratima Cheppala','true');
insert into persons (name,isAdmin) values ('Tarun Juneja','true');
insert into persons (name,isAdmin) values ('Smita Panasa','true');
insert into persons (name,isAdmin) values ('Goutham Patala','true');
insert into persons (name,isAdmin) values ('Sathish Kumar Reddy Pothuirai');
insert into persons (name,isAdmin) values ('Sathish Thoutham');
insert into persons (name,isAdmin) values ('Siva Kumar Reddy Tamma','true');
insert into persons (name,isAdmin) values ('Sai Krishna Kishore');
insert into persons (name,isAdmin) values ('Ramesh Gangineni');
commit;

insert into clients (name) values ('Valuelabs');
insert into clients (name) values ('Client');
commit;

insert into activities (activity_type) values ('Analysis');
insert into activities (activity_type) values ('Bug Fixing');
insert into activities (activity_type) values ('Client Call');
insert into activities (activity_type) values ('Code Review');
insert into activities (activity_type) values ('Coding');
insert into activities (activity_type) values ('Deployment');
insert into activities (activity_type) values ('Documentation');
insert into activities (activity_type) values ('Feedback Imp.');
insert into activities (activity_type) values ('Internal Meeting');
insert into activities (activity_type) values ('Interview');
insert into activities (activity_type) values ('Leave');
insert into activities (activity_type) values ('Meeting - Others(Specified in Task Desc.)');
insert into activities (activity_type) values ('Others (Specified in Task Desc.)');
insert into activities (activity_type) values ('Peer Review');
insert into activities (activity_type) values ('Project Management');
insert into activities (activity_type) values ('R & D');
insert into activities (activity_type) values ('Support');
insert into activities (activity_type) values ('Testing');
insert into activities (activity_type) values ('Training');
insert into activities (activity_type) values ('Unit Testing');
insert into activities (activity_type) values ('UTC');
insert into activities (activity_type) values ('Weekly Status Meeting');
commit;

insert into activity_types (activity_type) values ('Others (Specify in Task Desc.)');
insert into activity_types (activity_type) values ('Development');
insert into activity_types (activity_type) values ('Maintainence');
insert into activity_types (activity_type) values ('QA');
commit;

insert into modules (name) values ('Symphony7');
insert into modules (name) values ('ValueLabs');
insert into modules (name) values ('TAGV5');
commit;

insert into statuses (name) values ('In Process');
insert into statuses (name) values ('Completed');
insert into statuses (name) values ('On Hold');
commit;


