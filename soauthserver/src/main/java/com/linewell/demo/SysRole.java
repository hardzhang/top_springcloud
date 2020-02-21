package com.linewell.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Description:
 * @Author: Administrator
 * @Date: 2020/2/21 0021 14:32
 * @Copyright: Fujian Linewell Software Co., Ltd. All rights reserved.
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
