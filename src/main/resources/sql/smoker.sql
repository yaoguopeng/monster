/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : smoker

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-04-17 18:47:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_island_background
-- ----------------------------
DROP TABLE IF EXISTS `t_island_background`;
CREATE TABLE `t_island_background` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `background_image_path` varchar(255) DEFAULT NULL COMMENT '背景图路径',
  `background_type` varchar(255) DEFAULT NULL COMMENT '背景图类型，标识是哪个页面的背景图',
  `uuid` varchar(50) DEFAULT NULL COMMENT '背景图唯一标识',
  `showing_date_begin` date DEFAULT NULL COMMENT '[开始展示日期',
  `showing_date_end` date DEFAULT NULL COMMENT '结束展示日期]',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】背景图片';

-- ----------------------------
-- Records of t_island_background
-- ----------------------------
INSERT INTO `t_island_background` VALUES ('1', '/image/background-image/0ae8bb41-1aaf-40ff-b5a8-861d0e87032e.jpg', 'INDEX', '0ae8bb41-1aaf-40ff-b5a8-861d0e87032e', '2019-04-09', '2019-04-30', '2019-04-09 17:25:51', 'jsp', '0');
INSERT INTO `t_island_background` VALUES ('2', '/image/background-image/INDEXeffc9934-90db-4c21-9a46-86238bd561a2.jpg', 'INDEX', 'INDEXeffc9934-90db-4c21-9a46-86238bd561a2', '2019-05-01', '2019-06-01', '2019-04-11 16:05:08', 'jsp', '0');
INSERT INTO `t_island_background` VALUES ('3', '/image/background-image/INDEXac8cf68b-7782-49c2-8bdb-b3148376abcb.jpg', 'INDEX', 'INDEXac8cf68b-7782-49c2-8bdb-b3148376abcb', '2019-07-01', '2019-08-01', '2019-04-11 16:08:46', 'jsp', '0');
INSERT INTO `t_island_background` VALUES ('4', '/image/background-image/INDEXfc134ded-6b76-4eab-b243-860e0e6c52f7.jpg', 'INDEX', 'INDEXfc134ded-6b76-4eab-b243-860e0e6c52f7', '2019-09-01', '2019-10-01', '2019-04-11 16:15:33', 'jsp', '0');
INSERT INTO `t_island_background` VALUES ('5', '/image/background-image/INDEX192665e5-7a56-4b6e-bc05-cbbda1913352.jpg', 'INDEX', 'INDEX192665e5-7a56-4b6e-bc05-cbbda1913352', '2019-11-01', '2019-12-01', '2019-04-11 16:17:00', 'jsp', '0');

-- ----------------------------
-- Table structure for t_island_index
-- ----------------------------
DROP TABLE IF EXISTS `t_island_index`;
CREATE TABLE `t_island_index` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `index_content` varchar(500) DEFAULT NULL COMMENT '内容',
  `showing_date_begin` date DEFAULT NULL COMMENT '[起始展示日期',
  `showing_date_end` date DEFAULT NULL COMMENT '结束展示日期]',
  `index_author` varchar(255) DEFAULT NULL COMMENT '作者',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `is_deleted` varchar(255) DEFAULT '0' COMMENT '是否删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】欢迎页面展示内容';

-- ----------------------------
-- Records of t_island_index
-- ----------------------------
INSERT INTO `t_island_index` VALUES ('1', '        这个世界如此美味，我们应该为之努力奋斗！', '2019-04-01', '2019-04-10', '——vacation', '2019-04-04 09:45:36', '1', '0');
INSERT INTO `t_island_index` VALUES ('2', '        做人要像飞刀一样，一定要有目标。', null, null, '——vacation', null, null, '1');
INSERT INTO `t_island_index` VALUES ('3', '        愿你的生命中有足够多的云翳，来制造一个美丽的黄昏。', null, null, '——冰心', null, null, '1');
INSERT INTO `t_island_index` VALUES ('4', '        要避免一见钟情的沉沦，记得不要看她第一眼。', null, null, '——金庸', null, null, '1');
INSERT INTO `t_island_index` VALUES ('5', '        抓一把沙砾放在口袋里吧，它会成为金子。', null, null, '——佚名', null, null, '1');
INSERT INTO `t_island_index` VALUES ('6', '        Smooth seas do not make good sailors.', null, null, '——Somebody', null, null, '1');
INSERT INTO `t_island_index` VALUES ('7', '        C\'est la vie.', null, null, '——Somebody', null, null, '1');
INSERT INTO `t_island_index` VALUES ('8', '        你住的城市下雨了，很想问你有没有带伞，可是我忍住了，因为我怕你说你带了，我就白高兴一场了。', null, null, '—— un sportif en chambre', null, null, '1');
INSERT INTO `t_island_index` VALUES ('9', '        蒙多，想去哪就去哪！', null, null, '——蒙多医生', null, null, '1');
INSERT INTO `t_island_index` VALUES ('10', '        最怕一生碌碌无为却安慰自己平凡可贵。', null, null, '—— un sportif en chambre ', null, null, '1');
INSERT INTO `t_island_index` VALUES ('11', '        人们常说，吃饭可以忘忧。', null, null, '——佚名', null, null, '1');
INSERT INTO `t_island_index` VALUES ('12', '        where are you going?', null, null, '—— un sportif en chambre', null, null, '1');
INSERT INTO `t_island_index` VALUES ('15', '        问君能有几多愁，恰似一江春水向东流', '2019-04-11', '2019-04-11', '——李煜', '2019-04-09 18:02:17', 'jsp', '0');
INSERT INTO `t_island_index` VALUES ('16', '        \r\n    星期天正午，\r\n三角公园后门，\r\n红玫瑰为记，\r\n暗号：地震高岗，一派溪山千古秀；\r\n门朝大海，三河合水万年流', '2019-04-12', '2019-04-13', '——金庸', '2019-04-12 10:07:51', 'jsp', '0');

