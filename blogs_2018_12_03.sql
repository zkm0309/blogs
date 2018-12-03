/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.6.16 : Database - blogs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blogs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blogs`;

/*Table structure for table `b_account` */

DROP TABLE IF EXISTS `b_account`;

CREATE TABLE `b_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `accountname` varchar(50) DEFAULT NULL COMMENT '账号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `roid` int(11) DEFAULT NULL COMMENT '对应角色id',
  `arid` int(11) DEFAULT NULL COMMENT '对应区域id',
  `iindex` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `sex` int(11) DEFAULT NULL COMMENT '性别：1男 0女',
  `telphone` varchar(20) DEFAULT NULL COMMENT '电话',
  `imei` varchar(100) DEFAULT NULL COMMENT '手机设备唯一标识',
  `status` int(11) DEFAULT NULL COMMENT '状态(0:未激活 1:激活 -1:已删除)',
  `useremail` varchar(30) DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='账户表';

/*Data for the table `b_account` */

insert  into `b_account`(`id`,`username`,`accountname`,`password`,`roid`,`arid`,`iindex`,`remark`,`createdate`,`sex`,`telphone`,`imei`,`status`,`useremail`) values (1,'超级管理员','superadmin','E10ADC3949BA59ABBE56E057F20F883E',2,2,1,'超级管理员','2018-09-05 11:04:34',2,'18291432979',NULL,1,'zkm2275@163.com'),(2,'张思思','zhangsisi','E10ADC3949BA59ABBE56E057F20F883E',3,3,2,'张思思','2018-09-05 11:52:08',1,'15389217832',NULL,0,'zkm2275@163.com'),(3,'李思思','lisisi','E10ADC3949BA59ABBE56E057F20F883E',3,6,3,'李思思','2018-09-05 11:51:39',1,'17298922111',NULL,1,'zkm2275@163.com');

/*Table structure for table `b_area` */

DROP TABLE IF EXISTS `b_area`;

CREATE TABLE `b_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '区域名称',
  `status` int(11) DEFAULT NULL COMMENT '-1 删除   0 禁用  1启用 ',
  `code` varchar(30) DEFAULT NULL COMMENT '区域code',
  `pid` int(11) DEFAULT NULL COMMENT '上级区域',
  `layer` int(11) DEFAULT NULL COMMENT '层级 1 省  2 市  3 区  4 县 5 镇',
  `iindex` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='区域表';

/*Data for the table `b_area` */

insert  into `b_area`(`id`,`name`,`status`,`code`,`pid`,`layer`,`iindex`,`remark`) values (1,'区域根目录',1,'qygml',0,2,0,'区域根目录'),(2,'陕西省',1,'sxs',1,1,1,'陕西省'),(3,'西安市',1,'xas',2,2,1,'西安市'),(4,'宝鸡市',1,'bjs',2,2,3,'宝鸡市'),(5,'咸阳市',1,'xys',2,2,4,'咸阳市'),(6,'铜川市',1,'tcs',2,2,2,'铜川市'),(7,'测试',-1,'cs',2,5,5,'测试'),(8,'测试2',-1,'CS2',2,4,5,'测试2');

/*Table structure for table `b_articles` */

DROP TABLE IF EXISTS `b_articles`;

CREATE TABLE `b_articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uid` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(100) DEFAULT NULL COMMENT '文章标题',
  `keywords` varchar(50) DEFAULT NULL COMMENT '文章关键词',
  `abstracts` varchar(500) DEFAULT NULL COMMENT '文章简介',
  `content` text COMMENT '文章内容',
  `authorss` varchar(50) DEFAULT NULL COMMENT '文章作者',
  `sources` varchar(50) DEFAULT NULL COMMENT '文章来源',
  `iindex` int(11) DEFAULT NULL COMMENT '排序',
  `views` int(11) DEFAULT NULL COMMENT '文章浏览量',
  `comments` int(11) DEFAULT NULL COMMENT '评论总数',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `likenum` int(11) DEFAULT NULL COMMENT '点赞数',
  `auditstatus` int(11) DEFAULT NULL COMMENT '审核状态：-1已删除，1审核通过，0未审核',
  `assortmentid` int(11) DEFAULT NULL COMMENT '分类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文章表';

/*Data for the table `b_articles` */

insert  into `b_articles`(`id`,`uid`,`title`,`keywords`,`abstracts`,`content`,`authorss`,`sources`,`iindex`,`views`,`comments`,`createdate`,`likenum`,`auditstatus`,`assortmentid`) values (1,1,'java开发','Java','Linux入门','Java web 开发与服务运维专业','超级管理员','Java开发手册',1,1,1,'2018-09-11 17:10:27',1,0,2),(2,1,'Linux入门教程','Linux','Linux入门教程简介','<p>Linux入门教程简介，大家可以共同学习！<br/></p>','超级管理员','腾旭云',2,0,0,'2018-09-11 17:05:09',0,1,3),(3,1,'Java入门','Java','Java入门学习','<p>Java入门学习，欢迎大家参观学习！<br/></p>','超级管理员','阿里云',3,0,0,'2018-09-11 17:08:14',0,1,2),(4,1,'python-1','python爬虫-1','python爬虫教程','<p>python爬虫教程，欢迎有志人士点评！1<br/></p>','超级管理员','百度文库-1',4,0,0,'2018-09-12 14:17:39',0,-1,3);

/*Table structure for table `b_articlestags` */

DROP TABLE IF EXISTS `b_articlestags`;

CREATE TABLE `b_articlestags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `articlesid` int(11) DEFAULT NULL COMMENT '文章id',
  `tagsid` int(11) DEFAULT NULL COMMENT '标签id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文章标签关系表';

