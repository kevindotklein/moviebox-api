CREATE TABLE ratings (
    id UUID,
    comment TEXT NOT NULL,
    stars VARCHAR(7) NOT NULL,
    media_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT ratings_pk PRIMARY KEY (id),
    CONSTRAINT medias_fk FOREIGN KEY (media_id) REFERENCES medias (id),
    CONSTRAINT users_fk FOREIGN KEY (user_id) REFERENCES users (id)
)