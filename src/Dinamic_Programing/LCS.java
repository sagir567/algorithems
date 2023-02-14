package Dinamic_Programing;


/**
 * @author = sagir567
 * @ a   is the first string
 * @ b   is the second string
 * @T(m,n)=O(m*n) where n and are the length of the strings a and b respectively
 * the time complexity is O(m*n) because we have to fill the matrix with m rows and n columns
 * which is of size m*n
 * the space complexity is O(m*n) because the algorithem use a matrix with (m+1) rows and (n+1) columns
 * which is of size n*n
 **/
public class LCS {


    public static String LCS(String a, String b) {
        int[][] matrix = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {


                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        String res = "";
        int i = a.length();
        int j = b.length();
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                res = a.charAt(i - 1) + res;

                i--;
                j--;
            } else {
                if (matrix[i - 1][j] >= matrix[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }


        }
        System.out.println(res);
        return res;
    }


    public static void main(String[] args) {
        String a = "BDCABA";
        String b = "ABCBDAB";
        LCS(a, b);
    }
}
