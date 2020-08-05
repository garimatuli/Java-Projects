package july28;
// Multilevel Inheritance
// by default a class has "default" access modifier
class A{
    int a =10;
    private int d = 100;
    // Getter for private variable d
    public int getD() {
        return d;
    }
}
class B extends A{
    // protected members can be used by sub classes
    protected int b = 20;
}
class C extends B{
     int c = 30;
      void add() {
         int sum = a + b+ c + getD();
         System.out.println(sum);
    }
}
public class InheritanceTypes {
    public  static void main(String args[]){
        C c = new C();
        c.add(); //160
    }
}

/*
These inheritances are allowed:
Single
Multilevel (For example class C extends class B and class B extends class A)
Hierarchical (For example, classes B, C & D extends the same class A.)

These inheritances are not allowed as:
Hybrid: causes Diamond Problem;
Multiple: In Java a class is allowed to extend only 1 parent class where as multiple means a child class has two parent classes.
 */

/* The derived class inherits all the members and methods that are declared as public or protected.
 * The private members can be accessed only in its own class.
 * Such private members can only be accessed by subclass using public or protected getter and setter methods of super class.
 */
