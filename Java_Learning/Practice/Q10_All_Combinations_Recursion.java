// Find all possible combinations of String

/* If the input is "wxyz"  then the output of the string is
" w wx wxy wxyz wxz wy wyz wz x xy xyz xz y yz z "
"wx" is the same as "xw" so we need to compute any one of them.

For input "abc" , output is a, ab, abc, ac, b, bc, c
*/

package tasks.task7;

public class Q10_All_Combinations_Recursion {
    public static void main(String[] args) {
        String str = "abc";
        combination("", str);
    }
    static void combination(String prefix, String str)
    {
        System.out.println(prefix); // a, ab, abc, ac, b, bc, c

        for (int i = 0 ; i < str.length() ; i++) {

            // Recursive call
            combination(prefix + str.charAt(i), str.substring(i + 1));
        }
    }
}
