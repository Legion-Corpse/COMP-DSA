package ATCODER216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Stolen_Necklace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[2 * N + 1];
            for (int i = 1; i <= 2 * N; i++)
                A[i] = Integer.parseInt(st.nextToken());

            int[] fc = new int[N + 1];
            boolean[] seen = new boolean[N + 1];
            Arrays.fill(fc, -1);

            int p = 0;
            List<Integer> divs = new ArrayList<>();

            for (int i = 1; i <= 2 * N; i++) {
                int v = A[i];
                if (!seen[v]) {
                    seen[v] = true;
                    fc[v] = p;
                } else {
                    if (p == fc[v]) {
                        divs.add(i - 1);
                        p ^= 1;
                    }
                }
            }

            sb.append(divs.size()).append('\n');
            for (int i = 0; i < divs.size(); i++) {
                if (i > 0)
                    sb.append(' ');
                sb.append(divs.get(i));
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

// WRITEUP:
// We assign each gem a group (0 or 1) based on which half of the necklace it
// first appeared in.
// When a duplicate gem turns up in the same group it currently belongs to, we
// must cut the necklace before that position to rebalance both halves.
// We flip the group parity after each cut and collect all cut positions as the
// final answer.
