package ATCODER0009;

import java.io.*;
import java.util.*;

public class DungeonExplain {

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

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long s = nextLong();
        long c = nextLong();

        long k = 0;

        for (int i = 0; i < n; i++) {
            long h = nextLong();
            long p = nextLong();

            if (s >= h)
                s = s - h + p;
            else
                k++;
        }

        pw.println(k * c);
        pw.flush();
    }
}

// WRITEUP: Simulate each room. If current HP >= threshold h, defeat monster and
// gain p HP, else skip (count missed). Total cost = missed rooms * c.
