package July22;

import java.util.Scanner;

public class Print_User_Input {
    public static void main(String args[]){
        //creating scanner object & initializing with standard input object System.in
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        // taking user input
        String str = sc.nextLine();
        System.out.println(str);
    }
}
