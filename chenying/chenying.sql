/*
 Navicat MySQL Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : chenying

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 08/04/2019 00:16:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('chengying', '123456789');
INSERT INTO `admin` VALUES ('liming', '123456789');

-- ----------------------------
-- Table structure for dangfei
-- ----------------------------
DROP TABLE IF EXISTS `dangfei`;
CREATE TABLE `dangfei`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bianhao` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `idcard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `zhibu` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属支部',
  `totalmoney` int(5) NULL DEFAULT NULL COMMENT '党员缴纳金额',
  `time` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '缴纳党费时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dangfei
-- ----------------------------
INSERT INTO `dangfei` VALUES (1, '0001', '李明', '5455645456', '广州支部', 0, '2018/7/14');
INSERT INTO `dangfei` VALUES (2, '0001', '李明', '5455645456', '广州支部', 200, '2019/04/08');

-- ----------------------------
-- Table structure for dangshi
-- ----------------------------
DROP TABLE IF EXISTS `dangshi`;
CREATE TABLE `dangshi`  (
  `id` int(1) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dangshi
-- ----------------------------
INSERT INTO `dangshi` VALUES (1, '毛儿盖会议(1935年8月20日)', 'http://dangshi.people.com.cn/GB/165617/166496/168108/10011296.html');
INSERT INTO `dangshi` VALUES (2, '瞭望智库：毛泽东去世前几小时反复11次做这件事', 'http://news.sina.com.cn/c/2018-09-09/doc-ihivtsyk6948457.shtml');
INSERT INTO `dangshi` VALUES (3, '毛泽东五次说过此人不可重用 此人到底是谁？', 'http://news.ifeng.com/a/20181229/60218859_0.shtml');
INSERT INTO `dangshi` VALUES (4, '周恩来温文尔雅轻易不发火 为何老部长们最怕他？', 'https://military.china.com/history4/62/20180306/32160676_all.html');
INSERT INTO `dangshi` VALUES (5, '邓小平逝世22周年｜他始终与人民群众在一起', 'http://www.mod.gov.cn/education/2019-02/19/content_4836440.htm');

-- ----------------------------
-- Table structure for fazhan
-- ----------------------------
DROP TABLE IF EXISTS `fazhan`;
CREATE TABLE `fazhan`  (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `bianhao` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '编号',
  `name` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态  未婚',
  `biaoxian` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会议表现',
  `chuqing` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出勤率',
  `workstatus` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '工作状态',
  `sixiang` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '思想总结',
  `idcard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fazhan
-- ----------------------------
INSERT INTO `fazhan` VALUES (1, '0001', '李明', '男', '未婚', '积极提出问题，帮助领导思考解决方案', '80%', '良好', '认真，谦虚，虚心请教。', '460200158803650202');
INSERT INTO `fazhan` VALUES (2, '0002', '阿明', '男', '未婚', '良好', '99%', '良好', '好', '321312312321');

-- ----------------------------
-- Table structure for gaoceng
-- ----------------------------
DROP TABLE IF EXISTS `gaoceng`;
CREATE TABLE `gaoceng`  (
  `id` int(1) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gaoceng
-- ----------------------------
INSERT INTO `gaoceng` VALUES (1, '薪酬榜来了！这9类程序员上榜：AI第1 全栈第3，你排第几？', 'https://blog.csdn.net/csdnnews/article/details/89008010');
INSERT INTO `gaoceng` VALUES (2, '透视全国两会十大民生话题', 'https://baijiahao.baidu.com/s?id=1628507462022544875&wfr=spider&for=pc');
INSERT INTO `gaoceng` VALUES (3, '习近平:誓言铮铮这一年', 'http://news.cctv.com/2019/03/17/ARTIO6P8jS3K1oG8W7cv53k8190317.shtml');
INSERT INTO `gaoceng` VALUES (4, '传达学习贯彻全国两会精神', 'http://news.sina.com.cn/o/2019-03-21/doc-ihtxyzsk9169852.shtml');
INSERT INTO `gaoceng` VALUES (5, '着力解决民生热点痛点问题', 'http://theory.gmw.cn/2019-03/10/content_32622506.htm');

-- ----------------------------
-- Table structure for jibing
-- ----------------------------
DROP TABLE IF EXISTS `jibing`;
CREATE TABLE `jibing`  (
  `id` int(1) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jibing
-- ----------------------------
INSERT INTO `jibing` VALUES (1, '2019年全市疾病预防控制工作会议解读', 'http://www.zmdnews.cn/showinfo-48-520679-0.html');
INSERT INTO `jibing` VALUES (2, '首款产后抑郁症药 ', 'https://baijiahao.baidu.com/s?id=1628578394522327664&wfr=spider&for=pc');
INSERT INTO `jibing` VALUES (3, '北京市疾控中心2019年2月份新闻稿', 'http://www.bjcdc.org/article/55570/2019/2/1550131212114.html');
INSERT INTO `jibing` VALUES (4, '工业大麻概念进入风口 汉麻集团成资本市场香饽饽', 'https://baijiahao.baidu.com/s?id=1628105168777766766&wfr=spider&for=pc');
INSERT INTO `jibing` VALUES (5, '聊城假药罗生门', 'https://baijiahao.baidu.com/s?id=1628406470765341156&wfr=spider&for=pc');

-- ----------------------------
-- Table structure for shidai
-- ----------------------------
DROP TABLE IF EXISTS `shidai`;
CREATE TABLE `shidai`  (
  `id` int(1) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `usr` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shidai
-- ----------------------------
INSERT INTO `shidai` VALUES (1, '全国政协十三届二次会议在京开幕', 'http://zggcmhw.com/content/16207/2018-12-03/f6072a71078a4dfa98c45a93e2cc7d35.htm');
INSERT INTO `shidai` VALUES (2, '党支部工作这么干', 'http://zggcmhw.com/content/16207/2018-12-03/f6072a71078a4dfa98c45a93e2cc7d35.html');
INSERT INTO `shidai` VALUES (3, '“回眸改革开放40年 开启两新党建新征程”', 'http://zggcmhw.com/content/16207/2018-10-16/5db8ca2057be489aa01080d39b38d1b0.html');
INSERT INTO `shidai` VALUES (4, '人民日报要论：用好治理大党大国的\"法宝\"', 'http://zggcmhw.com/content/16207/2018-12-03/f6072a71078a4dfa98c45a93e2cc7d35.htm');
INSERT INTO `shidai` VALUES (5, '全国政协文艺界社科界委员畅谈聆听总书记讲话心得', 'http://zggcmhw.com/content/16202/2019-03-05/8423c722be8b4219a2c4aa4284318202.html');

-- ----------------------------
-- Table structure for tongzhi
-- ----------------------------
DROP TABLE IF EXISTS `tongzhi`;
CREATE TABLE `tongzhi`  (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tongzhi
-- ----------------------------
INSERT INTO `tongzhi` VALUES (2, '明天交党费', '李明');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `minzu` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '民族',
  `jiguan` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '籍贯',
  `phone` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式',
  `idcard` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `birthday` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '出生年月',
  `work` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '职业',
  `education` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文化程度',
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '现居地',
  `rudangtime` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入党时间',
  `people` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '入党推荐人',
  `zhibu` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属支部(海南支部)',
  `status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态(已婚)',
  `bianhao` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '党员编号 0001',
  `zhibubianhao` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支部编号6598',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '李明', '男', '汉', '四川', '18802006789', '5465454645656', '1996-01-03', '教师', '大学本科', '四川达州', '2018-10-01', '航华', '成都支部', '未婚', '0001', '0002');

-- ----------------------------
-- Table structure for zhibu
-- ----------------------------
DROP TABLE IF EXISTS `zhibu`;
CREATE TABLE `zhibu`  (
  `id` int(1) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhibu
-- ----------------------------
INSERT INTO `zhibu` VALUES (1, '三亚市大力推进党支部规范化建设！', 'https://baijiahao.baidu.com/s?id=1620969896706568039&wfr=spider&for=pc');
INSERT INTO `zhibu` VALUES (2, '信息中心党支部组织开展主题党日学习活动', 'http://www.most.gov.cn/jgdj/jcdt/201903/t20190315_145705.htm');
INSERT INTO `zhibu` VALUES (3, '交流中心第三党支部召开组织生活会', 'http://www.most.gov.cn/jgdj/jcdt/201903/t20190315_145705.htm');
INSERT INTO `zhibu` VALUES (4, '战略规划司“思创”青年小组赴阿里巴巴北京总部调研', 'http://www.most.gov.cn/jgdj/jcdt/201903/t20190307_145454.htm');
INSERT INTO `zhibu` VALUES (5, '交流中心召开中心组（扩大）学习会传达学习有关文件精神', 'http://www.most.gov.cn/jgdj/jcdt/201903/t20190307_145453.htm');

-- ----------------------------
-- Table structure for zhibuinfo
-- ----------------------------
DROP TABLE IF EXISTS `zhibuinfo`;
CREATE TABLE `zhibuinfo`  (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支部名称',
  `bianhao` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '支部编号',
  `people` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `address` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhibuinfo
-- ----------------------------
INSERT INTO `zhibuinfo` VALUES (2, '成都支部', '0002', '李丽', '18802006598', '四川成都温江');

-- ----------------------------
-- Table structure for zhishu
-- ----------------------------
DROP TABLE IF EXISTS `zhishu`;
CREATE TABLE `zhishu`  (
  `id` int(11) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zhishu
-- ----------------------------
INSERT INTO `zhishu` VALUES (1, '“回眸改革开放40年 开启两新党建新征程”', '16/5db8ca2057be489aa01080d39b38d1b0.html');
INSERT INTO `zhishu` VALUES (2, '测试', '16/5db8ca2057be489aa01080d39b38d1b0.html');

SET FOREIGN_KEY_CHECKS = 1;
