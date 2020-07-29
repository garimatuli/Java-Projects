package july27;

import java.util.ArrayList;

public class Wrapper {
    public static void main(String args[]) {
        int a = 10; // primitive data type
        Integer b = 20; // Wrapper class Object
        Integer c = 10; // Wrapper class Object
        Integer d = 10; // Wrapper class Object
        System.out.println(a + " " + b + " " + c + " " + d); //10 20 10 10
        System.out.println(a == b); //false
        System.out.println(a == c); //true
        System.out.println(d == c); //true
        System.out.println(b.equals(a)); //false
        System.out.println(b.equals(a)); //false
        System.out.println(c.equals(d)); //true

        // hash code
        String s = "Hello";
        String s1 = "Hello";
        String s2 = "hello";
        int x = s.hashCode();
        int x1 = s1.hashCode();
        int x2 = s2.hashCode();
        System.out.println(x + " " + x1 + " " + x2); // 69609650 69609650 99162322

        // Autoboxing - to convert primitive data types into corresponding objects.
        int num = 10; // int primitive
        char ch = 'a'; // char primitive
        Integer obj = Integer.valueOf(num); // creating a wrapper class object
        Character ch_obj = ch;
        System.out.println(num + " " + obj); // 10 10
        System.out.println(ch + " " + ch_obj); // a a

        // Autoboxing because ArrayList stores only objects
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //ArrayList<int> al = new ArrayList<int>(); - ERROR - can't be of primitive type <int>
        arrayList.add(num); // here conversion of int to Integer ie autoboxing is done by Java implicitly
        arrayList.add(obj); // already a wrapper class object so no conversion needed


        // Unboxing - to convert the Wrapper class object into corresponding primitive data types.
        int num1 = obj.intValue(); // Converting the wrapper object to primitive datatype
        char a1 = ch; // unboxing - Character object to primitive
        System.out.println(num1 + " " + obj); // 10 10
        System.out.println(ch + " " + a1); // a a

        // unboxing because get method of an ArrayList returns an Integer object
        int num2 = arrayList.get(0);
        System.out.println(num2); //10
    }
}

/* Wrapper Class convert primitive data types into objects.
The objects are necessary if we wish to modify the arguments passed into the method (because primitive types are passed by value).
The classes in java.util package handles only objects and hence wrapper classes help in this case also.
Data structures in the Collection framework such as ArrayList and Vector store only the objects (reference types) and not the primitive types.
The object is needed to support synchronization in multithreading.
*/
