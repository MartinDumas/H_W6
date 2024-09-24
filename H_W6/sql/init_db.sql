CREATE TABLE worker (
                        ID INTEGER PRIMARY KEY,
                        NAME VARCHAR(1000) NOT NULL CHECK (LENGTH (NAME) >= 2),
                        BIRTHDAY DATE CHECK (EXTRACT(YEAR FROM BIRTHDAY) >= 1900),
                        LEVEL VARCHAR(10) NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
                        SALARY INTEGER CHECK (SALARY BETWEEN 100 AND 100000)
);

CREATE TABLE client (
                        ID INTEGER PRIMARY KEY,
                        NAME VARCHAR(1000) NOT NULL CHECK (LENGTH (NAME) >= 2)
);

CREATE TABLE project (
                         ID INTEGER PRIMARY KEY,
                         CLIENT_ID INTEGER NOT NULL REFERENCES client(ID),
                         START_DATE DATE,
                         FINISH_DATE DATE
);

CREATE TABLE project_worker (
                                PROJECT_ID INTEGER NOT NULL,
                                FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
                                WORKER_ID INTEGER NOT NULL,
                                FOREIGN KEY (WORKER_ID) REFERENCES worker(ID),
                                PRIMARY KEY (PROJECT_ID, WORKER_ID)
);