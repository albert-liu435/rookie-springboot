认证授权:


为了方便，先修改host文件，添加如下配置
127.0.0.1 rookie-tuwer.client.com
127.0.0.1 rookie-tuwer.server.com
127.0.0.1 rookie-tuwer.resource1.com
127.0.0.1 rookie-tuwer.resource2.com
127.0.0.1 rookie-tuwer.gateway.com

访问：http://localhost:7000/
http://rookie-tuwer.gateway.com:9999/actuator/info
http://rookie-tuwer.server.com:9000/actuator/info
http://rookie-tuwer.client.com:8000/actuator/info

[//]: # (1、进行登录及验证)

[//]: # (在浏览器中输入url:http://rookie-tuwer.server.com:9000/oauth2/authorize?response_type=code&client_id=my_client&scope=read write&redirect_uri=https://www.baidu.com)

[//]: # (进行账号和密码登录后，进行授权得到code)

[//]: # (通过postman通过code换取token:http://rookie-tuwer.server.com:9000/oauth2/token)

[//]: # ()
[//]: # (携带token进行资源访问:http://rookie-tuwer.server.com:9000/oauth2/user)

[//]: # ()
[//]: # (2、资源访问：)

[//]: # (同上面的步骤1换取token后，进行资源访问)


3、进行客户端访问：http://rookie-tuwer.client.com:8000
测试资源服务之间的调用


参考文档：https://blog.csdn.net/tu_wer/category_11828716.html