-- ----------------------------
-- Table structure for t_island_joke
-- ----------------------------
DROP TABLE IF EXISTS `t_island_joke`;
CREATE TABLE `t_island_joke` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `joke_content` varchar(1000) DEFAULT NULL COMMENT '笑话内容',
  `joke_image_path` varchar(255) DEFAULT NULL COMMENT '段子图地址',
  `uuid` varchar(36) DEFAULT NULL COMMENT 'uuid',
  `created_time` datetime DEFAULT NULL COMMENT '入库时间',
  `is_deleted` varchar(255) DEFAULT '0' COMMENT '是否删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】开心一刻';

-- ----------------------------
-- Records of t_island_joke
-- ----------------------------
INSERT INTO `t_island_joke` VALUES ('1', '春分，意思就是春天到了，该分手了。', null, '1', '2019-03-26 11:48:49', '0');
INSERT INTO `t_island_joke` VALUES ('2', '小时候，我妈不止一次跟我说，亲嘴会怀孕，亲嘴会怀孕，结果我家猫跳起来抢肉吃的时候好死不死亲到了我的嘴，过了几个月它还生下了三只小猫……出于责任感，有我一口肉吃，我就不会让那三只小猫吃素！', null, '2', '2019-03-26 11:48:53', '0');
INSERT INTO `t_island_joke` VALUES ('3', '小时候我一次在家写作业，突然停电了，耶耶耶耶耶！终于不用写作业了，可以看电视了。还特二的去开电视，在黑暗的角落里我爸淡淡的说了说声：丑就够倒霉了，还这么傻！', null, '3', '2019-03-26 11:48:56', '0');
INSERT INTO `t_island_joke` VALUES ('4', '在菜市场买菜，看见一个姑娘正在很认真地挑黄瓜。 卖菜大妈很热情地说：姑娘，吃还是用啊？ 姑娘红着脸说：用。 大妈说：哎哎，这根好，又粗又壮的。 姑娘涨红着脸说：我是拿来敷脸的！ 大妈无辜地说：我没别的意思啊，你脸这么大，细的切片也盖不过来啊！', null, '4', '2019-03-26 11:48:58', '0');
INSERT INTO `t_island_joke` VALUES ('5', '        妈妈说梳头的时候照镜子就好了，不用把头摘下来', null, 'd3d13974-93d6-4da8-a2e2-f36f01037581', '2019-04-09 17:54:00', '0');
INSERT INTO `t_island_joke` VALUES ('6', '        ', '/image/joke-image/a22b4c94-e8ad-40c7-8195-c442b7374608.jpg', 'a22b4c94-e8ad-40c7-8195-c442b7374608', '2019-04-11 17:22:53', '0');

-- ----------------------------
-- Table structure for t_island_landscape
-- ----------------------------
DROP TABLE IF EXISTS `t_island_landscape`;
CREATE TABLE `t_island_landscape` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `landscape_image_path` varchar(255) DEFAULT NULL COMMENT '风景图片',
  `landscape_info` varchar(1000) DEFAULT NULL COMMENT '风景介绍',
  `uuid` varchar(36) DEFAULT NULL COMMENT '风景图片唯一标识',
  `showing_date` date DEFAULT NULL COMMENT '展示日期',
  `created_time` datetime DEFAULT NULL COMMENT '创建日期',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】风景推荐';

-- ----------------------------
-- Records of t_island_landscape
-- ----------------------------
INSERT INTO `t_island_landscape` VALUES ('1', '/image/landscape-image/10ac75f8-6ea2-4428-804d-2fc4c425a61f.jpg', '        茶卡盐湖，别称茶卡或达布逊淖尔，是位于青海省海西蒙古族藏族自治州乌兰县茶卡镇的天然结晶盐湖，是柴达木盆地四大盐湖之一。“茶卡”是藏语，意即盐池，也就是青海的盐；“达布逊淖尔”是蒙古语，也是盐湖之意。 \r\n茶卡盐湖气候温凉，干旱少雨，属高原大陆性气候，年平均气温4℃，年平均降水量210.4毫米。湖面海拔3100米，长15.8千米，宽9.2千米，呈椭圆形，总面积105平方千米。  \r\n茶卡盐湖与塔尔寺、青海湖、孟达天池齐名，是“青海四大景”之一，被旅行者们称为中国“天空之镜”，被国家旅游地理杂志评为“人一生必去的55个地方”之一。', null, '2019-04-09', '2019-04-09 17:27:42', 'jsp', '0');

-- ----------------------------
-- Table structure for t_island_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_island_manager`;
CREATE TABLE `t_island_manager` (
  `pk_id` varchar(36) NOT NULL COMMENT '主键',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实名字',
  `registe_name` varchar(255) DEFAULT NULL COMMENT '注册名（唯一，用于登录）',
  `registe_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `bind_email` varchar(11) DEFAULT NULL COMMENT '绑定邮箱',
  `registe_time` datetime DEFAULT NULL COMMENT '注册时间',
  `update_time` datetime DEFAULT NULL COMMENT '更改时间',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】管理员';

-- ----------------------------
-- Records of t_island_manager
-- ----------------------------
INSERT INTO `t_island_manager` VALUES ('1', 'RacherGreen', 'Racher', '1123456', '12345678911', '2019-03-13 16:05:34', null);

