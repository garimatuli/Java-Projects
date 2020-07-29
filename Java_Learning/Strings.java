package july27;

import java.util.Arrays;

public class Strings {
    public static void main(String args[]) {
        // new Keyword creates new memory allocation for objects in case of s1,s2,s4
        String s1 = new String();
        s1 = "Morning";
        String s2 = new String("Morning");
        String s3 = "Morning"; // not created using new Keyword so new memory not allocated,
        // instead s3 is just another name pointing to the same object to which S1 is pointing
        String s5 = "Morning Java";
        String s4 = new String("Morning");
        boolean bool = (s1 == s2); // false
        boolean bool1 = (s1 == s3); // true
        boolean bool2 = (s2 == s4); // false
        boolean bool3 = (s1 == s5); // false
        System.out.println(bool + " " + bool1 + " " + bool2 + " " + bool3); // false true false false
        s1.concat(" Java"); // s1 not modified as strings are immutable
        s2.concat(" Java");
        boolean bool4 = (s1 == s2); // false
        System.out.println(s1 + " " + s2 + " " + bool4); // Morning Morning false
        System.out.println(s1.concat(" Java")); // Morning Java
        s1 = s1 + " java.."; // Creates a new string s1
        System.out.println(s1 + " " + s1.length() + " " + s1.toUpperCase()); // Morning java.. 14 MORNING JAVA..
        System.out.println(s1); // Morning java..

        // split string
        String str = "Hi, this is Garima";
        String arr[] = str.split(" ");
        for (String ch : arr) {
            System.out.println(ch);
        }
        // reverse strings
        int len = arr.length;
        String revArr[] = new String[arr.length];
        for (int j = 0; j < len; j++) {
            revArr[j] =
                    arr[len - 1 - j];
        }
        System.out.println(Arrays.toString(revArr)); //[Garima, is, this, Hi,]

        System.out.println(str.contains("Garima")); //true
        System.out.println(str.contains("x")); // false

        // array to string
        char ch[] = {'g', 'a', 'r', 'i', 'm', 'a'};
        System.out.println(ch); //garima

// String class is an immutable class whereas StringBuffer and StringBuilder classes are mutable.
// StringBuilder is non-synchronized i.e. not thread safe
// StringBuilder is faster and preferred over StringBuffer for single threaded program.
// If thread safety is needed, then StringBuffer is used.
// StringBuffer is synchronized i.e. thread safe. It means two threads can't call the methods of StringBuffer simultaneously.

        // String Builder
        // mutable so original value is changed in case any operations are done on it
        // used when string will only be accessed from a single thread
        StringBuilder sb = new StringBuilder("Morning");
        System.out.println(sb); // Morning
        sb.replace(1, 4, "LEARN");
        System.out.println(sb); // MLEARNing
        sb.reverse(); // modifies original string
        System.out.println(sb); //gniNRAELM
        sb.append(" Java"); // modifies original string
        System.out.println(sb); // gniNRAELM Java

        // String Buffer
        // mutable so original value is changed in case any operations are done on it
        // Used when string will be accessed from multiple threads,because StringBuffer is synchronous so you have thread-safety.
        StringBuffer sb1 = new StringBuffer("Morning");
        System.out.println(sb1); // Morning
        sb1.replace(1, 4, "LEARN");
        System.out.println(sb1); // MLEARNing
        sb1.reverse(); // modifies original string
        System.out.println(sb1); //gniNRAELM
        sb1.append(" Java"); // modifies original string
        System.out.println(sb1); // gniNRAELM Java

        int x = sb1.capacity();
        System.out.println(x); //23 -> using 23 bits to store value of string gniNRAELM Java

        // join() method concatenates the given elements with the delimiter and returns the concatenated string
        String jn = String.join("-> ", "Wake up", "Eat",
                "Code", "Sleep", "Wake up");
        System.out.println(jn);// Wake up-> Eat-> Code-> Sleep-> Wake up

        String myStr = "Holly"; //immutable string
        // conversion from String object to StringBuffer
        StringBuffer sbr = new StringBuffer(myStr);
        sbr.reverse();
        System.out.println(sbr); //ylloH

        // conversion from StringBuffer object to String
        String myStr1 = sbr.toString();
        System.out.println("StringBuffer object to String : ");
        System.out.println(myStr1); //ylloH

        // conversion from String object to StringBuilder
        StringBuilder sbl = new StringBuilder(myStr);
        sbl.append("wood");
        System.out.println(sbl); //Hollywood

        // conversion from StringBuilder object to String
        String myStr2 = sbl.toString();
        System.out.println("StringBuilder object to String : ");
        System.out.println(myStr2); //Hollywood

        // conversion from StringBuffer object to StringBuilder or vice-versa
        // StringBuffer object to StringBuilder (sbr -> string -> sbl)
        StringBuffer sbr1 = new StringBuffer("Java");
        String str1 = sbr1.toString();
        StringBuilder sbl1 = new StringBuilder(str1);
        System.out.println(sbl1); // Java
        // StringBuilder object to StringBuffer (sbl -> string -> sbr)
        String str2 = sbl1.toString();
        StringBuffer sbr2 = new StringBuffer(str2);
        System.out.println(sbr2); // Java
    }
}
