DROP TABLE IF EXISTS students;
DROP SEQUENCE IF EXISTS global_stud_seq;

CREATE SEQUENCE global_stud_seq
  START 1000;
CREATE TABLE students (
  id         INT PRIMARY KEY DEFAULT nextval('global_stud_seq'),
  name       VARCHAR(100) NOT NULL,
  external   BOOLEAN         DEFAULT FALSE,
  createDate TIMESTAMP       DEFAULT now()
);