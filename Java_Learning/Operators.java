//Operators
public class Operators {
    public static void main(String[] args) {

        //unary
        int a=35;
        //++
        System.out.println(a+" "+(a++)+" "+(++a)); // 35 35 37
        //--
        System.out.println(a+" "+(a--)+" "+(--a)); // 37 37 35
        // ~ Bitwise complement Operator
        // ~ is a unary operator which returns the one’s compliment representation of the input value, i.e. with all bits inversed
        System.out.println((~a)); // -36

        //binary +,-,*,/,%
        int b = 34;
        //div
        System.out.println(a); // 35
        System.out.println(a/b); // 1
        //mod
        System.out.println(a%b); // 1

        //relational    >,<,<=,>=,==,!=
        boolean bool = (a>=b);
        System.out.println(bool); // true

        //logical   &&,||
        if(a>34 && b>34)
            System.out.println("both are greater than 34");
        else if(a>34 || b>34)
            System.out.println("one of the number is greater than 34"); // one of the number is greater than 34

        //ternary
        int x=(a>b)?12:4;
        System.out.println(x); //12

        //assignment
        int c =2;
        c+=2;//c=c+2
        System.out.println(c); // 4
        c-=2;
        System.out.println(c); // 2

        // We can use == operator for reference comparison (address comparison)
        // == checks if both objects point to the same memory location
        // .equals() method is for content comparison
        // .equals() evaluates to the comparison of values in the objects
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); //true
        System.out.println(s1.equals(s2)); // true
        String s3 = new String("HELLO");
        String s4 = new String("HELLO");
        System.out.println(s3 == s4); //false // as both s3 & s4 refers to different objects & have different addresses in memory
        System.out.println(s3.equals(s4)); // true


        //Bitwise Operators
        int p = 11, q = 12; //Binary rep - 11-> 1011 , 12-> 1100
        System.out.println(p+ " " +q); // 11 12
        // bitwise AND &
        System.out.println(p&q); // 8 (1011 & 1100 -> 1000)
        // bitwise Exclusive OR ^
        System.out.println(p^q); // 7 (1011 ^ 1100 -> 0111)
        // bitwise Inclusive OR |
        System.out.println(p|q); // 15 (1011 | 1100 -> 1111)
        // Bitwise Compliment
        System.out.println(~p); //-12 (~1011 -> 0100 -> 4 -> 2's complement of 4 is -12 which will be the result)

        //Bit Shift Operators
        // signed shift right
        System.out.println(p>>2); // 2 (1011 >> 2 -> 0010)
        System.out.println(-p>>2); // -3 (preserve the sign bit)
        // Unsigned shift right
        System.out.println(p>>>2); // 2 (1011 >>> 2 -> 0010)
        System.out.println(-p>>>2); // 1073741821 (DOES NOT preserve the sign bit)
        // signed shift left
        System.out.println(p<<2); // 44 (1011 << 2 -> 101100)
    }
}

