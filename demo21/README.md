### 开始 
建议使用IDEA，并安装lombok插件
本项目使用Maven进行构建
DEMO： io.huayu.springboot.demo.UserMessages

### 接口文档地址
接口文档工具使用的是：swagger，并已经集成在项目中，需要开发者在代码中增加相应的注释，会自动生成文档。
访问路径：http://localhost:8090/swagger-ui.html

### 接口传参方式
-- 接口请求地址：如： localhost:8090/login
-- 使用PostMan 工具进行调试，参数以 Json 形式放在 Body 中。
-- Header 参数
Content-Type：application/json
token：XXXXXX（需要验证权限时需要传输Token）

### 登录地址和测试账号
POST：localhost:8090/login
{
  "username": "13699299839",
  "password": "123456"
}

### 启动项目入口
- 需要安装Redis并启动
- src/main/java/io/huayu/springboot/StartApplication.java

### 项目环境 
中间件 | 版本 |  备注
-|-|-
JDK | 1.8+ | JDK1.8及以上 |
MySQL | 5.7+ | 5.7及以上 |
Redis | 3.2+ |  |

### 本项目使用集成了以下库 ，请先对相应库进行学习
技术 | 版本 |  备注
-|-|-
Spring Boot | 2.2.0.RELEASE |   |
Spring Framework | 5.2.0.RELEASE |   |
Mybatis | 3.5.2 | 持久层框架 |
Mybatis Plus | 3.2.0 | mybatis增强框架 |
Fastjson | 1.2.62 | JSON处理工具集 |
swagger2 | 2.6.1 | api文档生成工具 |
commons-lang3 | 3.9 | 常用工具包 |
commons-io | 2.6 | IO工具包 |
commons-codec | 1.13 | 加密解密等工具包 |
commons-collections4 | 4.4 | 集合工具包 |
reflections | 0.9.11 | 反射工具包 |
hibernate-validator | 6.0.17.Final | 后台参数校验注解 |
Shiro | 1.4.1 | 权限控制 |
JWT | 3.8.3 | JSON WEB TOKEN |
lombok | 1.18.10 | 注解生成Java Bean等工具 |
 
 
### Maven 构建
> 默认使用local环境,对应配置文件：application-local.yml

 