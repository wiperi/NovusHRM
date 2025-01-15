create table novus.departments
(
    id          int unsigned primary key auto_increment,
    name        varchar(50) not null unique,
    create_time datetime    null,
    update_time datetime    null
);


insert into novus.departments (id, name, create_time, update_time)
values (1, 'Human Resources', '2023-01-10 09:00:00', '2023-01-10 17:00:00'),
       (2, 'Finance', '2023-01-11 09:30:00', '2023-01-11 17:30:00'),
       (3, 'Engineering', '2023-01-12 10:00:00', '2023-01-12 18:00:00'),
       (4, 'Marketing', '2023-01-13 11:00:00', '2023-01-13 19:00:00'),
       (5, 'Sales', '2023-01-14 08:30:00', '2023-01-14 16:30:00');
