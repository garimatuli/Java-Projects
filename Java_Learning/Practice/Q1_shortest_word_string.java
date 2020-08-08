// program that takes given String of words and return the length of the shortest word
package tasks.task5_arrays_and_strings;

import java.util.Scanner;

public class Q1_shortest_word_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String myStr = sc.nextLine();

        int minLength = Integer.MAX_VALUE; // to store length of the minimum word
        String minLenWord = ""; // to store word with minimum length

        // Splitting string with delimiter as space into array of words
        String words[] = myStr.split(" ");

        //looping over array of words in the string
        for(String word: words) {
            if (word.length() < minLength){
                minLength = word.length();
                minLenWord = word;
            }
        }
        System.out.println("Length of shortest word '"+minLenWord+"' = "+minLength);
    }
}
