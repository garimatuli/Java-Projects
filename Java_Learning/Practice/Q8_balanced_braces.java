/* program that gives boolean values;
true, if the string has balanced braces & false, if the string has unbalanced braces:
For eg, => “[()]{}{[()()]()}” //output => true    //valid parenthesis
[(]) or “[})(” //output => false
 */
package tasks.task5_arrays_and_strings;

import java.util.HashMap;
import java.util.Stack;

public class Q8_balanced_braces {
    public static void main(String[] args) {
        String str = "[()]{}{[()()]()}"; //true
//        String str = "[(])";    //false
//        String str = "[})("; //false
        System.out.println(checkBalancedBraces(str));
    }

    static boolean checkBalancedBraces(String str) {

        // if length of string is odd, then it is surely not balanced
        if (str.length() % 2 != 0) {
            return false;
        }

        HashMap<Character, Character> myMap = new HashMap<Character, Character>();
        myMap.put('(', ')');
        myMap.put('[', ']');
        myMap.put('{', '}');

        Stack<Character> myStack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // checking for opening characters like ( or { or [
            if (myMap.containsKey(ch)) {
                myStack.push(ch);
            }
            // checking for closing characters like ) or } or ]
            else if (myMap.containsValue(ch)) {
                // if stack is not empty and if the element present at top of stack is equal to ch
                if (!myStack.empty() && myMap.get(myStack.peek()) == ch) {
                    myStack.pop(); // remove the matched brace
                }
                // if current current character is not opening bracket, then it must be closing.
                // and hence stack cannot be empty at this point.
                // If it is empty then its a case of unbalanced braces
                else {
                    return false;
                }
            }
        }
        return myStack.empty();
    }
}