/*Data for the table `b_articlestags` */

insert  into `b_articlestags`(`id`,`articlesid`,`tagsid`) values (1,1,1),(2,1,10),(3,3,1),(4,3,10);

/*Table structure for table `b_assortment` */

DROP TABLE IF EXISTS `b_assortment`;

CREATE TABLE `b_assortment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `status` int(11) DEFAULT NULL COMMENT '状态：-1 删除   0 禁用  1启用',
  `code` varchar(30) DEFAULT NULL COMMENT '分类code',
  `pid` int(11) DEFAULT NULL COMMENT '上级分类',
  `iindex` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='分类表';

/*Data for the table `b_assortment` */

insert  into `b_assortment`(`id`,`name`,`status`,`code`,`pid`,`iindex`,`remark`) values (1,'分类根目录',1,'gml',0,0,'分类根目录'),(2,'Java',1,'zxfb',1,1,'Java'),(3,'Linux',1,'RMTJ',1,2,'Linux');

/*Table structure for table `b_files` */

DROP TABLE IF EXISTS `b_files`;

CREATE TABLE `b_files` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) DEFAULT NULL COMMENT '文件名称',
  `status` int(11) DEFAULT NULL COMMENT '-1 删除     1正常',
  `fileurl` varchar(200) DEFAULT NULL COMMENT '文件url',
  `fingertable` varchar(50) DEFAULT NULL COMMENT '指定表',
  `fingerid` int(11) DEFAULT NULL COMMENT '指定Id',
  `type` int(11) DEFAULT NULL COMMENT '1 图片  2 文件',
  `suffix` varchar(20) DEFAULT NULL COMMENT '后缀 列 jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文件表';

/*Data for the table `b_files` */

insert  into `b_files`(`id`,`name`,`status`,`fileurl`,`fingertable`,`fingerid`,`type`,`suffix`) values (2,'ic_launcher.jpg',1,'20180906/1536196088810.jpg','b_picture',2,1,'jpg'),(3,'ic_launcher.jpg',1,'20180906/1536196406496.jpg','b_picture',1,1,'jpg'),(4,'ic_launcher.jpg',-1,'20180906/1536200356127.jpg','b_picture',3,1,'png'),(5,'ic_launcher.jpg',-1,'20180906/1536200356127.jpg','b_picture',3,1,'jpg'),(6,'ic_launcher.jpg',-1,'20180906/1536203057153.jpg','b_picture',4,1,'jpg'),(7,'ic_launcher.jpg',1,'20180912/1536732075112.jpg','b_articles',4,1,'jpg');

/*Table structure for table `b_links` */

DROP TABLE IF EXISTS `b_links`;

CREATE TABLE `b_links` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `status` int(11) DEFAULT NULL COMMENT '状态：-1 删除   0 禁用  1启用',
  `code` varchar(30) DEFAULT NULL COMMENT '连接code',
  `iindex` int(11) DEFAULT NULL COMMENT '排序',
  `linksurl` varchar(100) DEFAULT NULL COMMENT '连接URL',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='外链接表';

/*Data for the table `b_links` */

insert  into `b_links`(`id`,`title`,`status`,`code`,`iindex`,`linksurl`,`createdate`,`remark`) values (1,'腾讯云',1,'TXY',1,'https://cloud.tencent.com/','2018-09-04 00:00:00','腾讯云'),(5,'慕课网',1,'mkw',2,'https://www.imooc.com','2018-09-04 15:45:10','慕课网');

/*Table structure for table `b_menu` */

DROP TABLE IF EXISTS `b_menu`;

CREATE TABLE `b_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称 ',
  `status` int(11) DEFAULT NULL COMMENT '-1 删除   0 禁用  1启用',
  `menuurl` varchar(200) DEFAULT NULL COMMENT '菜单url',
  `pid` int(11) DEFAULT NULL COMMENT '上级菜单id',
  `opentype` int(11) DEFAULT NULL COMMENT '打开方式  0 当前页面打开  1 新页面打开',
  `iindex` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='菜单表';

