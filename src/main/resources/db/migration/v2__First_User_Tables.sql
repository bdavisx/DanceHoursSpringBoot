create table dance_user (
    user_id   uuid primary key not null,
    email     varchar(254)     not null,
    full_name varchar(1024)    not null,
    is_active bool             not null
);

create table dance_user_roles (
    user_id   uuid     not null,
    role_code char(16) not null,
    primary key (user_id, role_code)
);

create table user_roles (
    role_code   char(16) primary key not null,
    name        varchar(255),
    description text,
    is_admin    bool
);

create table aggregate_passwords (
    aggregate_id  uuid primary key not null,
    password_hash bytea            not null,
    salt          bytea            not null
);
