package EULER;

public class euler10 {
    public static void main(String[] args) {
        int limit = 2_000_000;
        boolean[] arr = new boolean[limit];
        java.util.Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for (int i = 2; i * i < limit; i++)
            if (arr[i])
                for (int j = i * i; j < limit; j += i)
                    arr[j] = false;
        long sum = 0;
        for (int i = 2; i < limit; i++)
            if (arr[i])
                sum += i;

        System.out.println(sum);
    }
}

// 142913828922
