package july24;

public class SetterGetters {
    public static void main(String args[]) {
        Hello hello = new Hello();
        // hello.a = 5; // error as variable a is declared as private, we cannot directly access it here ie from outside its class
        hello.setA(5);
        hello.setB(4);
        // System.out.println(hello.a); // error -
        System.out.println(hello.getA()); //5
        System.out.println(hello.getB()); //4
    }
}

class Hello {
    private int a; // private = restricted access
    private int b; // left click -> Generate -> Getter & Setter
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
}

/*Getters and setters encapsulate the fields of a class by making them accessible only through its public methods and keep the values themselves private.
 Encapsulation, is to make sure that "sensitive" data is hidden from users. To achieve this, you must:
-> declare class variables/attributes as private
-> provide public get and set methods to access and update the value of a private variable
So, a setter is a method that updates the value of a variable.
And a getter is a method that reads the value of a variable.
Getter and setter are also known as accessor and mutator in Java.
 */
