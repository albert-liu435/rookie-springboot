
CREATE TABLE db_mybatis.`t_car` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `car_num` varchar(255) DEFAULT NULL,
                               `brand` varchar(255) DEFAULT NULL,
                               `guide_price` DECIMAL(10,2) ,
                               `produce_time` char(10) DEFAULT NULL,
                               `car_type` varchar(255) DEFAULT null,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;


insert into db_mybatis.t_car(car_num,brand,guide_price,produce_time,car_type) values('1001','宝马520',10.00,'2022-9-6','燃油车');
insert into db_mybatis.t_car(car_num,brand,guide_price,produce_time,car_type) values('1002','奔驰E300L',55.00,'2022-10-6','新能源');


















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

