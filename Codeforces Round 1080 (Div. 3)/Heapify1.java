import java.io.*;
import java.util.*;

public class Heapify1 {

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
        int c = nextInt();
        StringBuilder sb = new StringBuilder();
        while (c-- > 0) {
            int n = nextInt();
            boolean valid = true;
            for (int i = 1; i <= n; i++) {
                int v = nextInt();
                if (valid && (v / (v & -v)) != (i / (i & -i)))
                    valid = false;
            }
            sb.append(valid ? "YES" : "NO").append('\n');
        }
        pw.print(sb);
        pw.flush();
    }
}

// WRITEUP:
// We use the key observation that in a valid min-heap, a node's position and
// value are related via their lowest set bit (lowbit).
// We check v/lowbit(v) == i/lowbit(i) for every node i; if any node fails this
// check, we output "No", otherwise "Yes".
