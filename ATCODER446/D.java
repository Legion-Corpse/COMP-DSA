package ATCODER446;

import java.util.*;
import java.io.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            int len = dp.getOrDefault(a - 1, 0) + 1;
            if (len > dp.getOrDefault(a, 0)) {
                dp.put(a, len);
            }
            if (len > ans)
                ans = len;
        }
        System.out.println(ans);
    }
}

// WRITEUP: DP with a map: dp[v] = longest chain ending at value v. For each
// element a, dp[a] = dp[a-1] + 1. Answer is the max dp value seen.
