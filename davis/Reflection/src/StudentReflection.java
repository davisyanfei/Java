package com.java.reflection;
public class StudentReflection {
    /*参数*/
    public String sex;  //都可以访问
    int age;  //package内可以访问
    protected String name;  //package 和 子类 可以访问
    private int id; //只有自己可以访问

    /*多参数构造*/
    private StudentReflection(int id, String name, String sex, int age) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
       // System.out.println("多参数构造方法运行  "+this.name+"---"+this.sex);
    }

    /*无参构造*/
    public StudentReflection() {
        super();
        this.id = 1;
        this.name = "zhagnsan";
        this.sex = "男";
        this.age = 17;
     //   System.out.println("无参构造方法运行 "+this.name+"---"+this.sex);
    }
    /*公用方法*/
    public void pubMethod() {
        System.out.println("公用方法");
    }
    /*私有方法*/
    private void privMethod() {
        System.out.println("私有方法");
    }

    /*受保护的方法*/
    protected void proMethod(String a,int b) {
        System.out.println(a+b);
    }

    /*默认权限的的方法*/
    void defMethod() {
        System.out.println("默认权限的的方法");
    }

    /*get和set方法*/
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
