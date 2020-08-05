package july28;
// Single Inheritance
class Employee{ // parent or super class or base class

    //attributes
    public String name;
    public String address;
    public int exp=0;
    public int salary;

    //Constructor
    Employee(){
        System.out.println("Parent class - Employee" ) ;
    }

    //methods or behavior
    public void work(){
        System.out.println("Working");
    }
    public void display(){
        System.out.println("Name: "+name+" living at "+address+" working at package of "+salary);
    }
}

// A class can extend only 1 class at a time
class Programmer extends Employee{ //Child class or sub class
    //Constructor
    Programmer(){
        System.out.println("Child Class - Programmer");
    }
    public  String tech;
    public void show(){
        System.out.println("Working on "+tech);
    }
    @Override
    public void work(){
        System.out.println("Working as programmer");
    }
}

class Manager extends Employee{ //Child class or sub class
    //Constructor
    Manager(){
        System.out.println("Child Class - Manager");
    }
    public  int teamSize;
    public void show(){
        System.out.println("Working with "+teamSize);
    }
}

public class Inherit {
    public  static void main(String args[]){
        // Object emp can access methods & attributes of Employee class only
        Employee emp = new Employee(); // for other employees except manger or programmer
        emp.work(); //Working

        // Object prg can access methods & attributes of Employee class as well as programmer
        Programmer prg = new Programmer();
        prg.work(); //Working as programmer

        // Object mgr can access methods & attributes of Employee class as well as Manager
        Manager mgr = new Manager();
        mgr.work(); //Working
        mgr.name = "GT";
        mgr.teamSize = 5;
        mgr.exp = 7;
        mgr.address = "NJ";
        mgr.salary = 50000;
        mgr.display(); //Name: GT living at NJ working at package of 50000
        mgr.show(); //Working with 5
    }
}
