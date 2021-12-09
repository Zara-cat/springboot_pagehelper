package com.zara.dao;

import com.zara.dto.UserPageReqDto;
import com.zara.entity.User;
import com.zara.vo.UserPageResVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IUserDao
 * @description : [描述说明该类的功能]
 * @createTime : [2021/12/8 17:05]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 17:05]
 * @updateRemark : [描述说明本次修改内容]
 */
@Mapper
public interface IUserDao {
    List<UserPageResVo> selAll(@Param("UserPageReqDto") UserPageReqDto dto);
}
