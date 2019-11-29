/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.58 : Database - jk_export
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jk_export` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jk_export`;

/*Table structure for table `export_c` */

DROP TABLE IF EXISTS `export_c`;

CREATE TABLE `export_c` (
  `EID` varchar(40) NOT NULL,
  `EXPORT_ID` varchar(40) NOT NULL,
  `INPUT_DATE` datetime DEFAULT NULL,
  `SHIPMENT_PORT` varchar(100) DEFAULT NULL,
  `DESTINATION_PORT` varchar(100) DEFAULT NULL,
  `TRANSPORT_MODE` varchar(10) DEFAULT NULL COMMENT 'SEA/AIR',
  `PRICE_CONDITION` varchar(10) DEFAULT NULL COMMENT 'FBO/CIF',
  `BOX_NUMS` int(11) DEFAULT NULL COMMENT '冗余，为委托服务，一个报运的总箱数',
  `GROSS_WEIGHTS` decimal(10,2) DEFAULT NULL COMMENT '冗余，为委托服务，一个报运的总毛重',
  `MEASUREMENTS` decimal(10,2) DEFAULT NULL COMMENT '冗余，为委托服务，一个报运的总体积',
  `STATE` int(11) DEFAULT NULL,
  `REASON` varchar(200) DEFAULT NULL,
  `ORDER_NO` int(11) DEFAULT NULL,
  `EXPORT_DATE` datetime DEFAULT NULL COMMENT '申批时间',
  PRIMARY KEY (`EID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `export_c` */

/*Table structure for table `export_product_c` */

DROP TABLE IF EXISTS `export_product_c`;

CREATE TABLE `export_product_c` (
  `EP_ID` varchar(40) NOT NULL,
  `EID` varchar(40) DEFAULT NULL,
  `EXPORT_PRODUCT_ID` varchar(40) NOT NULL,
  `EXPORT_ID` varchar(40) DEFAULT NULL,
  `FACTORY_ID` varchar(40) DEFAULT NULL,
  `PRODUCT_NO` varchar(50) DEFAULT NULL,
  `PACKING_UNIT` varchar(10) DEFAULT NULL COMMENT 'PCS/SETS',
  `CNUMBER` int(11) DEFAULT NULL,
  `BOX_NUM` int(11) DEFAULT NULL,
  `GROSS_WEIGHT` decimal(10,2) DEFAULT NULL,
  `NET_WEIGHT` decimal(10,2) DEFAULT NULL,
  `SIZE_LENGTH` decimal(10,2) DEFAULT NULL,
  `SIZE_WIDTH` decimal(10,2) DEFAULT NULL,
  `SIZE_HEIGHT` decimal(10,2) DEFAULT NULL,
  `EX_PRICE` decimal(10,2) DEFAULT NULL COMMENT 'sales confirmation 中的价格（手填）',
  `PRICE` decimal(10,2) DEFAULT NULL,
  `TAX` decimal(10,2) DEFAULT NULL COMMENT '收购单价=合同单价',
  `ORDER_NO` int(11) DEFAULT NULL,
  PRIMARY KEY (`EP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `export_product_c` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
