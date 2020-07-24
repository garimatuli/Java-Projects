import java.util.Scanner;

public class DecisionMaking {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        // if/else/else-if/nested-if/switch
        System.out.println("Enter an integer: ");
        int a = sc.nextInt();
        if (a> 0)
            System.out.println("Positive Int");
        else if (a<0)
            System.out.println("Negative Int");
        else
            System.out.println("Zero");

        //Nested if
        System.out.println("Enter years of work experience: ");
        int exp = sc.nextInt();
        if (exp==0)
            System.out.println("Fresher");
        else if (exp>0 && exp<10){
                if (exp<4)
                    System.out.println("You can have a raise of 5%");
                else
                     System.out.println("You can have a raise of 10%");
            }
        else
            System.out.println("You can have a raise of 20%");


        // switch
        System.out.println("Enter an operator(+-*/%): ");
        sc.nextLine(); // to clear the keyboard buffer created by pressing enter
        char ch = sc.nextLine().charAt(0);
        System.out.println("Enter two operands: ");
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int result = 0;

        switch (ch){
            case '+':
                result = x1+x2;
                break;
            case '-':
                result = x1-x2;
                break;
            default:
                System.out.println("Invalid Input");
        }
        System.out.println(result);
    }
}
