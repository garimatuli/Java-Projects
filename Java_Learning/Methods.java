// method - a block of code which only runs when it is called
// To reuse code: define the code once, and use it many times
package july24;

public class Methods {
    static void m1(){
        System.out.println("Executing a method without return type and without parameters");
    }
    static void m2(int a){
        System.out.println("Executing a method without return type but with a parameter "+a);
    }
    static int m3(){
        System.out.println("Executing a method with an integer return type but without parameters");
        return 100; // returns an int
    }
    static int m4(int a) {
        System.out.println("Executing a method with an integer return type but with a parameter "+a);
        return a; // returns an int
    }

    public static void main(String[] args) {
        m1();
        m2(4);
        System.out.println(m3());
        System.out.println(m4(55));
    }
}
