
CREATE TABLE oasys.`t_car` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `car_num` varchar(255) DEFAULT NULL,
                               `brand` varchar(255) DEFAULT NULL,
                               `guide_price` DECIMAL(10,2) ,
                               `produce_time` char(10) DEFAULT NULL,
                               `car_type` varchar(255) DEFAULT null,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;


insert into oasys.t_car(car_num,brand,guide_price,produce_time,car_type) values('1001','宝马520',10.00,'2022-9-6','燃油车');
insert into oasys.t_car(car_num,brand,guide_price,produce_time,car_type) values('1002','奔驰E300L',55.00,'2022-10-6','新能源');
