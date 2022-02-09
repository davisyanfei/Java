package com.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        /**
         * 	反射获取类的Class对象的三种方式
         * 1、通过类的实例对象调用getClass();
         * 2、通过类名直接调用.class来获取Class对象，需要导包
         * 3、通过类的全路径，Class.forName("全路径");来获取类的Class对象，此时会抛出一个异常，ClassNotFoundException
         */
        /*第一种*/
/*        StudentReflection sr = new StudentReflection();
        Class<? extends StudentReflection> c1 = sr.getClass();
        System.out.println(c1.getName());*/
/*        第二种
        Class<StudentReflection> c2 = StudentReflection.class;
        System.out.println(c2.getName());*/
       // 第三种（推荐使用）
        //Class<?> c3 = Class.forName("com.java.reflection.StudentReflection");
        Class<?> c3 = Class.forName("java.lang.String");
        System.out.println("C3的类名="+c3.getName());

/*        final String caaa="12";
        String a1=caaa; //new String("12");
        String a2=caaa; //new String("12");
        if (a1==a2){System.out.println("A1和A2是地址相同，同一个对象");}
        else System.out.println("a1和a2是defrent地址，不是一个对象");

        if (a1.equals(a2)) {System.out.println("里边存的值相同");}*/

        /**
         * 获取属性及操作属性
         */
        System.out.println(" getDeclaredFields() printing ");
        Field[] declaredFields = c3.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        System.out.println(" getDeclaredFields() printed--------- ");
        System.out.println("getFields() printing ");
        Field[] fields = c3.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("getFields() printed----------");

        System.out.println("declaredField() printing");
        Field declaredField = c3.getDeclaredField("sex");
        Field declaredField2 = c3.getDeclaredField("age");
        Field declaredField3 = c3.getDeclaredField("name");
        Field declaredField4 = c3.getDeclaredField("id");
        System.out.println(declaredField);
        System.out.println(declaredField2);
        System.out.println(declaredField3);
        System.out.println(declaredField4);
        System.out.println("declaredField() printed------------");

        declaredField4.setAccessible(true);//设置private属性可访问

/*     //此时再去获取类池里的情况，还是原来的类，accessable并没有改
        Class<?> c4 = Class.forName("com.java.reflection.StudentReflection");
        System.out.println(" 修改了id属性以后的 getDeclaredFields() printing ");
        Field[] dFields = c4.getDeclaredFields();
        for (Field field : dFields) {
            System.out.println(field);
        }*/


        //第一种方法  new一个对象， 用这个field 去读取那个新对象的对应字段的值
        com.java.reflection.StudentReflection aa=new com.java.reflection.StudentReflection();
        declaredField4.set(aa, 100);
        System.out.println("declaredField4去读取新new对象的值"+declaredField4.get(aa));
        //下面实验发现，前边修改的id其private属性被改成accessable以后，再次获取field时候还有private，并没有被持久化存储到class的内存中。
        Field field = c3.getDeclaredField("id");
        field.setAccessible(true);
        field.set(aa,2);
        System.out.println("重新获取的field id="+field.get(aa));  //当前的field


        Object obj = c3.getConstructor().newInstance();//通过获取构造方法来new一个对象
        // 设置属性值
        declaredField.set(obj, "男");
        declaredField2.set(obj, 10);
        declaredField3.set(obj, "张三");
        declaredField4.set(obj, 1);

        System.out.println("强制转换调用getid方法  id="+((StudentReflection)obj).getId()); //强制转换调用getid方法
        System.out.println("declaredField4 id="+declaredField4.get(obj));  //用已经set attribute的那个field来获取

       // 设置属性值
        field = c3.getDeclaredField("sex");
        field.set(obj, "女");
      //  获取属性值
        System.out.println(field.get(obj));


        /**
         * 获取构造方法，调用构造方法
         */
        Constructor<?>[] declaredConstructors = c3.getDeclaredConstructors();//获取所有构造
        System.out.println("构造器开始打印");
        for (Constructor<?> aaa : declaredConstructors) {
            System.out.println(aaa);
        }
        System.out.println("构造器打印结束");
        Constructor<?> declaredConstructors2 = c3.getDeclaredConstructor(null);//获取所有无参构造
        Constructor<?> declaredConstructor = c3.getDeclaredConstructor(new Class[]{int.class,String.class,String.class,int.class});//获取指定有参构造

        Constructor<?> constructor = c3.getConstructor(null);//获取无参公有构造
        Constructor<?>[] constructors = c3.getConstructors();//获取所有公有构造
        Object initargs = constructor.newInstance(null);//对无参构造方法的调用

        declaredConstructor.setAccessible(true);
        StudentReflection newInstance = (StudentReflection)declaredConstructor.newInstance(new Object[] {1,"张三","男",10});//对有参且私有的构造方法的调用
        String name = newInstance.getName();
        System.out.println(name);

        /**
         * 获取方法，调用方法
         */
        Method[] declaredMethods = c3.getDeclaredMethods();//获取所有声明的方法
        for (Method method : declaredMethods) {
            System.out.println(method);
        }


        Method declaredMethod = c3.getDeclaredMethod("privMethod", null);//获取名为“privMethod”的无参方法
        Method declaredMethod2 = c3.getDeclaredMethod("proMethod", String.class,int.class);//获取名为"proMethod"，参数类型为String,int的方法

        Method method = c3.getMethod("pubMethod", null);//获取公用的名为“pubMethod”的无参方法
        Method[] methods = c3.getMethods();//获取所有公用的方法

        declaredMethod2.invoke(obj, "测试调用方法",5);
        //调用私有方法
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(obj,null);
    }

}
