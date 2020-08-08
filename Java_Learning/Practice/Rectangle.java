package tasks.task6_classes_and_objects;

public class Rectangle {

    private int length = 0, breadth = 0;

    // Constructor Overloading
    Rectangle(){    //having no parameter, both length and breadth are assigned zero
        this.length = 0;
        this.breadth = 0;
        System.out.println(area(length,breadth));
    }

    Rectangle(int l,int b){     //having two parameters - length and breadth
        this.length = l;
        this.breadth = b;
        System.out.println(area(length,breadth));
    }

    Rectangle(int s){       //having one parameter - same length and breadth
        this.length = s;
        this.breadth = s;
        System.out.println(area(length,breadth));
    }

    // calculate & return area
    int area (int l, int b){
        return l*b;
    }

    public static void main(String[] args) {
        //creating objects of Rectangle class having none, one and two parameters to print their areas
        Rectangle r1 = new Rectangle();             //0
        Rectangle r2 = new Rectangle(4,5);    //20
        Rectangle r3 = new Rectangle(6);         //36
    }
}
