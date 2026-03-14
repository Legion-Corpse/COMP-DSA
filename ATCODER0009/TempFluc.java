package ATCODER0009;

import java.io.*;
import java.util.*;

public class TempFluc {

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
        int q = nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();

        int k = Math.max(1, (int) Math.ceil(Math.log(n + 1) / Math.log(2)));

        int[][] minSt = new int[k + 1][n];
        int[][] maxSt = new int[k + 1][n];

        for (int i = 0; i < n; i++) {
            minSt[0][i] = a[i];
            maxSt[0][i] = a[i];
        }

        for (int j = 1; j <= k; j++) {
            int len = 1 << j;
            int half = 1 << (j - 1);
            for (int i = 0; i <= n - len; i++) {
                minSt[j][i] = Math.min(minSt[j - 1][i], minSt[j - 1][i + half]);
                maxSt[j][i] = Math.max(maxSt[j - 1][i], maxSt[j - 1][i + half]);
            }
        }

        int[] log = new int[n + 1];
        for (int i = 2; i <= n; i++)
            log[i] = log[i / 2] + 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int l = nextInt() - 1;
            int r = nextInt() - 1;

            int len = r - l + 1;
            int p = log[len];

            int rMin = Math.min(minSt[p][l], minSt[p][r - (1 << p) + 1]);
            int rMax = Math.max(maxSt[p][l], maxSt[p][r - (1 << p) + 1]);

            sb.append(rMax - rMin).append('\n');
        }

        pw.print(sb);
        pw.flush();
    }
}

// WRITEUP: Build a sparse table for range-min and range-max queries. For each
// query (l, r), find the largest power-of-2 block and answer in O(1) with two
// overlapping lookups. Answer is rMax - rMin.
