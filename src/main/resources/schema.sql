CREATE TABLE IF NOT EXISTS USERS (
                                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                                     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     username TEXT NOT NULL UNIQUE,
                                     email TEXT NOT NULL UNIQUE,
                                     password TEXT NOT NULL
);
