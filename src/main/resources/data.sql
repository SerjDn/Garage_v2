--**************************************************
--These are scripts for H2 database
--**************************************************

CREATE TABLE IF NOT EXISTS "car"
(
    id integer NOT NULL AUTO_INCREMENT,
    brand text NOT NULL,
    model text NOT NULL,
    userid integer NULL,
    PRIMARY KEY (id)
);

INSERT INTO "car"(
    brand, model)
VALUES ('Audi', 'A3');

INSERT INTO "car"(
    brand, model, userid)
VALUES ('Audi', 'Q5', 1);

--**************************************************

CREATE TABLE IF NOT EXISTS "user"
(
    id integer NOT NULL AUTO_INCREMENT,
    name text NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO "user"(
    name)
VALUES ('Carl'), ('Arnold');
