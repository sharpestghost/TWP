CREATE TABLE
  IF NOT EXISTS link (
    id INT PRIMARY KEY generated always AS IDENTITY,
    url VARCHAR(255) UNIQUE NOT NULL,
    linkname VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    answer_count INT DEFAULT 0
  );

CREATE TABLE
  IF NOT EXISTS chat (
    id INT PRIMARY KEY,
    chatname VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );

CREATE TABLE
  IF NOT EXISTS link_chat (
    chat_id INTEGER NOT NULL,
    link_id INTEGER NOT NULL,
    PRIMARY KEY (chat_id, link_id),
    FOREIGN KEY (chat_id) REFERENCES chat (id) ON DELETE CASCADE,
    FOREIGN KEY (link_id) REFERENCES link (id) ON DELETE CASCADE
  );
