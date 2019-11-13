-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 13-11-2019 a las 06:14:25
-- Versión del servidor: 8.0.13-4
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Nclx7geMqX`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capturador`
--

CREATE TABLE `capturador` (
  `id_capt` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `salario` float NOT NULL,
  `password` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `asistencia` int(11) DEFAULT '0',
  `faltas` int(11) NOT NULL DEFAULT '0',
  `estatus` tinyint(1) DEFAULT '1',
  `fecha_actualizacion` date NOT NULL,
  `bonos_asistencia` float NOT NULL,
  `bonos_multas` float NOT NULL,
  `faltas_descuento` float NOT NULL,
  `sueldo_total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `capturador`
--

INSERT INTO `capturador` (`id_capt`, `nombre`, `apellido`, `salario`, `password`, `asistencia`, `faltas`, `estatus`, `fecha_actualizacion`, `bonos_asistencia`, `bonos_multas`, `faltas_descuento`, `sueldo_total`) VALUES
(8010, 'MARIA', 'BARRIOS', 3500, '8010_maria', 1, 0, 1, '2019-11-11', 0, 0, 0, 3500),
(8011, 'EUGENIO', 'PARDO', 3500, '8011_eugenio', 1, 0, 1, '2019-11-10', 0, 0, 0, 3500),
(8012, 'GABRIELA', 'GALLEGOS', 3500, '8012_victoria', 1, 0, 1, '2019-11-11', 0, 0, 0, 3500),
(8014, 'MIGUEL', 'JURADO', 3500, '8013_jurado', 1, 0, 1, '2019-11-11', 0, 0, 0, 3500),
(8015, 'ANDRES', 'JURADO', 3500, '8015_jurado', 1, 0, 1, '2019-11-10', 0, 0, 0, 3500),
(8016, 'SARITA', 'ZACARIAS', 3500, '8016_zacarias', 2, 1, 1, '2019-11-11', 0, 0, 0, 3500),
(8017, 'SOCORRO', 'MENDOZA', 3500, '8017_mendoza', 2, 0, 1, '2019-11-12', 0, 0, 0, 3500),
(8018, 'ALFONSO', 'GUIZAR', 3500, '8018_guizar', 1, 0, 1, '2019-11-11', 0, 0, 0, 3500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepcion`
--

CREATE TABLE `recepcion` (
  `id_recp` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf16 COLLATE utf16_spanish_ci NOT NULL,
  `apellido` varchar(50) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `salario` float NOT NULL,
  `asistencia` int(11) NOT NULL DEFAULT '0',
  `faltas` int(11) NOT NULL DEFAULT '0',
  `estatus` tinyint(1) DEFAULT NULL,
  `fecha_actualizacion` date NOT NULL,
  `bonos_asistencia` float NOT NULL DEFAULT '0',
  `bonos_multas` float NOT NULL DEFAULT '0',
  `faltas_descuento` float NOT NULL,
  `sueldo_total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `recepcion`
--

INSERT INTO `recepcion` (`id_recp`, `nombre`, `apellido`, `salario`, `asistencia`, `faltas`, `estatus`, `fecha_actualizacion`, `bonos_asistencia`, `bonos_multas`, `faltas_descuento`, `sueldo_total`) VALUES
(4010, 'MARTIN', 'HERNANDEZ', 5000, 1, 0, 1, '2019-11-10', 0, 0, 0, 0),
(4011, 'ALBERT', 'ABREU', 5000, 3, 0, 0, '2019-11-10', 0, 0, 0, 0),
(4012, 'PABLO', 'GUAMAN', 5000, 2, 0, 1, '2019-11-10', 0, 0, 0, 0),
(4013, 'CESAR', 'FONSECA', 5000, 1, 0, 1, '2019-11-10', 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `supervisor`
--

CREATE TABLE `supervisor` (
  `id_sup` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL,
  `salario` float NOT NULL,
  `password` varchar(100) CHARACTER SET utf16 COLLATE utf16_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `supervisor`
--

INSERT INTO `supervisor` (`id_sup`, `nombre`, `apellido`, `salario`, `password`) VALUES
(1010, 'YOLANDA', 'CARVACA', 8000, '1010_yolanda'),
(1011, 'LUIS', 'JURADO', 8000, '1011_jurado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `capturador`
--
ALTER TABLE `capturador`
  ADD UNIQUE KEY `id_capt` (`id_capt`);

--
-- Indices de la tabla `recepcion`
--
ALTER TABLE `recepcion`
  ADD PRIMARY KEY (`id_recp`);

--
-- Indices de la tabla `supervisor`
--
ALTER TABLE `supervisor`
  ADD UNIQUE KEY `id_sup` (`id_sup`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `capturador`
--
ALTER TABLE `capturador`
  MODIFY `id_capt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8019;

--
-- AUTO_INCREMENT de la tabla `recepcion`
--
ALTER TABLE `recepcion`
  MODIFY `id_recp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4014;

--
-- AUTO_INCREMENT de la tabla `supervisor`
--
ALTER TABLE `supervisor`
  MODIFY `id_sup` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1012;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
