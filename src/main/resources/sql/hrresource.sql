/*
SQLyog Enterprise - MySQL GUI v6.14
MySQL - 5.5.62 : Database - hrresource
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `hrresource`;

USE `hrresource`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `t_permission` */

DROP TABLE IF EXISTS `t_permission`;

CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `descpt` varchar(50) DEFAULT NULL COMMENT '描述',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单url',
  `create_time` varchar(64) DEFAULT NULL COMMENT '添加时间',
  `order` int(64) DEFAULT NULL COMMENT '顺序码',
  `del_flag` int(1) DEFAULT NULL COMMENT '删除标志（0:删除 1：存在）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `t_permission` */

insert  into `t_permission`(`id`,`name`,`pid`,`descpt`,`url`,`create_time`,`order`,`del_flag`) values (1,'系统管理',0,'系统管理','','2018-11-30 10:27:34',1,1),(2,'账号管理',1,'账号管理','/user/userManage','2018-11-30 11:44:41',2,1),(3,'角色管理',1,'角色管理','/role/roleManage','2018-11-30 11:45:27',3,1),(4,'权限管理',1,'权限管理','/permission/permissionManage','2018-11-30 11:48:35',4,1),(5,'薪酬管理',0,'薪酬管理','','2018-11-30 12:10:32',5,1),(6,'加班工资',5,'加班工资','/salary/jibangongzi','2018-12-04 11:47:07',8,1),(7,'员工薪酬信息',5,'员工薪酬信息','/salary/xinchouxinxi','2018-12-04 11:47:59',6,1),(8,'部门员工岗效',5,'部门员工岗效','/salary/bumenyuangonggangxiao','2018-12-04 11:48:44',7,1),(9,'其他发布',0,'其他发布','/home','2018-12-04 11:49:13',9,1),(10,'信息交流',9,'信息交流','/message','2018-12-04 11:49:36',10,1);

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限角色ID',
  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `permissions` varchar(20) DEFAULT NULL COMMENT '权限',
  `create_time` varchar(64) DEFAULT NULL COMMENT '创建时间',
  `order` int(64) DEFAULT NULL COMMENT '顺序码',
  `role_status` int(1) NOT NULL DEFAULT '1' COMMENT '1：有效 \r\n            0：无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户角色表';

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`role_name`,`role_desc`,`permissions`,`create_time`,`order`,`role_status`) values (1,'ROLE_ADMIN','系统管理员','1,5,9','2018-11-21 15:54:07',1,1),(2,'ROLE_MANAGE','人力资源部主管','1,5,9','2018-11-21 15:11:44',2,1),(3,'ROLE_XINCHOU','人力资源部薪酬管理','5,9',NULL,3,1),(4,'ROLE_JIXIAO','人力资源部绩效管理','5,9',NULL,4,1),(5,'ROLE_RENSHI','人力资源部人事管理','5,9',NULL,5,1),(6,'ROLE_LAOZIYUAN','分厂部门薪酬管理员','5,9',NULL,6,1);

/*Table structure for table `t_role_permission` */

DROP TABLE IF EXISTS `t_role_permission`;

CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjobmrl6dorhlfite4u34hciik` (`permission_id`),
  KEY `FK90j038mnbnthgkc17mqnoilu9` (`role_id`),
  CONSTRAINT `FK90j038mnbnthgkc17mqnoilu9` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKjobmrl6dorhlfite4u34hciik` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_permission` */

insert  into `t_role_permission`(`id`,`permission_id`,`role_id`) values (1,1,1),(2,5,1),(3,1,2),(4,5,2),(5,5,3),(6,5,4),(7,5,5),(8,5,6),(9,1,4),(10,9,1),(11,9,2),(12,9,3),(13,9,4),(14,9,5),(15,9,6);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sys_user_name` varchar(50) NOT NULL COMMENT '系统用户名称',
  `sys_user_pwd` varchar(250) DEFAULT NULL COMMENT '系统用户密码',
  `role_id` int(255) DEFAULT NULL COMMENT '角色',
  `user_phone` varchar(11) NOT NULL COMMENT '手机号',
  `reg_time` varchar(32) NOT NULL COMMENT '登记时间',
  `user_status` int(1) NOT NULL DEFAULT '0' COMMENT '状态（0：无效；1：有效）',
  `user_email` varchar(250) DEFAULT NULL COMMENT '邮箱',
  `user_dept` varchar(250) NOT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统管理员帐号';

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`sys_user_name`,`sys_user_pwd`,`role_id`,`user_phone`,`reg_time`,`user_status`,`user_email`,`user_dept`) values (1,'admin','3ef7164d1f6167cb9f2658c07d3c2f0a',1,'18007012143','2018-11-22 10:57:33',1,NULL,'总经理办'),(2,'张三','6565673a6caee66a6acbd51415bddbda',2,'19563648695','2018-11-22 10:57:33',1,NULL,'人力资源部'),(3,'李四','5e1030d25f5ca46aac4c0369b908d762',6,'11111111111','2018-11-22 11:01:58',1,NULL,'市场部'),(4,'王五','111111',6,'11111111111','2018-11-22 11:02:59',1,NULL,'生产制造部'),(5,'赵六','111111',4,'11111111111','2018-11-22 11:02:59',1,NULL,'人力资源部');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9c8iiy6ut0gnx491fqx4pxam` (`role_id`),
  KEY `FKq5un6x7ecoef5w1n39cop66kl` (`user_id`),
  CONSTRAINT `FKq5un6x7ecoef5w1n39cop66kl` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `FKa9c8iiy6ut0gnx491fqx4pxam` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`role_id`,`user_id`) values (1,1,1),(2,2,2),(3,6,3),(4,6,4),(5,1,5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
