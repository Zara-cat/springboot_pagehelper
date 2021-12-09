package com.zara.service.impl;

import com.zara.dao.IUserDao;
import com.zara.dto.UserPageReqDto;
import com.zara.service.IUserService;
import com.zara.vo.UserPageResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserServiceImpl
 * @description : [描述说明该类的功能]
 * @createTime : [2021/12/8 16:42]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 16:42]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    public List<UserPageResVo> list(UserPageReqDto userPageReqDto) {
        return dao.selAll(userPageReqDto);
    }
}
