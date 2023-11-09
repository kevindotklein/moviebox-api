CREATE TABLE series (
    id UUID,
    name VARCHAR(255) NOT NULL,
    cover VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    director VARCHAR(255) NOT NULL,
    year VARCHAR(10) NOT NULL,
    episodes VARCHAR(10) NOT NULL,
    seasons VARCHAR(10) NOT NULL,
    CONSTRAINT series_pk PRIMARY KEY (id)
)