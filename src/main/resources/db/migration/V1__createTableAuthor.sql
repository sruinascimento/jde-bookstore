CREATE TABLE author
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(50)  NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(400) NOT NULL,
    created_at  DATETIME     NOT NULL
);