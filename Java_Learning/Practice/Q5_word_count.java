// Program to Count the number of words in the String
package tasks.task7;

public class Q5_word_count {
    public static void main(String[] args) {
        String str = "Have an awesome trip and have fun";
        int count = 1; //counter for number of words

        for (int i=0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                count++; //increase count if there is a space
            }
        }
        System.out.println("String: "+str);
        System.out.println("Number of words in the String: "+count);
    }
}
