create table public.users
(
    id       bigint       not null primary key,
    username varchar(255) not null
);

create table public.user_product
(
    id      bigint       not null primary key,
    user_id integer      not null,
    count   integer      not null,
    balance integer      not null,
    type    varchar(255) not null
);

create table public.orders
(
    id      integer not null primary key,
    user_id integer not null,
    name    text    not null
);

create table public.order_details
(
    id         integer           not null primary key,
    order_id   integer           not null references public.orders,
    product_id integer           not null,
    count      integer default 1 not null
);

INSERT INTO public.users (id, username)
VALUES (2, 'Глеб Ольховский');
INSERT INTO public.users (id, username)
VALUES (3, 'Лена Мент');

INSERT INTO public.user_product (id, user_id, count, balance, type)
VALUES (1, 2, 12346, 6000000, 'CARD');
INSERT INTO public.user_product (id, user_id, count, balance, type)
VALUES (2, 2, 12346, 100000000, 'INVOICE');
INSERT INTO public.user_product (id, user_id, count, balance, type)
VALUES (3, 3, 654654, 1000000, 'CARD');
INSERT INTO public.user_product (id, user_id, count, balance, type)
VALUES (4, 3, 654654, 600000, 'INVOICE');
INSERT INTO public.user_product (id, user_id, count, balance, type)
VALUES (5, 3, 654654, 550000, 'CARD');
INSERT INTO public.user_product (id, user_id, count, balance, type)
VALUES (6, 3, 123464, 5000, 'INVOICE');

INSERT INTO public.orders (id, user_id, name)
VALUES (1, 101, 'Заказ №1');
INSERT INTO public.orders (id, user_id, name)
VALUES (2, 102, 'Заказ №2');
INSERT INTO public.orders (id, user_id, name)
VALUES (3, 103, 'Заказ №3');
INSERT INTO public.orders (id, user_id, name)
VALUES (4, 101, 'Заказ №4');
INSERT INTO public.orders (id, user_id, name)
VALUES (5, 102, 'Заказ №5');
INSERT INTO public.orders (id, user_id, name)
VALUES (6, 103, 'Заказ №6');

INSERT INTO public.order_details (id, order_id, product_id, count)
VALUES (1, 1, 201, 2);
INSERT INTO public.order_details (id, order_id, product_id, count)
VALUES (2, 1, 202, 3);
INSERT INTO public.order_details (id, order_id, product_id, count)
VALUES (3, 2, 203, 1);
INSERT INTO public.order_details (id, order_id, product_id, count)
VALUES (4, 3, 204, 5);
INSERT INTO public.order_details (id, order_id, product_id, count)
VALUES (5, 3, 205, 2);