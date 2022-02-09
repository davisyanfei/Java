package com.hashtable;

public class SingleLinkedList {//单链表
    public Node Head;
    
    public class Node{//节点
        public String phone_number;
        public String name;
        public String address;
        public int key;//哈希表关键字值
        public Node next;



        public Node() {//初始化单链表头节点
            phone_number=null;
            name=null;
            address=null;
            next=null;
            key=-1;
        }
        public Node(String phone_number,String name,String address,int key) {
            this.phone_number=phone_number;
            this.name=name;
            this.address=address;
            next=null;
            this.key=key;
        }
    }//节点内部类结束
    public SingleLinkedList(){
        Head=new Node();//创建头节点是必要的
    }
    public void Insert(String s1,String s2,String s3,int key) {//创建单恋表和插入新节点进单链表
        Node node=new Node(s1,s2,s3,key);
        node.next=Head.next;//插到头节点的后面
        Head.next=node;
    }
    public String [] search(String str) {//在单链表上的查询操作,读入电话号码
        String[] context=new String[3];//查询的信息，有电话号码，姓名和住址
        Node p=Head.next;
        while((p!=null)&&(!p.phone_number.equals(str))) {
            p=p.next;
        }
        if(p==null) {
            for(int i=0;i<context.length;i++) {
                context[i]="没有你要查找的电话号码";}
        }else {
            context[0]=p.phone_number;
            context[1]=p.name;
            context[2]=p.address;
        }
        return context;
    }
    public void delete(String str) {//在单链表上执行删除操作，读入的也是电话号码
        Node p=Head.next;
        Node q=Head;//前驱节点
        while((p!=null)&&(!p.phone_number.equals(str))) {
            q=p;
            p=p.next;
        }
        if(p==null) {
            System.out.println("没有找到你要删除的电话号码");
            return;

        }else {
            System.out.println("看看是不是真的找到了"+p.phone_number);//看看是不是真的找到了
            q.next=p.next;//节点删除操作
        }
    }
    public void printList(int key) {//在控制台上打印这个单链表
        Node p=Head;
        Head.key=key;
        while(p!=null) {
            System.out.print(p.phone_number+p.name+p.address+"("+p.key+")"+"——————>");
            p=p.next;
        }
    }



}
