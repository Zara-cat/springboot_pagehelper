package com.zara.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zara.entity.PageParam;
import com.zara.entity.User;
import com.zara.vo.PageInfoVo;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IBasePageService
 * @description : [分页查询 Service的 base 基类]
 * @createTime : [2021/12/8 15:35]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 15:35]
 * @updateRemark : [描述说明本次修改内容]
 */

/**
 * @param <T> 【分页条件】的类型，封装的对象
 * @param <R>  返回结果中 list 的泛型
 */
public interface IBasePageService<T,R> {

    /**
     * 分页查询
     * @param param Page和额外条件合并类
     * @return 分页集合
     */
    default PageInfoVo<R> page(PageParam<T> param){

        PageInfo<R> pageInfo = PageHelper.startPage(param).doSelectPageInfo(() -> list(param.getParam()));
        PageInfoVo<R> pageInfoVo = new PageInfoVo<>(pageInfo);
        return  pageInfoVo;
    }

    /**
     * 集合查询
     * @param t 查询参数
     * @return 查询响应
     */
    List<R> list(T t);
}
/**
 * 1.如果有分页查询的业务，请在响应的 IService 上 实现一下该接口
 * 2.在具体的 ServiceImpl 实现类中，完善 查询方法，并在 mapper 中写上相关的 查询所有的 sql 语句
 * 3.关于sql 语句 可以提前写好 sql 动态查询条件，方便我们 [条件分页]
 *      如：
 *          select username，age
 *          from user
 *          where 1 = 1
 *
 *
 */
