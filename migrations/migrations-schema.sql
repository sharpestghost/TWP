create table if not exists Link (
id bigint primary key,
url varchar(255) unique not null,
linkname varchar(255) not null,
description text,
updated_at timestamp default current_timestamp
);

create table if not exists Chat (
id int primary key,
chatname varchar(255) not null,
description text,
created_at timestamp default current_timestamp,
updated_at timestamp default current_timestamp
);

create table if not exists Link_Chat (
chat_id integer not null,
link_id integer not null,
primary key (chat_id, link_id),
foreign key (chat_id) references Chat(id) on delete cascade,
foreign key (link_id) references Link(id) on delete cascade
);