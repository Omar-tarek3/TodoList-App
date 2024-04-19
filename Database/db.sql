CREATE DATABASE todolist3;
USE todolist3;

CREATE TABLE todos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    completed BOOLEAN NOT NULL
);

-- Inserting the first todo item
INSERT INTO todos (id, title, completed) VALUES (1, 'Complete assignment', 0);

-- Inserting the second todo item
INSERT INTO todos (id, title, completed) VALUES (2, 'Buy groceries', 1);

-- Inserting the third todo item
INSERT INTO todos (id, title, completed) VALUES (3, 'Go for a run', 0);

INSERT INTO todos (id, title, completed) VALUES (4, 'FROM DOCKER', 0);
