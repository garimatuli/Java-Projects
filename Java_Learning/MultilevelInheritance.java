package july29;

interface X{
    void show();
}

interface Y{
    void display(int a);
}

interface Z extends Y{
    void display();
}

class Single implements X,Z {

    @Override
    public void show() {
        System.out.println("hey");
    }

    @Override
    public void display() {
        System.out.println("hello");
    }

    @Override
    public void display(int a) {
        System.out.println(a);
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        Single single = new Single();
        // single can access methods from all interface as class Single implements all these interfaces
        single.display(); //hello
        single.show(); //hey
        single.display(10); //10

        // x can access methods defined in Interface X only
        X x = new Single();
        x.show(); //hey

        // z can access methods defined in Interface Z as well as Y also
        // This is because interface Z extends interface Y
        Z z = new Single();
        z.display(); //hello
        z.display(55); //55

        // y can access methods defined in Interface Y only
        Y y = new Single();
        y.display(42); //42

        // Z z = new Z(); // ERROR - 'Z' is abstract; cannot be instantiated
    }
}

/*  Multiple inheritance by interface occurs if a class implements multiple interfaces
or also if an interface itself extends multiple interfaces. */

