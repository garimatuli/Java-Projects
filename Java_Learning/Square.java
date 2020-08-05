package july28;

//Multiple Inheritance using Interfaces (can't be done using classes)
public class Square implements Area,Volume {

    public static void main(String[] args) {

        Square s = new Square();

        System.out.println(s.area()); //900

        // sum() is overriden in Square sub-class
        System.out.println(s.sum()); //30 3000 520

        // static methods implemented in the interface are accessed using Interface-Name directly
        // does not require any object to access it
        System.out.println(Volume.volume()); //1000
    }

    @Override
    public int area() {
        int b = 30;
        return b*b;
    }

    @Override
    public int sum() {
        //OverRiding sum()
        // use super keyword to call the sum() from interfaces
        System.out.print(Area.super.sum()+" "); // 30 - sum() from Area Interface
        System.out.print(Volume.super.sum()+" ");// 3000 - sum() from Volume Interface
        int c = 420;
        return c+100;
    }
}

/*
Multiple Inheritance is not supported by class because of ambiguity.
In case of interface, there is no ambiguity because implementation to the method(s) is provided by the implementing class up to Java 7.
From Java 8, interfaces also have implementations of methods.
So if a class implementing two or more interfaces having the same method signature with implementation, it is mandated to implement the method in class also.
 */
