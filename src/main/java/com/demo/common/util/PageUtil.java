package com.demo.common.util;

import java.util.List;

public class PageUtil<T> {

    private Integer currentPage;//当前页码
    private Integer pageSize;//每页显示条数
    private Integer total;//总条数
    private List<T> record;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getStart(){
        return null != currentPage && null != pageSize && currentPage >= 1 && pageSize >= 1?(currentPage - 1) * pageSize:0;
    }
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRecord() {
        return record;
    }

    public void setRecord(List<T> record) {
        this.record = record;
    }
}
