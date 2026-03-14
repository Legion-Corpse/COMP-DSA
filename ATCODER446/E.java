package ATCODER446;

import java.io.*;
import java.util.*;

public class E {

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
        int M = nextInt();
        int A = nextInt();
        int B = nextInt();
        int total = M * M;
        ArrayList<Integer>[] list = new ArrayList[M];
        for (int i = 0; i < M; i++)
            list[i] = new ArrayList<>();
        for (int p = 0; p < M; p++) {
            int c = (B * p) % M;
            list[c].add(p);
        }
        boolean[] vis = new boolean[total];
        Queue<Integer> q = new ArrayDeque<>();
        for (int u = 0; u < M; u++) {
            for (int v = 0; v < M; v++) {
                if (u == 0 || v == 0) {
                    int idx = u * M + v;
                    if (!vis[idx]) {
                        vis[idx] = true;
                        q.add(idx);
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            int u = cur / M;
            int v = cur % M;
            int c = (v - A * u) % M;
            if (c < 0)
                c += M;
            for (int p : list[c]) {
                int pred = p * M + u;
                if (!vis[pred]) {
                    vis[pred] = true;
                    q.add(pred);
                }
            }
        }
        int bad = 0;
        for (int i = 0; i < total; i++)
            if (vis[i])
                bad++;
        pw.println(total - bad);
        pw.flush();
    }
}

// WRITEUP:
// We run BFS backwards from all degenerate states (u=0 or v=0), propagating
// through the recurrence f(x,y) = A*f(x-1,y) + B*f(x-1,p).
// Any state reachable from a degenerate state is "bad" (the sequence
// degenerates to 0).
// The answer is the total number of states minus the count of bad states.
