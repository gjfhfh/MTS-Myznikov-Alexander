CREATE TABLE universities(
  id bigserial PRIMARY KEY,
  name VARCHAR(60) NOT NULL,
  location VARCHAR(60) NOT NULL
);

CREATE TABLE users(
  id bigserial PRIMARY KEY,
  full_name VARCHAR(60) NOT NULL,
  university_id BIGINT REFERENCES universities(id)
);

CREATE TABLE books(
  id bigserial PRIMARY KEY,
  user_id BIGINT REFERENCES users(id),
  author VARCHAR(60) NOT NULL,
  title VARCHAR(60) NOT NULL,
  year INTEGER NOT NULL
);
