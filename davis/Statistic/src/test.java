// package top.itwinkle.publib;
/*
        1、项目名全部小写.
        2、包名全部小写.
        3、类名首字母大写,其余组成词首字母依次大写.
        4、变量名,方法名首字母小写,如果名称由多个单词组成,除首字母外的每个单词的首字母都要大写.
        5、常量名全部大写.
        6、所有命名规则必须遵循以下规则 :
*/
import javax.swing.*;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class test
{


    // 打印字符串取出ascii值，对于中文字符的ascii值的理解。
    public static void str_asci() {
/*        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,./;'[]-=`!@#$%^&*()一二三四-=【】；‘，。、";
        String longStr="";
        System.out.println("常用字符acsii表");
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i); //依次取出每个字母
            int index = tmp; //利用ascii码表，最小结果是0.
            longStr=longStr +tmp + "是" + index+";  ";
            if ((i % 10) ==9) {
                System.out.println(longStr);
                longStr ="";
            }
        }
        System.out.println(longStr);*/
        char w=65;
        System.out.println("65 is "+w);
    }

    // 测试 switch case语句的执行顺序，对于命中的case，会继续执行后边的所有的case语句中的内容，不再检查case条件。
    public static void swCase(char[] args) {
        String a = String.valueOf(args);
        switch (a){
            case "cs1800":
                System.out.println(args);
                break;
            default:
                System.out.println(args);
                break;
        }

        for (int i=0; i<3; i++){
            switch (i){
                case 1:
                    System.out.println("1");
                case 2:
                    System.out.println("2");
                case 3:
                    System.out.println("3");

            }
        }
        if (0b10 != 0b1) System.out.println("false");
        System.out.println(0b10==0b1);
    }


/*    java == 是测试两个对象所引用的地址是否为同一地址。  测试值是否相同用 iseqal
    java 可以让两个string对象指向同一地址，但是在从新给string赋值的时候，string的地址指向了新的值的内存空间。
    对string对象不提供直接修改内容值的方法，保证了程序的安全性
    但是对于普通object对象，如果b=a，则可以通过修改b的属性，从而也修改了a的属性*/
    public static class Obj{
         private String a="aaa";
    }
    public static void testString() {
/*        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);  //返回true。 因为指向了同一个常量地址
        //因为String类是引用数据类型，"=="比较的是两个引用变量的地址；如果是基本类型变量，则比较的是变量值。
        String name1 = new String("xubing");
        String name2 = new String("xubing");
        System.out.println(name1 == name2); //因为两个变量指向的地址不一样，所以返回false*/


        Obj[] objs= new Obj[2];
        objs[0] = new Obj();
        objs[1]=objs[0];
        objs[1].a = "bbbb";
        System.out.println(objs[0].a);
        System.out.println(objs[0]==objs[1]);

        Obj obj1,obj2;
        obj1 = new Obj();
        obj2 = new Obj();
        System.out.println(obj1==obj2);
        obj2 = obj1;
        System.out.println(obj1==obj2);


        System.out.println(obj1.a);
        obj2.a ="bbb";
        System.out.println(obj1.a==obj2.a);
        System.out.println(obj1.a);
    }


    public static void testStr2() {
        String str1 = "abc";
        System.out.println("试验1"+(str1 == "abc"));
/*       1 步骤：
        开辟一块空间存放引用str1，
        String池中开辟一块空间，存放String常量"abc"，
        引用str1指向池中String常量"abc"，
        str1所指代的地址即常量"abc"所在地址，输出为true*/

        String str2 = new String("abc");
        System.out.println("试验2"+(str2 == "abc"));
/*        2步骤：
        开辟一块空间存放引用str2，
        堆中开辟一块空间存放一个新建的String对象"abc"，
        引用str2指向堆中的新建的String对象"abc"，
        str2所指代的对象地址为堆中地址，而常量"abc"地址在池中，输出为false*/


        String str3 = new String("abc");
        System.out.println("试验3"+(str3 == str2));
/*        3步骤：
        栈中开辟一块空间存放引用str3，
        堆中开辟一块新空间存放另外一个(不同于str2所指)新建的String对象，
        引用str3指向另外新建的那个String对象
        str3和str2指向堆中不同的String对象，地址也不相同，输出为false*/

        String str4 = "a" + "b";
        System.out.println("试验4"+(str4 == "ab"));
/*        4步骤：
        栈中开辟一块空间存放引用str4，
        根据编译器合并已知量的优化功能，池中开辟一块空间，存放合并后的String常量"ab"，
        引用str4指向池中常量"ab"，
        str4所指即池中常量"ab"，输出为true*/


        final String s = "a";
        String str5 = s + "b";
        System.out.println("试验5"+(str5 == "ab"));
/*        步骤：
        同4*/

        String s1 = "a";
        String s2 = "b";
        String str6 = s1 + s2;
        System.out.println("试验6"+(str6 == "ab"));
/*        步骤：
        栈中开辟一块中间存放引用s1，s1指向池中String常量"a"，
        栈中开辟一块中间存放引用s2，s2指向池中String常量"b"，
        栈中开辟一块中间存放引用str6，
        s1 + s2通过StringBuilder的最后一步toString()方法还原一个新的String对象"ab"，因此堆中开辟一块空间存放此对象，
        引用str6指向堆中(s1 + s2)所还原的新String对象，
        str6指向的对象在堆中，而常量"ab"在池中，输出为false*/


        String str7 = "abc".substring(0, 2);
/*        步骤：
        栈中开辟一块空间存放引用str7，
        substring()方法还原一个新的String对象"ab"(不同于str6所指），堆中开辟一块空间存放此对象，
        引用str7指向堆中的新String对象，*/

        String str8 = "abc".toUpperCase();
/*        步骤：
        栈中开辟一块空间存放引用str8，
        toUpperCase()方法还原一个新的String对象"ABC"，池中并未开辟新的空间存放String常量"ABC"，
        引用str8指向堆中的新String对象*/

    }

/*    public static void arraylst() {
        ArrayList arr1 = new ArrayList();
*//* 建立一个Collection *//*
        String[] strings = {"A"， "B"， "C"， "D"};
        Collection stringList = java.util.Arrays.asList(strings);
        *//* 开始遍历 *//*
        for (Iterator itr = stringList.iterator(); itr.hasNext();) {
            Object str = itr.next();
            System.out.println(str);
        }
    }*/


    public static void main(String[] args) {
/*        char[] a = "cs112".toCharArray();
        swCase (a);*/
      //  testString();

/*        int[] arrayofNumbers ={1,2,3,9,5,6,7,8};
        for (int i : arrayofNumbers){
            System.out.println(i);
        }*/
        str_asci();
    }

}
