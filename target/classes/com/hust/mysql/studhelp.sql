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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�γ̱�';
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
INSERT INTO `examschedule` VALUES ('12345','JLPT N2','2018-07-01','�����������','���пƼ���ѧ�����ѧԺ','2018-03-27-22-22-31'),('12345','CET 6','2018-06-28','��ѧӢ����������','��ʮ��¥','2018-03-27-22-22-40');


DROP TABLE IF EXISTS `memo`;
CREATE TABLE `memo` (
  `student_id` varchar(30) NOT NULL,
  `create_time` varchar(45) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `detail` varchar(1000) DEFAULT NULL,
  `home` int(2) DEFAULT NULL COMMENT '��ҳ���� 1:�� 0:��',
  PRIMARY KEY (`student_id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `memo` VALUES ('12345','2018-03-29-16-10-25','������ݽṹ�ʼ�','����ѧϰ�����µ�֪ʶ          \n---------------------------------------\n��ɹ���B���ıʼ�               \n---------------------------------------\n��ϰ�������ɾ�������\n--------------------------------------\n��ɿκ���ϰ',1),('12345','2018-04-05-14-48-22','��������','�����ѧ�����¿�ʼ\n\n��������ȥ��ѧ������Ľ������������������',1),('qq200258','2018-04-19-20-42-08','��ϰ','1',1);


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `collage` varchar(45) DEFAULT NULL COMMENT '����ѧԺ',
  `major` varchar(45) DEFAULT NULL COMMENT 'רҵ',
  `grade` int(11) DEFAULT NULL COMMENT '�꼶',
  `class_no` int(11) DEFAULT NULL COMMENT '�༶',
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  `introduction` varchar(300) DEFAULT '��һ����,ʲôҲû����',
  `isphonesecret` tinyint(1) DEFAULT '1',
  `ismailsecret` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='1��ѧ��\n2����ְ��';
INSERT INTO `user` VALUES ('12345','1','����','��','��Ϣ��ѧ����ѧԺ','�������',2016,55,'13012345678','12345@qq.com',1,'����˺�����ʲôҲû����',1,0);