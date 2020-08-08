/*  program that would print the information (name, year of joining, salary, address)
of three employees by creating a class named 'Employee'.
The output should be as follows:
Name     Year of joining      Address
Robert    1994               64C- Walls Street
Sam       2000               68D- Walls Street
John      1999               26B- Walls Street
*/
package tasks.task6_classes_and_objects;

public class Employee {
    private String name = "";
    private String address = "";
    private int year = 0;

    // getters to access private variables
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getYear() {
        return year;
    }

    // employee details initialised in the constructor
    Employee(String name, int year, String address){
        this.name = name;
        this.year = year;
        this.address = address;
    }

    public static void main(String[] args) {

        // Creating 3 employee objects
        Employee emp1 = new Employee("Robert",1994,"64C- Walls Street");
        Employee emp2 = new Employee("Sam",2000,"68D- Walls Street");
        Employee emp3 = new Employee("John",1999, "26B- Walls Street");

        System.out.println("Name        "+"Year of joining      "+"Address  ");
        System.out.println(emp1.getName()+"      "+emp1.getYear()+"                 "+emp1.getAddress());
        System.out.println(emp2.getName()+"         "+emp2.getYear()+"                 "+emp2.getAddress());
        System.out.println(emp3.getName()+"        "+emp3.getYear()+"                 "+emp3.getAddress());
    }
}
