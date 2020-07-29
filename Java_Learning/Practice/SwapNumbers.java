package July22;

// Swap two numbers
public class SwapNumbers {
    public static void main (String args[]) {
        int a = 4;
        int b = 10;
        int c;

        // using the third variable
        System.out.println("Before swap: "+a+" "+b);
        c = a;
        a = b;
        b = c;
        System.out.println("After swap: "+a+" "+b);
        System.out.println("========================");

        // without using any third variable.
        System.out.println("Before swap: "+a+" "+b);
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("After swap: "+a+" "+b);
    }
}
