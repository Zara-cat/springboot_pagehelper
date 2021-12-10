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

