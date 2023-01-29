CREATE TABLE IF NOT EXISTS "car"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY,
    brand text NOT NULL,
    model text NOT NULL,
    userid integer NULL,
    PRIMARY KEY (id)
);