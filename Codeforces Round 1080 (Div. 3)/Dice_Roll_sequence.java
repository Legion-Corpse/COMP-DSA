import java.io.*;
import java.util.*;

public class Dice_Roll_sequence {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");

    static String next() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(r.readLine());
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
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();

            int[] prev = new int[6];
            for (int j = 1; j <= 6; j++) {
                prev[j - 1] = (a[0] == j) ? 0 : 1;
            }

            for (int i = 1; i < n; i++) {
                int[] cur = new int[6];
                for (int j = 1; j <= 6; j++) {
                    int cost = (a[i] == j) ? 0 : 1;
                    int best = Integer.MAX_VALUE;
                    for (int k = 1; k <= 6; k++) {
                        if (k != j && k + j != 7) {
                            best = Math.min(best, prev[k - 1]);
                        }
                    }
                    cur[j - 1] = cost + best;
                }
                prev = cur;
            }

            int ans = Integer.MAX_VALUE;
            for (int x : prev)
                ans = Math.min(ans, x);
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}

// WRITEUP:
// We model this as a DP where the state is the face shown at each position
// (values 1 through 6).
// The cost at each step is 0 if the face matches the given sequence value, else
// 1.
// The transition constraint is that consecutive faces k and j cannot be equal
// and cannot sum to 7 (i.e., they cannot be opposite faces on a die).
// We take the minimum total cost over all n positions and return the minimum
// over all possible final faces.
