# 南京大学在线软件测试系统

## 项目简介

本项目基于ruoyi-vue-pro框架，开发一个在线平台，提供各种表单的上传、处理、下载功能，供南京大学的软件测试部门使用。

* 后端项目基于 Spring Boot 多模块架构

* 前端项目基于 Vue2 + element-ui 实现的管理后台



## ruoyi-vue-pro框架简介

### 框架

| 框架                                                         | 说明                  | 版本        | 学习指南                                                     |
| ------------------------------------------------------------ | --------------------- | ----------- | ------------------------------------------------------------ |
| [Spring Boot](https://spring.io/projects/spring-boot)        | 应用开发框架          | 2.7.8       | [文档](https://github.com/YunaiV/SpringBoot-Labs)            |
| [MySQL](https://www.mysql.com/cn/)                           | 数据库服务器          | 5.7 / 8.0+  |                                                              |
| [Druid](https://github.com/alibaba/druid)                    | JDBC 连接池、监控组件 | 1.2.15      | [文档](http://www.iocoder.cn/Spring-Boot/datasource-pool/?yudao) |
| [MyBatis Plus](https://mp.baomidou.com/)                     | MyBatis 增强工具包    | 3.5.3.1     | [文档](http://www.iocoder.cn/Spring-Boot/MyBatis/?yudao)     |
| [Dynamic Datasource](https://dynamic-datasource.com/)        | 动态数据源            | 3.6.1       | [文档](http://www.iocoder.cn/Spring-Boot/datasource-pool/?yudao) |
| [Redis](https://redis.io/)                                   | key-value 数据库      | 5.0 / 6.0   |                                                              |
| [Redisson](https://github.com/redisson/redisson)             | Redis 客户端          | 3.18.0      | [文档](http://www.iocoder.cn/Spring-Boot/Redis/?yudao)       |
| [Spring MVC](https://github.com/spring-projects/spring-framework/tree/master/spring-webmvc) | MVC 框架              | 5.3.24      | [文档](http://www.iocoder.cn/SpringMVC/MVC/?yudao)           |
| [Spring Security](https://github.com/spring-projects/spring-security) | Spring 安全框架       | 5.7.6       | [文档](http://www.iocoder.cn/Spring-Boot/Spring-Security/?yudao) |
| [Hibernate Validator](https://github.com/hibernate/hibernate-validator) | 参数校验组件          | 6.2.5       | [文档](http://www.iocoder.cn/Spring-Boot/Validation/?yudao)  |
| [Flowable](https://github.com/flowable/flowable-engine)      | 工作流引擎            | 6.8.0       | [文档](https://doc.iocoder.cn/bpm/)                          |
| [Quartz](https://github.com/quartz-scheduler)                | 任务调度组件          | 2.3.2       | [文档](http://www.iocoder.cn/Spring-Boot/Job/?yudao)         |
| [Knife4j](https://gitee.com/xiaoym/knife4j)                  | Swagger 增强 UI 实现  | 4.0.0       | [文档](http://www.iocoder.cn/Spring-Boot/Swagger/?yudao)     |
| [Resilience4j](https://github.com/resilience4j/resilience4j) | 服务保障组件          | 1.7.1       | [文档](http://www.iocoder.cn/Spring-Boot/Resilience4j/?yudao) |
| [SkyWalking](https://skywalking.apache.org/)                 | 分布式应用追踪系统    | 8.12.0      | [文档](http://www.iocoder.cn/Spring-Boot/SkyWalking/?yudao)  |
| [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin) | Spring Boot 监控平台  | 2.7.10      | [文档](http://www.iocoder.cn/Spring-Boot/Admin/?yudao)       |
| [Jackson](https://github.com/FasterXML/jackson)              | JSON 工具库           | 2.13.3      |                                                              |
| [MapStruct](https://mapstruct.org/)                          | Java Bean 转换        | 1.5.3.Final | [文档](http://www.iocoder.cn/Spring-Boot/MapStruct/?yudao)   |
| [Lombok](https://projectlombok.org/)                         | 消除冗长的 Java 代码  | 1.18.24     | [文档](http://www.iocoder.cn/Spring-Boot/Lombok/?yudao)      |
| [JUnit](https://junit.org/junit5/)                           | Java 单元测试框架     | 5.8.2       | -                                                            |
| [Mockito](https://github.com/mockito/mockito)                | Java Mock 框架        | 4.8.0       | -                                                            |



## Update

* 完成表单的设计（数据库+前后端）

* 完成工作流的激活

* 完成云端数据库的接入

  