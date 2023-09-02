-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_ems
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `stream`
--

LOCK TABLES `stream` WRITE;
/*!40000 ALTER TABLE `stream` DISABLE KEYS */;
INSERT INTO `stream` VALUES (1,'Software Development'),(2,'Business Intelligence'),(3,'Data Engineering'),(4,'Cybersecurity'),(5,'Cloud Computing'),(6,'Technical Analysis');
/*!40000 ALTER TABLE `stream` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `stream_seq`
--

LOCK TABLES `stream_seq` WRITE;
/*!40000 ALTER TABLE `stream_seq` DISABLE KEYS */;
INSERT INTO `stream_seq` VALUES (101);
/*!40000 ALTER TABLE `stream_seq` ENABLE KEYS */;
UNLOCK TABLES;





--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'HR'),(2,'Trainee'),(3,'Trainer'),(4,'Account Manager');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role_seq`
--

LOCK TABLES `role_seq` WRITE;
/*!40000 ALTER TABLE `role_seq` DISABLE KEYS */;
INSERT INTO `role_seq` VALUES (101);
/*!40000 ALTER TABLE `role_seq` ENABLE KEYS */;
UNLOCK TABLES;











--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (fk_class, fk_role, fk_stream, has_personally_set_password, id, leave_taken, salary, start_date, fdm_role, email, first_name, last_name, password) VALUES (NULL,2,1,_binary '',1,1,60000,'2023-05-15','Trainee','min.park@fdm.com','Min','Park','$2a$10$bFFQjAizJBkioijXvjRS9OV2oYhok6imO9l/R2gOoV1tcG9LmQfhG'),(NULL,2,1,_binary '',2,12,60000,'2023-05-15','Trainee','stanley.chilton@fdm.com','Stanley','Chilton','$2a$10$0qwGbReaXFeFapir6ED0Q.YL12WM91oPL5zREIUz6mB2ifmyyiD6i'),(NULL,2,1,_binary '',3,11,60000,'2023-05-15','Trainee','matthew.theseira@fdm.com','Matthew','Theseira','$2a$10$C4jpXZ.hHhBC6uAm77iJVOV28FG4JFyorTiE7w0rp0HKRCc0tV3Fy'),(NULL,2,1,_binary '\0',4,8,60000,'2023-05-15','Trainee','zhanzhao.yang@fdm.com','Zhanzhao','Yang','$2a$10$fIadWbnQqD6ukH5VBZajruYZb.rbUvGRc4gPsaJiiMw18t7VKLA2a'),(NULL,2,1,_binary '\0',5,7,60000,'2023-05-15','Trainee','samantha.jermyn@fdm.com','Samantha','Jermyn','$2a$10$HoVp2pUJ4LD/UH7kRyEw2OU/gr/d/KifV9uy1Kd1C.DgtzCUwO5OC'),(NULL,2,1,_binary '\0',6,4,60000,'2023-05-15','Trainee','caovinh.lam@fdm.com','CaoVinh','Lam','$2a$10$q/bQvpKFA3V.u0vf26PvBOHYItuQFfOzc.QLaRypB1Yj4KPrZQ6ri'),(NULL,2,1,_binary '\0',7,2,60000,'2023-05-15','Trainee','matthew.veldhuizen@fdm.com','Matthew','Veldhuizen','$2a$10$3SZzDYbgUc/gdEms1yyE3OOKygqrRkfvty.i.sQFKRjQ4em0DRMBG'),(NULL,2,1,_binary '\0',8,1,60000,'2023-05-15','Trainee','christian.lee@fdm.com','Christian','Lee','$2a$10$ttYeyuhMkd2F6FDmcwWvkeDAFb2yBweJ37YxCeTQ5MupvtMHkpEXq'),(NULL,2,1,_binary '\0',9,1,60000,'2023-05-15','Trainee','phil.vu@fdm.com','Phil','Vu','$2a$10$.jkL1Aqz.uUWY6pxus0tQuCSVyGSZPkqco6HyTyt5vq6TDOhE/SiC'),(NULL,2,1,_binary '\0',10,1,60000,'2023-02-10','Trainee','yifeng.chen@fdm.com','Yifeng','Chen','$2a$10$XKZUqxgHOG6SupgH2yW7Q.XM0SCLu53E9594tBU9V9G/l95uTSLJe'),(NULL,2,1,_binary '\0',11,5,55000,'2023-03-15','Trainee','emma.johnson@fdm.com','Emma','Johnson','$2a$10$J9vFLpWpsGBLnKODQPCaAegHeFXCJUdfUkaBfz61OxSN5FvWsAzUa'),(NULL,2,2,_binary '\0',12,1,59000,'2023-04-20','Trainee','oliver.williams@fdm.com','Oliver','Williams','$2a$10$OLy5WaFlIc93KiVsy9/Lsu7iZv8dHIjCtZzdgbIlLh9Hhg1pRzmQ2'),(NULL,2,3,_binary '\0',13,10,60000,'2022-02-10','Trainee','sophia.miller@fdm.com','Sophia','Miller','$2a$10$f3KgMZ8SsMk3h5QMUihh1O3nSMR1bWhCA2pKn/i7SlTiL29JMN1be'),(NULL,2,4,_binary '\0',14,3,52000,'2018-04-20','Trainee','olivia.smith@fdm.com','Olivia','Smith','$2a$10$gTA06W5G.3LpaPuBydOif.B.65zIyfqM0OvF6/wId3o07rL1c8K66'),(NULL,2,5,_binary '\0',15,3,58000,'2020-02-10','Trainee','noah.wilson@fdm.com','Noah','Wilson','$2a$10$l9F6teDmE3MHJoqizMDF..QyvMb1aRK/hTvAljYBlZq8SFoiyn.1a'),(NULL,2,6,_binary '\0',16,10,56000,'2019-05-05','Trainee','liam.jones@fdm.com','Liam','Jones','$2a$10$OAbPGbjxLHaLGgf1oubNdumqiWKMPEEPQfLAr0TXxAZS8NugFq0Gm'),(NULL,2,1,_binary '\0',17,9,60000,'2021-06-30','Trainee','ava.anderson@fdm.com','Ava','Anderson','$2a$10$S2/otf6EDvJ24ru/ku7w2uwVH.aA3yd00KwACNVmLVpzcLeZb2fCe'),(NULL,2,2,_binary '\0',18,10,53000,'2020-07-15','Trainee','grace.white@fdm.com','Grace','White','$2a$10$Ieh31WPGPR4KZpkdfOXcLOdIHYhlZ63Uo0JDMWK1mGdHibXjf758C'),(NULL,2,3,_binary '\0',19,7,57000,'2023-08-10','Trainee','ethan.martin@fdm.com','Ethan','Martin','$2a$10$V./4kEVSyihpipw.5/hXdOhImpgbptuP1q75PUjbTUatUhiyLYjwq'),(NULL,2,4,_binary '\0',20,10,54000,'2022-09-25','Trainee','mia.brown@fdm.com','Mia','Brown','$2a$10$LUte/UNK1PdHqEpZTMOZfOXWfpEFcwXORTlzwOvAzlCC75SGySf0O'),(NULL,2,5,_binary '\0',21,12,59000,'2021-11-02','Trainee','oliver.johnson@fdm.com','Oliver','Johnson','$2a$10$QPyQqrBU.3DRB3U34m5N7ukP5DQaKDZPFp2P6pfdcMEpwMx7vGszG'),(NULL,2,6,_binary '\0',22,10,62000,'2022-12-12','Trainee','wence.panong@fdm.com','Wence','Panong','$2a$10$zl9hq3gBN63Be8JonvdrI.0WMl9xeoKArgp7Qfbi0lKuwcN4J8k/a'),(NULL,2,2,_binary '\0',23,1,59000,'2023-04-20','Trainee','olivia.johnson@fdm.com','Olivia','Johnson','$2a$10$/jy/jsmNbRnuEjxW52fJAe6R1X1tnAKQZHT3Gkemr.KKFjKWIqsVG'),(NULL,2,3,_binary '\0',24,10,60000,'2022-02-10','Trainee','william.davis@fdm.com','William','Davis','$2a$10$89iSwr8Hg5RYOTsFhBca5.92zprhv5BHj29ph1NrB2rvvIHhU/8RS'),(NULL,2,4,_binary '\0',25,3,52000,'2018-04-20','Trainee','ava.wilson@fdm.com','Ava','Wilson','$2a$10$ehLUXFh7XuZbRGUN2jVNHuiB/GQ0Ff33/S7xLQ6MSgja2myBk2Xem'),(NULL,2,5,_binary '\0',26,3,58000,'2020-02-10','Trainee','noah.jones@fdm.com','Noah','Jones','$2a$10$kibdlVt7QNVZY12LXqIDxuDHrDU.2gp5.F25WDdsSEKEddhyxy3nu'),(NULL,2,6,_binary '\0',27,10,56000,'2019-05-05','Trainee','oliver.anderson@fdm.com','Oliver','Anderson','$2a$10$RnjBEYWd8fIjEbfzQE3KpO7J.V.l6kwx7GU3KQvrpEUDUOwWDG3X2'),(NULL,2,2,_binary '\0',28,10,53000,'2020-07-15','Trainee','ethan.brown@fdm.com','Ethan','Brown','$2a$10$I1FFCbAdTjYq6Tv8SV3XIeBMA6X5k3GOwGi2DL7kOJr9k1wBJIUIS'),(NULL,2,3,_binary '\0',29,10,62000,'2022-12-12','Trainee','jessica.smith@fdm.com','Jessica','Smith','$2a$10$h8ySkirxUVM7PxjcKKnq8OFUx6b.vtvn75kjrT3LXEamgNK4QvhHi'),(NULL,2,4,_binary '\0',30,5,55000,'2023-03-15','Trainee','james.smith@fdm.com','James','Smith','$2a$10$sNYsApPySK9eYai1A.EAy.O0cdEr9xM9Fu3Fep3dJFVRAp3souIcS'),(NULL,2,5,_binary '\0',31,1,59000,'2023-04-20','Trainee','daniel.martinez@fdm.com','Daniel','Martinez','$2a$10$4l17sGU9tlyuLds9A9j1HeCqso2dWzzVro5iBRjeVJCCjU.9QYJLm'),(NULL,2,1,_binary '\0',32,5,55000,'2023-03-15','Trainee','emma.jones@fdm.com','Emma','Jones','$2a$10$hl1L9ftcH0EPm2KQAbVf2ugnPeZIoiM1T/QEjwmAmWtiovbjVZzxS'),(NULL,2,2,_binary '\0',33,1,59000,'2023-04-20','Trainee','oliver.miller@fdm.com','Oliver','Miller','$2a$10$5JzcnFZDJxbO3r5987hiH.4Y5qCTlKEZuWR28kLYYBvWa3g4qBMuK'),(NULL,2,3,_binary '\0',34,10,60000,'2022-02-10','Trainee','sophia.wilson@fdm.com','Sophia','Wilson','$2a$10$zEmQSHjpRA7vvgrF7LO/q.G1t3eLpojOVNjma0UMpxcDBqjx4D2MG'),(NULL,2,4,_binary '\0',35,3,52000,'2018-04-20','Trainee','olivia.brown@fdm.com','Olivia','Brown','$2a$10$PGTcKwNUm4eCrGPeqitPROiHnNHIC95T6ePLzN1Y7SrIk6MuoIMYC'),(NULL,2,5,_binary '\0',36,3,58000,'2020-02-10','Trainee','noah.anderson@fdm.com','Noah','Anderson','$2a$10$oL4PkOlqZiFvp4tRBOTVNu4DpQ9d0yUbw01/M38IcVJJcgL/kS6rW'),(NULL,2,6,_binary '\0',37,10,56000,'2019-05-05','Trainee','liam.johnson@fdm.com','Liam','Johnson','$2a$10$tSiWshcjUfA.f1wU8HKbwuklSOWYQKVLYf79Ab4c0kadWJmx1B4MG'),(NULL,2,1,_binary '\0',38,9,60000,'2021-06-30','Trainee','ava.davis@fdm.com','Ava','Davis','$2a$10$xdRTaMrP716uSxAStOf7vuSnS3LYExXux/Lve30QxSiO70ZQQsena'),(NULL,2,3,_binary '\0',39,7,57000,'2023-08-10','Trainee','ethan.martinez@fdm.com','Ethan','Martinez','$2a$10$P3eNwpfJkZNy61IdWrozkuTPSxQSLaHbKUX6FG2/PF9viwg/RiDTi'),(NULL,2,4,_binary '\0',40,10,54000,'2022-09-25','Trainee','mia.smith@fdm.com','Mia','Smith','$2a$10$fTOzYJ2doJ7npVt3.dr8Euu6Cbmqqe53Jy1K.O/O/N6IHPSHxM6e2'),(NULL,2,5,_binary '\0',41,12,59000,'2021-11-02','Trainee','william.johnson@fdm.com','William','Johnson','$2a$10$yaMyFou2N.pBRxCFiDsYVOS7AjR7TPaH/tst3uLp9Cwv80uiRNRse'),(NULL,2,1,_binary '\0',42,7,57000,'2023-08-10','Trainee','lucas.davis@fdm.com','Lucas','Davis','$2a$10$cS2kjavO8ESNFEzA94aTZOo4vy7PW9Z8CyMk1XPOEwABJbnCdMnn2'),(NULL,2,4,_binary '\0',43,10,54000,'2022-09-25','Trainee','ella.jones@fdm.com','Ella','Jones','$2a$10$NzQQ.RvErkQkCfWW6B26uOmrAD8CdnUHIjvyBIT5/G195zbZkkjM2'),(NULL,2,5,_binary '\0',44,12,59000,'2021-11-02','Trainee','oliver.smith@fdm.com','Oliver','Smith','$2a$10$wrxZ13tiQDIa8nBFw5s0iOFuzq7R4uRly1OrAPy03wluZ6r8nOMpi'),(NULL,2,6,_binary '\0',45,10,62000,'2022-12-12','Trainee','sophia.martinez@fdm.com','Sophia','Martinez','$2a$10$y6iGqmLETJ3dyKog7LJaj.Q6jW.CZdsYOMc.jdkdq4ubZD9ruQIHW'),(NULL,2,1,_binary '\0',46,7,57000,'2023-08-10','Trainee','jacob.miller@fdm.com','Jacob','Miller','$2a$10$voVo6upaywzAtwFunGDp9.kiapPWc39p0.EhvUOm0WPQ.o3Jtn96i'),(NULL,2,4,_binary '',47,10,54000,'2022-09-25','Trainee','mia.jones@fdm.com','Mia','Jones','$2a$10$VNmcZPqkMaclasaNQirtT.hRa/gJwfZQzDQPrOvv9v46EkOUtRmF.'),(NULL,2,6,_binary '\0',48,10,62000,'2022-12-12','Trainee','emma.martinez@fdm.com','Emma','Martinez','$2a$10$BoffaE/NsZJiC0/tAx7qKOpD1nEiBw03y/seaYqH.Z1gxMRfVzEJe'),(NULL,2,1,_binary '\0',49,7,57000,'2023-08-10','Trainee','james.brown@fdm.com','James','Brown','$2a$10$8Fa9xSz2Pz/qFmzqB5qYt.EAWcOmR0yCuyqm3QEN6f1nlv9K0U/vK'),(NULL,2,1,_binary '\0',50,5,55000,'2023-03-15','Trainee','emm.jones@fdm.com','Emm','Jones','$2a$10$.d7akvqukFeTvrrp/cVcZOqbY4TrwGfCkXk.AIp8NiLfMF03aGXom'),(NULL,2,2,_binary '\0',51,1,59000,'2023-04-20','Trainee','olive.miller@fdm.com','Olie','Miller','$2a$10$TUjw3//s2J8zcGnYXOw0uugtTuy7BbN80WVJAvZCTBv2yxf/scryS'),(NULL,2,3,_binary '\0',52,10,60000,'2022-02-10','Trainee','sophi.wilson@fdm.com','Sophi','Wilson','$2a$10$CfK4OnqN484M8ogX5Aqjceh2n6id1sD55awEEKRJy2BOXnMVtAqMm'),(NULL,2,4,_binary '\0',53,3,52000,'2018-04-20','Trainee','oliv.brown@fdm.com','Olivi','Brown','$2a$10$FcVUUUhKiiVaLLvp/YJwc.uTOl/Bb/MBHGOcuINryi4XM7wqk1Q7K'),(NULL,2,5,_binary '\0',54,3,58000,'2020-02-10','Trainee','noa.anderson@fdm.com','Noa','Anderson','$2a$10$PS1mcsNJAVgOB4Gha8MSFOqtGprSm8RfUbuiOevBFL0K0urlUDWM6'),(NULL,2,6,_binary '\0',55,10,56000,'2019-05-05','Trainee','lia.johnson@fdm.com','Li','Johnson','$2a$10$qUNanno5KacTH6ZUWRmnke2XxSTzOe9tKszE1F.VKllz45gwPvIti'),(NULL,2,1,_binary '\0',56,9,60000,'2021-06-30','Trainee','av.davis@fdm.com','Av','Davis','$2a$10$KyUB46relaqI/qRj6hbhr.UtQoePifIsgfH98hLOpP.LXVl.Zy1bi'),(NULL,2,2,_binary '\0',57,10,53000,'2020-07-15','Trainee','grace.thomas@fdm.com','Grac','Thomas','$2a$10$5aet8.z4Et1yfMwv3/.We.UWjJ33yQAfDetqyypqJH7v.uVEWfj4y'),(NULL,2,3,_binary '\0',58,7,57000,'2023-08-10','Trainee','ethn.martinez@fdm.com','Eth','Martinez','$2a$10$SJuJW6Rd7LD8AdNlV4IS3uL0/3Dy7OyDfTF7bEaieR8AauXfAmdIm'),(NULL,2,4,_binary '\0',59,10,54000,'2022-09-25','Trainee','mi.smith@fdm.com','Mi','Smith','$2a$10$xFcn2NOqDbtbVI55GljpJeMKcUvqjcJdB2NvPp0y525Rd.WxULYdC'),(NULL,2,5,_binary '\0',60,12,59000,'2021-11-02','Trainee','wil.johnson@fdm.com','Will','Johnson','$2a$10$29azfIYUybJ5jwbQr8Z3k.rWwi6CL/qL8rFIXOe92ePDbr4jOfz5S'),(NULL,2,1,_binary '\0',61,7,57000,'2023-08-10','Trainee','luca.davis@fdm.com','Luca','Davis','$2a$10$5pSEhwJYI7608zj0mqt1.uXCjInKj/brST9d4LhXMUltSCVAnwHfm'),(NULL,2,4,_binary '\0',62,10,54000,'2022-09-25','Trainee','ell.jones@fdm.com','Ell','Jones','$2a$10$dT/aIRCv91nWJHSGose.9.yqeisM06GnRMKWXbDUqlCtDg41VJZv.'),(NULL,2,5,_binary '\0',63,12,59000,'2021-11-02','Trainee','ol.smith@fdm.com','Oliv','Smith','$2a$10$UsMiCIFuzl0i2NqJKFHBR.F1AAugL1qsr4GBOb91onKlJMqqqGsNK'),(NULL,2,6,_binary '\0',64,10,62000,'2022-12-12','Trainee','sophi.martinez@fdm.com','Sophi','Martinez','$2a$10$d/nU5ki2fEQl.M3Q7wFmMuU11UXaIbkUI/IRj3x9g25.6Eq8OGFHa'),(NULL,2,1,_binary '\0',65,7,57000,'2023-08-10','Trainee','jac.miller@fdm.com','Jacobs','Miller','$2a$10$RNiqI5BieksVhw5w4z0oaePe4G0Z2Sn5qqrLUGD8C4jrzQWwgki/y'),(NULL,2,4,_binary '\0',66,10,54000,'2022-09-25','Trainee','mian.jones@fdm.com','Miad','Jones','$2a$10$LMpS4cUUN347HWtxMNlvBuLkFe0.Bots5kJkcuzu6Z0pU217B4TeS'),(NULL,2,6,_binary '\0',67,10,62000,'2022-12-12','Trainee','emmz.martinez@fdm.com','Emmaz','Martinez','$2a$10$GxAWMtSG1DO2dDgsmlPGcuMJHkiEPkMnlxp7.RZKN9GxJpmq0uJ6m'),(NULL,2,1,_binary '\0',68,7,57000,'2023-08-10','Trainee','jameie.brown@fdm.com','Jamuie','Brown','$2a$10$Z7HUoKhRE7X.LgCSEeID3.sh6hkqfJmsXn5hVGY/JkUH7iVjew.1y'),(NULL,3,NULL,_binary '',69,25,110000,'2021-02-01','Trainer','donald.witcombe@fdm.com','Donald','Witcombe','$2a$10$P7JQTg7MyKwTYi7Wj.HXuOBzfeI4LqFjy/4/W0vwut0jjEcowz6OG'),(NULL,3,NULL,_binary '\0',70,51,85000,'2021-05-01','Trainer','manisha.singh@fdm.com','Manisha','Singh','$2a$10$E.lgmLJYbi2zabUpPbPYl.FOZFRNByK4dHledmhecdcendcQYniv6'),(NULL,3,NULL,_binary '\0',71,46,100000,'2020-03-11','Trainer','iffty.ahmed@fdm.com','Iffty','Ahmed','$2a$10$PvsvVrs6jgPuay18unHwj.U1oYfNlgxuAZqseQ4CBRBjxv7FsxNjm'),(NULL,3,NULL,_binary '\0',72,35,100000,'2021-07-11','Trainer','carolina.portugal@fdm.com','Carolina','Portugal','$2a$10$W8XEhqAo.9EyGWmtag4PmO/qu17mKO/ErcAGr3YReMFN9LCo48Gji'),(NULL,3,NULL,_binary '\0',73,15,92000,'2020-07-11','Trainer','dan.solomon@fdm.com','Dan','Solomon','$2a$10$8g/jxm92ReTrEGqGcPvon.ix8mtssu3eaMBoo3DLldW4.pb/st6oG'),(NULL,3,NULL,_binary '\0',74,20,92000,'2021-03-15','Trainer','natalie.hughes@fdm.com','Natalie','Hughes','$2a$10$BhhI4Ieiy2cvXPcPfWKvoe4Vq3TP4ANDSMGQQYB3hUL8ehzJ7h.Xq'),(NULL,3,NULL,_binary '\0',75,18,92000,'2020-11-10','Trainer','robert.anderson@fdm.com','Robert','Anderson','$2a$10$/8QRnwEGJQaCP1Cn0AjDFeruU/h6lR0eC1hukOuTE0bhijBhDFsE.'),(NULL,3,NULL,_binary '\0',76,22,90000,'2021-05-05','Trainer','linda.brown@fdm.com','Linda','Brown','$2a$10$lxMmW9rOkyLxhzHGO3.2.OiSRnJdX2TRFfLM3PlgMvKDk03ij9oxe'),(NULL,3,NULL,_binary '\0',77,21,100000,'2021-06-30','Trainer','michael.jones@fdm.com','Michael','Jones','$2a$10$TTT/aJ95eRAuZZ7PTDD2XOl72TyqpA08dvdGqxyvzBCR5QBFFx8LC'),(NULL,3,NULL,_binary '\0',78,15,95000,'2020-07-15','Trainer','emily.smith@fdm.com','Emily','Smith','$2a$10$I7h26idl/v7C7j8Rkm0W6uoAU9yRbGJXVy4xjMQt4JJNLkDJDMuge'),(NULL,3,NULL,_binary '\0',79,28,90000,'2020-08-10','Trainer','daniel.martin@fdm.com','Daniel','Martin','$2a$10$KOzvtzfRUPyNBVx/dy69peyLkmQTYj7bDNzETMKooLnGgRMwVniui'),(NULL,3,NULL,_binary '\0',80,23,87000,'2020-09-25','Trainer','olivia.wilson@fdm.com','Olivia','Wilson','$2a$10$RW.vOfuL/rvMCNpdhabuTudD54894lR7rRn8SdwgHJ2qX/mm0ao9S'),(NULL,3,NULL,_binary '\0',81,20,100000,'2020-11-02','Trainer','william.anderson@fdm.com','William','Anderson','$2a$10$NAIpIIeiLBnonzkN3n8t5eABUrpg1lXf04YrcBFh6hm0tTpHr1aey'),(NULL,3,NULL,_binary '\0',82,30,90000,'2020-12-12','Trainer','sophia.davis@fdm.com','Sophia','Davis','$2a$10$jrGWiD2GUb93l.LMWe03mu31wY6tampl00LdMkmTRJ50b/DIEaVAG'),(NULL,3,NULL,_binary '\0',83,15,100000,'2022-12-12','Trainer','suellen.steward@fdm.com','Suellen','Steward','$2a$10$Gjvq46mCycvVbrteakw3OeiUvkWclxC94/jEehESaAQobFA1/zYni'),(NULL,1,NULL,_binary '\0',84,25,110000,'2021-02-01','HR','edwina.than-aye@fdm.com','Edwina','Than-Aye','$2a$10$FVTBA931TTCXwSMNL6B8menP1cqjS.zyCpqaavEtQsGtLobeVZdQW'),(NULL,1,NULL,_binary '\0',85,25,110000,'2021-02-01','HR','aleksandra.zlatevska@fdm.com','Aleksandra','Zlatevska','$2a$10$1m20/ewNP1HRBhVzIZi8ZeQiwtyxp4om3j4eIlPIr1RTUK7YM48mC'),(NULL,1,NULL,_binary '',86,25,110000,'2020-02-01','HR','john.doe@fdm.com','John','Doe','$2a$10$Uujpn/T2ir2qcBwKpOhfo.ZYIPps9DZ5TFwQvczL9Y5LLHvd5l4hS'),(NULL,1,NULL,_binary '\0',87,5,110000,'2023-02-01','HR','jane.doe@fdm.com','Jane','Doe','$2a$10$HdXD2cwFLGs60Urw.BUhOe9uuWZgCVfZ5p8I4J8gFKvIW6nS3jTvG'),(NULL,1,NULL,_binary '\0',88,5,110000,'2023-01-01','HR','joan.doe@fdm.com','Joan','Doe','$2a$10$VOrKMihQSAuWK0OYOAMqp.E99c7XUmZbfuYAYDeNg0srPZHJYu.Zy'),(NULL,4,NULL,_binary '\0',89,15,110000,'2022-01-15','AccountManager','james.mccarthy@fdm.com','James','McCarthy','$2a$10$6Sqbe3uT1vrrT.UWQFUDFuXDgCYk02PEa7LPsk5F.quHQ3aLZoZ/e'),(NULL,4,NULL,_binary '\0',90,65,110000,'2017-09-15','AccountManager','will.rayner@fdm.com','Will','Rayner','$2a$10$2rGWsD2BrXquvE2ApxijoulQ5Siv2c8C.ioqCsJEQG/n7sTxLxp6m'),(NULL,4,NULL,_binary '\0',91,13,110000,'2022-10-15','AccountManager','yasmin.bellairs-taylor@fdm.com','Yasmin','Bellairs-Taylor','$2a$10$tXUSSWws4mq6Oh6HvAJD3.Hw1hJlNdKa5lgZE0A0oxNx3mBBisLqC'),(NULL,4,NULL,_binary '\0',92,6,110000,'2022-01-25','AccountManager','nina.evangelinides@fdm.com','Nina','Evangelinides','$2a$10$nDWsRkE/Csyxr4Ou/rBcuO51TPZuLkW49aVUwhJ5StG80IZgYlOsS'),(NULL,4,NULL,_binary '\0',93,80,110000,'2012-06-15','AccountManager','joe.mclaren@fdm.com','Joe','Mclaren','$2a$10$gq3oqn.M/hejuhKpVKf65uk5oS3vAroQudkZEBVqMqo9iKtSItk2u'),(NULL,4,NULL,_binary '\0',94,12,110000,'2020-01-28','AccountManager','nicholas.lloyd@fdm.com','Nicholas','Lloyd','$2a$10$tH/aq4K583x.H0nnFzmIce/ai0IL93Onetfj4fs3qWulmyOEu4AMa'),(NULL,4,NULL,_binary '\0',95,35,110000,'2018-09-15','AccountManager','edward.bristow@fdm.com','Edward','Bristow','$2a$10$1CfP8uM.0zgGPu/8G9piPOvJUTlCxM0ldFFDE0JqYobfC9xh4daWu'),(NULL,4,NULL,_binary '\0',96,12,110000,'2023-01-15','AccountManager','rozalija.kizenevic@fdm.com','Rozalija','Kizenevic','$2a$10$nhsv8dJUcCwixuZBgG.l/OGFNHTNroVPn/46aVy2EFItm6HkIuqBq'),(NULL,2,NULL,_binary '\0',97,0,60000,'2023-08-31','Trainee','stuart.bassett@fdm.com','Stuart','Bassett','$2a$10$qsP1w1ZybCiCgOyk16Culub6xgagy9X3u4t7LpwHW5tGhSioep8R6'),(NULL,2,NULL,_binary '\0',98,0,60000,'2023-06-08','Trainee','daniel.chow@fdm.com','Daniel','Chow','$2a$10$zgH6KLUnX0q64l15mflpser/9wIfTiTJJlVmFuHnpPpPGOsQdF.uK');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

----
---- Dumping data for table `employee_seq`
----
--
--LOCK TABLES `employee_seq` WRITE;
--/*!40000 ALTER TABLE `employee_seq` DISABLE KEYS */;
--INSERT INTO `employee_seq` VALUES (151);
--/*!40000 ALTER TABLE `employee_seq` ENABLE KEYS */;
--UNLOCK TABLES;









--
-- Dumping data for table `leave_request`
--

LOCK TABLES `leave_request` WRITE;
/*!40000 ALTER TABLE `leave_request` DISABLE KEYS */;
INSERT INTO `leave_request` VALUES ('2023-09-01',86,1,'2023-08-28',38,'Pending'),('2023-09-07',1,2,'2023-09-04',30.4,'Pending'),('2023-09-14',3,3,'2023-09-11',25.3,'Pending'),('2023-09-27',2,4,'2023-09-25',22.8,'Pending'),('2023-09-01',69,5,'2023-08-28',38,'Pending'),('2023-09-01',47,6,'2023-08-28',38,'Pending');
/*!40000 ALTER TABLE `leave_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `leave_request_seq`
--

LOCK TABLES `leave_request_seq` WRITE;
/*!40000 ALTER TABLE `leave_request_seq` DISABLE KEYS */;
INSERT INTO `leave_request_seq` VALUES (101);
/*!40000 ALTER TABLE `leave_request_seq` ENABLE KEYS */;
UNLOCK TABLES;




/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-02 10:19:00
