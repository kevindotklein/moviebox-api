CREATE TABLE movies (
    id UUID,
    duration VARCHAR(20) NOT NULL,
    CONSTRAINT movies_pk PRIMARY KEY (id),
    CONSTRAINT medias_fk FOREIGN KEY (id) REFERENCES medias (id)
)