CREATE TABLE if not exists TB_ALUNO (
  id integer NOT NULL AUTO_INCREMENT,
  nome varchar(200) NOT NULL,
  rm integer NOT NULL,
  created_date timestamp DEFAULT NULL,
  updated_date timestamp DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;