package com.zara.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserPageResVo
 * @description : [UserVo对象]
 * @createTime : [2021/12/9 11:16]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/9 11:16]
 * @updateRemark : [描述说明本次修改内容]
 */
@Accessors(chain = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageResVo {
    //用户id
    private Integer id;
    // 用户名
    private String username;
    //地址
    private String address;
}
