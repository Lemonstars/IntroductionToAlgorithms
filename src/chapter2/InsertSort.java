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


    //练习2.1-2
    public int[] insertSortDesc(int[] input){
        int length=input.length;
        int[] output= Arrays.copyOf(input, length);

        for(int i=1;i<length;i++){
            int j=i-1;
            int value=output[i];
            while (j>=0 &&  value>output[j] ){
                output[j+1]=output[j];
                j--;
            }
            output[j+1]=value;
        }

        return output;
    }

    //练习2.1-4 1011 1010
    public int[] binaryAdd(int[] first,int[] second,int n){
        int result[]=new int[n+1];
        boolean isFull=false;
        for(int i=n-1;i>=0;i--){
            int temp=first[i]+second[i];
            if(isFull){
                temp++;
            }
            if(temp>=2){
                temp-=2;
                isFull=true;
            }else {
                isFull=false;
            }
            result[i+1]=temp;

        }


        if (isFull){
            result[0]=1;
        }else {
            result[0]=0;
        }
        return result;
    }



}

