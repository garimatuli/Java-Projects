// Print all permutations of the String
/*
For input "abc" , output is abc, acb, bac, bca, cab, cba
 */
package tasks.task7;

public class Q8_All_Permutations {

    public static void main(String[] args)
    {
        String str = "abc";
        permutation("", str);
    }

    static void permutation(String prefix, String str)
    {
        int len = str.length();

        // If string is empty
        if (len == 0) {
            System.out.println(" " + prefix); // abc, acb, bac, bca, cab, cba
        }

        for (int i = 0 ; i < len ; i++) {
            // Recursive call
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len));
        }
    }
}
