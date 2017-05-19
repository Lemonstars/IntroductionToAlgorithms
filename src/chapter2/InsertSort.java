package chapter2;

import java.util.Arrays;

/**
 * Created by starrylemon on 2017/5/19.
 */
public class InsertSort {



    public  int[] insertSort(int[] input){
        int length=input.length;
        int[] output= Arrays.copyOf(input, length);

        for(int i=1;i<length;i++){

            int key=output[i];
            int j=i-1;
            while (j>=0 && output[j]>key){
                output[j+1]=output[j];
                j--;
            }
            output[j+1]=key;
        }

        return output;
    }



}
