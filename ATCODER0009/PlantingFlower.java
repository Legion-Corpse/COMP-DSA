package ATCODER0009;

import java.io.*;
import java.util.*;

public class PlantingFlower {

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
        long n = nextLong();
        int m = nextInt();

        if (m == 0) {
            pw.println(n);
            pw.flush();
            return;
        }

        long[][] a = new long[m][2];
        for (int i = 0; i < m; i++) {
            a[i][0] = nextLong();
            a[i][1] = nextLong();
        }

        Arrays.sort(a, (x, y) -> Long.compare(x[0], y[0]));

        long[][] b = new long[m][2];
        int k = -1;

        for (long[] p : a) {
            if (k >= 0 && p[0] <= b[k][1] + 1) {
                b[k][1] = Math.max(b[k][1], p[1]);
            } else {
                k++;
                b[k][0] = p[0];
                b[k][1] = p[1];
            }
        }

        int len = k + 1;
        long end = b[len - 1][1];
        long rain = 0;

        for (int i = 0; i < len; i++)
            rain += b[i][1] - b[i][0] + 1;

        long sun = end - rain;

        if (sun >= n) {
            long lo = 1, hi = end;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                long r = 0;

                for (int i = 0; i < len; i++) {
                    if (b[i][0] > mid)
                        break;
                    r += Math.min(b[i][1], mid) - b[i][0] + 1;
                }

                long s = mid - r;
                if (s >= n)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            pw.println(lo);
        } else {
            long rem = n - sun;
            pw.println(end + rem);
        }

        pw.flush();
    }
}

// WRITEUP: Merge rainy intervals. Binary search for the n-th sunny day. If
// enough sunny days exist within the rainy range, binary search for the exact
// day; otherwise extend past the last rainy day.
