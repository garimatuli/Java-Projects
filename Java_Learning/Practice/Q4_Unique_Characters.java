//Program to find if String has all Unique Characters
package tasks.task7;

public class Q4_Unique_Characters {
    public static void main(String[] args) {
        String str = "Developer";
//        String str = "HTML";
        str = str.toLowerCase();
        boolean flag = false ; // to keep track if found a character which is not unique

        // iterating through each character of string
        for (int i=0; i < str.length() ; i++) {

            // if first & last occurrence of any character is not same , it means its present multiple times
            if (str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))){
                flag = true;
                break;
            }

        }
        if (flag)
            System.out.println("String does'nt has all Unique Characters!!");
        else
            System.out.println("String has all Unique Characters!!");
    }
}
