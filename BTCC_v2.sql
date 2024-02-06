CREATE SCHEMA `BancoLavaRapido`;

CREATE USER 'btcc'@'%' IDENTIFIED BY '123';
flush privileges;
GRANT ALL ON *.* TO 'btcc'@'%' WITH GRANT OPTION;

-- DROP USER 'btcc'@'%';

use BancoLavaRapido;

CREATE TABLE LRCliente (
idCliente BIGINT NOT NULL AUTO_INCREMENT,
nome varchar(255) not null,
cpf varchar(14) not null unique,
placaVeiculo nvarchar(8) not null,
nomeVeiculo varchar(50) default null,
corVeiculo varchar(20) default null,	
telefone nvarchar(13) default null,
celular nvarchar(14) default null,
detalhesLavagem nvarchar(255) default null,
dataCadastro datetime null default now(),
constraint id_cliente_pk primary key (idCliente)
);

-- drop table lrcliente;

insert into lrcliente(nome, 
					  cpf, 
					  placaveiculo, 
					  nomeveiculo, 
					  corveiculo, 
					  telefone, 
					  celular, 
					  detalheslavagem, 
					  datacadastro)
			values ('Sérgio Senna',
					'458.771.798-37',
					'ABC-1234',
					'corsa',
					'preto',
					'(11)4159-1832',
					'(11)96072-5642',
					'Carro com batida na porta esquerda',
					'2018-05-13 13:00:00');
insert into lrcliente(nome, 
					  cpf, 
					  placaveiculo, 
					  nomeveiculo, 
					  corveiculo, 
					  telefone, 
					  celular, 
					  detalheslavagem, 
					  datacadastro)
			values ('Pedro Salgado',
					'123.768.123-12',
					'GHF-6789',
					'Fox',
					'Azul',
					'(13)3456-7587',
					'(13)96785-5678',
					'Farol quebrado',
					'2018-06-12 12:00:00'),  
					('Felipe Oliveira',
					'768.947.367-34',
					'LNH-4735',
					'Space Fox',
					'Amarelo',
					'(14)4676-3567',
					'(14)95678-3796',
					'risco na porta esquerda',
					'2018-04-27 13:00:00'),
					('Douglas Bidu',
					'869.578.480-36',
					'PEU-0478',
					'Onix',
					'preto',
					'(17)2897-6754',
					'(17)98757-2076',
					'Pneu furado',
					'2018-03-31 23:00:00'),
					('Dino Pcs',
					'888.888.777-69',
					'PCS-7070',
					'Fusquinha',
					'Azul',
					'(37)4554-9009',
					'(37)97688-4343',
					'porta direita amassada',
					'2018-01-27 21:00:00'),
					('james do Bonde',
					'756.578.598-34',
					'TTR-0076',
					'Batcarro',
					'Azul Banana',
					'(11)4002-8922',
					'(11)97492-3502',
					'calota traseira da direita esta quebrada',
					'2018-04-28 09:00:00'),
					('Lucas caetano',
					'089.687.866-56',
					'SDF-7890',
					'Brasília',	
					'Amarelo',
					'(43)6789-4567',
					'(43)95678-4532',
					'vidro direito da frente rachado',
					'2018-05-21 10:00:00'),
					('Mateus Leal',
					'567.019.176-67',
					'DFG-6767',
					'Clio',
					'Prata fosco',
					'(45)4567-6767',
					'(45)95647-7584',
					'paralamas quebrado',
					'2018-03-30 23:00:00');
SELECT * FROM lrcliente WHERE (timestampdiff(day, datacadastro, now())> 15);


CREATE TABLE LREndereco (
idEndereco bigint not null auto_increment,
UF nvarchar(255) default null,
cidade varchar(255) default null,
bairro varchar(255) default null,
rua varchar(255) default null,
logradouroNum int default null,
CEP nvarchar(8) default null,
complemento varchar(255),
idFuncionarioFK bigint,
idFornecedorFK bigint,
constraint id_fornecedor_fk foreign key (idFornecedorFK) references LRFornecedor(idFornecedor),
constraint id_funcionario_fk foreign key (idFuncionarioFK) references LRFuncionario (idFuncionario),
constraint id_endereco_pk primary key (idEndereco)
);

