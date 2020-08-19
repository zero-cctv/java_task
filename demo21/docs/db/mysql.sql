-- MySQL dump 10.13  Distrib 8.0.20, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: demo
-- ------------------------------------------------------
-- Server version	5.6.38

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
-- Table structure for table `ip`
--

DROP TABLE IF EXISTS `ip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip_start` varchar(15) NOT NULL,
  `ip_end` varchar(15) NOT NULL,
  `area` varchar(100) NOT NULL,
  `operator` varchar(200) NOT NULL,
  `ip_start_num` bigint(20) NOT NULL,
  `ip_end_num` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='IP地址';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ip`
--

LOCK TABLES `ip` WRITE;
/*!40000 ALTER TABLE `ip` DISABLE KEYS */;
/*!40000 ALTER TABLE `ip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_department`
--

DROP TABLE IF EXISTS `sys_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_department` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '部门名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `level` int(11) DEFAULT NULL COMMENT '部门层级',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_department_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_department`
--

LOCK TABLES `sys_department` WRITE;
/*!40000 ALTER TABLE `sys_department` DISABLE KEYS */;
INSERT INTO `sys_department` VALUES (1,'技术部',NULL,1,1,359544077,'fe8c9cbac0c54395ac411335a31f4888',15,'2019-10-25 01:46:49','2019-11-13 11:56:07'),(2,'研发部',NULL,1,1,0,NULL,0,'2019-11-01 12:45:43',NULL),(20,'前端开发部',2,2,1,0,NULL,0,'2019-11-01 12:48:38',NULL),(21,'后台开发部',2,2,1,0,NULL,0,'2019-11-01 12:48:38',NULL),(22,'测试部',2,2,1,0,NULL,0,'2019-11-01 12:48:38',NULL),(201,'前端一组',20,3,1,0,NULL,0,'2019-11-01 12:48:38',NULL),(202,'前端二组',20,3,1,0,NULL,0,'2019-11-01 12:48:38',NULL),(203,'后台一组',21,3,1,0,NULL,0,'2019-11-01 12:48:38',NULL),(204,'后台二组',21,3,1,0,NULL,0,'2019-11-01 12:48:38',NULL),(205,'用户组',22,3,1,0,NULL,0,'2019-11-01 12:48:38',NULL);
/*!40000 ALTER TABLE `sys_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_log` (
  `log_id` bigint(18) NOT NULL COMMENT '主键',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `create_id` bigint(18) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (1060438746056376321,0,'A',100000,'2018-11-08 15:41:58'),(1060438788502732802,0,'B',100000,'2018-11-08 15:42:08'),(1060438799600861185,0,'C',100000,'2018-11-08 15:42:10'),(1060438809495224322,0,'D',100000,'2018-11-08 15:42:13');
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_operation_log`
--

DROP TABLE IF EXISTS `sys_operation_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_operation_log` (
  `id` bigint(18) NOT NULL COMMENT '主键',
  `user_id` bigint(18) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `name` varchar(200) DEFAULT NULL COMMENT '日志名称',
  `ip` varchar(15) DEFAULT NULL COMMENT 'IP',
  `area` varchar(100) DEFAULT NULL COMMENT '区域',
  `path` varchar(500) DEFAULT NULL COMMENT '全路径',
  `url` varchar(100) DEFAULT NULL COMMENT '访问路径',
  `module_name` varchar(100) DEFAULT NULL COMMENT '模块名称',
  `package_name` varchar(200) DEFAULT NULL COMMENT '包名',
  `class_name` varchar(100) DEFAULT NULL COMMENT '类名',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名称',
  `request_method` varchar(10) DEFAULT NULL COMMENT '请求方式，GET/POST',
  `content_type` varchar(100) DEFAULT NULL COMMENT '内容类型',
  `request_body` tinyint(1) DEFAULT NULL COMMENT '是否是JSON请求映射参数',
  `param` text COMMENT '请求参数',
  `token` varchar(1000) DEFAULT NULL COMMENT 'token',
  `type` int(11) DEFAULT NULL COMMENT '0:其它,1:新增,2:修改,3:删除,4:详情查询,5:所有列表,6:分页列表,7:其它查询,8:上传文件',
  `success` tinyint(1) DEFAULT NULL COMMENT '0:失败,1:成功',
  `code` int(11) DEFAULT NULL COMMENT '响应结果状态码',
  `msg` varchar(100) DEFAULT NULL COMMENT '响应结果消息',
  `exception_name` varchar(200) DEFAULT NULL COMMENT '异常类名称',
  `exception_msg` text COMMENT '异常信息',
  `result` text COMMENT '响应结果',
  `browser_name` varchar(100) DEFAULT NULL COMMENT '浏览器名称',
  `browser_version` varchar(100) DEFAULT NULL COMMENT '浏览器版本',
  `engine_name` varchar(100) DEFAULT NULL COMMENT '浏览器引擎名称',
  `engine_version` varchar(100) DEFAULT NULL COMMENT '浏览器引擎版本',
  `os_name` varchar(100) DEFAULT NULL COMMENT '系统名称',
  `platform_name` varchar(100) DEFAULT NULL COMMENT '平台名称',
  `mobile` tinyint(1) DEFAULT NULL COMMENT '是否是手机,0:否,1:是',
  `device_name` varchar(100) DEFAULT NULL COMMENT '移动端设备名称',
  `device_model` varchar(100) DEFAULT NULL COMMENT '移动端设备型号',
  `record_param` tinyint(1) DEFAULT NULL COMMENT '是否记录请求参数，0：不记录，1：记录',
  `record_result` tinyint(1) DEFAULT NULL COMMENT '是否记录响应结果，0:不记录，1:记录',
  `record_client` tinyint(1) DEFAULT NULL COMMENT '是否记录客户端信息，0：不记录，1：记录',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统操作日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_operation_log`
--

LOCK TABLES `sys_operation_log` WRITE;
/*!40000 ALTER TABLE `sys_operation_log` DISABLE KEYS */;
INSERT INTO `sys_operation_log` VALUES (1192112249041354754,NULL,NULL,NULL,'127.0.0.1',NULL,'http://127.0.0.1:8888/fooBar/getPageList','/fooBar/getPageList',NULL,NULL,'FooBarController','getFooBarPageList','POST','application/json',1,'{\"current\":1,\"size\":10,\"keyword\":null,\"orders\":null}',NULL,NULL,0,NULL,NULL,'java.lang.ArithmeticException','/ by zero',NULL,'Chrome','78.0.3904.70','Webkit','537.36','OSX','Mac',0,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-07 00:11:23',NULL),(1192112949985030145,NULL,NULL,NULL,'127.0.0.1',NULL,'http://127.0.0.1:8888/fooBar/getPageList','/fooBar/getPageList',NULL,NULL,'FooBarController','getFooBarPageList','POST','application/json',1,'{\"current\":1,\"size\":10,\"keyword\":null,\"orders\":null}',NULL,NULL,1,200,'操作成功',NULL,NULL,'{\"code\":200,\"msg\":\"操作成功\",\"success\":true,\"data\":{\"total\":3,\"records\":[{\"id\":1191591978479955969,\"name\":\"应该被保存的数据\",\"foo\":\"foo\",\"bar\":\"bar\",\"remark\":null,\"state\":1,\"version\":0,\"createTime\":1572932641000,\"updateTime\":null},{\"id\":1,\"name\":\"FooBar\",\"foo\":\"foo\",\"bar\":\"bar\",\"remark\":\"remark...\",\"state\":1,\"version\":0,\"createTime\":1572588314000,\"updateTime\":null},{\"id\":2,\"name\":\"HelloWorld\",\"foo\":\"hello\",\"bar\":\"world\",\"remark\":null,\"state\":1,\"version\":0,\"createTime\":1572588314000,\"updateTime\":null}]},\"time\":\"2019-11-06 16:14:10\"}','Chrome','78.0.3904.70','Webkit','537.36','OSX','Mac',0,NULL,NULL,NULL,NULL,NULL,NULL,'2019-11-07 00:14:10',NULL);
/*!40000 ALTER TABLE `sys_operation_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父id',
  `url` varchar(200) DEFAULT NULL COMMENT '路径',
  `code` varchar(100) NOT NULL COMMENT '唯一编码',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `type` int(11) NOT NULL COMMENT '类型，1：菜单，2：按钮',
  `level` int(11) NOT NULL COMMENT '层级，1：第一级，2：第二级，N：第N级',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_permission_code_uindex` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (1,'系统管理',NULL,'/system/sys-user-list','system:management','el-icon-s-unfold',1,1,1,0,'1权限备注，可以查看所有用户信息',0,'2019-10-26 03:12:40',NULL),(100,'用户管理',1,'/system/sys-user-list','sys:user:management','el-icon-s-unfold',1,2,1,0,'100权限备注，可以查看所有用户信息',0,'2019-10-26 03:15:48',NULL),(200,'角色管理',1,'/system/sys-user-list','sys:role:management','el-icon-s-unfold',1,2,1,0,'200权限备注，可以查看所有用户信息',0,'2019-10-26 03:15:48',NULL),(300,'权限管理',1,'/system/sys-user-list','sys:permission:management','el-icon-s-unfold',1,2,1,0,'300权限备注，可以查看所有用户信息',0,'2019-10-26 03:15:48',NULL),(400,'部门管理',1,'/system/sys-user-list','sys:department:management','el-icon-s-unfold',1,2,1,0,'400权限备注，可以查看所有用户信息',0,'2019-10-26 03:15:48',NULL),(1000,'用户新增',100,'/system/sys-user-list','sys:user:add','el-icon-s-custom',2,3,1,0,'1000权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(1001,'用户修改',100,'/system/sys-user-list','sys:user:update','el-icon-s-custom',2,3,1,0,'1001权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(1002,'用户删除',100,'/system/sys-user-list','sys:user:delete','el-icon-s-custom',2,3,1,0,'1002权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(1003,'用户详情',100,'/system/sys-user-list','sys:user:info','el-icon-s-custom',2,3,1,0,'1003权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(1004,'用户分页列表',100,'/system/sys-user-list','sys:user:page','el-icon-s-custom',2,3,1,0,'1004权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(1005,'用户修改密码',100,'/system/sys-user-list','sys:user:update:password','el-icon-s-custom',2,3,1,0,'1005权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(1006,'用户修改头像',100,'/system/sys-user-list','sys:user:update:head','el-icon-s-custom',2,3,1,0,'1006权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(2000,'角色新增',200,'/system/sys-user-list','sys:role:add','el-icon-s-custom',2,3,1,0,'2000权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(2001,'角色修改',200,'/system/sys-user-list','sys:role:update','el-icon-s-custom',2,3,1,0,'2001权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(2002,'角色删除',200,'/system/sys-user-list','sys:role:delete','el-icon-s-custom',2,3,1,0,'2002权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(2003,'角色详情',200,'/system/sys-user-list','sys:role:info','el-icon-s-custom',2,3,1,0,'2003权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(2004,'角色分页列表',200,'/system/sys-user-list','sys:role:page','el-icon-s-custom',2,3,1,0,'2004权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(2005,'角色列表',200,'/system/sys-user-list','sys:role:list','el-icon-s-custom',2,3,1,0,'2005权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3000,'权限新增',300,'/system/sys-user-list','sys:permission:add','el-icon-s-custom',2,3,1,0,'3000权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3001,'权限修改',300,'/system/sys-user-list','sys:permission:update','el-icon-s-custom',2,3,1,0,'3001权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3002,'权限删除',300,'/system/sys-user-list','sys:permission:delete','el-icon-s-custom',2,3,1,0,'3002权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3003,'权限详情',300,'/system/sys-user-list','sys:permission:info','el-icon-s-custom',2,3,1,0,'3003权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3004,'权限分页列表',300,'/system/sys-user-list','sys:permission:page','el-icon-s-custom',2,3,1,0,'3004权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3005,'权限所有列表',300,'/system/sys-user-list','sys:permission:all:menu:list','el-icon-s-custom',2,3,1,0,'3005权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3006,'权限所有树形列表',300,'/system/sys-user-list','sys:permission:all:menu:tree','el-icon-s-custom',2,3,1,0,'3006权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3007,'权限用户列表',300,'/system/sys-user-list','sys:permission:menu:list','el-icon-s-custom',2,3,1,0,'3007权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3008,'权限用户树形列表',300,'/system/sys-user-list','sys:permission:menu:tree','el-icon-s-custom',2,3,1,0,'3008权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(3009,'权限用户代码列表',300,'/system/sys-user-list','sys:permission:codes','el-icon-s-custom',2,3,1,0,'3009权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(4000,'部门新增',400,'/system/sys-user-list','sys:department:add','el-icon-s-custom',2,3,1,0,'4000权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(4001,'部门修改',400,'/system/sys-user-list','sys:department:update','el-icon-s-custom',2,3,1,0,'4001权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(4002,'部门删除',400,'/system/sys-user-list','sys:department:delete','el-icon-s-custom',2,3,1,0,'4002权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(4003,'部门详情',400,'/system/sys-user-list','sys:department:info','el-icon-s-custom',2,3,1,0,'4003权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(4004,'部门分页列表',400,'/system/sys-user-list','sys:department:page','el-icon-s-custom',2,3,1,0,'4004权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL),(4005,'部门列表',400,'/system/sys-user-list','sys:department:list','el-icon-s-custom',2,3,1,0,'4005权限备注，可以查看所有用户信息',0,'2019-10-26 03:18:40',NULL);
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) NOT NULL COMMENT '角色名称',
  `code` varchar(100) DEFAULT NULL COMMENT '角色唯一编码',
  `type` int(11) DEFAULT NULL COMMENT '角色类型',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '角色状态，0：禁用，1：启用',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_role_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='系统角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','admin',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(2,'test','test',NULL,1,'测试人员拥有部分权限',0,'2019-10-25 01:48:02',NULL),(3,'管理员1','admin1',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(4,'管理员2','admin2',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(5,'管理员3','admin3',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(6,'管理员4','admin4',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(7,'管理员5','admin5',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(8,'管理员6','admin6',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(9,'管理员7','admin7',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(10,'管理员8','admin8',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(11,'管理员9','admin9',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(12,'管理员10','admin10',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(13,'管理员11','admin11',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(14,'管理员12','admin12',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(15,'管理员13','admin13',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(16,'管理员14','admin14',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(17,'管理员15','admin15',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(18,'管理员16','admin16',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(19,'管理员17','admin17',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(20,'管理员18','admin18',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(21,'管理员19','admin19',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(22,'管理员20','admin20',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL),(23,'管理员21','admin21',NULL,1,'管理员拥有所有权限',0,'2019-10-25 01:47:21',NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `permission_id` (`permission_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES (233,1,3008,1,NULL,0,'2020-03-03 06:19:18',NULL),(234,1,1,1,NULL,0,'2020-03-03 06:19:18',NULL),(235,1,3009,1,NULL,0,'2020-03-03 06:19:18',NULL),(236,1,200,1,NULL,0,'2020-03-03 06:19:18',NULL),(237,1,2000,1,NULL,0,'2020-03-03 06:19:18',NULL),(238,1,400,1,NULL,0,'2020-03-03 06:19:18',NULL),(239,1,2001,1,NULL,0,'2020-03-03 06:19:18',NULL),(240,1,2002,1,NULL,0,'2020-03-03 06:19:18',NULL),(241,1,2003,1,NULL,0,'2020-03-03 06:19:18',NULL),(242,1,2004,1,NULL,0,'2020-03-03 06:19:18',NULL),(243,1,2005,1,NULL,0,'2020-03-03 06:19:18',NULL),(244,1,4000,1,NULL,0,'2020-03-03 06:19:18',NULL),(245,1,4001,1,NULL,0,'2020-03-03 06:19:18',NULL),(246,1,4002,1,NULL,0,'2020-03-03 06:19:18',NULL),(247,1,4003,1,NULL,0,'2020-03-03 06:19:18',NULL),(248,1,100,1,NULL,0,'2020-03-03 06:19:18',NULL),(249,1,4004,1,NULL,0,'2020-03-03 06:19:18',NULL),(250,1,4005,1,NULL,0,'2020-03-03 06:19:18',NULL),(251,1,1000,1,NULL,0,'2020-03-03 06:19:18',NULL),(252,1,1001,1,NULL,0,'2020-03-03 06:19:18',NULL),(253,1,1002,1,NULL,0,'2020-03-03 06:19:18',NULL),(254,1,1003,1,NULL,0,'2020-03-03 06:19:18',NULL),(255,1,1004,1,NULL,0,'2020-03-03 06:19:18',NULL),(256,1,300,1,NULL,0,'2020-03-03 06:19:18',NULL),(257,1,1005,1,NULL,0,'2020-03-03 06:19:18',NULL),(258,1,1006,1,NULL,0,'2020-03-03 06:19:18',NULL),(259,1,3000,1,NULL,0,'2020-03-03 06:19:18',NULL),(260,1,3001,1,NULL,0,'2020-03-03 06:19:18',NULL),(261,1,3002,1,NULL,0,'2020-03-03 06:19:18',NULL),(262,1,3003,1,NULL,0,'2020-03-03 06:19:18',NULL),(263,1,3004,1,NULL,0,'2020-03-03 06:19:18',NULL),(264,1,3005,1,NULL,0,'2020-03-03 06:19:18',NULL),(265,1,3006,1,NULL,0,'2020-03-03 06:19:18',NULL),(266,1,3007,1,NULL,0,'2020-03-03 06:19:18',NULL);
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `nickname` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐值',
  `phone` varchar(20) NOT NULL COMMENT '手机号码',
  `type` tinyint(2) unsigned NOT NULL DEFAULT '1' COMMENT '类型，1：学生，2：学校，3，企业',
  `gender` int(11) NOT NULL DEFAULT '1' COMMENT '性别，0：女，1：男，默认1',
  `head` varchar(200) DEFAULT NULL COMMENT '头像',
  `profile` varchar(2000) NOT NULL DEFAULT '' COMMENT '简介',
  `rating` mediumint(5) unsigned NOT NULL DEFAULT '0' COMMENT '星级评价',
  `service_total` mediumint(5) unsigned NOT NULL DEFAULT '0' COMMENT '服务成交数量',
  `total_fee` mediumint(5) unsigned NOT NULL DEFAULT '0' COMMENT '服务总金额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `department_id` bigint(20) NOT NULL DEFAULT '1' COMMENT '部门id',
  `role_id` bigint(20) NOT NULL DEFAULT '1' COMMENT '角色id',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用，2：锁定',
  `deleted` int(11) NOT NULL DEFAULT '0' COMMENT '逻辑删除，0：未删除，1：已删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_user_username_uindex` (`username`),
  KEY `department_id` (`department_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','管理员','11a254dab80d52bc4a347e030e54d861a9d2cdb2af2185a9ca4a7318e830d04d','666','15888889900',1,1,'a/1.jpg','1',1,221,0,' ',1,1,1,1,0,'2020-01-25 16:00:00','2020-01-25 16:00:00'),(2,'test','test','34783fb724b259beb71a1279f7cd93bdcfd92a273d566f926419a37825c500df','087c2e9857f35f1e243367f3b89b81c1','15888889901',1,1,'a/2.jpg','2',9,0,33,' ',1,2,1,1,0,'2020-01-25 16:00:00','2020-01-25 16:00:00'),(3,'13699299839','孙大圣','11a254dab80d52bc4a347e030e54d861a9d2cdb2af2185a9ca4a7318e830d04d','666','15888889902',2,1,'a/3.jpg','3',2,992,0,' ',1,1,1,1,0,'2020-01-25 16:00:00','2020-01-25 16:00:00');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_messages`
--

DROP TABLE IF EXISTS `user_messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_messages` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '发布者user id',
  `title` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '标题',
  `contents` varchar(5000) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '内容',
  `images` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '展示图',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态，0：删除，1：正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户留言表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_messages`
--

LOCK TABLES `user_messages` WRITE;
/*!40000 ALTER TABLE `user_messages` DISABLE KEYS */;
INSERT INTO `user_messages` VALUES (1,3,'我是标题','我是内容啊','',1,'2020-07-03 07:16:29',NULL),(2,3,'我是标题2','我是内容啊2','',1,'2020-07-03 07:21:30',NULL);
/*!40000 ALTER TABLE `user_messages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-03 15:34:31
