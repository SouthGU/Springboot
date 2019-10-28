## Springboot开发过程中遇见的问题

### 1. Springboot Data JPA驼峰命名法

```xml
Springboot中JPA默认自动将实体类中的 驼峰命名 转化为 下划线隔开 的方式进行数据库查询，
例如：将字段getAssetTypeName自动转换为 asset_type_name导致数据库找不到该字段；
departNo会自动转换为depart_no,如果不进行修改的话，那么数据库中的字段就必须是depart_no，否则会出现
500-Unknown column 'xxx' in 'field list'对应不上的情形

解决方法：在配置文件中取消自动将驼峰命名转为下划线形式
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

 jpa:
    hibernate:
      naming:
        physical-strategy: 	org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

由于添加了配置信息，取消了驼峰命名法：
@JoinColumn(name = "departId",referencedColumnName = "departNo")
修改为：
@JoinColumn(name = "depart_id",referencedColumnName = "departNo")
depart_id为原来数据表中字段。这样子实体的属性就和数据表中的字段相对应了。
```

### 2. application.yml配置文件

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf-8
    username: root
    password: 12345678
    driver-class-name: com.mysql.cj.jdbc.Driver
  mvc:
    view:
      prefix: /WEB-INF/
      suffix: .jsp
    static-path-pattern: /static/**
  redis:
    database: 0
    host: localhost
    port: 6379
  jpa:
    hibernate:
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        show_sql: true

server:
  port: 8080
  servlet:
    context-path: /
  tomcat:
    uri-encoding: UTF-8

```





