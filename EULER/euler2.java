package EULER;

public class euler2 {
    public static void main(String[] args) {
        long sum = 0, a = 1, b = 2;
        while (a <= 4_000_000) {
            if (a % 2 == 0)
                sum += a;
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println(sum);
    }
}

// 4613732