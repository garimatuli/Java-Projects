/*Write a JAVA program which takes character input from the user,
●	If the character is from r, a, n, d, o, m (consider both upper and lower cases), then print FOUND.
●	Print NOT FOUND for all the other alphabets.
*/

package task2;

import java.util.Scanner;

public class FindChar {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a character");
        char ch = sc.nextLine().toLowerCase().charAt(0);
        if (ch == 'r' || ch == 'a' || ch == 'n' || ch == 'd' || ch == 'o' || ch == 'm' ){
            System.out.println("FOUND");
        }
        else {
            System.out.println("NOT FOUND");
        }
}
}
