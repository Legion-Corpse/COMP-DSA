package ATCODER216;

import java.io.*;
import java.util.*;

public class Zombie {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long K = Long.parseLong(st.nextToken());
            long L = Long.parseLong(st.nextToken());
            long[] A = new long[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                A[i] = Long.parseLong(st.nextToken());
            Arrays.sort(A);

            long em = Math.max(A[0], L - A[N - 1]);
            int M = N - 1;
            long[] g = new long[M];
            for (int i = 0; i < M; i++)
                g[i] = A[i + 1] - A[i];
            Arrays.sort(g);

            long[] GS = new long[M + 1];
            for (int i = 0; i < M; i++)
                GS[i + 1] = GS[i] + g[M - 1 - i];
            long G = GS[M];
            long LG = L - G;

            long ans = GS[(int) Math.min(K, M)] / 2;

            long sm = Math.max(1L, K - M);
            for (long m = sm; m <= K; m++) {
                int k = (int) (K - m);
                long h = m * GS[k] + (m - 1) * LG;
                ans = Math.max(ans, em + h);
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}

// WRITEUP: Sort zombie positions and gaps. Try all splits: m times place a
// barrier spanning gaps, K-m times cut individual gaps. Maximize minimum
// distance from nearest endpoint plus cumulative gap savings, iterating over
// valid values of m.