CREATE TABLE LRFuncionario (
idFuncionario BIGINT NOT NULL auto_increment,
nome varchar(255) not null,
CPF varchar(14) not null unique,
dataNascimento date null,
telefone nvarchar(10) not null,
dataCadastro datetime null default now(),
constraint id_funcionario_pk primary key (idFuncionario)
);

CREATE TABLE LRFornecedor (
idFornecedor BIGINT NOT NULL AUTO_INCREMENT,
NomeFantasia varchar(255) not null,
CNPJ varchar(18) not null unique,
telefone varchar(10) not null,
dataCadastro datetime null default now(),
constraint id_fornecedor_pk primary key (idFornecedor)
);

CREATE TABLE LRProduto_Estoque (
idProduto BIGINT NOT NULL auto_increment,
nome varchar(255) not null,
codBarras decimal(13,0) not null,
quantidade int not null,
dataEntrada nvarchar(8) not null,
idFornecedorFK int,
constraint id_fornecedor_fk foreign key (idFornecedorFK) references LRFornecedor (idFornecedor),
constraint id_produto_pk primary key (idProduto)
);

CREATE TABLE LREntrada_Veiculos(
idEntrada BIGINT NOT NULL AUTO_INCREMENT,
placaVeiculo NVARCHAR(8),
nomeCliente NVARCHAR(255),
horarioEntrada datetime null default now(),
idClienteFK BIGINT,
constraint id_cliente_fk foreign key (idClienteFK) references LRCliente (idCliente),
constraint id_entrada_pk primary key (idEntrada)
);



CREATE TABLE LRSaida_Veiculos(
idSaida BIGINT NOT NULL AUTO_INCREMENT,
idEntradaFK BIGINT,
horarioSaida DATETIME NULL DEFAULT NOW(),
constraint id_entrada_fk foreign key (idEntradaFK) references LREntrada_Veiculos (idEntrada),
constraint id_saida_pk primary key (idSaida)
);
-- drop table LRSaida_Veiculos;
-- drop table LRProduto_Estoque;
-- drop table LRCliente;
-- drop table LREndereco;
-- drop table LREndereco;
-- drop table LRFuncionario;
-- drop table LRFornecedor;

select * from LRCliente;

DELIMITER $$
drop procedure if exists inserirFuncionario $$
create procedure inserirFuncionario(
in v_nome nvarchar(255),
in v_cpf nvarchar(14),
in v_dataNascimento date,
in v_telefone nvarchar(10),
in v_UF nvarchar(255),
in v_cidade nvarchar(255),
in v_bairro nvarchar(255),
in v_rua nvarchar(255),
in v_logradouroNum int,
in v_cep nvarchar(8),
in v_complemento nvarchar(255),
out msg nvarchar(255))

begin

declare n_nome nvarchar(255);
declare c_cpf nvarchar(14);
declare d_dataNascimento date;
declare t_telefone nvarchar(10);
declare u_uf nvarchar(255);
declare c_cidade nvarchar(255);
declare b_bairro nvarchar(255);
declare r_rua nvarchar(255);
declare l_logradouroNum int;
declare c_cep nvarchar(255);
declare c_complemento nvarchar(255);
declare i_idFuncFK int;


set c_cpf = (select (cpf) from LRFuncionario where cpf = v_cpf);


	if (c_cpf = v_cpf) then
		set msg = 'Esta pessoa já existe em nosso banco de dados';
	else

		insert into LRFuncionario (nome, cpf, dataNascimento, telefone)
			values (v_nome, v_cpf, v_dataNascimento, v_telefone);

		set i_idFuncFK = (select (idFuncionario) from LRFuncionario where cpf = v_cpf);

		insert into LREndereco(uf, cidade, bairro, rua, logradouroNum, cep, complemento, idFuncionarioFK)
					values(v_uf, v_cidade, v_bairro, v_rua, v_logradouroNum, v_cep, v_complemento, i_idFuncFK);

            set msg = 'Funcionario cadastrado';
	end if; 
    
END $$
DELIMITER ;

select * from LRendereco;
select * from LRFuncionario;
(select (idFuncionario) from LRFuncionario where cpf = '');

