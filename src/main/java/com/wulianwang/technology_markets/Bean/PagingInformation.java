package com.wulianwang.technology_markets.Bean;
/*
 *分页容器
 * */
public class PagingInformation {
    private int pageSize;          //单页条目数量
    private int totalElements;     //总条目数
    private int totalPages;        //总页数

    public PagingInformation() {
        this.pageSize = 0;
        this.totalElements = 0;
        this.totalPages = 0;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
