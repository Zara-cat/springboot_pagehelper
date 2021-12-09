package com.zara.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zara.entity.page.PageParam;
import com.zara.vo.page.PageInfoVo;

import java.util.List;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : IBasePageService
 * @description : [分页查询 Service 的 base 基类,如果有业务需要就继承该接口]
 * @createTime : [2021/12/8 15:35]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 15:35]
 * @updateRemark : [描述说明本次修改内容]
 */

/**
 * @param <T>  PageInfo 中 param 的 参数类型，
 * @param <R>  响应 前端的 vo对象 类型
 */
public interface IBasePageService<T,R> {

    /**
     * 分页查询
     * @param param
     * @return 封装的 PageInfoVo （对 PageHelper 中 PageInfo 的封装）
     */
    default PageInfoVo<R> page(PageParam<T> param){
        // 注意这里使用 PageHelper.startPage(Object obj)方法，注意配置 PageHelper文件中的 param 方法，
        // 但是如果使用本案例的PageParam，不需要配置 param参数,
        // param 默认配置就是 pageNum = pageNum ...
        // 这里直接 使用 page（PageHelper.startPage(param)的返回值） 的 doSelectPageInfo()方法进行分页，直接转换成 PageInfo 对象
        // 注意： doSelectPageInfo() 的参数 可是使用 java8新特性 Lambda 表达式进行实现，
        PageInfo<R> pageInfo = PageHelper.startPage(param).doSelectPageInfo(() -> list(param.getParam()));
        // 使用PageInfo 的 构造方法 进行 PageInfo 和 PageInfoVo 的转换
        PageInfoVo<R> pageInfoVo = new PageInfoVo<>(pageInfo);
        return  pageInfoVo;
    }

    /**
     * 集合查询
     * @param t 查询参数
     * @return 查询响应
     */
    //这里把list方法单独写出去的目的：
    //      1：分页和集合查询的分离和解耦
    //      2.当我们有对应的 条件对象传入的时候，我们可以将其实现后然后，加工处理我们的条件
    //          如：前端传过来名称，我们需要模糊查询。这样就可以在 list() 的实现中进行加工我们的查询条件参数
    List<R> list(T t);
}
