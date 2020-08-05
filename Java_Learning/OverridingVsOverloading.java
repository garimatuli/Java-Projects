package july28;

import java.util.stream.Stream;

class Dog{
    //Method Overriding with Hound's bark()
    //Method Overloading
    public void bark(){
        System.out.println("woof ");
    }
    //Method Overloading
    public void bark(int n){
        Stream.generate(() -> "woof ").limit(n).forEach(System.out::print);
        System.out.println();
    }
}
class Hound extends Dog{

    //Method Overloading
    public void sniff(){
        System.out.println("sniff ");
    }
    //Method Overloading
    public void sniff(int n){
        Stream.generate(() -> "sniff ").limit(n).forEach(System.out::print);
        System.out.println();
    }

    //Method Overriding
    public void bark(){
        System.out.println("bowl");
    }
}

public class OverridingVsOverloading {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.bark(); // woof
        dog.bark(4); // woof woof woof woof


        Dog dogH = new Hound();
        // Method Overloading
        // Reference type 'dog' here determines which overloaded method will be used at compile time.
        dogH.bark(); // bowl - it would have called Dog's bark() & output woof but then it was overridden by Hound's bark()
        dogH.bark(4); // woof woof woof woof
        // Method Overriding
        // 'Hound' here which is the real object type in the run-time (not the reference variable's type), determines which overridden method is used at runtime.
        dogH.bark(); // bowl // Hound's bark() is called instead of Dog

        Hound hound = new Hound();
        hound.sniff(); //sniff
        hound.sniff(4); // sniff sniff sniff sniff
    }
}


/*The most basic difference is that overloading is done in the same class while for overriding base and child classes are required.
Overriding is all about giving a specific implementation to the inherited method of parent class.*/

/* Overriding means having two methods with the same method name and parameters (i.e., method signature).
One of the methods is in the parent class and the other is in the child class.
Overloading occurs when two or more methods in one class have the same method name but different parameters.
*/

// Overriding is a run-time concept while overloading is a compile-time concept.
/* The real object type in the run-time, not the reference variable's type, determines which overridden method is used at runtime.
In contrast, reference type determines which overloaded method will be used at compile time. */

// Overloading is known as compile-time polymorphism.
// Overriding is known as runtime polymorphism​.
