package com.zara.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserPageReqDto
 * @description : [描述说明该类的功能]
 * @createTime : [2021/12/9 11:14]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/9 11:14]
 * @updateRemark : [描述说明本次修改内容]
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class UserPageReqDto {
    private String usernameOrAddress;
}
