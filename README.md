# 工程简介
## 项目环境
1. JDK1.8
2. MYSQL 5.0+
## 使用技术
1. spring boot
2. mybatis
3. pagehelper
## 数据库表格

t_user 

| 字段名   | 类型    | 注释   |
| :------- | :------ | ------ |
| id       | int     | 索引   |
| username | varchar | 用户名 |
| age      | int     | 年龄   |
| address  | varchar | 地址   |

模拟数据：

```mysql
INSERT INTO `t_user` VALUES (1, '小王', 23, '浙江省杭州市');
INSERT INTO `t_user` VALUES (2, '小李', 22, '云南省大理市');
INSERT INTO `t_user` VALUES (3, '小黑', 33, '上海市');
INSERT INTO `t_user` VALUES (4, '小白', 62, '北京市');
INSERT INTO `t_user` VALUES (5, '小青', 10, '河南省郑州市');
```



# 延伸阅读
## 基于 Spirng boot
- [Spring Boot官方文档](https://spring.io/projects/spring-boot)
- [Sping Boot 中文社区](https://springboot.io)
## 基于Mybatis
- [Mybatis 官方文档](https://mybatis.org/mybatis-3/zh/index.html)
## 集成PageHelper
- [PageHelper开源仓库](https://github.com/pagehelper/Mybatis-PageHelper)
# PageHelper讲解
## 基本使用
在实际项目运用中，PageHelper的使用非常便利快捷，仅通过`PageInfo` + `PageHelper`两个类，就足以完成分页功能，然而往往这种最简单的集成使用方式，却在很多实际应用场景中，没有得到充分的开发利用

接下来式我们最常用的使用方式：

```java
public PageInfo<ResponseEntityDto> page(RequestParamDto param) {
	PageHelper.startPage(param.getPageNum(), param.getPageSize());
	List<ResoinseEntityDto> list = mapper.selectManySelective(param);
	PageInfo<ResponseEntityDto> pageInfo = (PageInfo<ResponseEntityDto>)list;
	return pageInfo;
}
```
在某种程度上而言，上述写法的确式符合 PageHelper 的使用规范：

> ​	在集合查询前使用 `PgeHelper.startPage(pageNum,pageSize)`,并且中间不能穿插执行其他 SQL

但是作为Developer的我们,往往只有在追求完美和极致的道路上才能够寻得突破和机遇; 以下是合理且规范的基本使用:
```java
public PageInfo<ResponseEntityDto> page(RequestParamDto param) {
	return PageHelper.startPage(param.getPageNum(), param.getPageSize())
			  .doSelectPageInfo(() -> list(param))
}
public List<ResponseEntityDto> list(RequestParamDto param) {
	return mapper.selectManySelective(param);
}
```
## FAQ
### 1. 为什么要重新声明一个 list 函数？
>  答：往往在很多实际业务应用场景中，分页查询式基于大数据量的表格展示需求来进行的，然而很多时候需要一个非分页集合拆线呢接口来提供服务，我们还可以在list集合中写我们自己对查询条件参数的整理和包装等。
### 2. doSelectPageInfo 是什么？
> `doSelectPageInfo`是`PageHelper.startPage()`函数返回的默认`Page`实例内置的函数,该函数可以用以`Lambda`的形式通过额外的`Function`来进行查询而不需要再进行多余的`PageInfo`与`List`转换,而`doSelectPageInfo`的参数则是`PageHelper`内置的`Function(ISelect)`接口用以达到转换`PageInfo`的目的
