/*
Navicat MySQL Data Transfer

Source Server         : Lk_contention
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : s_test2

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-03-24 20:56:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT '系统管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123', '视频管理员');
INSERT INTO `admin` VALUES ('2', 'sa', 'sa', '系统管理员');
INSERT INTO `admin` VALUES ('3', 'sheep', '123', '用户管理员');
INSERT INTO `admin` VALUES ('4', 'ych', '123', '系统管理员');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '正能量', '2018-01-18 12:30:43');
INSERT INTO `category` VALUES ('2', '搞笑', '2018-01-18 12:30:53');
INSERT INTO `category` VALUES ('3', '技术', '2018-01-18 12:31:41');
INSERT INTO `category` VALUES ('4', '美女', '2019-01-25 16:06:56');
INSERT INTO `category` VALUES ('5', '动物', '2019-01-25 16:09:02');
INSERT INTO `category` VALUES ('6', '美食', '2019-01-25 16:09:28');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` bigint(10) NOT NULL AUTO_INCREMENT,
  `vedio_id` bigint(10) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `comment _date` datetime DEFAULT NULL,
  `creator` bigint(20) NOT NULL,
  PRIMARY KEY (`cid`),
  KEY `user_comment_pk` (`creator`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '11', 'nihoa', null, '1');
INSERT INTO `comment` VALUES ('6', '14', 'nihoa', '2019-01-25 19:29:44', '1');
INSERT INTO `comment` VALUES ('8', '5', 'nihoa', '2019-02-25 20:40:47', '1');
INSERT INTO `comment` VALUES ('9', '5', 'nihoa', '2019-02-25 20:41:02', '1');
INSERT INTO `comment` VALUES ('10', '2', 'nihoa', '2019-03-22 21:05:47', '1');

-- ----------------------------
-- Table structure for recomment
-- ----------------------------
DROP TABLE IF EXISTS `recomment`;
CREATE TABLE `recomment` (
  `r_id` bigint(255) NOT NULL AUTO_INCREMENT,
  `video_id` int(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `content` text,
  `prase_count` int(11) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recomment
-- ----------------------------
INSERT INTO `recomment` VALUES ('1', '1', '1', 'fdsafa', '32', '2019-03-23 20:52:23');
INSERT INTO `recomment` VALUES ('2', '32', '1', 'gfasdgasdf', '23', '2019-03-23 22:57:01');
INSERT INTO `recomment` VALUES ('3', '32', '1', 'gdfsg', '23', '2019-03-23 23:37:44');
INSERT INTO `recomment` VALUES ('4', '32', '1', 'gdsf', '2', '2019-03-23 23:37:48');
INSERT INTO `recomment` VALUES ('5', '32', '1', 'gdsfhg', '32', '2019-03-23 23:37:51');
INSERT INTO `recomment` VALUES ('6', '32', '1', 'gdfs', '23', '2019-03-23 23:37:54');
INSERT INTO `recomment` VALUES ('7', '23', '1', '发士大夫', '34', '2019-03-24 18:15:39');
INSERT INTO `recomment` VALUES ('8', '18', '1', '山东分公司', '3', '2019-03-24 18:22:52');
INSERT INTO `recomment` VALUES ('9', '18', '1', '发大水非法手段', '4', '2019-03-24 18:25:38');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `user_nickname` varchar(20) DEFAULT NULL,
  `user_price` varchar(255) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'blue', '123456', '杨先森', '1.jpg', null, '18776819804');
INSERT INTO `user` VALUES ('2', 'sheepych', '123456', '杨先森', '1.jpg', '2018-01-14 20:02:54', '18776819804');
INSERT INTO `user` VALUES ('4', 'mama', 'ma123456.@', 'mama', '1.jpg', '2019-02-17 18:28:37', '13158706205');
INSERT INTO `user` VALUES ('5', 'nihao', 'l123.', 'nihao', '1.jpg', '2019-02-26 14:45:55', '15803216785');
INSERT INTO `user` VALUES ('6', 'test2', 'l123456.', 'test2', '1.jpg', '2019-02-26 14:50:05', '1678775053');
INSERT INTO `user` VALUES ('7', 'test3', 'l66666666.', 'test3', '1.jpg', '2019-02-26 14:52:19', '1678775054');
INSERT INTO `user` VALUES ('8', 'test4', 'Ll123456.', 'test4', '1.jpg', '2019-02-26 14:54:33', '13564897945');
INSERT INTO `user` VALUES ('9', 'test5', 'Li12345!', 'test5', '1.jpg', '2019-02-26 15:39:32', '17389565675');
INSERT INTO `user` VALUES ('10', 'test6', 'Li123!', 'test6', '1.jpg', '2019-02-26 16:48:06', '17389705939');
INSERT INTO `user` VALUES ('11', 'test7', 'Li234#', 'test7', '1.jpg', '2019-02-26 16:50:23', '17389705939');
INSERT INTO `user` VALUES ('12', 'test7', 'Li234#', 'test7', '1.jpg', '2019-02-26 16:51:38', '17389705939');
INSERT INTO `user` VALUES ('13', 'test8', 'Li234#', 'test8', '1.jpg', '2019-02-26 16:52:59', '17389705939');
INSERT INTO `user` VALUES ('14', 'test9', 'Li123@', 'test9', '1.jpg', '2019-02-26 16:59:43', '17389705939');
INSERT INTO `user` VALUES ('15', 'test9', 'Li123@', 'test9', '1.jpg', '2019-02-26 17:00:24', '17389705939');
INSERT INTO `user` VALUES ('16', 'test9', 'Li123@', 'test9', '1.jpg', '2019-02-26 17:00:24', '17389705939');
INSERT INTO `user` VALUES ('17', 'test10', 'Li123!', 'test10', '1.jpg', '2019-02-26 17:02:31', '17389705939');
INSERT INTO `user` VALUES ('18', 'ttest1', 'Li123!', 'ttest1', '1.jpg', '2019-02-26 17:05:39', '17389705939');
INSERT INTO `user` VALUES ('19', 'tttt3', 'Li123!', 'tttt3', '1.jpg', '2019-02-26 17:18:00', '17389705939');
INSERT INTO `user` VALUES ('20', 'tttt3', 'LIu1234!', 'tttt3', '1.jpg', '2019-02-26 17:28:55', '17389705939');
INSERT INTO `user` VALUES ('21', 'tttt5', 'LIu', 'tttt5', '1.jpg', '2019-02-26 17:31:51', '17389705939');
INSERT INTO `user` VALUES ('22', 'teeee', 'Li123!', 'teeee', '1.jpg', '2019-02-26 17:43:24', '12738970593');
INSERT INTO `user` VALUES ('23', 'twst5', 'Liu1234#', 'twst5', '1.jpg', '2019-02-26 17:55:05', '17389705939');
INSERT INTO `user` VALUES ('24', 'tesdt4``', 'werwerwerwe', 'tesdt4``', '1.jpg', '2019-02-26 17:56:08', '15803428217');
INSERT INTO `user` VALUES ('25', 'gsdfgsdfg', '543535', 'gsdfgsdfg', '1.jpg', '2019-02-26 17:59:04', '13158706205');
INSERT INTO `user` VALUES ('26', 'gfdsg', 'ertwtwet', 'gfdsg', '1.jpg', '2019-02-26 18:02:33', '13158706205');
INSERT INTO `user` VALUES ('27', 'teee', 'Liu123!', 'teee', '1.jpg', '2019-02-26 20:13:25', '17389705939');
INSERT INTO `user` VALUES ('28', 'fasdfas', '1', 'fasdfas', '1.jpg', '2019-02-26 20:13:47', '15803428217');
INSERT INTO `user` VALUES ('29', 'dfgjh', 'ghfjghj', 'dfgjh', '1.jpg', '2019-02-26 20:24:50', '17389705939');
INSERT INTO `user` VALUES ('30', 'nihoa', 'Li123!', 'nihoa', '1.jpg', '2019-02-26 20:39:45', '17389705939');
INSERT INTO `user` VALUES ('31', null, null, null, '', null, null);

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(50) DEFAULT NULL,
  `movie_year` int(10) DEFAULT NULL,
  `show_time` datetime DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `options` varchar(50) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `grade` double DEFAULT '0',
  `downloads` bigint(50) DEFAULT '0',
  `plays` bigint(50) DEFAULT '0',
  `user_id` bigint(20) DEFAULT NULL,
  `mv_type` varchar(255) DEFAULT NULL,
  `img_type` varchar(255) DEFAULT NULL,
  `category_id` bigint(10) NOT NULL,
  `slider_image` varchar(10) DEFAULT '',
  `admin_id` int(2) DEFAULT NULL,
  `isplay` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_movie_pk` (`user_id`),
  KEY `category_movie_fk` (`category_id`),
  KEY `admin_pk` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '陈可辛-三分钟', '2018', '2018-01-31 00:00:00', '陈可辛', '00:07:45', 'iPhone X 拍摄的三分钟', '4', '0', '2158', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '1.jpg', '1', '.jpg', '1', '0');
INSERT INTO `video` VALUES ('2', '心理罪之城市之光', '2017', '2017-12-27 10:50:39', '刘诗诗', '1：30：14', '刘诗诗、邓超、阮经天联袂主演', '5', '2312', '1261', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '2.jpg', '1', '.jpg', '1', '0');
INSERT INTO `video` VALUES ('3', '罪途2之救赎代', null, '2018-04-30 00:00:00', '马小刚', '63:49', '罪途2之救赎代', '5', '0', '7', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '3.jpg', '1', '', null, '0');
INSERT INTO `video` VALUES ('4', '国家宝藏', null, '2018-02-18 00:00:00', '张国立', '1:10:31', '[国家宝藏]1210期：“越王勾践剑”真容再现', '4', '0', '9', '2', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '4.jpg', '4', '', null, '0');
INSERT INTO `video` VALUES ('5', '罪途1之死亡列车', null, '2018-01-31 00:00:00', '马小刚', '1:11:08', '罪途1之死亡列车', '5', '0', '7', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '5.jpg', '1', '', null, '0');
INSERT INTO `video` VALUES ('6', '海贼王01', '1999', '1999-10-20 00:00:00', '尾田荣一郎', '00:30:21', '海贼王', '5', '3', '230', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '6.jpg', '3', '', '1', '1');
INSERT INTO `video` VALUES ('7', '海贼王02', '1999', '1999-10-20 00:00:00', '尾田荣一郎', '00:30:21', '海贼王', '5', '3', '262', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '7.jpg', '3', '', '1', '1');
INSERT INTO `video` VALUES ('8', '海贼王03', '1999', '1999-10-20 00:00:00', '尾田荣一郎', '00:30:22', '海贼王', '5', '3', '235', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '8.jpg', '3', '', '1', '1');
INSERT INTO `video` VALUES ('9', '海贼王04', '1999', '1999-10-20 00:00:00', '尾田荣一郎', '00:30:21', '海贼王', '5', '3', '226', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '9.jpg', '3', '', '1', '0');
INSERT INTO `video` VALUES ('10', '海贼王05', '1999', '1999-10-20 00:00:00', '尾田荣一郎', '00:30:20', '海贼王', '5', '3', '222', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '10.jpg', '3', '', '1', '1');
INSERT INTO `video` VALUES ('11', '记忆大师', '2017', '2017-11-25 14:39:58', '杨江', '0:50:06', '记忆大师', '4', '0', '27', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '11.jpg', '1', '', '1', '0');
INSERT INTO `video` VALUES ('12', '猎场01', '2017', '2017-12-01 13:23:51', '胡歌', '0:5:33', '猎场', '4', '0', '1347', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '12.jpg', '2', '', '1', '0');
INSERT INTO `video` VALUES ('13', '猎场02', '2017', '2017-12-01 13:23:51', '胡歌', '0:5:00', '猎场', '4', '0', '7', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '13.jpg', '7', '', '1', '0');
INSERT INTO `video` VALUES ('14', '猎场03', '2017', '2017-12-01 13:23:51', '胡歌', '0:45:00', '猎场', '4', '0', '3', '2', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '14.jpg', '2', '', '1', '0');
INSERT INTO `video` VALUES ('15', '猎场04', '2017', '2017-12-01 13:23:51', '胡歌', '0:45:00', '猎场', '4', '0', '1', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '15.jpg', '2', '', '1', '1');
INSERT INTO `video` VALUES ('16', '猎场05', '2017', '2017-12-01 13:23:51', '胡歌', '0:45:00', '猎场', '4', '0', '0', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '16.jpg', '2', '', '1', '1');
INSERT INTO `video` VALUES ('17', '蓝精灵', '2017', '2017-11-25 14:46:45', '蓝精灵', '1:49:03', '蓝精灵', '4', '0', '16', '2', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '17.jpg', '1', '', '1', '1');
INSERT INTO `video` VALUES ('18', '麻烦家族', '2017', '2017-06-24 00:00:00', '吴刚', '1:32:08', '麻烦家族', '3', '0', '45', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '18.jpg', '1', '', null, '0');
INSERT INTO `video` VALUES ('19', '莫斯科行动01', '2018', '2018-01-25 13:40:45', '王刚刚', '00:41:21', '莫斯科行动', '3', '0', '128', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '19.jpg', '2', '', '1', '0');
INSERT INTO `video` VALUES ('20', '莫斯科行动02', '2018', '2018-01-25 13:40:45', '王刚刚', '00:41:21', '莫斯科行动', '3', '0', '124', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '20.jpg', '2', '', '1', '0');
INSERT INTO `video` VALUES ('21', '莫斯科行动03', '2018', '2018-01-25 13:40:45', '王刚刚', '00:41:21', '莫斯科行动', '3', '0', '124', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '21.jpg', '7', '', '1', '0');
INSERT INTO `video` VALUES ('22', '莫斯科行动04', '2018', '2018-01-25 13:40:45', '王刚刚', '00:41:21', '莫斯科行动', '3', '0', '127', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '22.jpg', '2', '', '1', '0');
INSERT INTO `video` VALUES ('23', '莫斯科行动05', '2018', '2018-01-25 13:40:45', '王刚刚', '00:41:21', '莫斯科行动', '3', '0', '130', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '23.jpg', '2', '', '1', '0');
INSERT INTO `video` VALUES ('24', '名侦探柯南01', '1996', '1996-01-08 00:00:00', '山本太一郞', '00:31:09', '名侦探柯南', '5', '0', '217', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '15.jpg', '3', '', null, '0');
INSERT INTO `video` VALUES ('25', '名侦探柯南02', '1996', '1996-01-08 00:00:00', '山本太一郞', '00:31:09', '名侦探柯南', '5', '0', '214', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '16.jpg', '3', '', null, '1');
INSERT INTO `video` VALUES ('26', '名侦探柯南03', '1996', '1996-01-08 00:00:00', '山本太一郞', '00:31:11', '名侦探柯南', '5', '0', '215', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '17.jpg', '3', '', null, '0');
INSERT INTO `video` VALUES ('27', '名侦探柯南04', '1996', '1996-01-08 00:00:00', '山本太一郞', '00:31:09', '名侦探柯南', '5', '0', '214', '1', '939be546-e356-4a25-9524-a6a77f310d49.mp4', '13.jpg', '3', '', null, '1');
INSERT INTO `video` VALUES ('28', '青春旅社01', '2017', '2017-12-25 14:14:35', '秦春', '1:31:35', '青春旅社', '5', '0', '12348', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '6.jpg', '4', '', '1', '0');
INSERT INTO `video` VALUES ('30', '声临其境02', '2018', '2018-01-25 14:10:27', '徐晴', '01:30:21', '声临其境', '3', '0', '24', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '2.jpg', '4', '', '1', '1');
INSERT INTO `video` VALUES ('31', '声临其境03', '2018', '2018-01-25 14:10:27', '徐晴', '01:30:21', '声临其境', '3', '0', '24', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '9.jpg', '4', '', '1', '1');
INSERT INTO `video` VALUES ('32', '神奇女侠', '2017', '2017-08-25 15:12:01', '神奇女侠', '1:42:31', '神奇女侠', '5', '0', '23160', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '16.jpg', '1', '.jpg', '1', '0');
INSERT INTO `video` VALUES ('48', 'test7', '2019', '2019-03-21 20:03:28', 'admin', null, '视屏测试', '3', '0', '1', null, '4530e556-0781-4e73-8b87-51c2919749d9.mp4', '857dbd934bd54a07abc4461f8a7ef886.jpg', '1', '', '1', '0');
INSERT INTO `video` VALUES ('49', '抖音一', '2019', '2019-03-21 22:01:41', 'admin', null, '抖音一', '3', '0', '0', null, '2390d9b3-3d2c-4079-aad0-49bfe0eff4d2.mp4', '5ed8eb3a56994f52bc4a280e59c5e60b.png', '5', '', '1', '0');
INSERT INTO `video` VALUES ('50', '抖音二', '2019', '2019-03-21 22:02:12', 'admin', null, '抖音二', '4', '0', '0', null, 'adaa5dbb-4e4c-4287-8e15-c8dbc915bca6.mp4', 'd09f370db6494f35bc8dd3ad970ff26f.png', '5', '', '1', '0');
INSERT INTO `video` VALUES ('51', '抖音三', '2019', '2019-03-21 22:02:34', 'admin', null, '抖音三', '1', '0', '0', null, '7dd8c869-792b-4b7d-b311-463749078358.mp4', 'ee62537a541d4574bf3d7ea39244a781.png', '5', '', '1', '0');
INSERT INTO `video` VALUES ('52', '抖音四', '2019', '2019-03-21 22:02:53', 'admin', null, '抖音四', '1', '0', '2', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '2e86f2d54c8e41df8ee9f818f4b518da.png', '5', '', '1', '0');
INSERT INTO `video` VALUES ('53', '抖音五', '2019', '2019-03-21 22:03:28', 'admin', null, '抖音五', '1', '0', '0', null, 'ae6f4aa7-2e93-488d-a426-1bffd2705188.mp4', '320a84f5a96e4524808704db7a731177.png', '5', '', '1', '0');
INSERT INTO `video` VALUES ('54', '抖音六', '2019', '2019-03-21 22:03:57', 'admin', null, '抖音六', '1', '0', '0', null, '0b90dbc6-7cfb-4d4a-9e95-b751edfc6c70.mp4', 'da5b7d6155154e78a82bc0692ea69602.png', '7', '', '1', '0');
INSERT INTO `video` VALUES ('55', '抖音七', '2019', '2019-03-21 22:04:34', 'admin', null, '抖音七', '5', '0', '0', null, 'bdb82621-944a-46d8-8fc5-15feab99746a.mp4', 'd9288fc5c1c148c5a6fe05cd93d699d8.png', '5', '', '1', '0');
INSERT INTO `video` VALUES ('56', '网易云一', '2019', '2019-03-21 22:05:23', 'admin', null, '网易云一', '3', '0', '0', null, 'd53ea8d9-62c4-4b11-806a-82ff77102566.mp4', '119311ad15284afe9f7d65cfb081cd03.png', '6', '', '1', '0');
INSERT INTO `video` VALUES ('57', '网易云二', '2019', '2019-03-21 22:05:54', 'admin', null, '网易云二', '4', '0', '0', null, '512f1035-9a3c-4be1-96cc-6a0ab69b3670.mp4', 'd74753c6920c494f84fb384fe994c79f.png', '6', '', '1', '0');
INSERT INTO `video` VALUES ('58', '网易云三', '2019', '2019-03-21 22:06:19', 'admin', null, '网易云三', '1', '0', '3', null, '7dd8c869-792b-4b7d-b311-463749078358.mp4', 'ee62537a541d4574bf3d7ea39244a781.png', '6', '', '1', '0');
INSERT INTO `video` VALUES ('59', '网易云四', '2019', '2019-03-21 22:06:44', 'admin', null, '网易云四', '1', '0', '2', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', 'bbed5550a6134e239acec83714c7d526.png', '6', '', '1', '0');
INSERT INTO `video` VALUES ('60', '网易云五', '2019', '2019-03-21 22:07:25', 'admin', null, '网易云五', '3', '0', '1', null, '9dd053a7-dd2d-489e-aace-1903097136ed.mp4', '177d27a3dc2e4271961a9cc167903df4.png', '6', '', '1', '0');
INSERT INTO `video` VALUES ('61', '网易六', '2019', '2019-03-21 22:07:53', 'admin', null, '网易六', '1', '0', '1', null, 'ed954cd9-eb16-432e-a774-a354f23972a4.mp4', '8d0444d4271046a9851449300ef7428f.png', '6', '', '1', '0');
INSERT INTO `video` VALUES ('62', '创业一', '2019', '2019-03-21 22:11:33', 'admin', null, '敢死队风格', '1', '0', '0', null, '74ddf1ae-0d3b-48e8-97b3-f6976322b665.mp4', 'cfcb54c501024cc1a5982463cbe593dc.png', '7', '', '1', '0');
INSERT INTO `video` VALUES ('63', '哈哈哈哈哈', '2019', '2019-03-21 22:11:55', 'admin', null, '发士大夫', '1', '0', '0', null, 'fc6f9791-d4c1-4f67-bde4-b61f0a9ca7b8.mp4', '2a8cf7c1abb2417d9221215a4f860869.png', '7', '', '1', '0');
INSERT INTO `video` VALUES ('72', '嘎达发生过', '2019', '2019-03-22 14:36:23', 'admin', null, '发士大夫', '5', '0', '0', null, '6bcfb981-a34c-4f0d-b778-bf0141b74f39.mp4', 'a2a0d847f9ed4402bbbbc85aede5aa46.png', '8', '', '1', '0');
INSERT INTO `video` VALUES ('73', '微微', '2019', '2019-03-22 14:41:10', 'admin', null, '复古怀旧风格和', '3', '0', '0', null, 'e6447bc4-1d7f-4d35-a798-4d2ee4cb7d33.mp4', '4e65c65047664a1b8ecff2a073588f89.png', '8', '', '1', '0');
INSERT INTO `video` VALUES ('74', 's说法伽', '2019', '2019-03-22 14:45:08', 'admin', null, '告诉对方', '3', '0', '0', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', 'bbed5550a6134e239acec83714c7d526.png', '8', '', '1', '0');
INSERT INTO `video` VALUES ('75', 'g国大使馆', '2019', '2019-03-22 14:45:12', 'admin', null, '高峰时段', '4', '0', '0', null, '4530e556-0781-4e73-8b87-51c2919749d9.mp4', '4530e556-0781-4e73-8b87-51c2919749d9.mp4', '8', '', '1', '0');
INSERT INTO `video` VALUES ('76', 'd的故事的风格', '2019', '2019-03-22 14:45:16', 'admin', null, '给 大夫嘎斯', '2', '0', '0', null, 'bdb82621-944a-46d8-8fc5-15feab99746a.mp4', 'd9288fc5c1c148c5a6fe05cd93d699d8.png', '8', '', '1', '0');
INSERT INTO `video` VALUES ('77', '高峰时段', '2019', '2019-03-22 14:45:20', 'admin', null, '大概是法国', '4', '0', '0', null, '7dd8c869-792b-4b7d-b311-463749078358.mp4', 'ee62537a541d4574bf3d7ea39244a781.png', '8', '', '1', '0');
INSERT INTO `video` VALUES ('78', 'f讽德诵功', '2019', '2019-03-22 14:45:24', 'admin', null, '大夫嘎斯广泛', '1', '0', '0', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '2.jpg', '8', '', '1', '0');
INSERT INTO `video` VALUES ('79', '回到法国', '2019', '2019-03-22 14:45:27', 'admin', null, '广泛大使馆 ', '2', '0', '0', null, '939be546-e356-4a25-9524-a6a77f310d49.mp4', '23.jpg', '8', '', null, '0');
