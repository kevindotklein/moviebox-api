CREATE TABLE ratings (
    id UUID,
    comment TEXT NOT NULL,
    stars VARCHAR(7) NOT NULL,
    media_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    CONSTRAINT ratings_pk PRIMARY KEY (id),
    CONSTRAINT medias_fk FOREIGN KEY (media_id) REFERENCES medias (id)
)