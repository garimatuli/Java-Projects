package july29;

abstract class Person{
    // This code inside block is executed each time a child class object is created
    {
        System.out.println("I am working");
    }

    // static block (also called static clause) which can be used for static initializations of a class.
    // This code inside static block is executed only once: the first time the class is loaded into memory.
    static {
        System.out.println("I am static");
    }

    // void sleep(); // ERROR - Missing method body, or declare abstract

    // Abstract methods can't have body
    abstract void work();

    void eat(){
        System.out.println("I am eating");
    }
}

class Student extends Person{
    @Override
    void work() {
        System.out.println("I study");
    }

    @Override
    void eat(){
        System.out.println("Eating Chocolates");
    }
}

class Programmer extends Person{
    @Override
    void work() {
        System.out.println("I code");
    }
}

public class Abstract_Example {
    public static void main(String[] args) {
        Programmer programmer = new Programmer(); // I am static // I am working
        programmer.work(); // I code
        programmer.eat(); // I am eating

        Student student = new Student(); // I am working
        student.eat(); // Eating Chocolates
        student.work(); // I study

        // Person person = new Person(); // ERROR - 'Person' is abstract; cannot be instantiated
    }
}

/* An abstract class is a class that is declared abstract
— it can have both abstract and concrete methods
Abstract classes cannot be instantiated, but they can be subclassed.
An abstract class may have static fields and static methods.
*/

/* A method without body (no implementation) is known as abstract method.
If a class has an abstract method, it should be declared abstract as well.
Abstract classes require subclasses to provide implementations for the abstract methods.
*/

/*In abstract class, the keyword ‘abstract’ is mandatory to declare a method as an abstract
In interfaces, the keyword ‘abstract’ is optional to declare a method as an abstract
because all the methods are abstract by default unless default or static keyword is used (Java 8)

Abstract class can have protected and public abstract methods
Interface can have only public abstract methods

Type of variables:
Abstract class can have static, non-static, final, non-final, or static final variables with any access specifier
Interface can have only public static final (constant) variables

Final Variables:
An abstract class may contain non-final variables.
Variables declared in a Java interface are by default public & final. Can't be private,protected , default

Accessibility of Data Members:
A Java abstract class can have class members like private, protected, public.
Members of a Java interface are public by default.
*/

/*If a child does not implement all the abstract methods of abstract parent class,
then the child class must need to be declared abstract as well.*/
