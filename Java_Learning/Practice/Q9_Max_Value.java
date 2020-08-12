// Find the maximum value in Array without using Collection
package tasks.task7;

public class Q9_Max_Value {
    public static void main(String[] args) {
        int arr [] = {1,1,4,5,1,7,99,100};
        int max = 0;
        for (int i=0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Max value in array: "+max);
    }
}
