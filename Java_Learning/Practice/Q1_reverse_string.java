//Program to reverse a string
package tasks.task7;

public class Q1_reverse_string {
    public static void main(String[] args) {
        String str = "I am a Web Developer";
        // Traversing string in reverse order
        for(int i = str.length()-1; i >= 0 ; i--){
            System.out.print(str.charAt(i));
        }
    }
}
