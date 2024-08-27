CREATE TABLE book
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    title            VARCHAR(50)  NOT NULL UNIQUE,
    summary          VARCHAR(500) NOT NULL,
    table_of_content TEXT,
    price            DECIMAL      NOT NULL,
    number_of_pages  INT          NOT NULL,
    isbn             VARCHAR(30)  NOT NULL UNIQUE,
    publication_date DATETIME     NOT NULL,
    category_id      BIGINT       NOT NULL,
    author_id        BIGINT       NOT NULL,

    CONSTRAINT fk_book_category
        FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT fk_book_author
        FOREIGN KEY (author_id) REFERENCES author (id)

);