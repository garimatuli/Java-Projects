/* program that reverse the words of a sentence.
For eg, => “Be Happy and Stay Motivated” => “eB yppah dna yatS detavitoM”.
*/
package tasks.task5_arrays_and_strings;

public class Q5_reverse_words {
    public static void main(String[] args) {
        String str = "Be Happy and Stay Motivated";

        // Creating String builder to do manipulation on the same string instead of creating multiple new string objects
        StringBuilder result = new StringBuilder(str.length());

        // split string into array of words
        String arr[] = str.split(" ");

        // iterate through each word in string
        for (String word : arr){
            // iterate through a particular word in reverse order
            for (int i = word.length()-1 ; i>=0 ; i--) {
                result = result.append(word.charAt(i));
            }
            result = result.append(" "); //adding space between 2 words
        }
        //converting back String Buffer to String
        System.out.println(result.toString()); // eB yppaH dna yatS detavitoM
    }
}
