package july27;

// Static - Block, Variable, Method, Class
public class Static_Example {

    //Static block
    static {
        System.out.println("Static block executed");
    }

    int a = 20;

    //static variable
    static int b; // by default value is 0
    static int c = 10; //class variable - shared with all instances of the class

    // static nested class
    static class Demo {
        int d = 15;
        void display() {
            System.out.println("Message from static nested class : " +d); //15
            //Only static member of Outer class is directly accessible in nested static class
            System.out.println("Message from static nested class : " +c); //10 // Compile time error if variable c is not static
            // System.out.println(a); // error - as Non-static field 'a' cannot be referenced from a static context
        }
    }

    //non static nested class - also called Inner class
    private class Inner{
        // Both static and non static member of Outer class is accessible in this Inner class
        public void display(){
            System.out.println("Message from non static nested or Inner class : " + c + " "+a);
        }
    }

    // static method(main !!)
    public static void main(String args[]) {
        // creating instance of nested Static class directly
        Demo demo = new Demo();
        demo.display(); //non-static method called using object of the class

        //  OR by instantiating static class using outer class
        Static_Example.Demo demo1 = new Static_Example.Demo();
        demo1.display(); //non-static method called using object of the class

        // In order to create instance of Inner/non-static nested class you need an Outer class instance first
        Static_Example obj = new Static_Example(); //outer class instance for creating non static nested class below
        Static_Example.Inner inner = obj.new Inner();
        //OR // we can also combine above steps in one step to create instance of Inner class
        Static_Example.Inner nonStaticIner = new Static_Example().new Inner();
        //calling non static method of Inner class
        inner.display();
        nonStaticIner.display();

        display(); // a static method can be called from another static method directly

        System.out.println(obj.a); //20 // non-static variables of class referred using object
        // static variables of class can be referred directly without using object
        System.out.println(c); //10
        System.out.println(b);//0
    }

    // static method
    static void display() {
//        System.out.println(a); // Non-static field 'a' cannot be referenced from a static context
        System.out.println("Message from static method : " +c); // static method can refer to static variables of a class directly
    }
}

/* Static block is used for initializing the static variables.
This block gets executed when the class is loaded in the memory.
A class can have multiple Static blocks, which will execute in the same sequence in which they have been written into the program.
*/

/*Java main() method is always static, so that compiler can call it without the creation of an object or before the creation of an object of the class.
In any Java program, the main() method is the starting point from where compiler starts program execution.
So, the compiler needs to call the main() method.
 */

/* Static Method in Java belongs to the class and not its instances.
A static method can access only static variables of class and invoke only static methods of the class.
Usually, static methods are utility methods that we want to expose to be used by other classes without the need of creating an instance. */

/* A static variable is common to all the instances (or objects) of the class because it is a class level variable.
In other words you can say that only a single copy of static variable is created and shared among all the instances of the class. */

/*
Static classes are basically a way of grouping classes together in Java.
Java doesn't allow you to create top-level static classes; only nested (inner) static classes.
 */

/*
A nested class is a member of its enclosing class.
Non-static nested classes (inner classes) have access to other members of the enclosing class, even if they are declared private.
Static nested classes do not have access to other members of the enclosing class.
 */
