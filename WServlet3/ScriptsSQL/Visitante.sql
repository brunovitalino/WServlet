USE wservlet3;

CREATE TABLE Visitante
(
	id INT(6) UNSIGNED ZEROFILL AUTO_INCREMENT,
    nome VARCHAR(15) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(50) NOT NULL,
    mensagem VARCHAR(500),
    PRIMARY KEY(id)
);

INSERT INTO Visitante(nome) VALUES ('Caverinha1');

SET insert_id=1;

-- Como eu estava fazendo alguns testes, entao criei esse scrip para
-- resetar o id de insercao, pois o set insert_id nao estava sendo suficiente.
SELECT * FROM Visitante;
DELETE FROM Visitante WHERE id>=1;
ALTER TABLE Visitante CHANGE id idOld INT(6) UNSIGNED ZEROFILL;
ALTER TABLE Visitante DROP PRIMARY KEY;
ALTER TABLE Visitante ADD id INT(6) UNSIGNED ZEROFILL AUTO_INCREMENT PRIMARY KEY FIRST;
ALTER TABLE Visitante DROP idOld;
-- ----------------------------------------------------------------------------

SELECT * FROM Visitante;




