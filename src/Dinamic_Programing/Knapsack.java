package Dinamic_Programing;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author = sagir567
 * @ weights   array of weights
 *                  weights[i] is the weight of item i
 *                  weights.length is the number of items
 *
 * @ values         array of values *                  [i] is the value of item i
 * @ capacity       is the capacity of the knapsack
 *                  the knapsack can hold a maximum weight of capacity
 * @T(n)=O(nW)
 *
 *                  where n is the number of items and W is the capacity of the knapsack
 *                  the time complexity is O(nW) because we have to fill the ValueMatrix
 *                  which is of size n*W
 *                  the space complexity is O(nW) because we have to store the ValueMatrix
 *                  which is of size n*W
 **/
public final class Knapsack {

    public static List knapsack(int[] weights, int[] values, int capacity) {

        int[][] ValueMatrix = new int[weights.length+1][capacity+1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    ValueMatrix[i][j] = ValueMatrix[i - 1][j];

                } else {
                    ValueMatrix[i][j] = Math.max(ValueMatrix[i - 1][j], ValueMatrix[i - 1][j - weights[i - 1]] + values[i - 1]);
                }


            }

        }
        List<Integer> products = new ArrayList<>();

        int current = capacity;
        for (int i= weights.length;i>0;i--){
            if(ValueMatrix[i][current]==ValueMatrix[i-1][current]){
                continue;
            }
            else{
                System.out.println("Item "+i+" is selected");
                current=current-weights[i-1];
                products.add(i);
            }
        }

    return products;
    }

    public static void main(String[] args) {
        int[] ValueMatrix = {2,2,4,5,3};
        int[] weights = {3,1,3,4,2};
        int capacity = 7;
        System.out.println(knapsack(weights, ValueMatrix, capacity));

    }
}
