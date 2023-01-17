CREATE TABLE "car"
(
    id integer NOT NULL AUTO_INCREMENT,
    brand text NOT NULL,
    model text NOT NULL,
    userid integer NULL,
    PRIMARY KEY (id)
);

INSERT INTO "car"(
    brand, model)
VALUES ('Nissan', 'Skyline');

CREATE TABLE "user"
(
    id integer NOT NULL AUTO_INCREMENT,
    name text NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO "user"(
    name)
VALUES ('John');