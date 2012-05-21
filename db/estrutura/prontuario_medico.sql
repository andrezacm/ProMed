-- phpMyAdmin SQL Dump
-- version 3.4.5deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 21/05/2012 às 13h03min
-- Versão do Servidor: 5.1.62
-- Versão do PHP: 5.3.6-13ubuntu3.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `prontuario_medico`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acesso`
--

CREATE TABLE IF NOT EXISTS `acesso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `anamnese`
--

CREATE TABLE IF NOT EXISTS `anamnese` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(255) DEFAULT NULL,
  `estado_civil` varchar(255) DEFAULT NULL,
  `profissao` varchar(255) DEFAULT NULL,
  `local_de_trabalho` varchar(255) DEFAULT NULL,
  `procedencia` varchar(255) DEFAULT NULL,
  `qp` mediumtext COMMENT 'Queixa principal (QP): Em poucas palavras, o profissional registra a queixa principal, o motivo que levou o paciente a procurar ajuda.',
  `cd` mediumtext COMMENT 'Caracterização da dor',
  `hda` mediumtext COMMENT 'História da doença atual (HDA): No histórico da doença actual é registrado tudo que se relaciona quanto à doença actual: sintomatologia, época de início, história da evolução da doença, entre outros. Em caso de dor, deve-se caracterizá-la por completo.',
  `hpp` mediumtext COMMENT 'História médica pregressa ou História patológica pregressa (HMP ou HPP): Adquire-se informações sobre toda a história médica do paciente, mesmo das condições que não estejam relacionadas com a doença atual.',
  `hf` mediumtext COMMENT 'Histórico familiar (HF): Neste histórico é perguntado ao paciente sobre sua família e suas condições de trabalho e vida. Procura-se alguma relação de hereditariedade das doenças.',
  `hps` mediumtext COMMENT 'História pessoal (fisiológica) e história social: Procura-se a informação sobre a ocupação do paciente,como: onde trabalha, onde reside, se é tabagista, alcoolista ou faz uso de outras drogas. Se viajou recentemente, se possui animais de estimação (para s',
  `rs` mediumtext COMMENT 'Revisão de sistemas: Esta revisão, também conhecida como interrogatório sintomatológico, anamnese especial/específica ou Interrogatório Sobre os Diversos Aparelhos (ISDA), consiste num interrogatório de todos os sistemas do paciente, permitindo ao médico ',
  `observacoes` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `arquivo`
--

CREATE TABLE IF NOT EXISTS `arquivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_documento` int(11) NOT NULL,
  `arquivo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_documento` (`id_documento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE IF NOT EXISTS `cargo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `dados_fisicos`
--

CREATE TABLE IF NOT EXISTS `dados_fisicos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `altura` float DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `tipo_sanguineo` char(2) DEFAULT NULL,
  `inspecao` mediumtext COMMENT 'Inspeção: exige a utilização do sentido da visão. Tem como objetivos detectar dismorfias, distúrbios do desenvolvimento, lesões cutâneas, presença de catéteres e tubos ou outros dispositivos.',
  `palpacao` mediumtext COMMENT 'Palpação: obtenção do dado através do tato e da pressão (para regiões mais profundas do corpo). Identifica modificações na estrutura, espessura, consistência, volume e dureza.',
  `percussao` mediumtext COMMENT 'Percussão: através de pequenos golpes, é possível escutar sons. Cada estrutura tem um som característico. Os sons obtidos podem ser: maciço (onde o local tocado é "duro", pode indicar hemorragia interna ou presença de secreções), timpânico (indica presenç',
  `auscuta` mediumtext COMMENT 'Ausculta: procedimento que detecta sons do organismo, só que diferente da percussão, esse procedimento usa aparelhos para auxílio, por exemplo o estetoscópio.',
  `observacoes` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `documento`
--

CREATE TABLE IF NOT EXISTS `documento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_procedimento` int(11) NOT NULL,
  `id_tipo_documento` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `observacoes` mediumtext,
  PRIMARY KEY (`id`),
  KEY `fk_procedimento` (`id_procedimento`),
  KEY `fk_tipo_documento` (`id_tipo_documento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `exame_clinico`
--

CREATE TABLE IF NOT EXISTS `exame_clinico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL,
  `id_anamnese` int(11) NOT NULL,
  `id_dados_fisicos` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_paciente` (`id_paciente`),
  KEY `fk_anamnese` (`id_anamnese`),
  KEY `fk_dados_fisicos` (`id_dados_fisicos`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medicamento`
--

CREATE TABLE IF NOT EXISTS `medicamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_registro` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `observacoes` mediumtext,
  PRIMARY KEY (`id`),
  KEY `fk_registro` (`id_registro`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` int(11) NOT NULL,
  `rg` int(10) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `sexo` enum('m','f') DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `estado` char(2) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `observacoes` mediumtext,
  `data_cadastro` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `parentesco`
--

CREATE TABLE IF NOT EXISTS `parentesco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL,
  `id_parente` int(11) NOT NULL,
  `grau` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_paciente` (`id_paciente`),
  KEY `fk_parente` (`id_parente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `procedimento`
--

CREATE TABLE IF NOT EXISTS `procedimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL,
  `id_tipo_procedimento` int(11) NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  `local` varchar(255) DEFAULT NULL,
  `observacoes` mediumtext,
  PRIMARY KEY (`id`),
  KEY `fk_paciente` (`id_paciente`),
  KEY `fk_tipo_procedimento` (`id_tipo_procedimento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `profissional`
--

CREATE TABLE IF NOT EXISTS `profissional` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cargo` int(11) NOT NULL,
  `cpf` int(11) NOT NULL,
  `rg` int(10) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `especialidade` varchar(255) DEFAULT NULL,
  `observacao` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`),
  KEY `fk_cargo` (`id_cargo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `registro`
--

CREATE TABLE IF NOT EXISTS `registro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_procedimento` int(11) NOT NULL,
  `id_profissional` int(11) NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_profissional` (`id_profissional`),
  KEY `fk_procedimento` (`id_procedimento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_documento`
--

CREATE TABLE IF NOT EXISTS `tipo_documento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_procedimento`
--

CREATE TABLE IF NOT EXISTS `tipo_procedimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` mediumtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_acesso` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_profissional` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `data_cadastro` datetime NOT NULL,
  `ultimo_acesso` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_acesso` (`id_acesso`),
  KEY `fk_paciente` (`id_paciente`),
  KEY `fk_profissional` (`id_profissional`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
