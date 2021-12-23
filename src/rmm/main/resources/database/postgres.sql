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
    type varchar(20) not null,
    customer_id varchar(36)
        constraint customers_devices_fk
            references customers
            on update cascade
);

CREATE TABLE IF NOT EXISTS services
(
    id varchar(36) not null
        constraint service_pkey
            primary key,
    name varchar(20) not null,
    costs json not null
);

CREATE TABLE IF NOT EXISTS customer_services
(
    id varchar(36) not null
        constraint customer_service_pkey
            primary key,
    customer_id varchar(36)
        constraint customer_customer_service_fk
            references customers
            on update cascade,
    service_id varchar(36)
        constraint service_customer_service_fk
            references services
            on update cascade
    );

truncate table services cascade;

insert into services(id, name, costs) values('dd226ce6-6c05-4111-b042-cfb7e43d8b48', 'Antivirus', '[{"platform": "Windows", "price": 5}, {"platform": "Mac", "price": 7}]');
insert into services(id, name, costs) values('ac77b045-5ee0-4176-b0f2-e63a6d7252bb', 'Cloudberry', '[{"platform": "Windows", "price": 3}, {"platform": "Mac", "price": 3}]');
insert into services(id, name, costs) values('db6bad1d-093e-433d-86b1-9896b3f82703', 'PSA', '[{"platform": "Windows", "price": 2}, {"platform": "Mac", "price": 2}]');
insert into services(id, name, costs) values('6fc77457-44da-48a4-8153-42dae4115b03', 'TeamViewer', '[{"platform": "Windows", "price": 1}, {"platform": "Mac", "price": 1}]');
