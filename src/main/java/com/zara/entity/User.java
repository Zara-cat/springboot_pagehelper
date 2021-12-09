package com.zara.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import java.io.Serializable;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : User
 * @description : [用户实体类]
 * @createTime : [2021/12/8 15:21]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 15:21]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 3337955056649739635L;
    /**
     * id
     */
    private Integer id;
    /**
     *  用户名
     */
    private String username;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 地址
     */
    private String address;
}
