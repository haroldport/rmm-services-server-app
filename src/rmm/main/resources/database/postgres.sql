CREATE TABLE IF NOT EXISTS devices
(
    id varchar(36) not null
        constraint device_pkey
            primary key,
    system_name varchar(100) not null,
    type varchar(20) not null
);
