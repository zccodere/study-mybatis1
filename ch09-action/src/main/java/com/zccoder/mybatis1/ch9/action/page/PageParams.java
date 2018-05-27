package com.zccoder.mybatis1.ch9.action.page;

/**
 * 标题：分页参数<br>
 * 描述：分页参数<br>
 * 时间：2018/05/24<br>
 *
 * @author zc
 **/
public class PageParams {

    /**
     * 当前页码
     */
    private Integer page;
    /**
     * 分页条数
     */
    private Integer pageSize;
    /**
     * 是否启动插件
     */
    private Boolean useFlag;
    /**
     * 是否检测当前页码的有效性
     */
    private Boolean checkFlag;
    /**
     * 当前SQL返回总数，插件回填
     */
    private Integer total;
    /**
     * SQL以当前分页的总页数，插件回填
     */
    private Integer totalPage;

    @Override
    public String toString() {
        return "PageParams{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", useFlag=" + useFlag +
                ", checkFlag=" + checkFlag +
                ", total=" + total +
                ", totalPage=" + totalPage +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Boolean useFlag) {
        this.useFlag = useFlag;
    }

    public Boolean getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Boolean checkFlag) {
        this.checkFlag = checkFlag;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
