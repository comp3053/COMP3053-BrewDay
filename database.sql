-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- 主机： 10.53.54.151:13872
-- 生成日期： 2019-05-23 20:27:44
-- 服务器版本： 5.7.18-20170830-log
-- PHP 版本： 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `database`
--

-- --------------------------------------------------------

--
-- 表的结构 `Brew`
--

CREATE TABLE `Brew` (
  `BrewID` int(11) NOT NULL,
  `BatchSize` float DEFAULT NULL,
  `Date` varchar(40) DEFAULT NULL,
  `RecipeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Brew`
--

INSERT INTO `Brew` (`BrewID`, `BatchSize`, `Date`, `RecipeID`) VALUES
(1, 10, '2019-05-23 00:55:19', 1),
(2, 90, '2019-05-23 01:03:10', 4),
(3, 10, '2019-05-23 01:12:56', 4),
(4, 10, '2019-05-23 01:23:14', 2),
(5, 0.5, '2019-05-23 01:25:39', 3),
(6, 10, '2019-05-23 01:27:59', 3),
(7, 1, '2019-05-23 01:31:54', 3),
(8, 5, '2019-05-23 18:18:59', 4),
(9, 2, '2019-05-23 20:24:18', 1);

-- --------------------------------------------------------

--
-- 表的结构 `Equipment`
--

CREATE TABLE `Equipment` (
  `Capacity` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Equipment`
--

INSERT INTO `Equipment` (`Capacity`) VALUES
(300);

-- --------------------------------------------------------

--
-- 表的结构 `Note`
--

CREATE TABLE `Note` (
  `NoteID` int(11) NOT NULL,
  `Content` varchar(2000) DEFAULT NULL,
  `createDate` char(20) DEFAULT NULL,
  `BrewID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Note`
--

INSERT INTO `Note` (`NoteID`, `Content`, `createDate`, `BrewID`) VALUES
(2, '123brew directly', '2019-05-23 01:03:23', 2),
(5, '88881111111', '2019-05-23 01:24:09', 4),
(6, 'taste good!', '2019-05-23 01:28:11', 6),
(7, 'very very good', '2019-05-23 01:32:04', 7),
(8, 'nonono', '2019-05-23 18:19:06', 8),
(9, 'test', '2019-05-23 20:24:38', 9);

-- --------------------------------------------------------

--
-- 表的结构 `Recipe`
--

CREATE TABLE `Recipe` (
  `RecipeID` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Quantity` float DEFAULT NULL,
  `Unit` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `Recipe`
--

INSERT INTO `Recipe` (`RecipeID`, `Name`, `Quantity`, `Unit`) VALUES
(1, 'beer', 10, 'L'),
(2, 'wine', 20, 'L'),
(3, 'happywater', 14.9, 'L'),
(4, 'test', 100, 'L'),
(6, 'test2', 3, 'L');

-- --------------------------------------------------------

--
-- 表的结构 `RecipeIngredient`
--

CREATE TABLE `RecipeIngredient` (
  `RecipeIngredientID` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Amount` float DEFAULT NULL,
  `Unit` varchar(10) DEFAULT NULL,
  `RecipeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `RecipeIngredient`
--

INSERT INTO `RecipeIngredient` (`RecipeIngredientID`, `Name`, `Amount`, `Unit`, `RecipeID`) VALUES
(1, 'water', 5, 'L', 1),
(2, 'malts', 5, 'g', 1),
(3, 'hops', 8, 'g', 1),
(4, 'yeasts', 9, 'g', 1),
(5, 'sugars', 20, 'g', 1),
(6, 'additives', 2, 'g', 1),
(7, 'water', 12, 'L', 2),
(8, 'hops', 25, 'g', 2),
(9, 'yeasts', 6, 'g', 2),
(10, 'additives', 5, 'g', 2),
(11, 'water', 5, 'L', 3),
(12, 'hops', 10, 'g', 3),
(13, 'additives', 52, 'g', 3),
(14, 'water', 99, 'L', 4),
(15, 'malts', 51, 'g', 4);

-- --------------------------------------------------------

--
-- 表的结构 `StorageIngredient`
--

CREATE TABLE `StorageIngredient` (
  `StorageIngredientID` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Amount` float DEFAULT NULL,
  `Unit` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `StorageIngredient`
--

INSERT INTO `StorageIngredient` (`StorageIngredientID`, `Name`, `Amount`, `Unit`) VALUES
(1, 'water', 998.159, 'L'),
(2, 'malts', 940.45, 'g'),
(3, 'hops', 961.709, 'g'),
(4, 'yeasts', 983.745, 'g'),
(5, 'sugars', 976, 'g'),
(6, 'additives', 962.041, 'g');

--
-- 转储表的索引
--

--
-- 表的索引 `Brew`
--
ALTER TABLE `Brew`
  ADD PRIMARY KEY (`BrewID`);

--
-- 表的索引 `Note`
--
ALTER TABLE `Note`
  ADD PRIMARY KEY (`NoteID`);

--
-- 表的索引 `Recipe`
--
ALTER TABLE `Recipe`
  ADD PRIMARY KEY (`RecipeID`);

--
-- 表的索引 `RecipeIngredient`
--
ALTER TABLE `RecipeIngredient`
  ADD PRIMARY KEY (`RecipeIngredientID`);

--
-- 表的索引 `StorageIngredient`
--
ALTER TABLE `StorageIngredient`
  ADD PRIMARY KEY (`StorageIngredientID`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `Brew`
--
ALTER TABLE `Brew`
  MODIFY `BrewID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `Note`
--
ALTER TABLE `Note`
  MODIFY `NoteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `Recipe`
--
ALTER TABLE `Recipe`
  MODIFY `RecipeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `RecipeIngredient`
--
ALTER TABLE `RecipeIngredient`
  MODIFY `RecipeIngredientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- 使用表AUTO_INCREMENT `StorageIngredient`
--
ALTER TABLE `StorageIngredient`
  MODIFY `StorageIngredientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
