// Java program to add two matrices of the same size

package task4;

public class Q15_matrices_addition {
    public static void main(String[] args) {
        int matrix1 [][] = {{1,2,3},{4,5,6}};
        int matrix2 [][] = {{1,1,1},{4,4,4}};
        int result [] [] = new int[matrix1.length][3];
        for (int i=0; i<matrix1.length; i++){
            for (int j=0; j<matrix1[i].length; j++){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Result of matrices addition: ");
        for (int i=0; i<matrix1.length; i++){
            for (int j=0; j<matrix1[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
