package com.netease.liveroomsdk.domain;

/**
 * Created by bjzhanxiang on 2017/3/25.
 */
public class PageInfo {


    /**
     * pageNo : 1
     * pageSize : 20
     * totalSize : 5
     * sort : 0
     * hasMore : false
     * pageType : PAGE
     * cursor : null
     * pageCount : 1
     * offset : 0
     */

    private int pageNo;
    private int pageSize;
    private int totalSize;
    private int sort;
    private boolean hasMore;
    private String pageType;
    private String cursor;
    private int pageCount;
    private int offset;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
