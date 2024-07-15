CREATE TABLE replies
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    message  TEXT         NOT NULL,
    created  DATETIME     NOT NULL,
    topic    BIGINT       NOT NULL,
    author   BIGINT       NOT NULL,
    FOREIGN KEY (topic) REFERENCES topics (id),
    FOREIGN KEY (author) REFERENCES users (id)

);