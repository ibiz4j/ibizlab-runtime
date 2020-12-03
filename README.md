# **ibizlab-runtime**

### 目标
提供一个完整的微服务架构轻量级支撑运行时系统， 具体包括:

- [x]  ibz-rt:基于vue的时尚现代前端UI+统一网关
- [x]  ibz-uaa:统一认证授权微服务（支持第三方认证）  
- [x]  ibz-ou:组织人事管理微服务  
- [x]  ibz-wf:工作流代理微服务（集成flowable） 
- [ ]  ibz-disk:分布式存储微服务(集成kkfileview在线预览+collabora-code在线编辑)  
- [x]  ibz-task:任务调度微服务（集成baomidou-jobs）  
- [x]  ibz-dict:数据字典管理微服务  
- [ ]  ~~ibz-pay:支付管理微服务~~  
- [ ]  ~~ibz-notify:通知微服务~~  
- [ ]  ~~ibz-dst:分布式统计分析微服务（基于Cassandra+drools）~~  


### 系统地址
演示Demo地址：http://rt.ebs.ibizlab.cn
演示账号/密码：ibzadmin/123456

### 配置平台
ibz-rt：http://mos.ibizlab.cn/mos/#/common_mosindex/srfkeys=2AFD15C7-9AE2-4108-BCC4-6AE6F7BC6087

ibz-uaa：http://mos.ibizlab.cn/mos/#/common_mosindex/srfkeys=4DA00F51-1D2D-40F9-B48A-D3CC094F0355

ibz-ou：http://mos.ibizlab.cn/mos/#/common_mosindex/srfkeys=C43977E6-4307-486E-8189-DF2E5E53A6F9

ibz-wf：http://mos.ibizlab.cn/mos/#/common_mosindex/srfkeys=16B3DF56-B7CD-4B7D-9306-2E89A6E6C3EF

ibz-disk：http://mos.ibizlab.cn/mos/#/common_mosindex/srfkeys=E735807E-353E-4BFC-A94A-6D316BF0BF56

ibz-task：http://mos.ibizlab.cn/mos/#/common_mosindex/srfkeys=D8E692AB-B2E6-4946-847D-893BD7FC890B

ibz-dict：http://mos.ibizlab.cn/mos/#/common_mosindex/srfkeys=B55147E6-6E60-4F23-99E5-58ADFDBB5EF7

欢迎加入开源商业套件交流QQ群：1056401976


