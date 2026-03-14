import java.io.*;
import java.util.*;

public class Heapify1 {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer t = new StringTokenizer("");

    static String n() throws IOException {
        while (!t.hasMoreTokens())
            t = new StringTokenizer(r.readLine());
        return t.nextToken();
    }

    static int ni() throws IOException {
        return Integer.parseInt(n());
    }

    public static void main(String[] args) throws IOException {
        int c = ni();
        StringBuilder s = new StringBuilder();
        while (c-- > 0) {
            int n = ni();
            boolean f = true;
            for (int i = 1; i <= n; i++) {
                int v = ni();
                if (f && (v / (v & -v)) != (i / (i & -i)))
                    f = false;
            }
            s.append(f ? "YES\n" : "NO\n");
        }
        System.out.print(s);
    }
}

// WRITEUP: For a min-heap, check v/lowbit(v) == i/lowbit(i) for every node. If
// any fails, the array is not a valid heap.
