package com.zara.vo.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author : [Zaara-cat]
 * @version : [v1.0]
 * @className : PageInfoVo
 * @description : [分页查询 统一VO对象]
 * @createTime : [2021/12/8 15:45]
 * @updateUser : [Zaara-cat]
 * @updateTime : [2021/12/8 15:45]
 * @updateRemark : [描述说明本次修改内容]
 */
@Data
@AllArgsConstructor
@Accessors
public class PageInfoVo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;


    public PageInfoVo() {
    }

    /**
     * 包装Page对象
     *
     * @param pageInfo
     */
    public PageInfoVo(PageInfo pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.size = pageInfo.getSize();
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
        this.list = pageInfo.getList();
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", size=").append(size);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
