CREATE TABLE IF NOT EXISTS "auth"
(
    name text NOT NULL,
    password text NOT NULL,
    role text NOT NULL,
    PRIMARY KEY (name)
);

INSERT INTO "auth"(
    name, password, role)
VALUES ('admin', '$2a$12$pYzPn1TbGHgIVaHHp03eeOnhx3iBpZ.XVKQCdivGjrwKHyHlQCmha', 'ADMIN'),
       ('user', '$2a$12$AJLrYIt45IK2t/QjVeFSUuV0.EakWOjQikMQ1PXsl/fz13yyc6vda', 'USER');