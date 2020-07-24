

public class Loops {
    public static void main(String args[]) {
        int i = 0, j=0, k=0;
        int sum1 = 0, sum2 = 0, sum3 = 0;

        // for
        for(i = 0 ; i<0;i++){
            sum1= sum1+i;
        }

        // while
        while(j<0){
            sum2= sum2+j;
            j++;
        }

        // do-while
        do {
            sum3= sum3+k;
            k++;
        }while(k<0);

        System.out.println(sum1+","+i+" "+sum2+","+j+" "+sum3+","+k); // 0,0 0,0 0,1
        // as do-while executes at-least one even if condition is not satisfied


        // Iterating Array with For loops
        int arr[] = {1,2,3,4};
        int sum4 = 0, sum5 = 0, sum6 = 0;

        //arr.for or foreach
        for (int i1 : arr) {
            sum4 = sum4 + i1;
        }
        //arr.fori
        for (int i1 = 0; i1 < arr.length; i1++) {
            sum5 = sum5 + arr[i1];
        }
        //arr.forr
        for (int i1 = arr.length - 1; i1 >= 0; i1--) {
            sum6 = sum6 + arr[i1];
        }

        System.out.println(sum4+","+sum5+","+sum6); // 10,10,10

    }
}
