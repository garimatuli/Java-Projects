// Day 2
// Primitive Data Types : byte, short, int, float, long, double, char
import java.util.Scanner;

public class DataTypes {
    static float f1 = 4.2f;
    static float f2 = 4.2F;
    static long l1 = 234;
    static long l2 = 234L;
    static char ch = 'a';
    static String str = "Hello";
    public static void main (String args[]){
        System.out.println(f1 +" "+f2+" "+l1+" "+l2+" "+ch+" "+str); // 4.2 4.2 234 234 a Hello

        // Declare the object and initialize with predefined standard input object
        Scanner sc = new Scanner(System.in); // to take user input

        System.out.println("Enter an integer: ");
        int i = sc.nextInt();
        System.out.println("Enter a byte: ");
        byte b = sc.nextByte();
        System.out.println("Enter a floating: ");
        float f = sc.nextFloat();
        System.out.println("Enter a double val: ");
        double d = sc.nextDouble();

        /* In this program we are reading a Double in line 21 , after entering the double value user press the Enter Key
         * but the scanner class keeps the Enter Key unread in the keyboard buffer and when its time to supply String to the nextLine(),
         * it will read the enter key from the user thinking that the user has entered the enter key.
         * (that's why we get empty output if we don’t use line 26 sc.nextLine(); to clear the keyboard buffer). */
        sc.nextLine(); //this is to clear the keyboard buffer

        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("Enter a character or string: ");
        Character ch = sc.nextLine().charAt(0);
        Character ch1 = s.charAt(2);

        System.out.println(i +" "+b+" "+f+" "+d+" "+s +" "+ch+" "+ch1); // 42 120 4.0 4.2 garima tuli c r

        String myStr = "Basic \n Java \n Programming";
        String newStr = "";
        Scanner obj = new Scanner(myStr); // initializing scanner object obj with string myStr
        while (obj.hasNext()) {
            newStr += obj.nextLine();
        }
        System.out.println(newStr); // Basic  Java  Programming
    }
}
