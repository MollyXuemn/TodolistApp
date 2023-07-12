CREATE TABLE public.todo_item
(
     id                         BIGSERIAL PRIMARY KEY,
     title                      VARCHAR(255) NOT NULL ,
     description                VARCHAR(255),
     createdAt                  TIMESTAMP NOT NULL,
     lastModified               TIMESTAMP NOT NULL,
     isDone                     BOOLEAN NOT NULL DEFAULT False
);

ALTER SEQUENCE todo_item_id_seq RESTART 100000 INCREMENT BY 50;
