package EULER;

public class euler5 {
    public static void main(String[] args) {
        long lcm = 1;
        for (int i = 2; i <= 20; i++)
            lcm = lcm / gcd(lcm, i) * i;
        System.out.println(lcm);
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

// 232792560
