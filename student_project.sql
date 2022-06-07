drop table if exists sp_street;
drop table if exists sp_country_struct;
drop table if exists sp_passport_office;
drop table if exists sp_register_office;

create table sp_street(
    street_code integer not null,
    street_name varchar(300),
    primary key (street_code)
);

create table sp_country_struct
(
    area_id char(12) not null,
    area_name varchar(200),
    primary key (area_id)
);

create table sp_passport_office(
    p_office_id integer not null,
    p_office_area_id char(12) not null,
    p_office_name varchar(200),
    primary key(p_office_id),
    foreign key(p_office_area_id) references sp_country_struct(area_id) on delete restrict
);

create table sp_register_office(
    r_office_id integer not null,
    r_office_area_id char(12) not null,
    r_office_name varchar(200),
    primary key(r_office_id),
    foreign key(r_office_area_id) references sp_country_struct(area_id) on delete restrict
);