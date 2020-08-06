package july30;

class A{
    void show(){
        System.out.println("A");
    }
}
class B extends A{
    void display(){
        System.out.println("B");
    }
}
class C extends B{
    void disp() {
        System.out.println("C");
    }
}
public class Casting {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        c.disp();
        c.display();
        c.show();

        A a1 = new B(); // Implicit up-casting from child to parent
        A a2 = (A) new B(); // Explicit up-casting (Not required) as its equivalent to A a1 = new B();
        a1.show();
        a2.show();

//        a.disp();//Error - method of subclass can't be directly called using parent's object
//        b.disp();//Error - to prvent it use DownCasting shown below
        ((C)a).disp();//down casting
        ((C)b).disp();//down casting
    }
}
