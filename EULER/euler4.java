package EULER;

public class euler4 {
    public static void main(String[] args) {
        long max = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                long p = (long) i * j;
                if (p > max && isPalindrome(p))
                    max = p;
            }
        }
        System.out.println(max);
    }

    static boolean isPalindrome(long n) {
        String s = Long.toString(n);
        int i = 0, j = s.length() - 1;
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}