/*Data for the table `b_menu` */

insert  into `b_menu`(`id`,`name`,`status`,`menuurl`,`pid`,`opentype`,`iindex`,`remark`) values (1,'菜单根目录',1,'',0,0,1,'菜单根目录'),(2,'系统管理',1,'#',1,0,0,'系统设置'),(3,'菜单管理',1,'menu/menu.jsp',2,0,1,'菜单管理'),(4,'区域管理',1,'area/area.jsp',2,0,2,'区域管理'),(5,'角色管理',1,'role/role_list.jsp',2,0,3,'角色管理'),(7,'账户管理',1,'user/user_list.jsp',2,0,4,'账户管理'),(8,'APP版本管理',-1,'assortment/index.jsp',2,0,6,'APP版本管理'),(9,'分类管理',1,'assortment/assortment_list.jsp',13,0,3,'分类管理'),(13,'基础配置',1,'#',1,0,1,'基础配置'),(14,'首页轮播图管理',1,'picture/picture_list.jsp',13,0,1,'首页轮播图管理'),(15,'友情链接',1,'links/links_list.jsp',13,0,2,'友情链接'),(16,'标签管理',1,'tags/tags_list.jsp',13,0,4,'标签管理'),(17,'文章管理',1,'articles/articles_list.jsp',13,0,5,'文章管理');

/*Table structure for table `b_picture` */

DROP TABLE IF EXISTS `b_picture`;

CREATE TABLE `b_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pname` varchar(50) DEFAULT NULL COMMENT '图片名称',
  `psketch` varchar(100) DEFAULT NULL COMMENT '图片简介',
  `pstatus` int(11) DEFAULT NULL COMMENT '图片状态：-1删除  1 启用，0，禁用',
  `pcreatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '图片创建时间',
  `piindex` int(11) DEFAULT NULL COMMENT '排序',
  `pcreateid` int(11) DEFAULT NULL COMMENT '创建者id',
  `purl` varchar(100) DEFAULT NULL COMMENT '图片链接URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='图片表';

/*Data for the table `b_picture` */

insert  into `b_picture`(`id`,`pname`,`psketch`,`pstatus`,`pcreatedate`,`piindex`,`pcreateid`,`purl`) values (1,'轮播图1','轮播图1',1,'2018-09-05 00:00:00',1,1,'http://www.baidu.com'),(2,'图片2','图片2',1,'2018-09-06 09:12:52',2,1,'http://www.baidu.com'),(3,'图片34','图片34',-1,'2018-09-06 11:03:53',3,1,'http://www.taobao.com4'),(4,'测试','测试',-1,'2018-09-06 11:03:53',4,1,'http://www.baidu.com');

/*Table structure for table `b_role` */

DROP TABLE IF EXISTS `b_role`;

CREATE TABLE `b_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `status` int(11) DEFAULT NULL COMMENT '状态：-1 删除   0 禁用  1启用',
  `code` varchar(30) DEFAULT NULL COMMENT '角色code',
  `iindex` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色表';

