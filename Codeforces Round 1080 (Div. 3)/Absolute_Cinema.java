import java.io.*;
import java.util.*;

public class Absolute_Cinema {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
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
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt();
            long[] f = new long[n];
            for (int i = 0; i < n; i++)
                f[i] = nextLong();
            if (n == 2) {
                sb.append(f[1]).append(' ').append(f[0]).append('\n');
            } else {
                long[] d = new long[n - 1];
                for (int i = 0; i < n - 1; i++)
                    d[i] = f[i + 1] - f[i];
                long[] a = new long[n];
                for (int i = 1; i <= n - 2; i++) {
                    a[i] = (d[i] - d[i - 1]) / 2;
                }
                long sum1 = 0, sum2 = 0;
                for (int i = 1; i <= n - 2; i++) {
                    sum1 += a[i] * i;
                    sum2 += a[i] * (n - i - 1);
                }
                a[n - 1] = (f[0] - sum1) / (n - 1);
                a[0] = (f[n - 1] - sum2) / (n - 1);
                for (int i = 0; i < n; i++) {
                    if (i > 0)
                        sb.append(' ');
                    sb.append(a[i]);
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}

// WRITEUP:
// We observe that f[] is a prefix-sum of some symmetric array a[], so we
// recover a[] by computing finite differences.
// We take d[i]=f[i+1]-f[i], then second differences give us the inner elements:
// a[i]=(d[i]-d[i-1])/2.
// We derive the boundary values a[0] and a[n-1] from the remaining sum
// constraints.
// Special case: for n==2 there is only one degree of freedom, so we output f[1]
// and f[0] directly.
