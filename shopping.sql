-- MySQL dump 10.13  Distrib 8.0.32, for macos13.0 (arm64)
--
-- Host: 127.0.0.1    Database: shopping
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `msgId` int NOT NULL AUTO_INCREMENT,
  `msgSender` varchar(255) DEFAULT '发送人',
  `msgTitle` varchar(255) DEFAULT '标题',
  `msgContent` varchar(255) DEFAULT '内容',
  `msgStatus` varchar(255) DEFAULT '未回复',
  `msgReplyContent` varchar(255) DEFAULT '',
  PRIMARY KEY (`msgId`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'admin','保修政策','充电宝保修几年？','已回复','保修一年'),(15,'user1','赔偿政策','充电宝炸了怎么赔','已回复','亲可以申请一个0元赔偿'),(16,'user2','保真吗','是原装正品吗？','已回复','不是的，但假一赔十'),(43,'2312','fa w',' 撒扽','未回复',''),(52,'发送人','标题','内容','未回复',''),(53,'发送人','标题','内容','未回复',''),(54,'发送人','标题','内容','未回复',''),(55,'updater','标题','更新','已回复','回复内容'),(78,'发送人','标题','内容','未回复',''),(79,'发送人','标题','内容','未回复',''),(91,'发送人','标题','内容','未回复',''),(92,'发送人','标题','内容','未回复',''),(102,'123','123','123','未回复','');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT '用户名',
  `passWord` varchar(255) DEFAULT '密码',
  `location` varchar(255) DEFAULT '地址',
  `phoneNumber` varchar(255) DEFAULT '手机号',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (16,'1','1','中国','13800000000'),(30,'admin','admin','美国纽约','1-212-244-9392'),(32,'2','2','加拿大渥太华','11-613-789-3434'),(100,'用户名','密码','地址','手机号'),(101,'用户名','密码','地址','手机号'),(102,'用户名','密码','地址','手机号'),(103,'用户名','密码','地址','手机号'),(117,'用户名','密码','地址','手机号'),(130,'用户名','密码','地址','手机号'),(131,'用户名','密码','地址','手机号'),(132,'用户名','密码','地址','手机号'),(133,'username','pwd','loc','num'),(134,'username','pwd','loc','number'),(146,'121','121','123','123');
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

-- Dump completed on 2023-03-15 21:45:05
