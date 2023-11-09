CREATE TABLE users (
   id UUID,
   full_name VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL UNIQUE,
   password VARCHAR(255) NOT NULL,
   birth_date DATE NOT NULL,
   created_at TIMESTAMP NOT NULL,
   role VARCHAR(10) NOT NULL,
   CONSTRAINT users_pk PRIMARY KEY (id)
)