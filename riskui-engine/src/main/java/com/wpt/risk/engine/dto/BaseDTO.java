package com.wpt.risk.engine.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

    private Integer pageSize;                           //每页个数
    private Integer curPage;                            //当前页

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    @Override
    public String toString() {
        return "BaseDTO{" +
                "pageSize=" + pageSize +
                ", curPage=" + curPage +
                '}';
    }
}