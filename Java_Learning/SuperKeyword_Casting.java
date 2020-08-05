package july28;

class Employee1{ // parent or super class or base class
    Employee1(){
        System.out.println("Parent Constructor");
    }
    public void work() {
        System.out.println("Working as an employee of XYZ");
    }
}

// A class can extend only 1 class at a time
class Programmer1 extends Employee1{ //Child class or sub class
    Programmer1(){
        super(); // Call the superclass constructor
        System.out.println("Child Employee Constructor");
    }
    public void work() {
        super.work(); // Call the superclass method
        System.out.println("Working as a Programmer at XYZ");
    }
}

class Manager1 extends Employee1{ //Child class or sub class
    Manager1(){ // not used super keyword, sill it first calls constructor of parent class
        System.out.println("Child Manager Constructor");
    }
    public void work() {
        System.out.println("Working as a Manager at XYZ");
    }
    public void team(){
        System.out.println("Team Building");
    }
}

public class SuperKeyword_Casting {
    public  static void main(String args[]){
        Employee1 emp1 = new Employee1();
        emp1.work();
        Programmer1 prg1 = new Programmer1();
        prg1.work();
        Manager1 mgr1 = new Manager1();
        mgr1.work();
        mgr1.team();

        /*Casting from a subclass to a superclass is called upcasting.
        Typically, the upcasting is implicitly performed by the compiler.
         */
        Employee1 emp2 = new Manager1(); // implicit upcasting takes place
        emp2.work(); // Working as a Manager at XYZ

        Employee1 emp3 = (Employee1) new Manager1(); // here although not required we are doing it explicitly
        emp3.work(); // work() common to both parent & child class can be accessed with this
        //emp3.team();

        /* As shown above team() of subclass can't be accessed directly by Employee emp3
        as its not in parent class, so we need to do downcasting shown below*/

        // Downcasting is necessary to gain access to members specific to subclass
        // Downcasting from a superclass to a subclass.
        // the compiler complains that team() method doesn’t exist for the type Employee1.
        //To call team() we should downcast emp3 to Manager1:
        ((Manager1) emp3).team();

        // you can't store reference to object of superclass in variable of its derived type.
        // you can't cast parent to subclass
        // Manager1 mgr2 = (Manager1) new Employee1(); //Error
    }
}
