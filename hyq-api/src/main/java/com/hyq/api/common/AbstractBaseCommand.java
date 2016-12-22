package com.hyq.api.common;

import java.io.Serializable;
import java.util.List;

public class AbstractBaseCommand implements Serializable {
    private Long id;
    private List<Long> ids;
    private int page;
    private int pageSize = 0;
    private String unknow;
    private String deviceId;
    private String fromIp;
    private String version;
    private String fmc;
    private String fic;

    public AbstractBaseCommand() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return this.ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getUnknow() {
        return this.unknow;
    }

    public void setUnknow(String unknow) {
        this.unknow = unknow;
    }

    public <T> Pager<T> compose() {
        Pager pager = new Pager();
        pager.setPageNo(this.page);
        if(this.pageSize > 0) {
            pager.setPageSize(this.pageSize);
        } else {
            pager.setPageSize(20);
        }

        return pager;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getFromIp() {
        return this.fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFmc() {
        return this.fmc;
    }

    public void setFmc(String fmc) {
        this.fmc = fmc;
    }

    public String getFic() {
        return this.fic;
    }

    public void setFic(String fic) {
        this.fic = fic;
    }
}
