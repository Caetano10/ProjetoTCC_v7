CREATE DATABASE  IF NOT EXISTS `bancolavarapido` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bancolavarapido`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bancolavarapido
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lrcliente`
--

DROP TABLE IF EXISTS `lrcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lrcliente` (
  `idCliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `placaVeiculo` varchar(7) CHARACTER SET utf8 NOT NULL,
  `nomeVeiculo` varchar(50) DEFAULT NULL,
  `corVeiculo` varchar(20) DEFAULT NULL,
  `telefone` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `celular` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `detalhesLavagem` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `dataCadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lrcliente`
--

LOCK TABLES `lrcliente` WRITE;
/*!40000 ALTER TABLE `lrcliente` DISABLE KEYS */;
INSERT INTO `lrcliente` VALUES (1,'Sérgio','45877179837','abc1234','Carrera GT','Verde Metálico','1141591832','11960725642','Fazer lavagem total toda vez no veículo','2018-06-01 01:14:39');
/*!40000 ALTER TABLE `lrcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lrendereco`
--

DROP TABLE IF EXISTS `lrendereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lrendereco` (
  `idEndereco` bigint(20) NOT NULL AUTO_INCREMENT,
  `UF` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `logradouroNum` int(11) DEFAULT NULL,
  `CEP` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `idFuncionarioFK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idEndereco`),
  KEY `id_funcionario_fk` (`idFuncionarioFK`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lrendereco`
--

LOCK TABLES `lrendereco` WRITE;
/*!40000 ALTER TABLE `lrendereco` DISABLE KEYS */;
INSERT INTO `lrendereco` VALUES (1,'São Paulo','Vargem Grande Paulista','Jardim São Mateus','Nossa Senhora de Guadalupe',35,'06730000','Perto da Biovet',1),(2,'São Paulo','Cotia','Barro Branco','Rua Amaral',165,'06757332','Próximo ao estabelecimento Assai',2);
/*!40000 ALTER TABLE `lrendereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lrfornecedor`
--

DROP TABLE IF EXISTS `lrfornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lrfornecedor` (
  `idFornecedor` bigint(20) NOT NULL AUTO_INCREMENT,
  `NomeFantasia` varchar(255) NOT NULL,
  `CNPJ` varchar(14) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `dataCadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  `idEnderecoFK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idFornecedor`),
  UNIQUE KEY `CNPJ` (`CNPJ`),
  KEY `id_endereco_fk` (`idEnderecoFK`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lrfornecedor`
--

LOCK TABLES `lrfornecedor` WRITE;
/*!40000 ALTER TABLE `lrfornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `lrfornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lrfuncionario`
--

DROP TABLE IF EXISTS `lrfuncionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lrfuncionario` (
  `idFuncionario` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `telefone` varchar(10) CHARACTER SET utf8 NOT NULL,
  `dataCadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE KEY `CPF` (`CPF`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lrfuncionario`
--

LOCK TABLES `lrfuncionario` WRITE;
/*!40000 ALTER TABLE `lrfuncionario` DISABLE KEYS */;
INSERT INTO `lrfuncionario` VALUES (1,'Sérgio Senna','45877179838','1997-06-18','1141591832','2018-06-04 06:47:46'),(2,'Pedro de Araujo','79866541511','2001-06-18','1146165656','2018-06-04 06:52:50'),(3,'Alonso Javier Rossa','64457897844','1997-09-09','1542435574','2018-06-04 07:15:10'),(4,'Fabio','66666666666','1995-05-05','1141591832','2018-06-04 07:18:47');
/*!40000 ALTER TABLE `lrfuncionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lrproduto_estoque`
--

DROP TABLE IF EXISTS `lrproduto_estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lrproduto_estoque` (
  `idProduto` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `codBarras` decimal(13,0) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `dataEntrada` varchar(8) CHARACTER SET utf8 NOT NULL,
  `idFornecedorFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduto`),
  KEY `id_fornecedor_fk` (`idFornecedorFK`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lrproduto_estoque`
--

LOCK TABLES `lrproduto_estoque` WRITE;
/*!40000 ALTER TABLE `lrproduto_estoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `lrproduto_estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `selecionarfuncionario`
--

DROP TABLE IF EXISTS `selecionarfuncionario`;
/*!50001 DROP VIEW IF EXISTS `selecionarfuncionario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `selecionarfuncionario` AS SELECT 
 1 AS `idFuncionario`,
 1 AS `nome`,
 1 AS `cpf`,
 1 AS `dataNascimento`,
 1 AS `telefone`,
 1 AS `dataCadastro`,
 1 AS `uf`,
 1 AS `cidade`,
 1 AS `bairro`,
 1 AS `rua`,
 1 AS `logradouroNum`,
 1 AS `cep`,
 1 AS `complemento`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'bancolavarapido'
--
/*!50003 DROP PROCEDURE IF EXISTS `inserirFuncionario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserirFuncionario`(
in v_nome nvarchar(255),
in v_cpf nvarchar(11),
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
declare c_cpf nvarchar(11);
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

set n_nome = (select (nome) from LRFuncionario where nome = v_nome);
set c_cpf = (select (cpf) from LRFuncionario where cpf = v_cpf);
set d_dataNascimento = (select (dataNascimento) from LRFuncionario where dataNascimento = v_dataNascimento);
set t_telefone = (select (telefone) from LRFuncionario where telefone = v_telefone);

	if (c_cpf = v_cpf) then
		set msg = 'Esta pessoa já existe em nosso banco de dados';
	else
		insert into LRFuncionario (nome, cpf, dataNascimento, telefone)
			values (v_nome, v_cpf, v_dataNascimento, v_telefone);
            set msg = 'Funcionario cadastrado';
	end if; 
    
set u_uf = (select (uf) from LREndereco where uf = v_uf);
set c_cidade = (select (cidade) from LREndereco where cidade = v_cidade);
set b_bairro = (select (bairro) from LREndereco where bairro = v_bairro);
set r_rua = (select (rua) from LREndereco where bairro = v_rua);
set l_logradouroNum = (select (logradouroNum) from LREndereco where logradouroNum = v_logradouroNum);
set c_cep = (select (cep) from LRendereco where cep = v_cep);
set c_complemento = (select (complemento) from LRendereco where complemento = v_complemento);
set i_idFuncFK = (select (idFuncionario) from LRFuncionario where cpf = v_cpf);

insert into LREndereco(uf, cidade, bairro, rua, logradouroNum, cep, complemento, idFuncionarioFK)
					values(v_uf, v_cidade, v_bairro, v_rua, v_logradouroNum, v_cep, v_complemento, i_idFuncFK);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `selecionarfuncionario`
--

/*!50001 DROP VIEW IF EXISTS `selecionarfuncionario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `selecionarfuncionario` AS (select `f`.`idFuncionario` AS `idFuncionario`,`f`.`nome` AS `nome`,`f`.`CPF` AS `cpf`,`f`.`dataNascimento` AS `dataNascimento`,`f`.`telefone` AS `telefone`,`f`.`dataCadastro` AS `dataCadastro`,`e`.`UF` AS `uf`,`e`.`cidade` AS `cidade`,`e`.`bairro` AS `bairro`,`e`.`rua` AS `rua`,`e`.`logradouroNum` AS `logradouroNum`,`e`.`CEP` AS `cep`,`e`.`complemento` AS `complemento` from (`lrfuncionario` `f` join `lrendereco` `e` on((`f`.`idFuncionario` = `e`.`idFuncionarioFK`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-04  7:24:04
