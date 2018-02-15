DROP TABLE IF EXISTS students;
DROP SEQUENCE IF EXISTS global_stud_seq;

CREATE SEQUENCE global_stud_seq
  START 100;

CREATE TABLE students (
  id           INTEGER PRIMARY KEY DEFAULT nextval('global_stud_seq'),
  name         VARCHAR(255) NOT NULL,
  isExtramural BOOL                DEFAULT TRUE,
  createdDate  TIMESTAMP           DEFAULT now()
);