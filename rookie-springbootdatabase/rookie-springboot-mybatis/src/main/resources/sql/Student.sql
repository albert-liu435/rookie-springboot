
CREATE TABLE db_mybatis.`t_student` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `name` varchar(255) DEFAULT NULL,
                               `age` INT(10) DEFAULT NULL,
                               `height` INT(10) DEFAULT NULL,
                               `birth` DATE DEFAULT NULL,
                               `sex` char(1) DEFAULT null,
                               createTime DATETIME,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

insert into db_mybatis.t_student values(null,'张三',23,175,now(),'男',now(),now());
insert into db_mybatis.t_student(car_num,brand,guide_price,produce_time,car_type) values('1002','奔驰E300L',55.00,'2022-10-6','新能源');

-- 添加字段
-- ALTER  TABLE  表名  ADD  COLUMN  新字段名  数据类型  [NOT  NULL  DEFAULT  默认值]
alter table db_mybatis.`t_student` add column sid int(10);
















