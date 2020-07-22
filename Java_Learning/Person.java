public class Person {
    // A static variable is common to all the instances (or objects) of the class because it is a class level variable.
    // In other words you can say that only a single copy of static variable is created and shared among all the instances of the class.
    static int age = 20;
    String name = "Garima";
    void sleep(){
        System.out.println("sleeping"); // shortcut - just write "sout"
    }
    public static void main (String args[]){
        Person person = new Person();
        Person person1 = new Person();
        Student student = new Student(); // creating student - object reference of Student class to access its methods & variables
        person.sleep();
        // age is static variable so a single instance is shared among all the instances created
        System.out.println(age); // 20
        person.age = 15; // will modify same age variable as its static
        System.out.println(age); // 15
        person1.age = 16; // although referenced by different object but it will modify same age variable as its static
        System.out.println(age); // 16
        System.out.println(person.age); // 16
        System.out.println(person1.age);// 16

        System.out.println(person.name); // Garima
        System.out.println(person1.name); // Garima
        person.name = "Person";
        person1.name = "Person1";
        System.out.println(person.name); // Person
        System.out.println(person1.name); // Person1
//        System.out.println(name); // ERROR - non static variable name can't be referenced from a static context
        // name is non static where as we are referencing it inside static main method

//        sleep(); // ERROR - non static method can't be referenced from a static context
        System.out.println(student.id);
        student.Study();
    }
}

class Student {
    int id = 4;
    void Study() {
        System.out.println("Study");
        Person person = new Person(); // creating person - object reference of Person class to access its methods & variables
        person.age = 30;
        System.out.println(person.age);
        System.out.println(person.name);
        person.sleep();
    }
}
