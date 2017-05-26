package chapter2;

public class MergeSort {

    public static void main(String arg[]){
        int[] test1=new int[]{6,3,4,2,1,5};
        int[] test2=new int[]{6,5,8,7,3,2,4,1,9};
        merge_sort(test1,0,test1.length-1);
        merge_sort(test2,0,test2.length-1);
        printArray(test1);
        printArray(test2);
    }

    public static void merge_sort(int input[],int p,int r){
        if(p<r) {
            int q = (p + r) / 2;
            merge_sort(input, p, q);
            merge_sort(input, q + 1, r);
            merge(input, p, q, r);
        }
    }

    public static void merge(int intput[],int p,int q ,int r){
        int n1=q-p+1;
        int n2=r-q;

        int left[]=new int[n1];
        int right[]=new int[n2];
        for(int i=0;i<n1;i++){
            left[i]=intput[p+i];
        }
        for(int i=0;i<n2;i++){
            right[i]=intput[q+1+i];
        }

        int i=0;
        int j=0;

        for(int k=p;k<=r;k++){
            if(i==n1){
                intput[k]=right[j];
                j++;
            }else if(j==n2){
                intput[k]=left[i];
                i++;
            }else if(left[i]<right[j]){
                intput[k]=left[i];
                i++;
            }else {
                intput[k]=right[j];
                j++;
            }
        }
    }

    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            if(i!=array.length-1)
                System.out.print(array[i]+" ");
            else
                System.out.println(array[i]);
        }
    }

}
