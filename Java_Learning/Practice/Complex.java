/* Print the sum, difference and product of two complex numbers
by creating a class named 'Complex' with separate methods for each operation
whose real and imaginary parts are entered by user.
*/

package tasks.task6_classes_and_objects;

import java.util.Scanner;

public class Complex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter real part of the first complex number: ");
        int real1 = sc.nextInt();
        System.out.println("Enter imaginary part of the first complex number: ");
        int imaginary1 = sc.nextInt();

        System.out.println("Enter real part of the 2nd complex number: ");
        int real2 = sc.nextInt();
        System.out.println("Enter imaginary part of the 2nd complex number: ");
        int imaginary2 = sc.nextInt();

        System.out.println("Sum of complex numbers: "+sum(real1,imaginary1,real2,imaginary2));
        System.out.println("Difference of complex numbers: "+difference(real1,imaginary1,real2,imaginary2));
        System.out.println("Product of complex numbers: "+product(real1,imaginary1,real2,imaginary2));
    }

    static String sum (int real1, int imaginary1,int real2,int imaginary2){
        int real = real1 + real2;
        int imaginary = imaginary1 + imaginary2;
        if (imaginary < 0)
            return (real+"-"+Math.abs(imaginary)+"i");
        else
            return (real+"+"+imaginary+"i");
    }

    static String difference(int real1, int imaginary1,int real2,int imaginary2){
        int real = real1 - real2;
        int imaginary = imaginary1 - imaginary2;
        if (imaginary < 0)
            return (real+"-"+Math.abs(imaginary)+"i");
        else
            return (real+"+"+imaginary+"i");
    }

    static String product(int real1, int imaginary1,int real2,int imaginary2){
        int real = real1 * real2;
        int imaginary = imaginary1 * imaginary2;
        if (imaginary < 0)
            return (real+"-"+Math.abs(imaginary)+"i");
        else
            return (real+"+"+imaginary+"i");
    }
}
