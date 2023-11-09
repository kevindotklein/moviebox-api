CREATE TABLE movies (
    id UUID,
    name VARCHAR(255) NOT NULL,
    cover VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    genre VARCHAR(50) NOT NULL,
    director VARCHAR(255) NOT NULL,
    year VARCHAR(10) NOT NULL,
    duration VARCHAR(100) NOT NULL,
    CONSTRAINT movies_pk PRIMARY KEY (id)
)