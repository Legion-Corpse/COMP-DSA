package EULER;

public class euler6 {
    public static void main(String[] args) {
        long sumSq = 0, sum = 0;
        for (int i = 1; i <= 100; i++) {
            sumSq += (long) i * i;
            sum += i;
        }
        System.out.println(sum * sum - sumSq);
    }
}

// 25164150