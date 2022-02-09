package com.lux.study.assist;

import javassist.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: lux
 * @date: 2017/10/25 14:54
 */
public class App {
    public static void main(String[] args) {
        try {
            String className = "com.lux.study.assist.UserInfo";
            UserInfo userInfo = new UserInfo();
            userInfo.setName("test");
            userInfo.setId(1);
            System.out.println("before:" + userInfo);
            ClassPool pool = ClassPool.getDefault();
            CtClass cc = pool.get(className);
            CtMethod mthd = CtNewMethod.make("public String test() { return \" test() is called \"+ toString();  }", cc);
            cc.addMethod(mthd);



            AppClassLoader appClassLoader = AppClassLoader.getInstance();
            Class<?> clazz = appClassLoader.findClassByBytes(className, cc.toBytecode());
//            clazz.getDeclaredConstructor().newInstance();
            Object obj = appClassLoader.getObj(clazz,userInfo);
            System.out.println("after:" + obj);
            //测试反射调用添加的方法
            System.out.println(obj.getClass().getDeclaredMethod("test").invoke(obj));

            Class<?> c4 = Class.forName(className);
/*            System.out.println(" addmenthond以后的 getDeclaredFields() printing ");
            Method[] declaredMethods = c4.getDeclaredMethods();//获取所有声明的方法
            for (Method method : declaredMethods) {
                System.out.println(method);
            }
            System.out.println(" addmenthond以后的 getDeclaredFields() printed------ ");*/
            UserInfo myuser = new UserInfo();
            Method method = c4.getMethod("getName");
            System.out.println(((Method)mthd).invoke(myuser));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}