package com.zara.controller;

import com.zara.dto.UserPageReqDto;
import com.zara.entity.page.PageParam;
import com.zara.service.IUserService;
import com.zara.vo.page.PageInfoVo;
import com.zara.vo.UserPageResVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : UserController
 * @description : [描述说明该类的功能]
 * @createTime : [2021/12/8 17:33]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 17:33]
 * @updateRemark : [描述说明本次修改内容]
 */
@RestController
@RequestMapping("aboutUser")
public class UserController {

    @Autowired
    private IUserService service;

    @PostMapping("/page")
    public PageInfoVo<UserPageResVo> page(@RequestBody PageParam<UserPageReqDto> dtoPageParam){
        PageInfoVo<UserPageResVo> page = service.page(dtoPageParam);
        page.getList().forEach(System.out::println);
        return page;
    }

    @PostMapping("/list")
    public List<UserPageResVo> list(@RequestBody UserPageReqDto dto){
        List<UserPageResVo> list = service.list(dto);
        return list;
    }
}
