import java.awt.desktop.SystemEventListener;
//抽象类
abstract class Absclass {
    int aa=0;
    public  abstract void run();
    public void start(){
        aa =aa +111;  //先运行一堆语句，然后call run
        run();
        System.out.println("print by start methond");
    };
}
//接口, 接口说到底是定义了一个规范，比如下边就定义了一个函数名称必须为jiekou1，没有参数，返回空
//被其他类调用的时候，调用者会按照这个规范、规则，去调用
abstract interface Jiekou {
    public  abstract void jiekou1();

}



class Bclass extends Absclass implements Jiekou {
    @Override
    public void run() {
        aa=aa+10;
    }
    @Override
    public void jiekou1() {
        System.out.println("Bclass implements jiekou1");
    }



    public static void main(String[] args) {
        Absclass w=new Absclass(){
            @Override
        public void run() {
                 aa=aa+10;
                }
        };
        w.start();


        Bclass b = new Bclass();
       // b.a = 100;
        b.jiekou1();
    }
}


