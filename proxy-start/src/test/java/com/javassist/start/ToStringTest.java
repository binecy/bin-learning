package com.javassist.start;

import javassist.*;
import org.junit.Test;

/**
 * Created by liangguobin on 2017/7/18.
 */
public class ToStringTest {

    @Test
    public void test1() throws CannotCompileException, NotFoundException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(Blog.class));

        String className = "com.javassist.start.Blog";
        CtClass ccOld = pool.get(className);

        CtClass ccNew = pool.makeClass(className + "Access");
        ccNew.setSuperclass(ccOld);


        CtMethod[] methods = ccOld.getMethods();

        StringBuffer strbuff = new StringBuffer();
        strbuff.append("java.lang.StringBuffer sb = new java.lang.StringBuffer();");
        strbuff.append("sb.append(\"" + className + " -> \");");

        for (CtMethod method : methods) {
            if (method.getName().startsWith("set")) {
                String shortName = method.getName().substring(3);
                String fieldName = shortName.toLowerCase();
                if (method.getParameterTypes()[0].getName().equals(boolean.class.getName())) {
                    strbuff.append("sb.append(\" " + fieldName + ":\" +is" + shortName + "());");
                } else {
                    strbuff.append("sb.append(\" " + fieldName + ":\" +get" + shortName + "()); ");
                }
            }
        }

        strbuff.append("return sb.toString();");


        System.out.println(strbuff.toString());

        CtMethod sm = new CtMethod(pool.get("java.lang.String"), "toString", null, ccNew);
        sm.setBody("{" + strbuff.toString() + "}");
        ccNew.addMethod(sm);



        //System.out.println(ccNew.toClass().toString());
        Blog b = (Blog) ccNew.toClass().newInstance();

        b.setTitle("test");
        b.setContent("hello");
        System.out.println(b.toString());
    }

    @Test
    public void test2() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {

        StringDesc stringDesc = getStringDesc(Blog.class);
        Blog blog = new Blog();
        blog.setContent("hello");
        blog.setTitle("test");

        stringDesc.setVal(blog);

        System.out.println(stringDesc);
    }


    private StringDesc getStringDesc(Class clazz) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(StringDesc.class));


        String className = "com.javassist.start.StringDesc";
        CtClass ccOld = pool.get(className);

        CtClass ccNew = pool.makeClass(className + "Access");
        ccNew.setSuperclass(ccOld);

        StringBuffer strbuff = new StringBuffer();

//        strbuff.append("System.out.println(val);");
        strbuff.append("java.lang.StringBuffer sb = new java.lang.StringBuffer();");


        String valClassName = clazz.getName();

        CtClass ccVal = pool.get(valClassName);

        CtMethod[] methods = ccVal.getMethods();
        for (CtMethod method : methods) {
            if (method.getName().startsWith("set")) {
                String shortName = method.getName().substring(3);
                String fieldName = shortName.toLowerCase();
                if (method.getParameterTypes()[0].getName().equals(boolean.class.getName())) {
                    strbuff.append("sb.append(\" " + fieldName + ":\" +((" + valClassName +")val).is" + shortName + "());");
                } else {
                    strbuff.append("sb.append(\" " + fieldName + ":\" +((" + valClassName + ")val).get" + shortName + "()); ");
                }
            }
        }
        strbuff.append("return sb.toString();");

        System.out.println(strbuff.toString());


        CtMethod sm = new CtMethod(pool.get("java.lang.String"), "toString", null, ccNew);
        sm.setBody("{" + strbuff.toString() + "}");
        ccNew.addMethod(sm);

        StringDesc stringDesc = (StringDesc)ccNew.toClass().newInstance();
        return stringDesc;
    }
}
