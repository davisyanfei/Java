package com.java.reflection;
//import  com.java.reflection.StudentReflection;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class test {

/*             public int hashCode() {
                 final int prime=31;
                 int result=1;
                 result=prime*result+age;
                 result=prime*result+((name==null)?0:name.hashCode());
                 return result;
             }*/

    public static void test1() {
                 System.out.println(false && false);
        Set<String> myset = new HashSet();
        myset.add("str1");

        myset.add("str2");
        myset.add("str3");
        myset.add("str4");
        myset.add("str5");
        myset.add("str1");
        myset.add("str6");

        if(myset.contains("str1")){ System.out.println("contain");}

/*        for ( String str : a) {
            if (str.equals("str1")) {
                System.out.println(str);
                break;
            }
            else System.out.println(str);
        }*/
/*        Iterator it = myset.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/
    }

    public static  void test2(){
        //Set 集合存和取的顺序不一致。
        Set hs = new HashSet();
        hs.add("世界军事");
        hs.add("兵器知识");
        hs.add("舰船知识");
        hs.add("汉和防务");


        System.out.println(hs);
        // [舰船知识, 世界军事, 兵器知识, 汉和防务]
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    public static void main(String[] args) {
        test1();

    }
}


/*
public class test {
    public static void main(String[] args){
        com.java.reflection.StudentReflection a= new com.java.reflection.StudentReflection();
       // com.java.reflection.StudentReflection b= new com.java.reflection.StudentReflection(1,"lisi","nv",17);
    }
}

*/