-- ----------------------------
-- Table structure for t_island_message
-- ----------------------------
DROP TABLE IF EXISTS `t_island_message`;
CREATE TABLE `t_island_message` (
  `pk_id` varchar(36) NOT NULL COMMENT '主键',
  `unionid` varchar(50) DEFAULT NULL COMMENT '接收消息者',
  `message_content` varchar(255) DEFAULT NULL COMMENT '消息内容',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_read` varchar(10) DEFAULT NULL COMMENT '是否已读',
  `message_type` varchar(255) DEFAULT NULL COMMENT '消息类型',
  `is_deleted` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】消息表';

-- ----------------------------
-- Records of t_island_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_island_motto
-- ----------------------------
DROP TABLE IF EXISTS `t_island_motto`;
CREATE TABLE `t_island_motto` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `motto_author` varchar(255) DEFAULT NULL COMMENT '格言作者',
  `motto_content` varchar(255) DEFAULT NULL COMMENT '格言内容',
  `motto_from` varchar(255) DEFAULT NULL COMMENT '引自哪篇著作',
  `showing_date` date DEFAULT NULL COMMENT '展示日期',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  `updated_by` datetime DEFAULT NULL COMMENT '更新人',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】格言表';

-- ----------------------------
-- Records of t_island_motto
-- ----------------------------
INSERT INTO `t_island_motto` VALUES ('1', '——莎士比亚', '凡是过往，皆为序章。', null, '2019-03-26', '2019-03-18 19:13:38', null, null, null, '0');
INSERT INTO `t_island_motto` VALUES ('2', '——由纪夫', '在冬天光线过于充足的日子里，我透明的心甚至也有光线爬进来。也就是在这种时候，我一边幻想自己身上生出无遮无拦的双翼，一边强烈地预感到自己这一生恐将一事无成。', null, '2019-03-30', '2019-03-20 12:50:49', null, null, null, '0');
INSERT INTO `t_island_motto` VALUES ('3', '——古龙', '如果能让别人笑笑，偶尔做些愚蠢的事情又何妨。', null, '2019-04-01', '2019-03-20 12:58:12', null, null, null, '0');
INSERT INTO `t_island_motto` VALUES ('4', '——鲁智深', '钱塘江上潮信起，今日方知我是我。', null, '2019-04-02', '2019-03-20 13:03:50', null, null, null, '0');
INSERT INTO `t_island_motto` VALUES ('5', '——粤语金句', '食得咸鱼抵得渴，做什么事情都是要付出代价的。', null, '2019-04-04', '2019-03-20 14:35:17', null, null, null, '0');
INSERT INTO `t_island_motto` VALUES ('6', '——小提示', '不要局势不佳就想投降，胜利往往属于坚持到底的选手，翻盘获胜的感觉才是最爽快的。', null, '2019-04-05', '2019-03-20 14:38:20', null, null, null, '0');
INSERT INTO `t_island_motto` VALUES ('7', '——un sportif en chambre', '年轻真好，还能感受来自爱情的伤害', null, '2019-04-29', '2019-04-01 18:16:56', null, null, null, '0');
INSERT INTO `t_island_motto` VALUES ('8', '——somebody', '        世上没有无刺的玫瑰，也不会有无胜利者的战斗！', '《Age of Empires III》', '2018-12-04', '2019-04-04 14:43:59', null, null, null, '0');
INSERT INTO `t_island_motto` VALUES ('9', '——泰戈尔', '        生如夏花之绚烂，死如秋叶之静美。', '《生如夏花》', '2019-04-08', '2019-04-04 17:48:25', 'jsp', null, null, '0');

-- ----------------------------
-- Table structure for t_island_movie
-- ----------------------------
DROP TABLE IF EXISTS `t_island_movie`;
CREATE TABLE `t_island_movie` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `movie_image_path` varchar(1000) DEFAULT NULL COMMENT '电影剧照路径',
  `movie_beautiful_lines` varchar(1000) DEFAULT NULL COMMENT '电影经典台词（以及人物角色名字）',
  `movie_name` varchar(255) DEFAULT NULL COMMENT '电影名称',
  `uuid` varchar(36) DEFAULT NULL COMMENT '唯一标识',
  `showing_date` date DEFAULT NULL COMMENT '展示日期',
  `created_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_deleted` varchar(255) DEFAULT '0' COMMENT '是否删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】电影展示';

-- ----------------------------
-- Records of t_island_movie
-- ----------------------------
INSERT INTO `t_island_movie` VALUES ('1', '/image/movie_image/1.jpg', '岁月匆匆，我后来爱上过很多女人。她们在我的臂膀中问我爱不爱她们，我都会说，爱。但是我最爱的女人，却从未问过我这个问题。', '——《西西里的美丽传说》', '1', '2019-03-26', '1', '2019-03-26 11:15:07', '0');
INSERT INTO `t_island_movie` VALUES ('2', '/image/movie_image/2.jpg', '记忆是痛苦的根源，能够忘记，是你的福气。', '——《功夫》', '2', '2019-03-27', '1', '2019-03-26 11:27:36', '0');
INSERT INTO `t_island_movie` VALUES ('3', '/image/movie_image/3.jpg', 'Women and children can be careless, but not men.', '——《教父》', '3', '2019-03-28', '1', '2019-03-26 11:33:39', '0');
INSERT INTO `t_island_movie` VALUES ('7', '/image/movie_image/d99c0794-4305-4114-ab2f-6ab4eda96bfb.jpg', '        do, try not!', '——《星球大战》', 'd99c0794-4305-4114-ab2f-6ab4eda96bfb', '2019-04-09', 'jsp', '2019-04-09 17:29:18', '0');

-- ----------------------------
-- Table structure for t_island_music
-- ----------------------------
DROP TABLE IF EXISTS `t_island_music`;
CREATE TABLE `t_island_music` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `music_name` varchar(255) DEFAULT NULL COMMENT '歌名',
  `music_path` varchar(255) DEFAULT NULL,
  `music_singer` varchar(255) DEFAULT NULL COMMENT '歌手',
  `music_album` varchar(255) DEFAULT NULL COMMENT '专辑',
  `music_image_path` varchar(255) DEFAULT NULL COMMENT '歌曲配图地址',
  `showing_date` date DEFAULT NULL COMMENT '展示日期',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否删除：1是0否',
  `uuid` varchar(36) DEFAULT NULL COMMENT '唯一标识',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】音乐';

-- ----------------------------
-- Records of t_island_music
-- ----------------------------
INSERT INTO `t_island_music` VALUES ('1', 'going home', '/sound/music/1c21b517-a823-4b48-b75a-6f806fafba15.mp3', 'Sophie Zelmani', 'Decade of dreams 1995-2005', '/image/music_image/1c21b517-a823-4b48-b75a-6f806fafba15.jpg', '2019-03-26', '2019-03-26 12:51:36', '1', '0', '1');
INSERT INTO `t_island_music` VALUES ('2', '《rise》', '/sound/music/1c21b517-a823-4b48-b75a-6f806fafba15.mp3', '——epic', 'epic music', '/image/music_image/1c21b517-a823-4b48-b75a-6f806fafba15.jpg', '2019-04-09', '2019-04-09 17:34:26', 'jsp', '0', '1c21b517-a823-4b48-b75a-6f806fafba15');
INSERT INTO `t_island_music` VALUES ('5', '《444》', '/sound/music/e95460b8-9d80-4b0e-972e-78b95c671dae.docx', '——111', '111', '/image/music_image/e95460b8-9d80-4b0e-972e-78b95c671dae.jpg', '2019-04-03', '2019-04-10 16:58:33', 'jsp', '0', 'e95460b8-9d80-4b0e-972e-78b95c671dae');

-- ----------------------------
-- Table structure for t_island_painting
-- ----------------------------
DROP TABLE IF EXISTS `t_island_painting`;
CREATE TABLE `t_island_painting` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `painting_path` varchar(255) DEFAULT NULL COMMENT '名画图片路径',
  `painting_author` varchar(255) DEFAULT NULL COMMENT '名画作者',
  `painting_info` varchar(5000) DEFAULT NULL COMMENT '名画简介',
  `showing_date` date DEFAULT NULL COMMENT '展示日期',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否删除：1是0否',
  `uuid` varchar(36) DEFAULT NULL COMMENT '唯一标识',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】名画及其介绍';

-- ----------------------------
-- Records of t_island_painting
-- ----------------------------
INSERT INTO `t_island_painting` VALUES ('1', '/image/painting/27179b2b-3a4b-404b-a2f3-549f57f4364b.jpg', '——列奥纳多·达·芬奇', '《蒙娜丽莎》的姿势，已经升华为一种神圣的符号，它不仅仅是艺术规律问题，不仅仅是对文艺复兴人文思想粗糙大潮的冲击，而是心灵回归者、觉醒者心中的一个崇高细致理想的显现。《蒙娜丽莎》具有另一种难以说明的象征意义，如佛的坐势、站势、讲道姿势，菩萨的动势，基督的几种象征性姿势：如两手摊开，一手持十字，一手指天，这有某种非世俗的意味，不是做作，而是不得不是如此，是最不自然最自然，最不简单最简单，最轻松最沉甸甸的样式，你无法赞美它，又无法挑剔它，它就是这样，原始的样子，人们只能沉醉其中，而不能有条理地褒贬它。\r\n一切欺骗与神秘都集中在《蒙娜丽莎》身上，而令人们产生一种畏惧。《蒙娜丽莎》是一个精力充沛的形象，在该幅作品面前，不能说她是女人肖像，她穿越一切无所不见、又视而不见的空洞目光，想躲避是办不到的，而想迎接那目光同样也是枉然。奇异的前额，广阔得失去了一个平凡人的味道，弥漫在脸上的那种神奇表情，似笑、非笑使人们无法相信这是一张现实的脸，而它的存在，又无法使人们的怀疑进行得彻底。《蒙娜丽莎》的表情，像东方佛教中佛陀的表情一样，是非凡人所能做出来的。“蒙娜丽莎”不是因为了什么而微笑，她只是静静地在那，脸上是自然地出现的一种永恒的、无所谓表情的表情。 \r\n 《蒙娜丽莎》的美学意义，主要在于人物形象焕发出的人性的光辉；而在这之前，即使是人的形象，也带有或多或少的宗教气息。 ', '2019-03-26', '2019-03-26 13:12:56', '1', '0', '1');
INSERT INTO `t_island_painting` VALUES ('2', '/image/painting/27179b2b-3a4b-404b-a2f3-549f57f4364b.jpg', '——达芬奇', '蒙娜丽莎的微笑', '2019-04-09', '2019-04-09 17:35:48', 'jsp', '0', '27179b2b-3a4b-404b-a2f3-549f57f4364b');
INSERT INTO `t_island_painting` VALUES ('3', '/image/painting/b84bb0b1-9e9f-4381-9edf-3215af2cdccb.jpg', '——达芬奇', '      dawenxi', null, '2019-04-10 16:37:08', 'jsp', '0', 'b84bb0b1-9e9f-4381-9edf-3215af2cdccb');
INSERT INTO `t_island_painting` VALUES ('4', '/image/painting/135f2455-1122-4a4e-9a6f-31330071aaaf.png', '——aaa', '        sdasdasd', '2019-04-10', '2019-04-10 16:59:17', 'jsp', '0', '135f2455-1122-4a4e-9a6f-31330071aaaf');

-- ----------------------------
-- Table structure for t_island_passage
-- ----------------------------
DROP TABLE IF EXISTS `t_island_passage`;
CREATE TABLE `t_island_passage` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `passage_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `passage_from` varchar(255) DEFAULT NULL COMMENT '作品出处',
  `passage_author` varchar(255) DEFAULT NULL COMMENT '作者',
  `passage_content` varchar(8000) DEFAULT NULL COMMENT '内容',
  `showing_date` date DEFAULT NULL COMMENT '展示日期',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】文章分享';

-- ----------------------------
-- Records of t_island_passage
-- ----------------------------
INSERT INTO `t_island_passage` VALUES ('1', '《时间即生命》', null, '——梁实秋', '最令人怵目惊心的一件事，是看着钟表上的秒针一下一下的移动，每移动一下就是表示我们的寿命已经缩短了一部分。再看看墙上挂着的可以一张张撕下的日历，每天撕下一张就是表示我们的寿命又缩短了一天。因为时间即生命。没有人不爱惜他的生命，但很少人珍视他的时间。如果想在有生之年做一点什么事，学一点什么学问，充实自己，帮助别人，使生命成为有意义，不虚此生，那么就不可浪费光阴。这道理人人都懂，可是很少人真能积极不懈的善于利用他的时间。\r\n　　我自己就是浪费了很多时间的一个人。我不打麻将，我不经常的听戏看电影，几年中难得一次，我不长时间看电视，通常只看半个小时，我也不串门子闲聊天。有人问我：“那么你大部分时间都做了些什么呢？”我痛自反省，我发现，除了职务上的必须及人情上所不能免的活动之外，我的时间大部分都浪费了。我应该集中精力，读我所未读过的书，我应该利用所有时间，写我所要写的东西，但是我没能这样做。我的好多的时间都糊里糊涂的混过去了，“少壮不努力，老大徒伤悲。”例如我翻译莎士比亚，本来计划于课余之暇每年翻译两部，二十年即可完成，但是我用了三十年，主要的原因是懒。翻译之所以完成，主要的是因为活得相当长久，十分惊险。翻译完成之后，虽然仍有工作计划，但体力渐衰，有力不从心之感。假使年轻的时候鞭策自己，如今当有较好或较多的表现。然而悔之晚矣。\r\n　　再例如，作为一个中国人，经书不可不读。我年过三十才知道读书自修的重要。我披阅，我圈点，但是恒心不足，时作时辍。五十以学易，可以无大过矣，我如今已年过八十，还没有接触过易经，说来惭愧。史书也很重要。我出国留学的时候，我阿亲买了一套同文石印的前四史，塞满了我的行箧的一半空间，我在外国混了几年之后又把前四史原封带回来了。直到四十年后才鼓起勇气读了“通鉴”一遍。现在我要读的书太多，深感时间有限。\r\n　　无论做什么事，健康的身体是基本条件。我在学校读书的时候，有所谓“强迫运动”，我踢破过几双球鞋，打断过几只球拍。因此侥幸维持下来最低限度的体力。老来打过几年太极拳，目前则以散步活动筋骨而已。寄语年轻朋友，千万要持之以恒的从事运动，这不是嬉戏，不是浪费时间。健康的身体是作人做事的真正的本钱。', '2019-03-26', '2019-03-26 13:06:43', '1', '0');
INSERT INTO `t_island_passage` VALUES ('2', '故都的秋', '《无》', '——郁达夫', '        就是孤独的秋啊', '2019-04-09', '2019-04-09 17:51:06', 'jsp', '0');

-- ----------------------------
-- Table structure for t_island_poem
-- ----------------------------
DROP TABLE IF EXISTS `t_island_poem`;
CREATE TABLE `t_island_poem` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `poem_title` varchar(255) DEFAULT NULL COMMENT '诗歌标题',
  `poem_type` varchar(255) DEFAULT NULL COMMENT '诗歌类型',
  `poem_author` varchar(255) DEFAULT NULL COMMENT '诗歌作者',
  `poem_content` varchar(1000) DEFAULT NULL COMMENT '诗歌内容',
  `poem_note` varchar(2000) DEFAULT NULL COMMENT '词汇注释',
  `poem_explanation` varchar(3000) DEFAULT NULL COMMENT '诗歌解释',
  `poem_appreciation` varchar(3000) DEFAULT NULL COMMENT '诗歌赏析',
  `showing_date` date DEFAULT NULL COMMENT '展示日期',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(36) DEFAULT NULL COMMENT '创建人',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='【时光小岛】诗歌鉴赏';

-- ----------------------------
-- Records of t_island_poem
-- ----------------------------
INSERT INTO `t_island_poem` VALUES ('1', '《偶然》', '现代诗', '——徐志摩', '我是天空里的一片云，\r\n偶尔投影在你的波心──\r\n你不必讶异，\r\n更无须欢喜──\r\n在转瞬间消灭了踪影。\r\n\r\n你我相逢在黑夜的海上，\r\n你有你的，我有我的，方向；\r\n你记得也好，\r\n最好你忘掉\r\n在这交会时互放的光亮！', '此诗写于1926年5月，乃是诗人徐志摩初遇林徽因于伦敦时所写，昔时徐志摩偶识林徽因，燃起爱情之火、诗作之灵感，一挥而就有此佳作。初载于同年5月27日《晨报副刊·诗镌》第9期，署名志摩。这也是徐志摩和陆小曼合写的剧本《卞昆冈》第五幕里老瞎子的唱词。 ', '近代古文字学家、考古学家、诗人陈梦家《纪念徐志摩》：“《偶然》等几首诗，划开了他前后两期的鸿沟，他抹去了以前的火气，用整齐柔丽清爽的诗句，来写那微妙的灵魂的秘密。”  \r\n现代文学评论家、翻译家、诗人卞之琳《徐志摩诗集》：“这首诗在作者诗中是在形式上最完美的一首。”  \r\n现代作家夏墨《情丝·现代诗中的美丽与哀愁》：“徐志摩这首《偶然》小诗，对我来说，用上‘情有独钟’之语而不为过。”  \r\n当代自由诗人严文科《和·人类只有一个地球》：“作者在一个完全虚化的时间副词的题目下写出一首如此灵动的小诗。这首对人生、对情感有着深切感悟的诗，诗人表达了对爱与美的消逝的感叹，字里行间也透露出对这些美好情愫的眷顾之情。” ', '这首两段十行的小诗，在现代诗歇长廊中堪称别具一格。诗史上，一部洋洋洒洒上千行长诗可以随似水流年埋没于无情的历史沉积中，而某些玲珑短诗，却能够超越历史，独放异彩。作为给读者以强烈的“浪漫主义诗人”印象的徐志摩，这首诗歌的象征性（既有总体象征，又有局部性意象象征）也许格外值得注意。“偶然”是一个完全抽象化的时间副词，在这个标题下写什么内容，应当说是自由随意的，而作者在这抽象的标题下，写的是两件比较实在的事情，一是天空里的云偶尔投影在水里的波心，二是“你”、“我”（都是象征性的意象）相逢在海上、若用“我和你”、“相遇”之类谁都能从诗歌中概括出来的相当实际的词作标题，这抽象和具象之间的张力，自然就荡然无存了。徐志摩能把“偶然”这样一个极为抽象的时间副词形象化，置入象征性的结构中，充满情趣哲理，不但珠润玉圆，朗朗上口而且余味无穷，意溢于言外。\r\n全诗两节，上下节格律对称。每一节的第一句、第二句、第五句都是用三个音步组成。如“偶尔投影在你的波心”，“在这交会时互放的光亮”每节的第三、第四句都是两音步构成，如“你不必讶异”，“你记得也好，最好你忘掉”。在音步的安排处理上显然严谨中不乏洒脱，较长的音步与较短音步相问，读起来纡徐从容、委婉顿挫而朗朗上口。在“偶然”这样一个可以化生众多具象的标题下，“云”与“水”，“你”与“我”、“黑夜的海”、“互放的光亮等意象及意象与意象之间的关系构成，都可以因为读者个人情感阅历的差异及体验强度的深浅而进行不同的理解或组构。这正是“其称名也小，其取类也大”（《易·系辞》）的“象征”之以少喻多、以小喻大、以个别喻一般的妙用。或人世遭际挫折，或情感阴差阳错，或追悔莫及……人生，必然会有这样一些“偶然”的“相逢”和“交会”而这“交时互放的光亮”，必将成为永难忘怀的记忆而长伴人生。\r\n此诗并非只是简单的爱情诗，它更包含对人生的感叹。云与水相距万里，偶尔云倩影投影在波心上，可在转瞬间却又消失了踪影。航行在海上的舟在黑夜里相逢，然而各有各的方向，偶然相遇，却又匆匆离别。人生正是如此，每个人都有自己既定不变的人生轨迹，相遇是偶然，但人生的彼岸却是必然。人生的旅途有许多的偶然，转角遇到的爱，相逢结下的缘，可这偶然的爱与缘都只是昙花一现，匆匆而来，匆匆而去，随后各自再度回归到自己的人生轨迹上继续前行。对于这些偶然的爱与缘，人们无须欢喜，也最好忘掉因为每个人都有各的方向，人们既无法改变人生，那就忘掉，忘掉交会是互放的光亮。这是人生的无可奈何，但也是人生最好的选择，心中无所牵挂才能继续前行，前路还有更多的偶然，若每一个偶然的相遇，都驻足相伴，心的牵挂，那人生将偏离轨迹，亦无法到达必然的彼岸。\r\n在此诗中，徐志摩传达的是对情感的节制。对于交会时互放的光亮，他说最好忘掉，这是对偶然萌生的情愫的扼杀。徐志摩带着欧美浪漫主义回国，把东西方文明交汇最终形成自己唯美主义的诗文风格，然而这首诗对偶然相遇的美好进行了压制，这是时代的变更造成的，徐志摩处于最黑暗的年代，他无法逃脱这个时代固有的丑恶和斗争，他无法偏离既定不变的人生轨迹，所以他无奈地选择了压制自己内心的情感，忘掉偶然的相遇。然而，接受人生最终也让徐志摩懂得了潇洒地放手，因而他说道：“你记得也好，最好你忘掉。”', '2019-03-26', '2019-03-26 13:02:36', '1', '0');
INSERT INTO `t_island_poem` VALUES ('2', '登鹳雀楼', '古诗', '——王之涣', '        白日依山尽，黄河入海流\r\n        欲穷千里目，更上一层楼', '        无', '        无', '        好诗', '2019-04-09', '2019-04-09 17:48:11', 'jsp', '0');

-- ----------------------------
-- Table structure for t_island_post
-- ----------------------------
DROP TABLE IF EXISTS `t_island_post`;
CREATE TABLE `t_island_post` (
  `pk_id` varchar(36) NOT NULL,
  `topic_id` varchar(36) DEFAULT NULL COMMENT '主题',
  `post_content` varchar(500) DEFAULT NULL COMMENT '帖子内容',
  `post_image_path` varchar(255) DEFAULT NULL COMMENT '帖子图片路径',
  `created_by` varchar(255) DEFAULT NULL COMMENT '发帖人unionid',
  `created_time` datetime DEFAULT NULL COMMENT '发帖时间',
  `updated_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否已删除1是0否,默认0',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_island_post
-- ----------------------------

-- ----------------------------
-- Table structure for t_island_post_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_island_post_reply`;
CREATE TABLE `t_island_post_reply` (
  `pk_id` varchar(36) NOT NULL COMMENT '主键',
  `post_id` varchar(36) DEFAULT NULL COMMENT '帖子id',
  `reply_id` varchar(36) DEFAULT NULL COMMENT '回复id',
  `reply_content` varchar(500) DEFAULT NULL COMMENT '回复内容',
  `reply_from` varchar(50) DEFAULT NULL COMMENT '回复人',
  `created_time` datetime DEFAULT NULL COMMENT '回复时间',
  `updated_time` datetime DEFAULT NULL COMMENT '修改时间',
  `reply_to` varchar(50) DEFAULT NULL COMMENT '回复指向人',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否已删除1是0否,默认0',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】帖子回复表';

-- ----------------------------
-- Records of t_island_post_reply
-- ----------------------------

-- ----------------------------
-- Table structure for t_island_post_thumbs_up
-- ----------------------------
DROP TABLE IF EXISTS `t_island_post_thumbs_up`;
CREATE TABLE `t_island_post_thumbs_up` (
  `pk_id` varchar(36) NOT NULL DEFAULT '' COMMENT '主键',
  `post_id` varchar(36) DEFAULT NULL COMMENT '帖子唯一标识',
  `thumbs_up_by` varchar(50) DEFAULT NULL COMMENT '点赞者unionid',
  `created_time` datetime DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】点赞帖子';

-- ----------------------------
-- Records of t_island_post_thumbs_up
-- ----------------------------

-- ----------------------------
-- Table structure for t_island_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_island_topic`;
CREATE TABLE `t_island_topic` (
  `pk_id` varchar(36) NOT NULL,
  `topic_name` varchar(255) DEFAULT NULL COMMENT '主题名称',
  `topic_type` varchar(255) DEFAULT NULL COMMENT '主题类型',
  `created_by` varchar(50) DEFAULT NULL COMMENT '创建人unionid',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_deleted` varchar(10) DEFAULT '0' COMMENT '是否已删除1是0否，默认0',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】主题表';

-- ----------------------------
-- Records of t_island_topic
-- ----------------------------

-- ----------------------------
-- Table structure for t_island_topic_info
-- ----------------------------
DROP TABLE IF EXISTS `t_island_topic_info`;
CREATE TABLE `t_island_topic_info` (
  `topic_id` varchar(36) NOT NULL COMMENT '主题id',
  `topic_visit_times` bigint(20) DEFAULT '0' COMMENT '主题受访次数',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】主题相关信息表';

-- ----------------------------
-- Records of t_island_topic_info
-- ----------------------------

-- ----------------------------
-- Table structure for t_island_topic_visitor_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_island_topic_visitor_relation`;
CREATE TABLE `t_island_topic_visitor_relation` (
  `pk_id` varchar(36) NOT NULL COMMENT '主键',
  `topic_id` varchar(36) DEFAULT NULL COMMENT '主题唯一标识',
  `union_id` varchar(50) DEFAULT NULL COMMENT '用户微信唯一标识',
  `created_time` datetime DEFAULT NULL COMMENT '关注时间',
  `is_cancel` varchar(10) DEFAULT '0' COMMENT '是否取消关注1是0否',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】用户关注话题关系表';

-- ----------------------------
-- Records of t_island_topic_visitor_relation
-- ----------------------------

-- ----------------------------
-- Table structure for t_island_visitor
-- ----------------------------
DROP TABLE IF EXISTS `t_island_visitor`;
CREATE TABLE `t_island_visitor` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `union_id` varchar(50) DEFAULT NULL COMMENT '微信用户唯一标识',
  `first_landing_time` datetime DEFAULT NULL COMMENT '首次拜访的时间',
  `nick_name` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户昵称',
  `last_landing_time` datetime DEFAULT NULL COMMENT '最后一次拜访的时间',
  `landing_count` int(11) DEFAULT NULL COMMENT '访问次数',
  `avatar_path` varchar(500) DEFAULT NULL COMMENT '用户头像地址',
  `tel` varchar(255) DEFAULT NULL COMMENT '微信用户绑定手机号',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别 0：未知、1：男、2：女',
  `use_language` varchar(255) DEFAULT NULL COMMENT '语言：en英文； zh_CN简体中文；zh_TW	繁体中文；',
  `city` varchar(500) DEFAULT NULL COMMENT '城市',
  `province` varchar(500) DEFAULT NULL COMMENT '省份',
  `country` varchar(500) DEFAULT NULL COMMENT '国籍',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='小程序【时光小岛】的用户表';

-- ----------------------------
-- Records of t_island_visitor
-- ----------------------------
INSERT INTO `t_island_visitor` VALUES ('1', 'ExpectoPatronum', '2019-03-27 12:43:23', 'Pony', '2019-03-27 12:43:32', '2', 'https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEJJD64t61NY61UQncHrZts4sc4LZ1QA3jYctktzalBSRD5gcsaQfCh7UO1SgpKicrcuWGWggSdjBCw/132', null, null, null, null, null, null);
INSERT INTO `t_island_visitor` VALUES ('2', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '2019-04-12 16:01:16', '　　　　　　', '2019-04-17 18:07:29', '6', 'https://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaEKOu2Tc6mQU2G0r4hXDWV78VJ9IicXdAtd9KK2gFOKyHmbNpN2KyrwQsqIALVFaOltUla4NNtibUBicw/132', null, '1', 'zh_CN', 'Hangzhou', 'Zhejiang', 'China');
INSERT INTO `t_island_visitor` VALUES ('3', 'owCIF1cCKYMz24gvPN_zr_Csnnjg', '2019-04-17 18:12:47', 'vacation', '2019-04-17 18:15:18', '2', 'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJgLcVUbruQGvDFvj6NfJpwd3A5EueKib1mwXVl5LghdINFQYY7PCoFo2jj8iar0kSice2frPNoENmjw/132', null, '1', 'en', '', 'Bolivar', 'Venezuela');

-- ----------------------------
-- Table structure for t_island_visitor_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_island_visitor_login_log`;
CREATE TABLE `t_island_visitor_login_log` (
  `pk_id` varchar(36) NOT NULL COMMENT '主键',
  `union_id` varchar(50) DEFAULT NULL COMMENT '登录者微信唯一标识',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `login_ordinal` bigint(20) DEFAULT NULL COMMENT '第几次登录',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】来访记录';

-- ----------------------------
-- Records of t_island_visitor_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_island_visitor_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_island_visitor_relation`;
CREATE TABLE `t_island_visitor_relation` (
  `pk_id` int(11) NOT NULL COMMENT '主键',
  `fans_id` varchar(50) NOT NULL COMMENT '关注者微信唯一标识',
  `star_id` varchar(50) NOT NULL COMMENT '被关注者微信唯一标识',
  `is_important` varchar(10) DEFAULT '0' COMMENT '是否特别关注1是0否，默认0',
  `is_mutual` varchar(255) DEFAULT '0' COMMENT '是否相互关注1是0否，默认0',
  `concern_cancel` varchar(10) DEFAULT '0' COMMENT '是否取消关注1是0否，默认0',
  `created_time` datetime DEFAULT NULL COMMENT '关注时间',
  `updated_time` datetime DEFAULT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】用户关注关系表';

-- ----------------------------
-- Records of t_island_visitor_relation
-- ----------------------------

-- ----------------------------
-- Table structure for t_visitor_dialogue
-- ----------------------------
DROP TABLE IF EXISTS `t_visitor_dialogue`;
CREATE TABLE `t_visitor_dialogue` (
  `pk_id` varchar(36) NOT NULL COMMENT '主键',
  `voice_from` varchar(50) DEFAULT NULL COMMENT '发送者unionid',
  `voice_to` varchar(50) DEFAULT NULL COMMENT '接收者unionid',
  `voice_content` varchar(3000) DEFAULT NULL COMMENT '对话内容',
  `created_time` datetime DEFAULT NULL COMMENT '对话时间',
  `is_read` varchar(255) DEFAULT '0' COMMENT '是否已读：1是，0否',
  `is_deleted` varchar(255) DEFAULT '0' COMMENT '是否已删除：1是0否',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】用户之间对话';

-- ----------------------------
-- Records of t_visitor_dialogue
-- ----------------------------

-- ----------------------------
-- Table structure for t_visitor_storehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_visitor_storehouse`;
CREATE TABLE `t_visitor_storehouse` (
  `pk_id` varchar(36) NOT NULL COMMENT '主键',
  `union_id` varchar(50) DEFAULT NULL COMMENT 'union_id',
  `work_id` int(11) DEFAULT NULL COMMENT '作品唯一标识',
  `work_type` varchar(255) DEFAULT NULL COMMENT '作品类型：格言、名画、文章、诗歌、景色、音乐、电影、段子',
  `stored_time` datetime DEFAULT NULL COMMENT '收藏时间',
  `stored_cancel` varchar(10) DEFAULT '0' COMMENT '是否取消：1是0否',
  `cancel_time` datetime DEFAULT NULL COMMENT '取消时间',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】游客收藏仓库';

-- ----------------------------
-- Records of t_visitor_storehouse
-- ----------------------------
INSERT INTO `t_visitor_storehouse` VALUES ('01efbb3c-4da3-4937-9ad0-42c2878e9716', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '3', 'MOVIE', '2019-04-12 17:52:56', '1', '2019-04-17 09:34:53');
INSERT INTO `t_visitor_storehouse` VALUES ('1', '1', '1', 'MOVIE', '2019-04-12 16:59:23', '1', '2019-04-15 09:44:56');
INSERT INTO `t_visitor_storehouse` VALUES ('2', '1', '1', 'JOKE', null, '0', '2019-04-17 09:34:49');
INSERT INTO `t_visitor_storehouse` VALUES ('3', '1', '2', 'JOKE', null, '1', null);
INSERT INTO `t_visitor_storehouse` VALUES ('31e0be11-1c81-4fb7-a161-9b2add786a5d', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '2', 'MOVIE', '2019-04-17 09:53:47', '0', null);
INSERT INTO `t_visitor_storehouse` VALUES ('5c5728e1-a05e-4fb4-b928-e8c0171f8f58', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '2', 'JOKE', '2019-04-17 18:03:02', '0', null);
INSERT INTO `t_visitor_storehouse` VALUES ('5fcb1651-d29d-42dc-b66e-4d8f617871b3', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '7', 'MOVIE', '2019-04-12 17:28:06', '1', '2019-04-17 09:36:19');
INSERT INTO `t_visitor_storehouse` VALUES ('6f216ff4-7017-42ad-9400-dab9fd5278a1', '1', '3', 'MOVIE', '2019-04-12 17:14:56', '0', null);
INSERT INTO `t_visitor_storehouse` VALUES ('7c5d593e-7670-4f64-a8f8-7d448898c0fe', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '1', 'JOKE', '2019-04-17 18:07:05', '0', null);
INSERT INTO `t_visitor_storehouse` VALUES ('b6c153e0-d385-4115-909b-0eab6cc3abe5', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '1', 'PAINTING', '2019-04-17 17:27:56', '1', '2019-04-17 17:28:07');
INSERT INTO `t_visitor_storehouse` VALUES ('b7d1c41e-8dc2-4e6e-befd-6382be5765aa', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '4', 'PAINTING', '2019-04-17 17:26:17', '0', null);
INSERT INTO `t_visitor_storehouse` VALUES ('c9680b9f-aba2-4bd4-8ca1-164b9479d649', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '2', 'PAINTING', '2019-04-17 17:49:23', '1', '2019-04-17 17:49:24');
INSERT INTO `t_visitor_storehouse` VALUES ('edca60a0-8dce-4a07-8431-81e9e5d49af0', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '1', 'MOVIE', '2019-04-12 17:28:54', '1', '2019-04-17 09:50:47');
INSERT INTO `t_visitor_storehouse` VALUES ('fad35e67-e544-479d-a8f3-b92dcce6729d', 'owCIF1YaOmfvlodwsNh0Ex5L6Ne8', '6', 'JOKE', '2019-04-17 18:04:01', '0', '2019-04-17 18:04:03');

-- ----------------------------
-- Table structure for t_visitor_words
-- ----------------------------
DROP TABLE IF EXISTS `t_visitor_words`;
CREATE TABLE `t_visitor_words` (
  `pk_id` varchar(36) NOT NULL COMMENT '主键',
  `work_id` varchar(36) DEFAULT NULL COMMENT '点评的作品id',
  `work_type` varchar(255) DEFAULT NULL COMMENT '点评的作品类型',
  `words_content` varchar(500) DEFAULT NULL COMMENT '点评/回复内容',
  `words_id` varchar(36) DEFAULT NULL COMMENT '回复的点评id(本表的id）',
  `union_id` varchar(50) DEFAULT NULL COMMENT 'unionid',
  `created_time` datetime DEFAULT NULL COMMENT '点评/回复时间',
  `is_deleted` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='【时光小岛】访客点评互动记录';

-- ----------------------------
-- Records of t_visitor_words
-- ----------------------------
