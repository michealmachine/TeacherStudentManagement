create table login
(
    id       int auto_increment
        primary key,
    username varchar(20) null,
    password varchar(20) null,
    constraint username
        unique (username)
);

create table student
(
    id         int auto_increment
        primary key,
    name       varchar(10) null,
    grade      varchar(10) null,
    profession varchar(20) null,
    gender     char(2)     null
);

create table teacher
(
    id      int auto_increment
        primary key,
    name    varchar(10) null,
    gender  char(2)     null,
    college varchar(10) null
);

create table course
(
    cid   int         not null,
    tid   int         not null,
    name  varchar(10) null,
    tname varchar(10) null,
    primary key (cid, tid),
    constraint fkey
        foreign key (tid) references teacher (id)
            on delete cascade
);

create table studentcourse
(
    sid int not null,
    cid int not null,
    tid int not null,
    primary key (sid, cid, tid),
    constraint kc
        foreign key (cid, tid) references course (cid, tid)
            on delete cascade,
    constraint ks
        foreign key (sid) references student (id)
            on delete cascade
);

