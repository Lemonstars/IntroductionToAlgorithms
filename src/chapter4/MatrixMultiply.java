package chapter4;

public class MatrixMultiply {


    public static void main(String arg[]){

        //测试矩阵一般乘法
//        int a[][]=new int[][]{{1,2,3},{4,5,6}};
//        int b[][]=new int[][]{{6,5},{4,3},{2,1}};
//        int result[][]=violenceMultiply(a,b);
//        System.out.println("a =");
//        printMatrix(a);
//        System.out.println("b =");
//        printMatrix(b);
//        System.out.println("result =");
//        printMatrix(result);

        //测试方针的递归分治算法
        int c[][]=new int[][]{{1,2},{3,4}};
        int d[][]=new int[][]{{4,3},{2,1}};
        int res[][]=squareMatrixMultiplyRecursive(c,d);
        printMatrix(res);
    }

    //计算矩阵乘法的一般算法，复杂度为O(n^3)
    private static int[][] violenceMultiply(int[][] a,int[][] b){

        int aLen=a.length;
        int aWidth=a[0].length;
        int bLen=b.length;
        int bWidth=b[0].length;

        if(aWidth!=bLen){
            throw new IllegalArgumentException("The length of the first matrix should" +
                    "be equal to the width of the seond");
        }

        int n=aLen;
        int k=bWidth;
        int m=aWidth;
        int result[][]=new int[n][k];

        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                int sum=0;
                for(int t=0;t<m;t++){
                    sum+=a[i][t]*b[t][j];
                }
                result[i][j]=sum;
            }
        }

        return result;
    }

    //计算方阵乘法的递归分治算法，注意：复杂度仍为O(n^3)
    //在此为简化，特固定n为2的幂
    private static int[][] squareMatrixMultiplyRecursive(int[][] a,int[][] b){
        int n=a.length;
        int result[][]=new int[n][n];

        if (n==1){
            result[0][0]=a[0][0]*b[0][0];
        }else {
            int aSplite[][][]=spliteMatrix(a);
            int bSplite[][][]=spliteMatrix(b);

            int a11[][]=aSplite[0];
            int a12[][]=aSplite[1];
            int a21[][]=aSplite[2];
            int a22[][]=aSplite[3];

            int b11[][]=bSplite[0];
            int b12[][]=bSplite[1];
            int b21[][]=bSplite[2];
            int b22[][]=bSplite[3];

            int c11[][]=addMatrix(squareMatrixMultiplyRecursive(a11,b11),
                            squareMatrixMultiplyRecursive(a12,b21));
            int c12[][]=addMatrix(squareMatrixMultiplyRecursive(a11,b12),
                    squareMatrixMultiplyRecursive(a12,b22));
            int c21[][]=addMatrix(squareMatrixMultiplyRecursive(a21,b11),
                    squareMatrixMultiplyRecursive(a22,b21));
            int c22[][]=addMatrix(squareMatrixMultiplyRecursive(a21,b12),
                    squareMatrixMultiplyRecursive(a22,b22));

            int m=n/2;
            for(int i=0;i<m;i++){
                for(int j=0;j<m;j++){
                    result[i][j]=c11[i][j];
                    result[i][j+m]=c12[i][j];
                    result[m+i][j]=c21[i][j];
                    result[m+i][m+j]=c22[i][j];
                }
            }
        }

        return result;
    }

    //拆分大方阵(n为2的幂)为四个等同的小方阵
    private static int[][][] spliteMatrix(int matrix[][]){
        int n=matrix.length/2;
        int result[][][]=new int[4][n][n];

        int[][] target=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[0][i][j]=matrix[i][j];
                result[1][i][j]=matrix[i][n+j];
                result[2][i][j]=matrix[n+i][j];
                result[3][i][j]=matrix[n+i][n+j];
            }
        }

        return result;
    }

    //打印矩阵
    private static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    //矩阵相加
    private static int[][] addMatrix(int a[][],int b[][]){

        if( a.length!=b.length || a[0].length!=b[0].length ){
            throw new IllegalArgumentException("Wrong Matrix Input");
        }

        int n=a.length;
        int m=a[0].length;
        int result[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result[i][j]=a[i][j]+b[i][j];
            }
        }
        return result;
    }

}
