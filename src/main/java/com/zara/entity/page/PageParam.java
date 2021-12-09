package com.zara.entity.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author : [Zara-cat]
 * @version : [v1.0]
 * @className : PageParam
 * @description : [分页查询 实体类]
 * @createTime : [2021/12/8 15:56]
 * @updateUser : [Zara-cat]
 * @updateTime : [2021/12/8 15:56]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
//注意：这里的属性名称在本例中不需要配置 yml的 param 。业务如果需要修改属性名，请在 yml 中同步设置
public class PageParam<T> {
    // 页码，默认 1
    private Integer pageNum = 1;
    // 每页数量 默认1
    private Integer pageSize = 1;
    // 排序 id desc
    private String orderBy;
    // 其他参数
    private  T param;

    public PageParam<T> setOrderBy(String orderBy) {
        this.orderBy = orderBy; // 此处可优化 优化详情且看解析
        return this;
    }
}
