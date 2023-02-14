package DivideAndConcur;

public class Karatsuba_Mul {

    // Karatsuba multiplication
    /**
     *
     * @param x second number
     * @param y first number
     * @return x*y using karatsuba multiplication
     * T(n)=3T(n/2)+O(n^c*log^d(n))
     * a=3,b=2,c=1,d=0;
     * T(n)=O(n^log2(3)
     */
    public static int karatsuba(int x, int y) {
        int len = Math.max(String.valueOf(x).length(), String.valueOf(y).length());
        if (len == 1) {
            return x * y;

        }
        int a = x / (int) Math.pow(10, len / 2);
        int b = x % (int) Math.pow(10, len / 2);
        int c = y / (int) Math.pow(10, len / 2);
        int d = y % (int) Math.pow(10, len / 2);
        int ac = karatsuba(a, c);
        int bd = karatsuba(b, d);
        int adbc = karatsuba(a + b, c + d) - ac - bd;
        return (int) (ac * Math.pow(10, len) + adbc * Math.pow(10, len / 2) + bd);

    }

    public static void main(String[] args) {
        int x = 5125421;
        int y = 6;
        System.out.println(karatsuba(x, y));
    }
}
