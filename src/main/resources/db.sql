create table orders_kafka
(
    order_id int primary key,
    status varchar(50),
    consumer_id varchar(50),
    order_date DATE,
    order_status boolean
);
