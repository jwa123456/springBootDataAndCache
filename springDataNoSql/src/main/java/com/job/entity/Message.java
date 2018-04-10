package com.job.entity;

import org.springframework.data.annotation.Id;

/**
 * @Author: wei.jiang
 * @Date: Created on 2018/4/10
 */
public class Message {

    @Id
    private String id;
    private String title;
    private String desc;
    private Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Message(String id, String title, String desc, Integer count) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.count = count;
    }
}
