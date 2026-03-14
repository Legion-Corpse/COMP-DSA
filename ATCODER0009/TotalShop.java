package ATCODER0009;

import java.io.*;
import java.util.*;

public class TotalShop {

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
        int K = nextInt();
        long M = nextLong();

        long totalMod = 0;
        for (int i = 0; i < K; i++) {
            long x = nextLong();
            totalMod = (totalMod + x) % M;
        }

        pw.println(totalMod);
        pw.flush();
    }
}

// WRITEUP: Read K prices and accumulate their sum mod M. Output the running
// total modulo M.
