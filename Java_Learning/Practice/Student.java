/*program to print the names of students by creating a Student class.
If no name is passed while creating an object of Student class, then the name should be "Unknown",
otherwise the name should be equal to the String value passed while creating object of Student class.*/
package tasks.task6_classes_and_objects;

public class Student {

    private String name;

    // Method Overloading
    void printStudentName(){
        this.name = "Unknown";
        System.out.println(name);
    }
    void printStudentName(String str){
        this.name = str;
        System.out.println(name);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.printStudentName();              //Unknown
        s2.printStudentName("Garima");  //Garima
    }
}
