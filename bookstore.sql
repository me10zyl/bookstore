-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	5.7.3-m13

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
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `feedid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `subject` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `msg` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `ip` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`feedid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'','测试留言','测试留言','','0:0:0:0:0:0:0:1'),(2,'','测试留言2','测试留言2','','0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `goodsid` bigint(20) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `breifintroduction` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `detailintroduction` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `goodsprice` float DEFAULT NULL,
  `photo` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `category` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`goodsid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'Java编程思想','本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。[1] ','从本书获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。本书共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、JavaI/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的绝佳教材和参考书。',37,'03.jpg','编程语言'),(2,'Struts2权威指南','《Struts2权威指南:基于WebWork核心的MVC开发》介绍的Struts 2已经完全超出了Struts 1框架原有的高度，Struts 2建立在Struts 1和WebWork两个框架整合的基础之上，因此提供了更多优秀的机制。','虽然Struts 1目前还未被完全淘汰，但Struts 1所表现出来的缺陷已经处处制约着开发者的手脚。在2007年上半年，Struts 2终于在众多开发者期盼中，发布了第一个稳定版本：2.0.6。为了让众多Struts学习、工作者快速掌握Struts 2的开发，笔者精心编著了本书。本书按Struts 2的架构体系，细致地介绍了Struts 2各个知识点。在介绍过程中，笔者依照读者的学习规律，首先介绍基本概念和基本操作，然后对内容进行深入讲解。笔者在介绍Struts 2框架时，既照顾到Struts 2初学者的能力，对每个知识点都给出简单的快速上手的示例；同时也考虑到开发者在日后开发中可能遇到的问题，详细讲解了每个知识点的各种用法，本书覆盖到Struts 2近80%的API。因此，本书完全可以作为Struts 2框架的权威手册，以供开发者在实际开发过程中参考。\n本书最后配备了几个常用场景的实例，通过实例演示了Struts 2框架的用法，希望读者可以通过这几个实例，触类旁通，解决日常开发中的问题。',40,'08.jpg','程序框架');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `newgoods`
--

DROP TABLE IF EXISTS `newgoods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `newgoods` (
  `goodsid` int(11) NOT NULL,
  PRIMARY KEY (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newgoods`
--

LOCK TABLES `newgoods` WRITE;
/*!40000 ALTER TABLE `newgoods` DISABLE KEYS */;
INSERT INTO `newgoods` VALUES (1),(2);
/*!40000 ALTER TABLE `newgoods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotiongoods`
--

DROP TABLE IF EXISTS `promotiongoods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotiongoods` (
  `goodsid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotiongoods`
--

LOCK TABLES `promotiongoods` WRITE;
/*!40000 ALTER TABLE `promotiongoods` DISABLE KEYS */;
INSERT INTO `promotiongoods` VALUES (1),(2);
/*!40000 ALTER TABLE `promotiongoods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialgoods`
--

DROP TABLE IF EXISTS `specialgoods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialgoods` (
  `goodsid` int(11) NOT NULL,
  PRIMARY KEY (`goodsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialgoods`
--

LOCK TABLES `specialgoods` WRITE;
/*!40000 ALTER TABLE `specialgoods` DISABLE KEYS */;
INSERT INTO `specialgoods` VALUES (1),(2);
/*!40000 ALTER TABLE `specialgoods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `password_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `truename` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `address_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'611033','123123',NULL,NULL,NULL,NULL,NULL),(2,'611034','123123',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-27 17:19:14
