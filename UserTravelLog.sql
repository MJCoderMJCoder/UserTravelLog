CREATE DATABASE  IF NOT EXISTS `usertravellog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `usertravellog`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: usertravellog
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `attention`
--

DROP TABLE IF EXISTS `attention`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attention` (
  `attentionId` int(11) NOT NULL AUTO_INCREMENT,
  `userSelf` int(11) NOT NULL COMMENT '用户自己',
  `attentionUser` int(11) NOT NULL COMMENT '关注的用户',
  PRIMARY KEY (`attentionId`),
  UNIQUE KEY `idattention_UNIQUE` (`attentionId`),
  KEY `userSelf_idx` (`userSelf`),
  KEY `attentionUser_idx` (`attentionUser`),
  CONSTRAINT `attentionUser` FOREIGN KEY (`attentionUser`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `userSelf` FOREIGN KEY (`userSelf`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='关注';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attention`
--

LOCK TABLES `attention` WRITE;
/*!40000 ALTER TABLE `attention` DISABLE KEYS */;
INSERT INTO `attention` VALUES (39,12,1),(40,12,3),(45,1,3),(49,1,12);
/*!40000 ALTER TABLE `attention` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `commentUser` int(11) NOT NULL,
  `commentsTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `commentTxt` varchar(45) NOT NULL,
  `commentsTravelLog` int(11) NOT NULL COMMENT '评论的是那条旅游日志的记录',
  PRIMARY KEY (`commentId`),
  UNIQUE KEY `idcomments_UNIQUE` (`commentId`),
  KEY `commentUser_idx` (`commentUser`),
  KEY `commentsTravelLog_idx` (`commentsTravelLog`),
  CONSTRAINT `commentUser` FOREIGN KEY (`commentUser`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `commentsTravelLog` FOREIGN KEY (`commentsTravelLog`) REFERENCES `travellog` (`travelLogId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='旅游日志的评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (25,1,'2019-01-11 03:34:11','好漂亮',25),(26,1,'2019-01-11 03:34:15','好漂亮',25),(27,1,'2019-01-11 03:34:55','中小学',25),(29,1,'2019-01-11 03:41:33','u',26),(30,12,'2019-01-11 06:11:52','手续费',26),(31,19,'2019-01-11 07:30:42','等会凤凰凤凰',27),(36,19,'2019-01-12 04:03:51','DJ好的好的惠风和畅',34),(37,1,'2019-01-14 01:22:50','Fkfjfj',34),(38,1,'2019-01-14 01:22:51','Fkfjfj',34);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travellog`
--

DROP TABLE IF EXISTS `travellog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travellog` (
  `travelLogId` int(11) NOT NULL AUTO_INCREMENT,
  `travelLogUser` int(11) NOT NULL,
  `travelLogTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `travelLogImg` varchar(100) DEFAULT NULL,
  `travelLogTxt` varchar(45) DEFAULT NULL,
  `travelLogPraise` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  PRIMARY KEY (`travelLogId`),
  UNIQUE KEY `travelLogId_UNIQUE` (`travelLogId`),
  KEY `travelLogUser_idx` (`travelLogUser`),
  CONSTRAINT `travelLogUser` FOREIGN KEY (`travelLogUser`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='旅游日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travellog`
--

LOCK TABLES `travellog` WRITE;
/*!40000 ALTER TABLE `travellog` DISABLE KEYS */;
INSERT INTO `travellog` VALUES (8,3,'2019-01-11 00:35:55','upload/1547100239045_logImg.jpg','时间长期以来说明书记者',3),(25,3,'2019-01-11 02:17:49','upload/1547118646739_logImg.jpg','谁的女神，绝大部分部分分隔符部分百分比不方法百分比',7),(26,1,'2019-01-11 03:41:20','upload/1547178080290_logImg.jpg','大部分解放军事我们俩人们的',1),(27,12,'2019-01-11 06:12:28','upload/1547187148581_logImg.jpg','张柏芝。实际上基督教',4),(28,19,'2019-01-11 06:57:03','upload/1547189823175_logImg.jpg','SJ代表大会DJ新疆的继续减肥',0),(31,1,'2019-01-11 12:21:27','upload/1547209287448_logImg.jpg','上班行不行白血病的是不得不行不行白血病电脑城彼此彼此彼此彼此从彼此彼此不错成本',0),(34,19,'2019-01-12 04:03:39','upload/1547265819440_logImg.jpg','新和好想好想好想好想',23),(35,1,'2019-01-14 02:08:41','upload/1547431721353_logImg.jpg','Sdbdbdbnznxjxjxj',0),(46,20,'2019-01-14 10:39:29','upload/1547462369590_965402043126075da75fe22479df5f1c.jpg','发布广告',0);
/*!40000 ALTER TABLE `travellog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userPortrait` varchar(100) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `userAccount` varchar(45) NOT NULL,
  `userQQ` varchar(45) DEFAULT NULL,
  `userPhone` varchar(45) DEFAULT NULL,
  `userEmail` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) NOT NULL,
  `userType` int(11) NOT NULL DEFAULT '1' COMMENT '用户类型：1（大于0 ）是普通用户；-1（小于0）是管理员；0是超级管理员。',
  `userConfidante` varchar(45) DEFAULT NULL COMMENT '用户的关键联系人（闺蜜、铁哥们）',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId_UNIQUE` (`userId`),
  UNIQUE KEY `userAccount_UNIQUE` (`userAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'upload/1547175837722_head.jpg','啊的民','Admin','384747473838','27272727272','598157378@qq.com','123456',1,'72737373737'),(3,'upload/1547121309844_head.jpg','Admin Java','Admij','598157378','18334706003','598157378@qq.com','123456',1,'15513866902'),(12,'upload/1547187264882_head.jpg','模具哦的人','MJCoder','228282838','182837373','xx@sjsj.cn','123456',1,'2737337'),(15,'','','MJCoderZFF','','','','123456',1,NULL),(16,'','','testZff','','','','123456',1,NULL),(17,'','','Abcdefg','','','','Abcdefg',1,NULL),(18,'upload/1547188266674_head.jpg','纸纷飞测试','testTEST','3938448383','2828282822','wjs@sina.cn','123456',1,'18334706003'),(19,'upload/1547265859583_head.jpg','宿舍的订婚的好的话话','123456','28282828282','1823444848484','wjs@sina.cn','123456',1,'18334706003'),(20,'upload/1547191711098_head.jpg','纸纷飞','root','4564654131641','18334706003','598157378@qq.com','root',-1,'root');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'usertravellog'
--

--
-- Dumping routines for database 'usertravellog'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-14 20:50:48
