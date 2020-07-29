package july27;

import java.util.ArrayList;
import java.util.List;

// ArrayList - you don't need to care much about size or type of data you will be storing in it
public class ArrayListEx {
    public static void main (String args[]){
        List<Integer> al = new ArrayList<>();
        ArrayList<Integer> al1 = new ArrayList<>();
        // adding elements to array list with/without using index
        al.add(3);
        al.add(5);
        al1.add(0,55);
        al1.add(1,44);
        System.out.println(al); // [3, 5]
        System.out.println(al1); // [55, 44]

        // traversing through elements of array list using forEach loop
        for(int a:al1){
            System.out.println(a); // 55 // 44
        }

        System.out.println(al.size()); //2
        System.out.println( al.isEmpty()); //false

        System.out.println(al.remove(1)); // 5 - removes element at index 1 which is 5
        System.out.println(al); //[3]
    }
}
