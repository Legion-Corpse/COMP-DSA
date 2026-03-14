package ATCODER446;

import java.util.*;
import java.io.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new List[N + 1];
        int[] g = new int[N + 1];
        Arrays.fill(g, N + 1);
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            if (u < g[v])
                g[v] = u;
        }

        int[] f = new int[N + 1];
        Arrays.fill(f, N + 1);
        f[1] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 1, 1 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int c = cur[0], u = cur[1];
            if (c > f[u])
                continue;
            for (int v : adj[u]) {
                int nc = Math.max(c, v);
                if (nc < f[v]) {
                    f[v] = nc;
                    pq.offer(new int[] { nc, v });
                }
            }
        }

        int[] diff = new int[N + 2];
        for (int v = 2; v <= N; v++) {
            int gv = g[v];
            if (gv < v) {
                diff[gv]++;
                diff[v]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        int maxF = 0, cnt = 0;
        for (int k = 1; k <= N; k++) {
            cnt += diff[k];
            if (f[k] > maxF)
                maxF = f[k];
            if (maxF > k) {
                sb.append(-1).append('\n');
            } else {
                sb.append(cnt).append('\n');
            }
        }
        System.out.print(sb);
    }

}

// WRITEUP:
// We run Dijkstra from node 1, minimizing the maximum node index on the path
// rather than the total weight.
// This gives f[v] = the smallest possible max-index on any path from 1 to v.
// We then use a difference array over constraints k to count valid predecessor
// nodes, and for each k, if f[k] > k we output -1, otherwise we output the
// prefix sum.
