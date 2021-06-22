create table produto
(
    id         bigint auto_increment primary key,
    nome       varchar(50)  not null,
    descricao  varchar(150) not null,
    preco      decimal      not null,
    quantidade int          not null,
    status     bit(1)       not null
);
