// find the two elements from a given array of positive and negative numbers such that their sum is closest to zero.
package task4;

public class Q21_sum_closest_to_zero {
    public static void main(String[] args) {
        int arr[] = {15, 5, -20, 30, -45};
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int el1 = 0 , el2 = 0;

        for (int i=0; i < arr.length-1; i++){
            for (int j = i+1; j < arr.length; j++){
                sum = Math.abs(arr[i] + arr[j]);
                 if (sum < min) {
                     min = sum;
                     el1 = arr[i] ; el2 = arr[j];
                     //System.out.println(arr[i] + ", "+arr[j]+", "+min);
                 }
            }
        }
        System.out.println("Two elements with their sum closest to Zero: "+el1 + ", "+el2);
    }
}
