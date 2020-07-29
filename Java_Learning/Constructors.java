package july24;
/* A Java constructor is special method that is used to initialize objects.
* It is called when an object is instantiated.
* A constructor in Java can not be abstract, final, static and Synchronized.
*/
public class Constructors {
    private static int number = 0;
    // Constructor Overloading - more than one constructor with different parameters list, in such a way so that each constructor performs a different task.
    // No-argument constructor / default constructor
    public Constructors() {
        System.out.println("Parent class Default Constructor");
        number = 5;
        System.out.println("Number: "+number);
    }
    public Constructors(int theNumber) {
        System.out.println("Parent class Parameterized Constructor");
        this.number = theNumber;
        System.out.println("Number: "+number);
    }

    public static void main(String[] args) {
        System.out.println(number); // 0
        // Create an object of class Constructors (This will call the default constructor)
        Constructors myObj = new Constructors();
        System.out.println(myObj.number); // 5
        // Create an object of class Constructors (This will call the default constructor)
        Constructors myObj1 = new Constructors(100);
        System.out.println(myObj1.number); // 100
        C_Child myChild = new C_Child();
        C_Child myChild1 = new C_Child(55);
    }
}

/* subclass C_Child extending the Constructors class */
class C_Child extends Constructors
{
    C_Child()
    {
        // invoke or call parent class constructor
        super();
        System.out.println("Child class Default Constructor");
    }
    C_Child(int myNum)
    {
        // invoke or call parent class constructor
        super(myNum);
        System.out.println("Child class Parameterized Constructor");
    }
}
