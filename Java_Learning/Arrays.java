package july24;

public class Arrays {
    public static void main(String[] args) {
        int marks[]; // array declaration
        marks = new int[5]; // allocating memory
        int ids[] = {1, 2, 3}; // array declaration, initialization & memory allocation

        //clone an array
        int ids_copy [] = ids.clone();
        ids_copy[0] = 99; // changing the cloned/copied array does not change the original array
        for(int i = 0 ; i<ids.length; i++){
            System.out.println(ids_copy[i]);
            System.out.println(ids[i]);
        }

        // iteration
        System.out.println("for-each loop, exclusively to loop through elements in arrays");
        for (int ele : ids){
            System.out.println(ele);
        }

        // 2-D
        System.out.println("2-D array");
        int[][] twoDArr = { {1, 2, 3, 4}, {5, 6, 7} };
        for (int i = 0; i < twoDArr.length; ++i) {
            for(int j = 0; j < twoDArr[i].length; ++j) {
                System.out.println(twoDArr[i][j]);
            }
        }

        //multi-dimensional
        int[][][] threeD_arr = new int[10][20][30];
        threeD_arr[0][0][0] = 1;

        System.out.println("threeD_arr[0][0][0] = " + threeD_arr[0][0][0]);
    }
}
