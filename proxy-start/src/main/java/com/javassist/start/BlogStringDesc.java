package com.javassist.start;

/**
 * Created by bin on 2017/7/22.
 */
public class BlogStringDesc extends StringDesc<Blog> {
    @Override
    public String toString() {
        return "blog[title=" + getBean().getTitle() + ", content=" + getBean().getContent() + "]";
    }
}
