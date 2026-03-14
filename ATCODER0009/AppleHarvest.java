package ATCODER0009;

import java.io.*;
import java.util.*;

public class AppleHarvest {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static String next() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long t = nextLong();
        long k = nextLong();

        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();

        Arrays.sort(a);

        long dMax = a[0] - 1;
        long r = t + k;
        long d = Math.max(0, dMax);
        long th = r + d;

        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] <= th)
                left = mid + 1;
            else
                right = mid;
        }

        pw.println(left);
        pw.flush();
    }
}

// WRITEUP: Sort apple positions. Compute farthest reachable position r = t + k,
// and delay d from nearest apple minus 1. Binary search for how many apples
// satisfy a[i] <= r + d.
