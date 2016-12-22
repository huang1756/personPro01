package com.hyq.api.common;

import java.io.Serializable;

public class AbstractBaseModel implements Serializable {

    private Long id;

    public AbstractBaseModel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
