CREATE DATABASE  IF NOT EXISTS `studhelp`;
USE `studhelp`;

DROP TABLE IF EXISTS `bbs`;
CREATE TABLE `bbs` (
  `student_id` varchar(50) NOT NULL,
  `student_name` varchar(45) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `create_time` varchar(45) NOT NULL,
  `detail` varchar(1500) DEFAULT NULL,
  `good` int(11) DEFAULT '0',
  PRIMARY KEY (`student_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `topic_student_id` varchar(30) NOT NULL,
  `create_time` varchar(45) NOT NULL,
  `comment_student_id` varchar(45) NOT NULL,
  `comment_time` varchar(45) NOT NULL,
  `student_name` varchar(45) DEFAULT NULL,
  `comment` varchar(1500) DEFAULT NULL,
  PRIMARY KEY (`topic_student_id`,`create_time`,`comment_student_id`,`comment_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `coursetable`;
CREATE TABLE `coursetable` (
  `student_id` varchar(20) NOT NULL,
  `class_no` int(11) NOT NULL,
  `mon` varchar(100) DEFAULT '',
  `tue` varchar(100) DEFAULT '',
  `wed` varchar(100) DEFAULT '',
  `thu` varchar(100) DEFAULT '',
  `fri` varchar(100) DEFAULT '',
  `sat` varchar(100) DEFAULT '',
  `sun` varchar(100) DEFAULT '',
  PRIMARY KEY (`student_id`,`class_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';
INSERT INTO `coursetable` VALUES ('12345',1,'','','','','','',''),('12345',2,'','','','','','',''),('12345',3,'','','','','','',''),('12345',4,'','','','','','',''),('12345',5,'','','','','','','');


DROP TABLE IF EXISTS `examschedule`;
CREATE TABLE `examschedule` (
  `student_id` varchar(20) NOT NULL,
  `exam_name` varchar(45) DEFAULT NULL,
  `exam_time` varchar(45) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `exam_place` varchar(45) DEFAULT NULL,
  `create_time` varchar(45) NOT NULL,
  PRIMARY KEY (`create_time`,`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `examschedule` VALUES ('12345','JLPT N2','2018-07-01','日语二级考试','华中科技大学外国语学院','2018-03-27-22-22-31'),('12345','CET 6','2018-06-28','大学英语六级考试','西十二楼','2018-03-27-22-22-40');


DROP TABLE IF EXISTS `memo`;
CREATE TABLE `memo` (
  `student_id` varchar(30) NOT NULL,
  `create_time` varchar(45) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `detail` varchar(1000) DEFAULT NULL,
  `home` int(2) DEFAULT NULL COMMENT '首页推送 1:是 0:否',
  PRIMARY KEY (`student_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `memo` VALUES ('12345','2018-03-29-16-10-25','完成数据结构笔记','今天学习第六章的知识          \n---------------------------------------\n完成关于B树的笔记               \n---------------------------------------\n复习链表结点的删除和添加\n--------------------------------------\n完成课后练习',1),('12345','2018-04-05-14-48-22','社团招新','计算机学社招新开始\n\n周三下午去大学生活动中心进行商讨招新相关事宜',1),('qq200258','2018-04-19-20-42-08','自习','1',1);


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `collage` varchar(45) DEFAULT NULL COMMENT '所在学院',
  `major` varchar(45) DEFAULT NULL COMMENT '专业',
  `grade` int(11) DEFAULT NULL COMMENT '年级',
  `class_no` int(11) DEFAULT NULL COMMENT '班级',
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  `introduction` varchar(300) DEFAULT '这家伙很懒,什么也没留下',
  `isphonesecret` tinyint(1) DEFAULT '1',
  `ismailsecret` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='1：学生\n2：教职工';
INSERT INTO `user` VALUES ('12345','1','测试','男','信息科学技术学院','软件工程',2016,55,'13012345678','12345@qq.com',1,'这个人很懒，什么也没留下',1,0);