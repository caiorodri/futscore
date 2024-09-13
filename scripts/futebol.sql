drop database if exists futebol;
create database if not exists futebol;
use futebol;

CREATE TABLE continente(
	
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL

);

INSERT INTO continente (nome) VALUES  ("África"), ("Ásia"), ("América do Sul"), ("América Central"), ("América do Norte"), ("Europa"), ("Oceania"), ("Antártida");

CREATE TABLE pais (
	
    id INT PRIMARY KEY AUTO_INCREMENT,
    continente_id INT NOT NULL,
    nome VARCHAR(30) NOT NULL,
    imagem BLOB,
    CONSTRAINT fk_pais_continente FOREIGN KEY (continente_id) REFERENCES continente(id)
);

CREATE TABLE IF NOT EXISTS clube(

	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    pais_id INT NOT NULL,
    ano_fundacao DATE,
    imagem BLOB,
    CONSTRAINT fk_clube_pais FOREIGN KEY (pais_id) REFERENCES pais(id)
	
);

CREATE TABLE jogador (
	
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(40) NOT NULL,
    clube_atual_id BIGINT,
    nacionalidade INT NOT NULL,
    data_nascimento DATE,
    jogos INT DEFAULT 0,
    gols INT DEFAULT 0,
    assistencias INT DEFAULT 0,
    cartoes_amarelo INT DEFAULT 0,
    cartoes_vermelho INT DEFAULT 0,
    valor_mercado DOUBLE DEFAULT 0,
    imagem BLOB,
	CONSTRAINT fk_jogador_clube FOREIGN KEY (clube_atual_id) REFERENCES clube(id),
	CONSTRAINT fk_jogador_pais FOREIGN KEY (nacionalidade) REFERENCES pais(id)
);

CREATE TABLE competicao_tipo(
	
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL
    
);

INSERT INTO competicao_tipo (nome) VALUES ("Nacional"), ("Continental"), ("Mundial");

CREATE TABLE competicao_formato(
	
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL

);

INSERT INTO competicao_formato (nome) VALUES ("Pontos Corridos"), ("Mata-Mata"), ("Pontos Corridos + Mata-Mata");

CREATE TABLE competicao(

	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    competicao_tipo_id INT NOT NULL,
    pais_id INT,
    imagem BLOB,
    CONSTRAINT fk_competicao_competicao_tipo FOREIGN KEY (competicao_tipo_id) REFERENCES competicao_tipo(id),
    CONSTRAINT fk_competicao_pais FOREIGN KEY (pais_id) REFERENCES pais(id)
    
);

CREATE TABLE competicao_ano(

	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    competicao_id BIGINT NOT NULL,
    formato_id INT NOT NULL,
    quantidade_clubes INT NOT NULL,
    ano YEAR NOT NULL,
    pontuacao_vitoria INT DEFAULT 3,
    pontuacao_empate INT DEFAULT 1,
    pontuacao_derrota INT DEFAULT 0,
	CONSTRAINT fk_competicao_formato FOREIGN KEY (formato_id) REFERENCES competicao_formato(id),
	CONSTRAINT fk_competicao_ano_competicao FOREIGN KEY (competicao_id) REFERENCES competicao(id)
);


CREATE TABLE IF NOT EXISTS campeonato(
	
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    competicao_ano_id BIGINT NOT NULL,
    clube_id BIGINT NOT NULL,
    partidas INT DEFAULT 0,
    vitorias INT DEFAULT 0,
    empates INT DEFAULT 0,
    derrotas INT DEFAULT 0,
    gols_feito INT DEFAULT 0,
    gols_sofrido INT DEFAULT 0,
    punicao INT DEFAULT 0,
    CONSTRAINT fk_campeonato_competicao_ano FOREIGN KEY (competicao_ano_id) REFERENCES competicao_ano(id),
	CONSTRAINT fk_campeonato_clube FOREIGN KEY (clube_id) REFERENCES clube(id)
);


