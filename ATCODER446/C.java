package ATCODER446;

import java.io.*;
import java.util.*;

public class C {

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

    public static void main(String[] args) throws IOException {
        int T = nextInt();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = nextInt();
            int D = nextInt();
            int[] A = new int[N];
            int[] B = new int[N];
            for (int i = 0; i < N; i++)
                A[i] = nextInt();
            for (int i = 0; i < N; i++)
                B[i] = nextInt();
            Deque<int[]> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                q.add(new int[] { i, A[i - 1] });
                int b = B[i - 1];
                while (b > 0) {
                    int[] f = q.peek();
                    if (f[1] <= b) {
                        b -= f[1];
                        q.poll();
                    } else {
                        f[1] -= b;
                        b = 0;
                    }
                }
                int c = i - D;
                while (!q.isEmpty() && q.peek()[0] <= c)
                    q.poll();
            }
            int ans = 0;
            for (int[] e : q)
                ans += e[1];
            sb.append(ans).append('\n');
        }
        pw.print(sb);
        pw.flush();
    }
}

// WRITEUP:
// We simulate a queue of (customer, remaining amount) pairs over N days.
// Each day, we add the new customer then serve as many customers from the front
// as the daily budget B allows.
// After D days the subscription expires, so we evict any customers who joined
// more than D days ago, then sum the remaining unpaid amounts.
