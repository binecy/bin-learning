package com.javassist.start;

/**
 * Created by liangguobin on 2017/7/18.
 */
public class StringDesc {

    public Object val;

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

//    @Override
//    public String toString() {
//        System.out.println(val);
//        java.lang.StringBuffer sb = new java.lang.StringBuffer();
//        sb.append(" title:" +((com.javassist.start.Blog)val).getTitle());
//        sb.append(" content:" +(com.javassist.start.Blog)val.getContent()); return super.toString();
//        return super.toString();
//    }
}
