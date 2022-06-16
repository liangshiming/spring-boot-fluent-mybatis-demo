#服务基础文档

### 项目代码结构树说明
```
spring-boot-fluent-mybatis-demo
 
```

### 系统结构树说明
```
 spring-boot-fluent-mybatis-demo 
  - src
    - main
      - java
        - com.ming.demo //统一目录结构,最后文件夹为服务名
        - config  //放bean配置
        - constant //放静态类型,枚举,自定义常量类
        - controller // controller层
        - convert //数据转化层,用于dto,vo,dao数据转化
        - domain //存 dto , vo 对象
          	- dto  // dto对象
          	- vo   // vo对象，包括请求对象和响应对象，请求对象已req结尾，返回对象已Vo结尾
        - fluent  //fluent-mybatis 结构目录,可以通过代码生成生成dao对象 ,后面整个目录通过代码生成
            - dao 
            	- impl 数据库impl
            	- intf 数据库接口
            - entity 数据库对象  
     - serivce  //服务service
     - utils工具类
  
   test
      - java
        -com.ming.demo
          - EntityGenerator //dao代码生成器        
          
```
### demo说明
#### 客户模块接口开发一个分页查询客户时间线信息接口
```
  0.建表语句
  -- auto-generated definition
    create table demo_customer
    (
        id           bigint auto_increment comment '主键' primary key,
        name         varchar(100) null comment '用户名',
        former_name  varchar(100) null comment '昵称',
        english_name varchar(100) null comment '英文名',
        phone        varchar(32)  null comment '手机',
        email        varchar(32)  null comment '邮箱',
        company_id   bigint       null comment '归属组织ID',
        partner_id   bigint       null comment '父级ID',
        owner_user   bigint       null comment '所属用户',
        is_deleted   tinyint(1)   null comment '是否删除:0-删除,1-正常',
        remark       varchar(128) null comment '备注',
        create_user  bigint       null comment '创建用户',
        update_user  bigint       null comment '更新用户',
        gmt_create   datetime     null comment '创建时间',
        gmt_modified datetime     null comment '更新时间'
    
    ) comment '用户表';
    
    -- auto-generated definition
    create table demo_biz_activity
    (
        id                 bigint auto_increment comment '主键' primary key,
        activity_note      int(1)       null comment '活动标签:1-会议,2-电话,3-聚餐',
        company_id         bigint       null comment '归属组织ID',
        plan_end_time      datetime     null comment '活动开始时间',
        plan_start_time    datetime     null comment '活动结束时间',
        public_description varchar(10)  null comment '公共描述',
        remark             varchar(128) null comment '备注',
        done               tinyint(1)   null comment '是否完成:0-否,1-是',
        is_deleted         tinyint(1)   null comment '是否删除:0-删除,1-正常',
        gmt_create         datetime     null comment '创建时间',
        gmt_modified       datetime     null comment '更新时间'
    )
        comment '活动表';
    -- auto-generated definition
    create table demo_biz_note
    (
        id            bigint auto_increment comment '主键' primary key,
        customer_id   bigint       null comment '所属用户ID',
        biz_type_code varchar(10)  null comment '业务类型编码',
        note_type     int(1)       null comment '笔记类型:1-一般,2-信件',
        content       varchar(128) null comment '笔记内容',
        is_deleted    tinyint(1)   null comment '是否删除:0-删除,1-正常',
        remark        varchar(128) null comment '备注',
        gmt_create    datetime     null comment '创建时间',
        gmt_modified  datetime     null comment '更新时间'
    )
        comment '笔记表';
        
  1. 数据库源
  // 数据源 url
  static final String url =
      "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8";
       username: demo
       password: demo

  2. 数据库包含三张表：
      1. demo_customer 客户表
      2. demo_biz_activity 客户活动表
      3. demo_biz_note 客户笔记表
      
      数据关系：
          customer 客户表  1 = n  biz_activity 客户活动表,关联ID company_id -> company_id
          
          customer 客户表  1 = n  biz_note 客户笔记表,关联ID id -> customer_id
      
     一个客户会关联多个活动，一个客户会关联多个笔记 
  3.增删改查都在Test代码实现
```
### fluent-mybatis 数据库查询使用说明

#### 官网文档地址
- https://gitee.com/fluent-mybatis/fluent-mybatis/wikis/fluent%20mybatis%E7%89%B9%E6%80%A7%E6%80%BB%E8%A7%88

### 开发规范
#### 开发需要配置的maven仓库 ，默认用的阿里云镜像

#### 开发需要配置
- lombok 插件(必备)
