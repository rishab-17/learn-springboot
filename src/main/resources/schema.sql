CREATE TABLE IF NOT EXISTS RUN (
    id INT NOT NULL,
    title varchar(50) NOT NULL,
    started_on timestamp NOT NULL,
    completed_on timestamp NOT NULL,
    miles int NOT NULL,
    location varchar(30) NOT NULL,
    PRIMARY KEY (id)
);