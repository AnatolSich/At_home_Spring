DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS books;
DROP SEQUENCE IF EXISTS global_stud_seq;
DROP SEQUENCE IF EXISTS global_book_seq;

CREATE SEQUENCE global_stud_seq
  START 100;
CREATE SEQUENCE global_book_seq
  START 1000;

CREATE TABLE students
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_stud_seq'),
  name        VARCHAR(100) NOT NULL,
  age         INTEGER      NOT NULL,
  is_admin     BOOL                DEFAULT FALSE,
  created_date TIMESTAMP           DEFAULT now()
);

CREATE TABLE books
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_book_seq'),
  student_id INTEGER NOT NULL,
  pages INTEGER NOT NULL,
  author VARCHAR(100) NOT NULL,
  FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE
);