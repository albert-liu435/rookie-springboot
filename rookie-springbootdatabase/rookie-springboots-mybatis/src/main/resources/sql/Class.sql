
CREATE TABLE oasys.`t_class` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                   `cid` INT(10) DEFAULT NULL,
                                   `cname` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

insert into oasys.t_class values(null,1000,'高三一班');
insert into oasys.t_class values(null,1001,'高三二班');

-- -- 添加字段
-- -- ALTER  TABLE  表名  ADD  COLUMN  新字段名  数据类型  [NOT  NULL  DEFAULT  默认值]
-- alter table oasys.`t_student` add column sid int(10);
















