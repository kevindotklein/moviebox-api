CREATE TABLE medias (
    id UUID,
    name VARCHAR(255) NOT NULL,
    cover TEXT NOT NULL,
    description TEXT NOT NULL,
    genre VARCHAR(20) NOT NULL,
    director VARCHAR(255) NOT NULL,
    year VARCHAR(6) NOT NULL,
    CONSTRAINT medias_pk PRIMARY KEY (id)
)