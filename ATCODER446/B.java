package ATCODER446;

import java.io.*;
import java.util.*;

public class B {

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
        int n = nextInt();
        int m = nextInt();
        boolean[] taken = new boolean[m + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int l = nextInt();
            int chosen = 0;
            for (int j = 0; j < l; j++) {
                int x = nextInt();
                if (chosen == 0 && !taken[x]) {
                    taken[x] = true;
                    chosen = x;
                }
            }
            sb.append(chosen).append('\n');
        }
        pw.print(sb);
        pw.flush();
    }
}

// WRITEUP:
// We greedily assign each person the first item they prefer that hasn't already
// been taken by someone else.
// We use a boolean array to track which items are claimed, and output the
// assigned item for each person (0 if none of their preferences were
// available).
