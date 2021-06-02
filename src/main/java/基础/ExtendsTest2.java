package 基础;

/**
 * 
* @Title: ExtendsTest2
* @Description: 继承测试  经典题
* @Version:1.0.0  
* @author pancm
* @date 2017年6月2日
 */
public class ExtendsTest2 {  
    public static void main(String[] args) {  
        A a1 = new A();  
        A a2 = new B();  
        B b = new B();

        C c = new C();  
        D d = new D();
        E1 e1 = new E1();

//        System.out.println("1--" + a1.show(b));   //A and A
//        System.out.println("2--" + a1.show(c));   //A and A
//        System.out.println("3--" + a1.show(d));   //A and D
//        System.out.println("3--2" + a1.show(e1));   //A and D
//
//        System.out.println("4--" + a2.show(b));   //B and A
//        System.out.println("5--" + a2.show(c));   //B and A
        System.out.println("6--" + a2.show(d));   //A and D
//        System.out.println("6--2" + a2.show(e1));   //A and D
//
//        System.out.println("7--" + b.show(b));    //B and B
//        System.out.println("8--" + b.show(c));    //B and B
//        System.out.println("9--" + b.show(d));    //A and D
//        System.out.println("9--2" + b.show(e1));    //A and D
    }
} 

class A {
    public String show(A obj) {
        return ("A and A");
    }
    public String show(D obj) {
        return ("A and D");
    }  //重载
}
  
 class B extends A{  
    public String show(B obj){  
        return ("B and B");  
    }  
      
    public String show(A obj){  
        return ("B and A");  
    }   //重写
}  
  
 class C extends B{  
  
}  
  
 class D extends B{  

}
class E1 extends D{

}


/**
 * 研究继承内super()函数 和this()指向问题
 *
 * 附加finally机制
 */
class test{
    public static void main(String[] args) {
        B b = new B();
        b.testB(); //继承内，子类可以调用父类函数，而父类不可以调用子类函数
//        A a = new A();
//        A b = new B();

    }

    static class A{
        public A() {
            this.testA();
            System.out.println("A构造函数");
        }
        public A(String name){
            System.out.println("A有参构造");
        }
        public void testA(){
            System.out.println("A测试函数");
        }
        public void testB(){
            System.out.println("A测试2函数");
        }
    }
    static class B extends A{
        public B() {
            super();
            System.out.println("B构造函数");
        }
        public void testA(){
            System.out.println("B测试函数");
        }
//        public void testB(){
//            System.out.println("B测试2函数");
//        }
    }

}
/**
 * 研究继承内super()函数 和this()指向问题
 *
 * 附加finally机制
 */
class Test1 {
    public static void main(String[] args) {
        System.out.println("b"+new B().getValue());
    }
    static class A {
        protected int value; //5 10
        public A (int v) {
            this.setValue(v);//this  谁调用就指向谁
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++; //1、10+1
                return value; //1、 11  2、23
            } finally {
                this.setValue(value);  //this  谁调用就指向谁
                System.out.println("a"+value); //1、22   2、34
            }
        }
    }
    static class B extends A {
        public B () {
            super(5); //1、调用父类构造函数
            setValue(getValue()- 3);
        }
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
