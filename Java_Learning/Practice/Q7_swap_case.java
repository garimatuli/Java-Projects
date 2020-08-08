// program that swaps the case of the alphabets of the string,
// For eg, => “heLLo WOrLd” => “HEllO woRlD”.
package tasks.task5_arrays_and_strings;

public class Q7_swap_case {
    public static void main(String[] args) {
        String str = "heLLo WOrLd";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }else if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            }
            sb.append(ch);
        }
        // Converting back String Builder to string
        System.out.println(sb.toString()); // HEllO woRlD
    }
}
