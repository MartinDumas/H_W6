CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE worker (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        salary INT NOT NULL
);

CREATE TABLE project (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         client_id BIGINT,
                         FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE project_worker
(
    project_id BIGINT,
    worker_id  BIGINT,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (project_id) REFERENCES project (id),
    FOREIGN KEY (worker_id) REFERENCES worker (id)
);