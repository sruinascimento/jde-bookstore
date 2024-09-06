CREATE TABLE state
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    country_id BIGINT NOT NULL,

    CONSTRAINT fk_state_country_country_id
        FOREIGN KEY (country_id) REFERENCES country (id),
    CONSTRAINT uk_state_name_country_id
        UNIQUE(name, country_id)
);