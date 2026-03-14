import java.io.*;
import java.util.*;

public class Sieve_of_Erato67henes {

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
        int t = nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (nextInt() == 67)
                    found = true;
            }
            sb.append(found ? "YES" : "NO").append('\n');
        }
        pw.print(sb);
        pw.flush();
    }
}

// WRITEUP:
// We scan each test case's array and check if the value 67 appears at least
// once.
// We output YES if we find it and NO otherwise.
