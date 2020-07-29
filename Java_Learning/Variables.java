package july24;

public class Variables {
    // class variable
    static int a = 10; //static variable
    final static int b = 15; //final variable
    // final static int x; // error - Need to initialize final variables at the time of declaration only
   // b = 20;  // error - as we cannot re-assign a value to a final variable

    // non-static variable
    int c = 10; //instance variable
    final int d = 20; // final instance variable
    //local variable in a method

    public static void main(String args[]) {

        // class variables can be accessed without creating any instance of the class
        System.out.println("Value of static class variable a : " + a);
        System.out.println("Value of final static class variable b : " + b);

        // Class Instance created inorder to access a non static variable.
        Variables v = new Variables();
        System.out.println("Value of non-static instance variable c : " + v.c);
        System.out.println("Value of non-static final instance variable d : " + v.d);
        int e = 100; //local variable of main method
        System.out.println("Value of non-static local variable e :"+e);
        myMethod();
        // Error - as local variable of myMethod() does not exist here
        // System.out.println("Value of non-static local variable f :"+f);

        Variables v1 = new Variables();
        Variables v2 = new Variables();

        // only one copy of class variable is shared with all instances of that class.
        // If changes are made to that variable, all other instances will see the effect of the changes.
        System.out.println(v1.a+" "+v2.a); // 10 10
        v1.a = 99;
        v2.a = 88;
        System.out.println(v1.a+" "+v2.a); // 88 88

        // An instance variable is bound to the object itself.
        // And every instance of that class (object) has it's own copy of that variable.
        // Changes made to the variable don't reflect in other instances of that class.
        System.out.println(v1.c+" "+v2.c); // 10 10
        v1.c = 99;
        v2.c = 88;
        System.out.println(v1.c+" "+v2.c); // 99 88
    }
    static void myMethod(){
        int f = 55; //local variable of myMethod()
        System.out.println("Value of non-static local variable f :"+f);
    }
}

// Declaring (Creating) Variables
// dataType variableName = value;

// Types: Local, Instance, Class
/* Local (non-static) variables are declared inside a method, they are not visible outside the method.
   Instance/Member/Field (non-static) variables are declared in a class, but outside a method.
   Class/Static variables are declared with the static keyword in a class, but outside a method. */

// Final Variables: adding final keyword in variable declaration & initialisation makes the variable unchangeable and read-only
// Need to initialize final variables at the time of declaration only
// can be static or non-static

/* A static variable is common to all the instances (or objects) of the class because it is a class level variable.
In other words you can say that only a single copy of static variable is created and shared among all the instances of the class. */

/* Instance variable in Java is used by Objects to store their states.
Variables that are defined without the STATIC keyword and are Outside any method declaration are Object-specific and are known as instance variables.
They are called so because their values are instance specific and are not shared among instances. */

/* A local variable in Java is typically used in a method, constructor, or block and has only local scope.
So, you can use the variable only within the scope of a block.
Other methods in the class aren't even aware that the variable exists. */

/* An instance variable is a variable that's bound to the object itself.
And every instance of that class (object) has it's own copy of that variable.
Changes made to the variable don't reflect in other instances of that class.
an instance variable is created when an object is created and destroyed when the object is destroyed.
*/
