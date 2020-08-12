//Program to find the first non-repeated character in the String

package tasks.task7;

public class Q2_NonRepeatedCharacter {
    public static void main(String[] args) {
        String str = "World Best Web Developer".toLowerCase();
        for (int i = 0 ; i < str.length() ; i++){
            // if first index of a character is same as its last index,
            // then there is only 1 occurrence of that character
            if(str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))){
                System.out.println(str.charAt(i)); //s
                break;
            }
        }
    }
}
