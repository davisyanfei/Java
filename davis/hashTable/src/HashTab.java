package com.hashtable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import  com.hashtable.SingleLinkedList;



public class HashTab {
    public SingleLinkedList [] hashtable;
    public int hash_length=8;
    static int jj=0;
    String text_path;
    public HashTab() {//默认构造方法，初始化哈希表，但是每个单链表只有头节点
        hashtable=new SingleLinkedList[hash_length];
        for(int i=0;i<hash_length;i++) {
            hashtable[i]=new SingleLinkedList();
        }
        //创建空哈希表
    }
    public HashTab(String filepath) throws IOException {//传进去的是文件路径
        this();//先创建哈希表
        /**这里是文件读取方法，可能会出错**/
        File file=new File(filepath);
        String textLine1;//读取文件的第一行，是电话号码
        String textLine2 = null;//读取文件的第二行，是姓名
        String textLine3 = null;//读取文件的第三行，是家庭住址
        //一次性读三行，如此反复，每三行是一个用户的信息
        int key;
        BufferedReader read=new BufferedReader(new FileReader(file));
        try {

            while((textLine1=read.readLine())!=null) {
                for(int line=1;line<=3;line++) {
                    if(line==1) {
                        System.out.println("电话号码:"+textLine1);
                    }
                    else if(line==2) {
                        textLine2=read.readLine();
                        System.out.println("姓名:"+textLine2);
                    }
                    else if(line==3) {
                        textLine3=read.readLine();
                        System.out.println("家庭住址:"+textLine3);
                    }
                }//一个用户读完了
                key=get_key(textLine1);//获取关键字值
                hashtable[key].Insert(textLine1, textLine2, textLine3,key);//把记录插入金指定的单链表之中
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            read.close();//一定要关闭IO流
        }

    }
    public int get_key(String phone) {//触摸区域发确定关键字值，也就是哈希函数啦
        int key=0;
        char [] phonenumber=phone.toCharArray();
        for(int i=0;i<phonenumber.length;i++) {
            String str=String.valueOf(phonenumber[i]);
            str.trim();
            int j=Integer.parseInt(str);
            //System.out.print("看看字符串转int型有没有问题"+j);
            key=key+j;
        }
        key=key%7;
        System.out.println("关键字:"+key);
        return key;
    }
    public String [] search(String phonenumber) {//在哈希表上查找,传的参数是电话号码，从图形用户界面上获取啦啦啦我最帅
        String[] context=new String[3];//查询的信息，有电话号码，姓名和住址
        int key=get_key(phonenumber);
        context=hashtable[key].search(phonenumber);//在对应的同义词单链表上去查
        return context;
    }
    public void delete(String phonenumber) {//在哈希表上删除，传的参数是电话号码，从图形用户界面上获取啦啦啦我最帅
        int key=get_key(phonenumber);
        hashtable[key].delete(phonenumber);//在对应的同义词单链表上去删除
        PrintHash();//每次更新了哈希表都在控制台上自动打印出来
    }
    public void Insert(String phonenumber,String thename,String theplace) {//在哈希表上插入一个新记录
        int key=get_key(phonenumber);
        hashtable[key].Insert(phonenumber, thename, theplace,key);//把记录插入金指定的单链表之中
        PrintHash();//每次更新了哈希表都在控制台上自动打印出来
    }
    public void PrintHash() {//在控制台上打印哈希表
        for(int i=0;i<hash_length;i++) {
            hashtable[i].printList(i);//也就是打印每一个单恋比奥啦
            System.out.println();
        }

    }

    public static void main(String[] args) {
        try{
            HashTab myhashTable=new HashTab("D:/GitHub/davis/hashTable/user.txt");
            String[] mycontext=new String[3];
            mycontext=myhashTable.search("13910001001");
            System.out.println("我的打印"+mycontext[0]  +mycontext[1]   +mycontext[2]);
            mycontext=myhashTable.search("13910001007");
            System.out.println("我的打印"+mycontext[0]  +mycontext[1]   +mycontext[2]);
        }
        catch (Exception e) {

        };

/*        int i;
        for (i=0;i<100;i++ ){
            System.out.println(hashTable.arrays[i]);
        }*/



    }



}
