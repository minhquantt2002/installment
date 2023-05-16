create database installment;
use installment;
create table tblUser
(
    id        int primary key auto_increment,
    username  varchar(25) unique not null,
    password  varchar(25)        not null,
    full_name varchar(50)        not null,
    role      varchar(50)        not null
);

create table tblPartner
(
    id      int primary key auto_increment,
    name    varchar(125) not null,
    tel     varchar(20)  not null,
    email   varchar(50)  not null,
    address varchar(250) not null,
    note    varchar(250)
);

create table tblProduct
(
    id          int primary key auto_increment,
    name        varchar(50) not null,
    price       float       not null,
    category	varchar(50) not null,
    description varchar(250)
);

create table tblClient
(
    id        int primary key auto_increment,
    full_name varchar(125) not null,
    id_card   varchar(20)  not null,
    address   varchar(250) not null,
    tel       varchar(20)  not null,
    email     varchar(50),
    note      varchar(250)
);

create table tblContract
(
    id              int primary key auto_increment,
    name            varchar(100) not null,
    interest_rate   float        not null,
    term_loan       varchar(50)  not null,
    created_day 	varchar(100) not null,
    note            varchar(250),
    user_id         int          not null,
    client_id       int          not null,
    partner_id      int          not null,
    foreign key (user_id) references tblUser (id),
    foreign key (client_id) references tblClient (id),
    foreign key (partner_id) references tblPartner (id)
);

create table tblPaymentSchedule
(
    id            int primary key auto_increment,
    payment_date  varchar(100)  not null,
    amount        float 		not null,
    remain_amount float 		not null,
    contract_id   int   		not null,
    foreign key (contract_id) references tblContract (id)
);

create table tblContractDetail
(
    id          int primary key auto_increment,
    price       float 	not null,
    quantity    int 	not null,
    product_id  int 	not null,
    contract_id int 	not null,
    foreign key (product_id) references tblProduct (id),
    foreign key (contract_id) references tblContract (id)
);
