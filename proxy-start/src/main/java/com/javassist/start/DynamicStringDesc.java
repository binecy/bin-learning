package com.javassist.start;

import javassist.*;

/**
 * Created by bin on 2017/7/22.
 */
public class DynamicStringDesc {

    public static <T> StringDesc<T> getStringDesc(Class<T> clazz) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(StringDesc.class));
        pool.insertClassPath(new ClassClassPath(clazz));


        CtClass stringDescCt = pool.get(StringDesc.class.getName());
        // beanStringDescCt是动态生成的类
        CtClass beanStringDescCt = pool.makeClass(clazz.getSimpleName() + "StringDesc");
        // 设置动态类的父类是StringDesc
        beanStringDescCt.setSuperclass(stringDescCt);

        // strBuilder用于构建toString方法体
        StringBuilder strBuilder = new StringBuilder();

        String beanClassName = clazz.getName();
        strBuilder.append("java.lang.StringBuffer sb = new java.lang.StringBuffer();");
        // 输出bean类名
        strBuilder.append("sb.append(\"" + beanClassName  + "[\");");

        CtClass beanCt = pool.get(beanClassName);

        CtMethod[] methods = beanCt.getMethods();
        // 输出bean属性
        for (CtMethod method : methods) {
            if(method.getName().startsWith("get")) {
                String fieldName = method.getName().substring(3).toLowerCase();

                strBuilder.append("sb.append(\"" + fieldName + "=\" +((" + beanClassName +")bean)." + method.getName() + "() + \", \");");

            }
        }

        strBuilder.append("sb.append(\"]\");");
        strBuilder.append("return sb.toString();");

        // 动态构建toString方法
        CtMethod sm = new CtMethod(pool.get("java.lang.String"), "toString", null, beanStringDescCt);
        // 设置方法体
        sm.setBody("{" + strBuilder.toString() + "}");
        // 将toString方法添加到动态类中
        beanStringDescCt.addMethod(sm);

        // 生成动态类实例
        StringDesc stringDesc = (StringDesc)beanStringDescCt.toClass().newInstance();
        return stringDesc;
    }
}
