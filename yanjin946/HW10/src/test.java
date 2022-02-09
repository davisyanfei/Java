import javax.swing.text.AttributeSet;

public class test {
            /**
         * @param args
         */
            public static void main(String args[]) {
/*                B b=new B();
                System.out.println(b);
                System.out.println(c);
                b.aa();*/
                Pet[] pets={new Dog(20), new Cat(30)};
                for (int i = 0; i < 2; i++) {
                    pets[i].call();
                    if (pets[i] instanceof Dog ) {
                        ((Dog)pets[i]).swim();
                    }
                    if (pets[i] instanceof Cat) {
                        ((Cat)pets[i]).climb();
                    }
                }

/*                Pet s1 = new Dog(20);
                Pet s2 = new Cat(30);
                s1.call();
                s2.call();
              //  ((Cat)s2).climb();
                if (s2 instanceof Cat) {
                    ((Cat)s2).climb();
                }*/

            }
    }

    class A{
        int num=5;
        A(){
           show();
        }
        public void show(){
            System.out.println("A"+num);
        }
        public  void  aa(){
            System.out.println("fathers method"+num);
        }
    }

    class B extends A{
      //  int num=10;
        B(){
            num=10;
            showb();

        }

        public void showb(){
            System.out.println("B"+num);
        }
/*        @Override
        public  void  aa(){
            System.out.println("Child's method"+num);
           // super.aa();
        }*/
    }





class Pet {
    int a;
    Pet(){ a = 10; }
    public void call(){System.out.println("父类中a ="+a);}
}

class Dog extends Pet {
    int a;
    Dog(int a){
        this.a = a;
    }
    public void call()
    {
       // System.out.println("父类中a= "+ super.a);
        System.out.println("wawawawa"+a); }

    public void swim(){
        System.out.println("Dog swim "+a);
    }
}

class Cat extends Pet {
    int a;
    Cat(int a){
        this.a = a;
    }
    public void call()
    {
        System.out.println("miaomiaomiao"+a); }

    public void climb(){
        System.out.println("cat climb tree ");
    }
}
