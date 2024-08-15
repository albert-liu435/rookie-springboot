CREATE TABLE `xxl_job_lock` (
                                `lock_name` varchar(50) NOT NULL COMMENT '锁名称',
                                PRIMARY KEY (`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `xxl_job_lock` ( `lock_name`) VALUES ( 'schedule_lock');

INSERT INTO `xxl_job_lock` ( `lock_name`) VALUES ( 'order');

-- INSERT INTO `xxl_job_lock` ( `lock_name`) VALUES ( 'order');

