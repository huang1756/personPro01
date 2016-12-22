package com.hyq.api.common;

/**
 * Created by Administrator on 2016/12/22.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager<T> implements Serializable {
    private static final long serialVersionUID = -6901554891308675522L;
    private int pageNo = 1;
    private int pageSize = -1;
    private List<T> results = null;
    private long totalCount = -1L;
    private boolean autoCount = true;

    public Pager() {
        this.results = new ArrayList();
    }

    public Pager(int pageSize) {
        this.results = new ArrayList();
        this.setPageSize(pageSize);
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        if(this.pageNo < 1) {
            this.pageNo = 1;
        }

    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if(this.pageSize < 1) {
            this.pageSize = 20;
        }

    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getFirst() {
        return (this.pageNo - 1) * this.pageSize + 1;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public List<T> getResults() {
        return this.results;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        if(this.getTotalPages() < (long)this.pageNo) {
            this.pageNo = Long.valueOf(this.getTotalPages()).intValue();
        }

    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public boolean isAutoCount() {
        return this.autoCount;
    }

    public void setAutoCount(boolean autoCount) {
        this.autoCount = autoCount;
    }

    public long getTotalPages() {
        if(this.totalCount < 0L) {
            return -1L;
        } else {
            long count = this.totalCount / (long)this.pageSize;
            if(this.totalCount % (long)this.pageSize > 0L) {
                ++count;
            }

            return count;
        }
    }

    public boolean isHasNext() {
        return (long)(this.pageNo + 1) <= this.getTotalPages();
    }

    public int getNextPage() {
        return this.isHasNext()?this.pageNo + 1:this.pageNo;
    }

    public boolean isHasPre() {
        return this.pageNo - 1 >= 1;
    }

    public int getPrePage() {
        return this.isHasPre()?this.pageNo - 1:this.pageNo;
    }

    public void copyExcludeResultsFrom(Pager<?> sourcePager) {
        this.setPageNo(sourcePager.getPageNo());
        this.setPageSize(sourcePager.getPageSize());
        this.setTotalCount(sourcePager.getTotalCount());
        this.setAutoCount(sourcePager.isAutoCount());
    }
}
