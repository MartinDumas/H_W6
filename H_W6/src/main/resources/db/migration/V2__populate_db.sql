INSERT INTO client (name) VALUES ('Client A'), ('Client B');
INSERT INTO worker (name, salary) VALUES ('Worker A', 1000), ('Worker B', 1200);
INSERT INTO project (name, client_id) VALUES ('Project X', 1), ('Project Y', 2);
INSERT INTO project_worker (project_id, worker_id) VALUES (1, 1), (1, 2), (2, 1);
