create table IF NOT EXISTS Link (
id INT primary key generated always as identity,
url varchar(255) UNIQUE NOT NULL,
linkname varchar(255) NOT NULL,
description TEXT,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table IF NOT EXISTS Chat (
id INT primary key generated always as identity,
chatname varchar(255) NOT NULL,
description TEXT,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table IF NOT EXISTS Link_Chat (
chat_id integer not null,
link_id integer not null,
PRIMARY KEY (chat_id, link_id),
FOREIGN KEY (chat_id) REFERENCES Chat(id),
FOREIGN KEY (link_id) REFERENCES Link(id)
);