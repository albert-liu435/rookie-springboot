DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL COMMENT 'id',
                        `name` varchar(64) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '姓名',
                        `sex` varchar(16) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '性别',
                        `age` int(255) DEFAULT NULL COMMENT '年龄',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `status` int(10) NOT NULL DEFAULT '0' COMMENT '是否删除 1删除 0未删除',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


INSERT INTO `user` (`id`, `name`, `sex`, `age`, `create_time`, `update_time`, `status`)
VALUES
(36663930135646208,'小小','女',3,'2019-08-20 00:05:51','2019-08-20 00:05:51',1),
(36664096632737792,'奶奶','女',66,'2019-08-20 00:06:28','2019-08-20 00:06:28',1),
(36664096632737793,'妈妈','女',33,'2019-08-20 00:06:28','2019-08-20 00:06:28',1),
(36664096632737794,'小小','女',3,'2019-08-20 00:06:28','2019-08-20 00:06:28',1),
(36664096632737795,'爷爷','男',66,'2019-08-20 00:06:28','2019-08-20 00:06:28',1),
(36664096632737796,'爸爸','男',33,'2019-08-20 00:06:28','2019-08-20 00:06:28',1);





DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `age` int DEFAULT NULL COMMENT '年龄',
                        `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
                        `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
                        `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
                        `address` varchar(256) DEFAULT NULL COMMENT '地址',
                        PRIMARY KEY (`id`),
                        KEY `idx_age` (`age`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';



INSERT INTO `user` (`id`, `age`, `name`, `email`, `mobile`, `address`)
VALUES
    (1,10,'zhaoliu','450760999@qq.com','13722222222','宁波市慈溪市观海卫镇禹皇路999号鸣鹤古镇'),
    (2,20,'lisi','xu5555@outlook.com','13912345678','西安市未央区凤城二路与连心路交叉口南100米'),
    (8,30,'wangba','wangba@163.com','13712345678','西安市未央区凤城二路与连心路交叉口南100米');


