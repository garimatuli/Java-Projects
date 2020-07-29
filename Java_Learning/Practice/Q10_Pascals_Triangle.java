package task3_looping_statements;

import java.util.Scanner;

public class Q10_Pascals_Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int num = sc.nextInt();
        int arr[][] = new int[num][num];
        for (int i=0;i<num;i++){
            for (int j=0;j<=i;j++){
                if(j == 0 || j == i) { // First & last value in each row is 1
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j]; //Other values are sum of values to the left of the current in previous row
                }
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
