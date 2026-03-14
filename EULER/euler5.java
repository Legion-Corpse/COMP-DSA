package EULER;

public class euler5 {
    public static void main(String[] args) {
        long n = 20;
        for (long i = 2; i <= n; i++) {
            while (n % i == 0) {
                n /= i;
            }
        }
        System.out.println(n);
    }
}
