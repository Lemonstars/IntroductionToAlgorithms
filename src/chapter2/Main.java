package chapter2;

/**
 * Created by starrylemon on 2017/5/19.
 */
public class Main {

    public static void main(String[] arg){

        int[] test1=new int[]{5,4,3,2,1};
        int[] test2=new int[]{1};
        int[] test3=new int[]{3,2,4,1,5};
        int[] test4=new int[]{1,2,3,4,5};

        InsertSort insertSort=new InsertSort();
        printArray(insertSort.insertSort(test1));
        printArray(insertSort.insertSort(test2));
        printArray(insertSort.insertSort(test3));
        printArray(insertSort.insertSort(test4));

    }

    public static void printArray(int[] input){
        int length=input.length;
        for(int i=0;i<length;i++){
            if(i!=length-1)
                System.out.print(input[i]+" ");
            else
                System.out.println(input[i]);
        }
    }

}
