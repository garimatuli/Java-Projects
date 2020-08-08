/*program that takes out the even from the odds and odd from the list of even numbers,
For eg, => {23,25,75,87,47,1,91,51,2} //Output for this case =>2
=> {22,44,64,76,98,12,43,54,90} // Output for this case =>43.
*/
package tasks.task5_arrays_and_strings;

import java.util.ArrayList;

public class Q6_odd_even_array {
    public static void main(String[] args) {
        int arr[] = {23,25,75,87,47,1,91,51,2}; //Output -> 2
//        int arr[] = {22,44,64,76,98,12,43,54,90} ; //Output -> 43
//        int arr[] = {22,44,64,76,98,12,33,43,54,90} ; //Output -> Neither single even nor single odd in the odd/even list

        ArrayList even = new ArrayList();
        ArrayList odd = new ArrayList();
        int tempEven = 0, tempOdd = 0;

        // iterating over array
        for (int el: arr){
            //checking if element is even or odd
            if(el%2==0) {
                even.add(el);
                tempEven = el;
            }
            else {
                odd.add(el);
                tempOdd = el;
            }
        }

        // if its an odd list, there could be 1 even element which is odd one out
        if (even.size() == 1)
            System.out.println(tempEven);
        else if(odd.size() == 1) // if its an even list, there could be 1 odd element which is odd one out
        System.out.println(tempOdd);
        else
            System.out.println("Neither single even nor single odd in the odd/even list");
    }
}
