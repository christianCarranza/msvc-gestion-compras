INSERT INTO user (user_name, password) VALUES ('john', '$2a$10$6GL5w2yuN/FsWsMNfI/XQ.QZ/RFqXjl297aqZaTd4dF/OwSSmnr.y');
INSERT INTO user (user_name, password) VALUES ('admin', '$2a$10$tbLO2pMHW6JWU3wA1VB8EeGLEVLzNcBKfh5p38MD/Ch398DjM9Ab2');

INSERT INTO role (name) VALUES ('USER');
INSERT INTO role (name) VALUES ('ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2); 