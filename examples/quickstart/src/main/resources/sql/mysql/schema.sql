/*drop table if exists ss_task;
drop table if exists ss_user;

create table ss_task (
	id bigint auto_increment,
	title varchar(128) not null,
	description varchar(255),
	user_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table ss_user (
	id bigint auto_increment,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	roles varchar(255) not null,
	register_date timestamp not null default 0,
	primary key (id)
) engine=InnoDB;
*/
--	基础城市或地址 
drop table if exists tb_base_city;

create table tb_base_city (
    id bigint auto_increment,
    `cityName` varchar(255) null,
    `cityType` varchar(255) null,
    primary key (id)
) engine=InnoDB;

-- 基础枚举数据表
drop table if exists tb_base_enum;

create table tb_base_enum (
    id bigint auto_increment,
    `enumType` varchar(255) null,
    `enumValue` varchar(255) null,
    `enumDesc` varchar(255) null,
    primary key (id)
) engine=InnoDB;

--基础用户
drop table if exists tb_base_user;


create table tb_base_user (
    id bigint auto_increment,
    `name` varchar(255) null,
    `password` varchar(255) null,
    `account` varchar(255) null,
    `registerDate` TIMESTAMP  null,
    `roles` varchar(255) null,
    `groupList` bigint  null,
    primary key (id)
) engine=InnoDB;

--球场
drop table if exists tb_court;

create table tb_court (
    id bigint auto_increment,
    `fee` varchar(255) null,
    `city_id` bigint  null,
    `courtCount` varchar(255) null,
    `endTime` TIMESTAMP null,
    `startTime` TIMESTAMP null,
    `phone` varchar(255) null,
    `district_id` bigint  null,
    `address` varchar(255) null,
    `weights` varchar(255) null,
    `latitude` double(5,10)  null,
    `longitude` double(5,10)  null,
    `courtDesc` varchar(255) null,
    primary key (id)
) engine=InnoDB;

create table tb_court_images (
    id bigint auto_increment,
    `court_id` bigint  not null,
    `image_id` bigint not null,
    primary key (id)
) engine=InnoDB;

create table tb_court_evaluate (
    id bigint auto_increment,
    `court_id` bigint  not null,
    `evaluate_id` bigint not null,
    primary key (id)
) engine=InnoDB;

-- 评价model
drop table if exists tb_evaluate;

create table tb_evaluate (
	id bigint auto_increment,
    `score` bigint  null,
    `evaluate` varchar(255) null,
    primary key (id)
) engine=InnoDB;

create table tb_event_evaluate (
    id bigint auto_increment,
    `event_id` bigint  not null,
    `evaluate_id` bigint not null,
    primary key (id)
) engine=InnoDB;

--
drop table if exists event_tb;


create table event_tb (
	id bigint auto_increment,
    `eventTime` TIMESTAMP  null,
    `commitTime` TIMESTAMP  null,
    `require` varchar(255) null,
    `category_id` bigint  null,
    `address` varchar(255) null,
    `totolPrice` double(5,10)  null,
    `phone` varchar(255) null,
    `latitude` double(5,10)  null,
    `longitude` double(5,10)  null,
    `descrition` varchar(255) null,
    `remark` varchar(255) null,
    `title` bigint  null,
    `event_status_id` bigint  null,
    `weight` bigint  null,
    `comments` bigint  null,
    primary key (id)
) engine=InnoDB;



create table tb_event_owner (
    id bigint auto_increment,
    `event_id` bigint  not null,
    `owner_id` bigint not null,
    primary key (id)
) engine=InnoDB;


create table tb_event_partake (
    id bigint auto_increment,
    `event_id` bigint  not null,
    `partake_id` bigint not null,
    primary key (id)
) engine=InnoDB;

create table tb_event_court (
    id bigint auto_increment,
    `event_id` bigint  not null,
    `court_id` bigint not null,
    primary key (id)
) engine=InnoDB;

create table tb_event_startuser (
    id bigint auto_increment,
    `event_id` bigint  not null,
    `startuser_id` bigint not null,
    primary key (id)
) engine=InnoDB;

-- 文件存储
drop table if exists tb_file_store;


create table tb_file_store (
	id bigint auto_increment,
    `fileUrl` varchar(255) null,
    `fileName` varchar(255) null,
    `fileType` bigint  null,
    primary key (id)
) engine=InnoDB;

-- 球友
drop table if exists tb_tennis_user;


create table tb_tennis_user (
	id bigint auto_increment,
    `user_id` bigint  null,
    `integral` varchar(255) null,
    `lastLoginDate` varchar(255) null,
    `personalInfo` bigint  null,
    `gender` bigint  null,
    `accountLevel` varchar(255) null,
    `birthday` varchar(255) null,
    `state` bigint  null,
    `tennisAge` int(11)  null,
    `phone` varchar(255) null,
    `address` varchar(255) null,
    `deviceFlag` varchar(255) null,
    `tennisLevel` int(11)  null,
    `email` varchar(255) null,
    `age` int(11)  null,
    `loginTimes` int(11)  null,
    `phote` varchar(255) null,
    primary key (id)
) engine=InnoDB;

create table tb_user_friends (
    id bigint auto_increment,
    `user_id` bigint  not null,
    `evaluate_id` bigint not null,
    primary key (id)
) engine=InnoDB;


