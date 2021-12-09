package com.zara.service;

import com.zara.base.IBasePageService;
import com.zara.dto.UserPageReqDto;
import com.zara.vo.UserPageResVo;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IUserService
 * @description : [user 业务接口]
 * @createTime : [2021/12/8 16:38]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 16:38]
 * @updateRemark : [描述说明本次修改内容]
 */
public interface IUserService extends IBasePageService<UserPageReqDto, UserPageResVo> {
    // 如：我们需要进行用户的分页，直接 继承 我们的 IBasePageService
    // 根据实际使用场景 声明请求参数 和 响应结果的 DTO 、VO 对象 ，进行泛型传递
}
