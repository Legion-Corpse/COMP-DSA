package ATCODER446;

import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        final long MOD = 998244353;
        long total = 0;
        int[] C = new int[N + 1];
        ArrayList<Integer>[] lists = new ArrayList[N + 1];
        for (int x : A) {
            long sumOther = (total - C[x]) % MOD;
            if (sumOther < 0)
                sumOther += MOD;
            long newG1 = ((x > 1 ? 1 : 0) + sumOther) % MOD;
            long newC;
            if (x == 1) {
                newC = (1 + sumOther) % MOD;
            } else {
                ArrayList<Integer> list = lists[x];
                int need = x - 1;
                long prev = 0;
                if (list != null) {
                    int sz = list.size();
                    if (sz >= need) {
                        prev = list.get(sz - need);
                    }
                }
                newC = prev;
            }
            long delta = (newC - C[x]) % MOD;
            total = (total + delta) % MOD;
            if (total < 0)
                total += MOD;
            C[x] = (int) newC;
            if (x > 1) {
                if (lists[x] == null)
                    lists[x] = new ArrayList<>();
                lists[x].add((int) newG1);
            }
        }
        System.out.println(total);
    }
}

// WRITEUP: Track C[x] = sequences ending with x exactly x times in a row. newC
// for x==1 counts all valid predecessors; for x>1 requires exactly x-1 prior
// occurrences of x. Maintain running total and update C[x] using stored lists
// of past newG1 values.
