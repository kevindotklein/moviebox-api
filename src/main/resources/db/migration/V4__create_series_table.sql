CREATE TABLE series (
    id UUID,
    episodes VARCHAR(10) NOT NULL,
    seasons VARCHAR(10) NOT NULL,
    CONSTRAINT series_pk PRIMARY KEY (id),
    CONSTRAINT medias_fk FOREIGN KEY (id) REFERENCES medias (id)
)