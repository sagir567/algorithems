package Arrays;

public class Max_sum_SubArray {
    /**
     * @param args the command line arguments
     * @param arr   array of integers
     * @return  max sum of subarray
     */
    public static int kadanesAlgo(int[] arr){
        int maxSum = 0;
        int currentSum = 0;

        for(int i = 0; i < arr.length; i++){
            currentSum += arr[i];
            if(currentSum < 0){
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }



    public static void main (String[] args){
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(kadanesAlgo(arr));

    }


}
