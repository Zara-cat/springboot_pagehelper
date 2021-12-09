package com.zara.service.impl;

import com.zara.dao.IUserDao;
import com.zara.dto.UserPageReqDto;
import com.zara.service.IUserService;
import com.zara.vo.UserPageResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserServiceImpl
 * @description : [user 业务实现类]
 * @createTime : [2021/12/8 16:42]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 16:42]
 * @updateRemark : [描述说明本次修改内容]
 */
@Service
public class UserServiceImpl implements IUserService {
    //注入 dao
    @Autowired
    private IUserDao dao;

    @Override
    public List<UserPageResVo> list(UserPageReqDto userPageReqDto) {
        // 这里可以进行对 条件参数的一次校验和封装，然后调用 dao 进行 sql 操作
        if (!ObjectUtils.isEmpty(userPageReqDto)){
            if (!StringUtils.isEmpty(userPageReqDto.getUsernameOrAddress())){
                // 本案例，条件UserPageReqDto 中 参数1：根据用户名或者地址进行模糊查询，可以为null，如若参数为null。则为简单的查询
                userPageReqDto.setUsernameOrAddress("%"+userPageReqDto.getUsernameOrAddress()+"%");
            }
        }
        return dao.selAll(userPageReqDto);
    }
}
