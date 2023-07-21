CREATE TABLE worker
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR (1000) NOT NULL CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000),
    birthday DATE CHECK (YEAR(birthday) > 1900),
    level VARCHAR (10) NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    salary INT CHECK (salary  >= 100 AND salary <= 100000)
);

CREATE TABLE client
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR (1000) NOT NULL CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000)
);    

CREATE TABLE project
(
    id IDENTITY PRIMARY KEY,
    client_id BIGINT,
    start_date DATE,
    finish_date DATE
);

CREATE TABLE project_worker  
(
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    PRIMARY KEY (worker_id, project_id),
    FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY(worker_id) REFERENCES worker(id)
);