call inserirFuncionario('Pedro de Araujo',
						'798.665.415-11',
                        '2001-06-18',
                        '1146165656',
                        'São Paulo',
                        'Cotia',
                        'Barro Branco',
                        'Rua Amaral',
                        '165',
                        '06757332',
                        'Próximo ao estabelecimento Assai', 
                        @msg);
select @msg;
-- truncate LREndereco;
create view selecionarFuncionario AS
	(select f.idFuncionario, f.nome, f.cpf, f.dataNascimento, f.telefone, f.dataCadastro, e.uf, e.cidade, e.bairro, e.rua, e.logradouroNum, e.cep, e.complemento
			from LRFuncionario as f inner join LREndereco as e on f.idFuncionario = e.idFuncionarioFK);
            
select * from selecionarFuncionario;
select * from LREndereco;
select * from LRFuncionario;

-- truncate LRFuncionario;
-- drop procedure inserirFuncionario;

-- drop view selecionarFuncionario;

DELIMITER $$
drop procedure if exists inserirFornecedor $$
create procedure inserirFornecedor(
in v_nomeFantasia nvarchar(255),
in v_cnpj nvarchar(18),
in v_telefone nvarchar(10),
in v_UF nvarchar(255),
in v_cidade nvarchar(255),
in v_bairro nvarchar(255),
in v_rua nvarchar(255),
in v_logradouroNum int,
in v_cep nvarchar(8),
in v_complemento nvarchar(255),
out msg nvarchar(255))

begin

declare n_nomeFantasia nvarchar(255);
declare c_cnpj nvarchar(18);
declare t_telefone nvarchar(10);
declare u_uf nvarchar(255);
declare c_cidade nvarchar(255);
declare b_bairro nvarchar(255);
declare r_rua nvarchar(255);
declare l_logradouroNum int;
declare c_cep nvarchar(255);
declare c_complemento nvarchar(255);
declare i_idFornFK int;

set c_cnpj = (select (cnpj) from LRFornecedor where cnpj = v_cnpj);

	if (c_cnpj = v_cnpj) then
		set msg = 'Esta pessoa já existe em nosso banco de dados';
	else
		insert into LRFornecedor (nomeFantasia, cnpj, telefone)
					values (v_nomeFantasia, v_cnpj, v_telefone);
		set i_idFornFK = (select (idFornecedor) from LRFornecedor where cnpj = v_cnpj);

		insert into LREndereco(uf, cidade, bairro, rua, logradouroNum, cep, complemento, idFornecedorFK)
					values(v_uf, v_cidade, v_bairro, v_rua, v_logradouroNum, v_cep, v_complemento, i_idFornFK);
            set msg = 'Fornecedor cadastrado';
	end if; 
    

END $$
DELIMITER ;

call inserirFornecedor('Biovet Inc.',
						'14.555.123/0000-01',
                        '1141691235',
                        'São Paulo',
                        'Vargem Grande Paulista',
                        'São Mateus',
                        'Av. Biovet',
                        112,
                        '06730000',
                        'Próximo a empresa Nagawa',
                        @msg);
select @msg;

create view selecionarFornecedor as
		(SELECT fornecedor.idFornecedor, fornecedor.nomeFantasia, fornecedor.cnpj, fornecedor.telefone, fornecedor.dataCadastro, e.uf, e.cidade, e.bairro, e.rua, e.logradouroNum, e.cep, e.complemento
			from LRFornecedor as fornecedor inner join LREndereco as e on fornecedor.idFornecedor = e.idFornecedorFK);

select * from selecionarFornecedor;
-- drop view selecionarFornecedor;
-- drop procedure inserirFornecedor;

call inserirFuncionario('Matheus',
						'456.132.456-55',
						'2001-06-06',
						'1146465646',
						'SP',
						'Itapevi',
						'Centro',
						'Beta',
						 22,
						'04578996',
						'Perto da quadra',
						@msg);

select * from LRcliente;

create table LRLogin(
idLogin bigint not null auto_increment,
Login nvarchar(20) not null,
Senha nvarchar(512) not null,
constraint id_login_pk primary key (idLogin)
);

insert into LRLogin (login, senha) values ('admin', '123'),
										  ('Sergio', 'g42230br');