CREATE TABLE jogador_clube_passagem(
	
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    jogador_id BIGINT,
    clube_id BIGINT,
    jogos INT DEFAULT 0,
    gols INT DEFAULT 0,
    assistencias INT DEFAULT 0,
	CONSTRAINT fk_jogador_clube_passagem_jogador FOREIGN KEY (jogador_id) REFERENCES jogador(id),
	CONSTRAINT fk_jogador_clube_passagem_clube FOREIGN KEY (clube_id) REFERENCES clube(id)

);


CREATE TABLE jogador_campeonato_passagem(

	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    campeonato_id BIGINT,
    jogador_id BIGINT,
    clube_id BIGINT,
    jogos INT DEFAULT 0,
    gols INT DEFAULT 0,
    assistencias INT DEFAULT 0,
    clube_passagem BIGINT,
    CONSTRAINT fk_jogador_campeonato_passagem_clube_passagem FOREIGN KEY (clube_passagem) REFERENCES jogador_clube_passagem(id),
	CONSTRAINT fk_jogador_campeonato_passagem_jogador FOREIGN KEY (jogador_id) REFERENCES jogador(id),
	CONSTRAINT fk_jogador_campeonato_passagem_campeonato FOREIGN KEY (campeonato_id) REFERENCES campeonato(id),
	CONSTRAINT fk_jogador_campeonato_passagem_clube FOREIGN KEY (clube_id) REFERENCES clube(id)

);


CREATE TABLE artilharia(
	
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
	campeonato_id BIGINT NOT NULL,
    jogador_id BIGINT NOT NULL,
	clube_id BIGINT NOT NULL,
    gols INT DEFAULT 0,
    assistencias INT DEFAULT 0,
    CONSTRAINT fk_artilharia_campeonato FOREIGN KEY (campeonato_id) REFERENCES campeonato(id),
    CONSTRAINT fk_artilharia_jogador FOREIGN KEY (jogador_id) REFERENCES jogador(id),
	CONSTRAINT fk_artilharia_clube FOREIGN KEY (clube_id) REFERENCES clube(id)
);

CREATE TABLE arbitro(

	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    partidas INT DEFAULT 0,
    cartoes_amarelo INT DEFAULT 0,
    cartoes_vermelho INT DEFAULT 0

);

CREATE TABLE estadio(

	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_pais INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    capacidade INT NOT NULL,
    CONSTRAINT fk_estadio_pais FOREIGN KEY (id_pais) REFERENCES pais(id)
	
);

CREATE TABLE estadio_clube(

	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_estadio BIGINT NOT NULL,
    id_clube BIGINT NOT NULL,
    CONSTRAINT fk_estadio_clube_estadio FOREIGN KEY (id_estadio) REFERENCES estadio(id),
    CONSTRAINT fk_estadio_clube_clube FOREIGN KEY (id_clube) REFERENCES clube(id)
    
);

CREATE TABLE partida(

	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_competicao_ano BIGINT NOT NULL,
    id_clube_mandante BIGINT NOT NULL,
    id_clube_visitante BIGINT NOT NULL,
    id_estadio BIGINT NOT NULL,
    id_arbitro BIGINT NOT NULL,
    mando_campo_neutro BOOLEAN DEFAULT FALSE,
    quantidade_torcedores INT,
    CONSTRAINT fk_partida_competicao_ano FOREIGN KEY (id_competicao_ano) REFERENCES competicao_ano(id),
    CONSTRAINT fk_partida_clube_mandante FOREIGN KEY (id_clube_mandante) REFERENCES clube(id),
    CONSTRAINT fk_partida_clube_visitante FOREIGN KEY (id_clube_visitante) REFERENCES clube(id),
    CONSTRAINT fk_partida_arbitro FOREIGN KEY (id_arbitro) REFERENCES arbitro(id),
    CONSTRAINT fk_partida_estadio FOREIGN KEY (id_estadio) REFERENCES estadio(id)

);
