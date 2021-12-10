# 工程简介
## 文档目录
[TOC]
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
## 1. 基本使用
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
### FAQ
#### 1. 为什么要重新声明一个 list 函数？
>  答：往往在很多实际业务应用场景中，分页查询式基于大数据量的表格展示需求来进行的，然而很多时候需要一个非分页集合拆线呢接口来提供服务，我们还可以在list集合中写我们自己对查询条件参数的整理和包装等。

#### 2. doSelectPageInfo 是什么？
> `doSelectPageInfo`是`PageHelper.startPage()`函数返回的默认`Page`实例内置的函数,该函数可以用以`Lambda`的形式通过额外的`Function`来进行查询而不需要再进行多余的`PageInfo`与`List`转换,而`doSelectPageInfo`的参数则是`PageHelper`内置的`Function(ISelect)`接口用以达到转换`PageInfo`的目的 

####  3. 这样的写法的代码量看起来不少反多？
正如同①中所描述的,就代码量而言,确实没有更进一步的简化，但是再某些业务场景中,在已具有`list`函数接口的情况下,是一种更直观的优化(优化详情请看进阶使用)

## 2. 进阶（细节看项目案例）
### 核心接口或类
1. `IBasePageService` 需要实现分页业务的业务接口需要继承该接口，注意page函数的实现方式
2. `PageParam` 如需实现分页需要传递的对象，注意属性都有那些，都代表什么含义
3. `PageInfoVo` 分页返回的结果，可以根据 `PageInfo`类进行高度定制我们的响应格式
### FAQ
#### 1. `PageParam` 中除了常规的`pageNum`、`pageSize`为什么还需要 `orderBy`?
>  常规的分页查询中只需要`pageNum/pageSize`即可完成分页的目的,但是往往伴随着分页查询的还有筛选排序，而`orderBy`则是专注基于SQL的动态传参排序

#### 2. `orderBy`如何使用?会有什么问题吗?
>答: orderBy和pageNum/pageSize一样,都是Pagehelper通过MyBatis拦截器,在query查询中注入进去的,所以在前端传参时,orderBy参数应为数据库column desc/asc这种形式,多字段排序则可以用逗号(,)拼接,譬如: columnA desc,columnB,

>但是另外一方面又存在两个问题, 第一就是大多数数据库表字段设计中,都会使用==蛇形case==命名,而非常规开发中的==驼峰case==命名,所以存在一层转换,而这种转换可以分配给前端传参时,也可以分配给后端接参时.

>第二就是这样赤裸裸的将排序字段暴露在接口中,会存在order by SQL注入的风险,所以在实际使用过程中,我们需要通过某些手段去校验和排查orderBy的传参是否合法,譬如用正则表达式匹配参数值只能含有order by语法中必要的值,例如字段名,desc or asc,不允许包含特殊字符/数据库关键字等

#### 3. pageNum/pageSize一定需要给默认值吗?
> 答: 通过阅读PageHelper源码,我们得知在Page查询参数为null时,它并不会赋予它们默认值,并不进行额外的处理,以至于导致分页失败,而给默认值,也是为了谨防前后端调试接口过程中可能会出现的各种意外

# 鸣谢 
参考文献作者：臣不贰
文献链接：https://juejin.cn/post/6886502951440318472