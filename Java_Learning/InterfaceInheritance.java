package july29;

// Nested/Inner Interface

 interface A{
    void show();

    // gives error with any other access specifier
     interface D{ // implicitly static and public
        void method();
    }
}

interface B  {  // implicitly static and public
    static void show(){
        System.out.println("hello");
    };
}

class C implements A,A.D,B{

    @Override
    public void show(){
        System.out.println("Hi");
    }

    @Override
    public void method(){
        System.out.println("Nested Interface");
    }
}

public class InterfaceInheritance {
    public static void main(String[] args) {
        C c= new C();
        c.show(); //Hi
        c.method(); //Nested Interface

        A.D obj = new C();
        obj.method(); //Nested Interface

        B obj1 = new C();
        // DownCasting obj1 from B to C
        ((C) obj1).method(); //Nested Interface
        // Interface B is static so any method in it directly accessed using Interface name
        B.show(); //hello

        // A a = new A(); // ERROR - 'A' is abstract; cannot be instantiated
    }
}

/* Nested interfaces are static by default.
Nested interfaces declared inside class can take any access modifier,
however nested interface declared inside interface is public implicitly.
*/

/* Since nested interface cannot be accessed directly,
the main purpose of using them is to resolve the namespace by grouping related interfaces (or related interface and class) together.
This way, we can only call the nested interface by using outer class or outer interface name followed by dot( . ),
followed by the interface name.
*/

/*In Java, all methods in an interface are public even if we do not specify public with method names.
Also, data fields are public static final even if we do not mention it with fields names.
Therefore, data fields must be initialized.
*/

/* Inner interfaces in Java are mainly used for:
-> solving the name-spacing issue when the interface has a common name
-> increasing encapsulation
-> increasing readability by grouping related interfaces in one place
A well-known example is the Entry interface which is declared inside the Map interface.
Defined this way, the interface isn't in global scope,
and it's referenced as Map.Entry differentiating it from other Entry interfaces and making its relation to Map obvious.
*/
