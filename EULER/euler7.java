package EULER;

public class euler7 {
    public static void main(String[] args) {
        int count = 0, n = 1;
        while (count < 10001) {
            n++;
            if (isPrime(n))
                count++;
        }
        System.out.println(n);
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}

// 104743