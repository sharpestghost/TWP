create table Link (
id integer primary key generated always as identity,
url varchar(255) UNIQUE NOT NULL,
name varchar(255) NOT NULL,
description TEXT,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table Chat (
id integer primary key generated always as identity,
name varchar(255) NOT NULL,
description TEXT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table Link_Chat (
chat_id integer primary key not null,
link_id integer primary key not null,
FOREIGN KEY (chat_id) REFERENCES Chat(id),
FOREIGN KEY (link_id) REFERENCES Link(id)
)