import java.io.*;
import java.util.*;

public class Idiot_Search {

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

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt();
            int[] left = new int[n + 1];
            int[] right = new int[n + 1];
            int[] parent = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                int l = nextInt();
                int r = nextInt();
                left[i] = l;
                right[i] = r;
                if (l != 0)
                    parent[l] = i;
                if (r != 0)
                    parent[r] = i;
            }
            parent[1] = 0;

            long[] up = new long[n + 1];
            boolean[] vis = new boolean[n + 1];
            Deque<Integer> stk = new ArrayDeque<>();
            stk.push(1);
            while (!stk.isEmpty()) {
                int v = stk.peek();
                if (!vis[v]) {
                    vis[v] = true;
                    if (right[v] != 0)
                        stk.push(right[v]);
                    if (left[v] != 0)
                        stk.push(left[v]);
                } else {
                    stk.pop();
                    up[v] = (left[v] == 0 && right[v] == 0) ? 1 : 3 + up[left[v]] + up[right[v]];
                }
            }

            long[] ans = new long[n + 1];
            Deque<Integer> dfs = new ArrayDeque<>();
            dfs.push(1);
            while (!dfs.isEmpty()) {
                int v = dfs.pop();
                ans[v] = (up[v] + ans[parent[v]]) % MOD;
                if (left[v] != 0)
                    dfs.push(left[v]);
                if (right[v] != 0)
                    dfs.push(right[v]);
            }

            for (int i = 1; i <= n; i++) {
                if (i > 1)
                    sb.append(' ');
                sb.append(ans[i]);
            }
            sb.append('\n');
        }
        pw.print(sb);
        pw.flush();
    }
}

// WRITEUP:
// We compute up[v] = total traversal cost of the subtree rooted at v: leaves
// cost 1 step, internal nodes cost 3 + left subtree + right subtree.
// We then do a second DFS top-down to push the parent's contribution: ans[v] =
// up[v] + ans[parent[v]].
// ans[v] gives the total cost if the binary search starts at node v, summing
// its own subtree cost with the cost from the rest of the tree.
// Both passes use iterative DFS to avoid JVM stack overflow on deep trees.
