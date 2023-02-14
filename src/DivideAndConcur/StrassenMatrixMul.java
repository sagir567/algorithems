package DivideAndConcur;

public class StrassenMatrixMul {

    /**

     * @param A = nxn matrix
     * @param B = nxn matrix
     * @return  C = AxB matrix
     * T(n)=7T(n/2)+O(n^2)
     * a=7,b=2,c=1,d=0;
     * o(n^log2(7))<o(n^3)
     */
    public static double [][] multuply(double [][] A,double[][]B ) {
        int n = A.length;
        double[][] C = new double[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
        } else {
            double[][] A11 = new double[n / 2][n / 2];
            double[][] A12 = new double[n / 2][n / 2];
            double[][] A21 = new double[n / 2][n / 2];
            double[][] A22 = new double[n / 2][n / 2];
            double[][] B11 = new double[n / 2][n / 2];
            double[][] B12 = new double[n / 2][n / 2];
            double[][] B21 = new double[n / 2][n / 2];
            double[][] B22 = new double[n / 2][n / 2];

            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);
            double[][] M1 = multuply(add(A11, A22), add(B11, B22));
            double[][] M2 = multuply(add(A21, A22), B11);
            double[][] M3 = multuply(A11, sub(B12, B22));
            double[][] M4 = multuply(A22, sub(B21, B11));
            double[][] M5 = multuply(add(A11, A12), B22);
            double[][] M6 = multuply(sub(A21, A11), add(B11, B12));
            double[][] M7 = multuply(sub(A12, A22), add(B21, B22));
            double[][] C11 = add(sub(add(M1, M4), M5), M7);
            double[][] C12 = add(M3, M5);
            double[][] C21 = add(M2, M4);
            double[][] C22 = add(sub(add(M1, M3), M2), M6);
            join(C11, C, 0, 0);
            join(C12, C, 0, n / 2);
            join(C21, C, n / 2, 0);
            join(C22, C, n / 2, n / 2);



        }
        return C;
    }
    public static double [][] add(double [][] A,double [][] B){
        int n = A.length;
        double [][] C = new double[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                C[i][j]=A[i][j]+B[i][j];
            }
        }
        return C;
    }
    public static double [][] sub(double [][] A,double [][] B){
        int n = A.length;
        double [][] C = new double[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                C[i][j]=A[i][j]-B[i][j];
            }
        }
        return C;
    }
    public static void split(double [][] P,double [][] C,int iB,int jB){
        for(int i1=0,i2=iB;i1<C.length;i1++,i2++){
            for(int j1=0,j2=jB;j1<C.length;j1++,j2++){
                C[i1][j1]=P[i2][j2];
            }
        }
    }
    public static void join(double [][] C,double [][] P,int iB,int jB){
        for(int i1=0,i2=iB;i1<C.length;i1++,i2++){
            for(int j1=0,j2=jB;j1<C.length;j1++,j2++){
                P[i2][j2]=C[i1][j1];
            }
        }
    }
    public static void print(double [][] P){
        for(int i=0;i<P.length;i++){
            for(int j=0;j<P.length;j++){
                System.out.print(P[i][j]+" ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {


    }
}
