CREATE TABLE IF NOT EXISTS customers
(
    id varchar(36) not null
        constraint customer_pkey
            primary key,
    username varchar(100) not null
        constraint username_uq
            unique,
    password varchar(8) not null
);

CREATE TABLE IF NOT EXISTS devices
(
    id varchar(36) not null
        constraint device_pkey
            primary key,
    system_name varchar(100) not null,
    type varchar(20) not null
);
