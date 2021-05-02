CREATE TABLE IF NOT EXISTS users
(
    user_id SERIAL NOT NULL PRIMARY KEY ,
    username VARCHAR(256) NOT NULL ,
    password VARCHAR(256) NOT NULL,
    email VARCHAR(256) NOT NULL
);
CREATE TABLE IF NOT EXISTS roles
(
    role_id INT NOT NULL PRIMARY KEY ,
    role_name VARCHAR(256) NOT NULL
);
CREATE TABLE IF NOT EXISTS user_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (role_id) REFERENCES roles (role_id),

    UNIQUE (user_id, role_id)
);

INSERT INTO roles (role_id, role_name)
SELECT 1, 'ROLE_USER'
    WHERE NOT EXISTS (
        SELECT role_id FROM roles WHERE role_id = 1
    );
INSERT INTO roles (role_id, role_name)
SELECT 2, 'ROLE_ADMIN'
    WHERE NOT EXISTS (
        SELECT role_id FROM roles WHERE role_id = 2
    );
