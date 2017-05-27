package chapter4;


public class MaxArray {

    /*
        求解最大子数组
     */

    public static void main(String arg[]){

        int[] test1=new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int[] result=findMaxSubArray(test1,0,test1.length-1);
        System.out.println("归并解法:");
        System.out.println("Left index: "+result[0]);
        System.out.println("Right index: "+result[1]);
        System.out.println("Max sum: "+result[2]);

        System.out.println("暴力解法:");
        int[] resultViolence=violenceSolve(test1);
        System.out.println("Left index: "+resultViolence[0]);
        System.out.println("Right index: "+resultViolence[1]);
        System.out.println("Max sum: "+resultViolence[2]);

    }

    private static int[] findMaxSubArray(int[] input,int low,int high){
        int[] result=new int[3];

        int[] left;
        int[] right;
        int[] cross;

        if (low==high){
            result[0]=low;
            result[1]=high;
            result[2]=input[low];
        }else {
            int mid=(low+high)/2;
            left=findMaxSubArray(input,low,mid);
            right=findMaxSubArray(input,mid+1,high);
            cross=findMaxCrossingSubArray(input,low,mid,high);

            int leftSum=left[2];
            int rightSum=right[2];
            int crossSum=cross[2];
            if(leftSum>=rightSum){
                if(leftSum>=crossSum){
                    result=left;
                }else {
                    result=cross;
                }
            }else {
                if(rightSum>=crossSum){
                    result=right;
                }else {
                    result=cross;
                }
            }
        }

        return result;
    }

    //求解横跨mid的最大子数组
    private static int[] findMaxCrossingSubArray(int[] input,int low,int mid,int high){
        int[] result=new int[3];

        int leftSum=Integer.MIN_VALUE;
        int currentLeftSum=0;
        int maxLeftIndex=mid;
        for(int i=mid;i>=low;i--){
            currentLeftSum+=input[i];
            if(currentLeftSum>leftSum){
                leftSum=currentLeftSum;
                maxLeftIndex=i;
            }
        }

        int rightSum=Integer.MIN_VALUE;
        int currentRightSum=0;
        int maxRightIdnex=mid+1;
        for (int i=mid+1;i<=high;i++){
            currentRightSum+=input[i];
            if(currentRightSum>rightSum){
                rightSum=currentRightSum;
                maxRightIdnex=i;
            }
        }

        result[0]=maxLeftIndex;
        result[1]=maxRightIdnex;
        result[2]=leftSum+rightSum;

        return result;
    }

    private static int[] violenceSolve(int[] input){
        int[] result=new int[3];
        int sum=Integer.MIN_VALUE;

        for(int i=0;i<input.length;i++){
            int currentSum=0;
            for(int j=i;j<input.length;j++){
                currentSum+=input[j];
                if(currentSum>sum){
                    result[0]=i;
                    result[1]=j;
                    result[2]=currentSum;
                    sum=currentSum;
                }
            }
        }
        return result;
    }
}
