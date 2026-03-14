import java.io.*;
import java.util.*;

public class parabola_independence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n], b = new int[n], c = new int[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                a[i] = Integer.parseInt(st.nextToken());
                b[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] adj = new List[n];
            List<Integer>[] radj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
                radj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    long A = (long) a[i] - a[j];
                    long B = (long) b[i] - b[j];
                    long C = (long) c[i] - c[j];
                    boolean comp = false;
                    int dir = 0;
                    if (A == 0) {
                        if (B == 0 && C != 0) {
                            comp = true;
                            dir = C > 0 ? 1 : -1;
                        }
                    } else {
                        long disc = B * B - 4 * A * C;
                        if (disc < 0) {
                            comp = true;
                            dir = A > 0 ? 1 : -1;
                        }
                    }
                    if (comp) {
                        if (dir == 1) {
                            adj[j].add(i);
                            radj[i].add(j);
                        } else {
                            adj[i].add(j);
                            radj[j].add(i);
                        }
                    }
                }
            }
            int[] indeg = new int[n];
            for (int i = 0; i < n; i++) {
                for (int v : adj[i])
                    indeg[v]++;
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++)
                if (indeg[i] == 0)
                    q.add(i);
            int[] order = new int[n];
            int idx = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                order[idx++] = u;
                for (int v : adj[u]) {
                    indeg[v]--;
                    if (indeg[v] == 0)
                        q.add(v);
                }
            }
            int[] len1 = new int[n];
            Arrays.fill(len1, 1);
            for (int i = 0; i < n; i++) {
                int u = order[i];
                for (int v : adj[u]) {
                    if (len1[v] < len1[u] + 1)
                        len1[v] = len1[u] + 1;
                }
            }
            int[] len2 = new int[n];
            Arrays.fill(len2, 1);
            for (int i = n - 1; i >= 0; i--) {
                int u = order[i];
                for (int v : adj[u]) {
                    if (len2[u] < len2[v] + 1)
                        len2[u] = len2[v] + 1;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i > 0)
                    pw.print(' ');
                pw.print(len1[i] + len2[i] - 1);
            }
            pw.println();
        }
        pw.close();
    }
}

// WRITEUP:
// We say two parabolas i and j are "comparable" if their difference polynomial
// has no real roots (negative discriminant, or A==0 and B!=0).
// We build a DAG where an edge j->i means parabola i is always strictly below
// parabola j.
// We topologically sort the DAG using Kahn's BFS, then compute the longest
// chain through each node using forward and backward DP passes.
// The final answer for each node i is len1[i] + len2[i] - 1, where len1 is the
// longest chain ending at i and len2 is the longest chain starting at i.
