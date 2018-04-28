DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS students;

DROP SEQUENCE IF EXISTS global_stud_seq;
DROP SEQUENCE IF EXISTS global_book_seq;
CREATE SEQUENCE global_stud_seq
  START 1000;
CREATE SEQUENCE global_book_seq
  START 5000;

CREATE TABLE students (
  id       INTEGER PRIMARY KEY  DEFAULT nextval('global_stud_seq'),
  name     VARCHAR(50) NOT NULL,
  age      INTEGER     NOT NULL,
  reg_date TIMESTAMP   NOT NULL,
  is_admin BOOLEAN     NOT NULL DEFAULT FALSE

);

CREATE TABLE books (
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_book_seq'),
  title      VARCHAR(100) NOT NULL,
  author     VARCHAR(50)  NOT NULL,
  pages      INTEGER      NOT NULL,
  student_id INTEGER      NOT NULL,
  FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE
);