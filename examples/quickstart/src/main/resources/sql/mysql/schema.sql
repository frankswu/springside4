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
drop table if exists ss_task;
drop table if exists ss_user;

drop table if exists tb_base_city;
drop table if exists tb_base_enum;
drop table if exists tb_evaluate;
drop table if exists tb_court;
drop table if exists tb_event;
drop table if exists tb_event_evaluate;
drop table if exists tb_event_owner;
drop table if exists tb_event_partake; 
drop table if exists tb_event_court; 
drop table if exists tb_event_startuser; 
drop table if exists tb_file_store;
drop table if exists tb_tennis_user;
drop table if exists tb_base_user;
drop table if exists tb_group;
drop table if exists tb_user_group;


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
	register_date timestamp not null,
	primary key (id)
) engine=InnoDB;



-- frankswu 


create table tb_group (
    id bigint auto_increment,
    group_Name varchar(255) null,
    group_desc varchar(255) null,
    primary key (id)
) engine=InnoDB;

create table tb_user_group (
    id bigint auto_increment,
    user_id bigint  not null,
    group_id bigint not null,
    primary key (id)
) engine=InnoDB;

--	基础城市或地址 


create table tb_base_city (
    id bigint auto_increment,
    city_Name varchar(255) null,
    city_Type varchar(255) null,
    primary key (id)
) engine=InnoDB;

-- 基础枚举数据表


create table tb_base_enum (
    id bigint auto_increment,
    enum_Type varchar(255) null,
    enum_Value varchar(255) null,
    enum_Desc varchar(255) null,
    primary key (id)
) engine=InnoDB;

--基础用户



create table tb_base_user (
    id bigint auto_increment,
    name varchar(255) null,
    password varchar(255) null,
    account varchar(255) null,
    register_Date TIMESTAMP  null,
    roles varchar(255) null,
    group_List bigint  null,
    primary key (id)
) engine=InnoDB;

--球场


create table tb_court (
    id bigint auto_increment,
    title varchar(255) null,
    fee varchar(255) null,
    city_id bigint  not null,
    court_Count varchar(255) null,
    end_Time TIMESTAMP null,
    start_Time TIMESTAMP null,
    phone varchar(255) null,
    district_id bigint not null,
    address varchar(255) null,
    weights varchar(255) null,
    latitude double(10,8)  null,
    longitude double(10,8)  null,
    court_Desc varchar(255) null,
    primary key (id)
) engine=InnoDB;

create table tb_court_images (
    id bigint auto_increment,
    court_id bigint  not null,
    image_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table tb_court_evaluate (
    id bigint auto_increment,
    court_id bigint  not null,
    evaluate_id bigint not null,
    primary key (id)
) engine=InnoDB;

-- 评价model

create table tb_evaluate (
	id bigint auto_increment,
    score bigint  null,
    evaluate varchar(255) null,
    category_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table tb_event_evaluate (
    id bigint auto_increment,
    event_id bigint  not null,
    evaluate_id bigint not null,
    primary key (id)
) engine=InnoDB;

--


create table tb_event (
	id bigint auto_increment,
    event_Time TIMESTAMP  null,
    commit_Time TIMESTAMP  null,
    require varchar(255) null,
    category_id bigint  null,
    status_id bigint null,
    address varchar(255) null,
    totol_Price double(10,8)  null,
    phone varchar(255) null,
    latitude double(10,8)  null,
    longitude double(10,8)  null,
    descrition varchar(255) null,
    remark varchar(255) null,
    title varchar(255)  null,
    event_status_id bigint  null,
    weight bigint  null,
    primary key (id)
) engine=InnoDB;



create table tb_event_owner (
    id bigint auto_increment,
    event_id bigint  not null,
    owner_id bigint not null,
    primary key (id)
) engine=InnoDB;


create table tb_event_partake (
    id bigint auto_increment,
    event_id bigint  not null,
    partake_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table tb_event_court (
    id bigint auto_increment,
    event_id bigint  not null,
    court_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table tb_event_startuser (
    id bigint auto_increment,
    event_id bigint  not null,
    startuser_id bigint not null,
    primary key (id)
) engine=InnoDB;

-- 文件存储


create table tb_file_store (
	id bigint auto_increment,
    file_Url varchar(255) null,
    file_Name varchar(255) null,
    file_Type bigint  null,
    primary key (id)
) engine=InnoDB;

-- 球友


create table tb_tennis_user (
	id bigint not null,
    user_id bigint  null,
    integral varchar(255) null,
    last_Login_Date varchar(255) null,
    personal_Info bigint  null,
    gender bigint  null,
    account_Level varchar(255) null,
    birthday varchar(255) null,
    state bigint  null,
    tennis_Age int(11)  null,
    phone varchar(255) null,
    address varchar(255) null,
    device_Flag varchar(255) null,
    tennis_Level int(11)  null,
    email varchar(255) null,
    age int(11)  null,
    login_Times int(11)  null,
    phote varchar(255) null,
    gender_id bigint null,
    state_id bigint null,
    primary key (id)
) engine=InnoDB;

create table tb_user_friends (
    id bigint auto_increment,
    user_id bigint  not null,
    evaluate_id bigint not null,
    primary key (id)
) engine=InnoDB;

create table tb_user_image (
    id bigint auto_increment,
    user_id bigint  not null,
    image_id bigint not null,
    primary key (id)
) engine=InnoDB;

