mybatis初始化：
参考文档：
    https://blog.csdn.net/m0_65563175/article/details/127354442
    https://github.com/mybatis/spring-boot-starter
    https://blog.csdn.net/m0_65563175/article/details/127354442
主要类和测试类：TabUserMapper,TabUserMapperTest


mybatis插件使用：
https://blog.csdn.net/chenxidong9/article/details/80609175
https://blog.csdn.net/qq_15437629/article/details/133879678
https://www.jb51.net/program/3301264pt.htm

主要涉及到的类:CustomerInterceptor,MybatisInterceptorConfig
测试类：com.rookie.bigdata.mapper.TabUserMapperTest.updateByPrimaryKeySelective

主要涉及到的类:AutoIdInterceptor,MybatisInterceptorConfig
测试类：com.rookie.bigdata.mapper.TabUserMapperTest.interceptorInsert

mybatis简易数据权限：
https://www.yisu.com/jc/594944.html
DataScopeInterceptor
DataPermissionInterceptor


数据脱敏：
https://www.cnblogs.com/qdhxhz/p/16352087.html
主要涉及到的类:DesensitizationInterceptor,MybatisInterceptorConfig
测试类：com.rookie.bigdata.mapper.DUserMapperTest.findAllUser








