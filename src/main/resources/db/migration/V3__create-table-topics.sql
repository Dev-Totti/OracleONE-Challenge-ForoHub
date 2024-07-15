CREATE TABLE topics
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    title   VARCHAR(100) NOT NULL,
    message TEXT         NOT NULL,
    created datetime     NOT NULL,
    status  VARCHAR(20)  NOT NULL,
    author  BIGINT       NOT NULL,
    course  BIGINT       NOT NULL,
    FOREIGN KEY (author) REFERENCES users (id),
    FOREIGN KEY (course) REFERENCES courses (id)

);