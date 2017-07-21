package com.spring.start.bean;

/**
 * Created by liangguobin on 2017/7/3.
 */
public class Blog implements IBlog{

    private String title;
    private String content;

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