### 技术栈
#### 完整的[Spring应用](https://spring.io/)
* 基于[Spring Boot](https://projects.spring.io/spring-boot/)提供应用配置简化
* [Maven](https://maven.apache.org/)构建，测试，运行应用
* [Spring Security](https://docs.spring.io/spring-security/site/index.html)组件
* [JSON Web令牌（JWT）](https://jwt.io/)身份验证安全机制
* [Spring MVC REST](https://spring.io/guides/gs/rest-service/) + [Jackson](https://github.com/FasterXML/jackson)
* [Swagger](https://swagger.io/)来自动生成REST Controller API文档
* [Zalando Problem Spring Web](https://github.com/zalando/problem-spring-web)处理异常
* [Mybatis-plus](https://mp.baomidou.com/)
* 基于[Liquibase](http://www.liquibase.org/)数据库更新
* [Elasticsearch](https://github.com/elastic/elasticsearch)支持，如果你需要基于你的数据库提供高级搜索能力
* [MongoDB](https://www.mongodb.org/)支持， 如果你想使用面向文档的NOSQL数据库替代JPA
* 构建标准可执行的JAR文件

#### 微服务技术栈

* 基于[Netflix Zuul](https://github.com/Netflix/zuul)的HTTP流量路由
* 基于[Nacos](https://nacos.io/zh-cn/index.html)或[Eureka](https://github.com/Netflix/eureka)的服务发现
* 基于[Feign](https://github.com/OpenFeign/feign)的服务消费客户端
* 使用[Caffeine](https://github.com/ben-manes/caffeine) + [Redis](https://redis.io/)提供两级缓存
* 完整的[Docker](https://www.docker.com/)和[Docker Compose](https://github.com/docker/compose)支持
* [RocketMQ](http://rocketmq.apache.org/)支持， 如果你需要一个消息发布订阅系统

#### 基于Vue， 提供时尚、现代、移动优化的前端
* 基于ViewUI和ElementUI的Web设计
* 现代浏览器兼容 (Chrome， FireFox， Microsoft Edge…)
* 完整国际化支持
* 可选的Sass支持
* 使用yarn便捷安装最新的JavaScript库
* 使用Vue-cli构建



### 开发配置

* 后端依赖jdk1.8 + maven3  
* 前端依赖nodejs + yarn，并建议更换国内源

#### 开发编译
```
mvn package -Pallinone
```

开发人员快速启动，使用DevBootApplication启动可以一次性以springboot启动所有服务，并模拟仿真注册所有微服务，笔者开发时一般都如此启动，很方便调试

`boot/src/main/java/cn/ibizlab/DevBootApplication.java`

Boot on port:10086  
http://127.0.0.1:10086  

#### 数据库配置
liquibase 支持，启动自动发布数据库结构和示例数据   
`boot/src/main/resources/liquibase/*`  

#### 生产编译
```
mvn package -Pgateway
mvn package -Papi
```

启动网关  
`java -jar ibzrt-app-web.jar`  
或者  
编译器运行 `gateway/src/main/java/cn/ibizlab/web/WebApplication.java`  
Boot on port:30000  
http://127.0.0.1:30000

启动各个微服务  

例:ibzuaa 统一认证授权微服务  
`java -jar ibzuaa/ibzuaa-provider-api.jar`  
或者  
编译器运行 `ibzuaa/ibzuaa-provider/ibzuaa-provider-api/src/main/java/cn/ibizlab/api/ibzuaaapiApplication.java`  
Boot on port:40002  

例:ibzou 组织人事管理微服务   
`java -jar ibzou/ibzou-provider-api.jar`  
或者  
编译器运行 `ibzou/ibzou-provider/ibzou-provider-api/src/main/java/cn/ibizlab/api/ibzouapiApplication.java`  
Boot on port:40001  

......   

#### Docker + Docker-compose

本系统提供了docker镜像，方便快速部署  
docker pull [ibiz4j/ibizlab-runtime:latest](https://hub.docker.com/repository/docker/ibiz4j/ibizlab-runtime) 

启动基础配套服务，nacos+redis    
```
docker-compose -f boot/src/main/docker/ibzrt-dependencies.yaml up -d
```

启动数据库服务，mysql/postgresql/oracle，数据库存储自动持久化到ibzrt-data目录中  
```
docker-compose -f boot/src/main/docker/ibzrt-mysql.yaml up -d
```
或者，postgresql，数据库存储自动持久化到ibzrt-pg目录中  
```
docker-compose -f boot/src/main/docker/ibzrt-pg.yaml up -d
```
或者，oracle，数据库存储自动持久化到ibzrt-orcl目录中  
```
docker-compose -f boot/src/main/docker/ibzrt-oracle.yaml up -d
```

启动ibizlab-runtime boot服务（主程序 http://127.0.0.1:10086）  
```
docker-compose -f boot/src/main/docker/ibzrt-boot.yaml up -d
```

启动附加可选配套组件服务（flowable等）
```
docker-compose -f boot/src/main/docker/ibzrt-ibzrt-extensions.yaml up -d
```

#### 只使用部分微服务

如果您并不想使用完整的网关，只想引用部分微服务，我们为每个微服务都提供了单独一份前端代码，您可以使用以下命令编译各子项微服务的前端网页和独立网关

```
mvn package -Pweb
```

例:只启动ibzwf 工作流代理微服务  

启动工作流代理微服务后台:   
`java -jar ibzwf/ibzwf-provider-api.jar`  
或者  
编译器运行 `ibzwf/ibzwf-provider/ibzwf-provider-api/src/main/java/cn/ibizlab/api/ibzwfapiApplication.java`  
Boot on port:40003  

启动工作流代理微服务前端网关:  
`java -jar ibzwf/ibzwf-app-web.jar`  
或者  
编译器运行 `ibzwf/ibzwf-app/ibzwf-app-web/src/main/java/cn/ibizlab/web/webApplication.java`  
Boot on port:30003  
http://127.0.0.1:30003 

### 开源计划
* ibz-disk 集成在线预览和编辑  2020年6月底
* ibz-pay:支付管理微服务  2020年7月
* ibz-notify:通知微服务  2020年7月
* ibz-dst:分布式统计分析微服务（集成drools）  2020年8月