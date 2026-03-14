package ATCODER446;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
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
        System.out.println(total - bad);
    }
}

// WRITEUP: BFS backwards from all degenerate states (u=0 or v=0). States
// reachable from degenerate = "bad". Answer is total states minus bad states.
