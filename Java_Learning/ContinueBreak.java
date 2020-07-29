package july24;
/*
* Break statement terminates the enclosing loop such as while, do-while, for or switch statement wherever break is declared.
* Continue statement skips the rest of loop wherever continue is declared and execute the next iteration.
* We can't use continue statement with 'switch','lablel' as it is not compatible with them.
*/
public class ContinueBreak {
    public static void main (String args[]) {
        for (int i = 1; i < 100; i++) {
            if (i%9 == 0) {
                break;
            }
            if (i%2 == 0){
                continue;
            }
            System.out.println(i);
        }
    }
}
