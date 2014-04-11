insert into ss_task (id, title, description, user_id) values(1, 'Study PlayFramework 2.0','http://www.playframework.org/', 2);
insert into ss_task (id, title, description, user_id) values(2, 'Study Grails 2.0','http://www.grails.org/', 2);
insert into ss_task (id, title, description, user_id) values(3, 'Try SpringFuse','http://www.springfuse.com/', 2);
insert into ss_task (id, title, description, user_id) values(4, 'Try Spring Roo','http://www.springsource.org/spring-roo', 2);
insert into ss_task (id, title, description, user_id) values(5, 'Release SpringSide 4.0','As soon as posibble.', 2);

insert into ss_user (id, login_name, name, password, salt, roles, register_date) values(1,'admin','Admin','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','admin','2012-06-04 01:00:00');
insert into ss_user (id, login_name, name, password, salt, roles, register_date) values(2,'user','Calvin','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','user','2012-06-04 02:00:00');

-- new table
 
 

insert into tb_event 
(id,`title`,`descrition`,`phone`,`totol_price`,`require`,`commit_time`,`event_time`,`address`,`longitude`,`latitude`,`remark`,`category_id`,`statues`,`weight`) values 
(1,'title','descrition','phone',0,'require','2014-04-04 02:00:00','2014-04-04 02:00:00','address',0,0,'remark',1,2,0);

insert into tb_event_owner (event_id,owner_id)
values (1,1);



insert into tb_event_partake (event_id,partake_id)
values (1,2);

insert into tb_event_startuser (event_id,startuser_id)
values (1,1);

insert into tb_event_court (event_id,court_id)
values (1,1);

insert into tb_event_evaluate (event_id,evaluate_id)
values (1,1);

insert into tb_event_evaluate (event_id,evaluate_id)
values (1,2);

insert into tb_base_enum (id,`enum_type`,`enum_value`,`enum_desc`)
values (1,'enumsdfType','enumdsffValue','enumDssesc');
 
insert into tb_base_enum (id,`enum_type`,`enum_value`,`enum_desc`)
values (2,'enumTsfsfype','enumsfValue','enumDesdddc');
 
insert into tb_base_user (id,`account`,`name`,`password`,`roles`,`register_date`)
values (1,'account','name','password','roles','2014-04-04 02:00:00');

insert into tb_base_user (id,`account`,`name`,`password`,`roles`,`register_date`)
values (2,'account','name','password','roles','2014-04-04 02:00:00');
 

insert into tb_tennis_user (id,`user_id`,`age`,`address`,`birthday`,`gender_id`,`phote`,`phone`,`email`,`tennis_age`,`tennis_level`,`personal_info`,`login_times`,`last_login_date`,`device_flag`,`state_id`,`integral`,`account_level`)
values (1,1,0,'address','birthday',4,'phote','phone','email',0,0,0,0,'lastLoginDate','deviceFlag',6,'integral','accountLevel');
 
insert into tb_tennis_user (id,`user_id`,`age`,`address`,`birthday`,`gender_id`,`phote`,`phone`,`email`,`tennis_age`,`tennis_level`,`personal_info`,`login_times`,`last_login_date`,`device_flag`,`state_id`,`integral`,`account_level`)
values (2,2,0,'address','birthday',5,'phote','phone','email',0,0,0,0,'lastLoginDate','deviceFlag',7,'integral','accountLevel');
 
insert into tb_base_enum (id,`enum_type`,`enum_value`,`enum_desc`)
values (4,'user_gender','man','man');
insert into tb_base_enum (id,`enum_type`,`enum_value`,`enum_desc`)
values (5,'user_gender','women','women');
 
insert into tb_base_enum (id,`enum_type`,`enum_value`,`enum_desc`)
values (6,'user_state','0','在线');
insert into tb_base_enum (id,`enum_type`,`enum_value`,`enum_desc`)
values (7,'user_state','1','不在线');
insert into tb_base_enum (id,`enum_type`,`enum_value`,`enum_desc`)
values (8,'user_state','2','黑名单');



insert into tb_court (id,`address`,`city_id`,`district_id`,`phone`,`start_time`,`end_time`,`fee`,`court_desc`,`court_count`,`weights`,`longitude`,`latitude`)
values (1,'address',1,2,'phone','2014-04-04 02:00:00','2014-04-04 02:00:00','fee','courtDesc','courtCount','weights',0,0);

insert into tb_base_city (id,city_name,city_type)
values(1,'上海','province');
insert into tb_base_city (id,city_name,city_type)
values(2,'长宁区','municipality');


 
insert into tb_evaluate (id,`evaluate`,`score`,category_id)
values (1,'evaluate',34,3);

insert into tb_evaluate (id,`evaluate`,`score`,category_id)
values (2,'evaluate',4,3);

insert into tb_base_enum (id,`enum_type`,`enum_value`,`enum_desc`)
values (3,'evaluatetype','evaluatetype1','evaluatetype1');


