/*Data for the table `b_role` */

insert  into `b_role`(`id`,`name`,`status`,`code`,`iindex`,`remark`) values (1,'超级管理员',1,'cgy',1,'超级管理员'),(2,'省管理员',1,'sgly',2,'省管理员'),(3,'市管理员',1,'sgly',3,'市管理员'),(4,'区管理员',1,'qgly',4,'区管理员'),(6,'县管理员',1,'xgly',5,'县管理员'),(10,'镇管理员',1,'zgly',7,'镇管理员'),(11,'测试',-1,'ces',8,'测试');

/*Table structure for table `b_rolemenu` */

DROP TABLE IF EXISTS `b_rolemenu`;

CREATE TABLE `b_rolemenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roid` int(11) DEFAULT NULL COMMENT '角色id',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='角色菜单关系表';

/*Data for the table `b_rolemenu` */

insert  into `b_rolemenu`(`id`,`roid`,`menuid`) values (22,10,1),(23,10,2),(24,10,9),(25,10,8),(26,1,8),(27,1,4),(28,1,1),(29,1,7),(30,1,3),(31,1,9),(32,1,5),(33,1,2),(34,3,1),(35,3,2),(36,3,7),(92,2,1),(93,2,2),(94,2,3),(95,2,4),(96,2,5),(97,2,7),(98,2,13),(99,2,14),(100,2,15),(101,2,9),(102,2,16),(103,2,17);

/*Table structure for table `b_tags` */

DROP TABLE IF EXISTS `b_tags`;

CREATE TABLE `b_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tagname` varchar(50) DEFAULT NULL COMMENT '标签标题',
  `status` int(11) DEFAULT NULL COMMENT '状态：-1 删除   0 禁用  1启用',
  `code` varchar(30) DEFAULT NULL COMMENT '标签code',
  `iindex` int(11) DEFAULT NULL COMMENT '排序',
  `tagurl` varchar(100) DEFAULT NULL COMMENT '标签URL',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='标签表';

/*Data for the table `b_tags` */

insert  into `b_tags`(`id`,`tagname`,`status`,`code`,`iindex`,`tagurl`,`createdate`,`remark`) values (1,'Java',1,'h-ui',1,'http://www.h-ui.net/','2018-09-11 15:12:08','H-ui前端框架'),(10,'Linux',0,'216web',2,'http://www.h-ui.net/websafecolors.shtml','2018-09-11 15:12:13','216Web安全色');

/* Function  structure for function  `getAssortmentChildrenList` */

/*!50003 DROP FUNCTION IF EXISTS `getAssortmentChildrenList` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`tbwytest`@`%` FUNCTION `getAssortmentChildrenList`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
DECLARE sTemp VARCHAR(1000);
DECLARE sTempChd VARCHAR(1000);
 
 
SET sTemp = '$';
SET sTempChd =cast(rootId as CHAR);
 
 
WHILE sTempChd is not null DO
SET sTemp = concat(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM b_assortment where FIND_IN_SET(pid,sTempChd)>0;
END WHILE;
RETURN sTemp;
END */$$
DELIMITER ;

/* Function  structure for function  `getChildrenList` */

/*!50003 DROP FUNCTION IF EXISTS `getChildrenList` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`tbwytest`@`%` FUNCTION `getChildrenList`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
DECLARE sTemp VARCHAR(1000);
DECLARE sTempChd VARCHAR(1000);
 
 
SET sTemp = '$';
SET sTempChd =cast(rootId as CHAR);
 
 
WHILE sTempChd is not null DO
SET sTemp = concat(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM b_area where FIND_IN_SET(pid,sTempChd)>0;
END WHILE;
RETURN sTemp;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
