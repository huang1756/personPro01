package com.hyq.admin.common;

import javax.persistence.*;

/**
 * 实体基类
 * Created by Administrator on 2016/12/21.
 */
@MappedSuperclass
public class BaseEntity {
    /**ID222266666666666666666666666666666666666666666666666*/
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    public BaseEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
