package ATCODER446;

import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] parts = br.readLine().split(" ");
            int N = Integer.parseInt(parts[0]);
            int D = Integer.parseInt(parts[1]);
            int[] A = new int[N];
            int[] B = new int[N];
            parts = br.readLine().split(" ");
            for (int i = 0; i < N; i++)
                A[i] = Integer.parseInt(parts[i]);
            parts = br.readLine().split(" ");
            for (int i = 0; i < N; i++)
                B[i] = Integer.parseInt(parts[i]);
            Deque<int[]> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                q.add(new int[] { i, A[i - 1] });
                int b = B[i - 1];
                while (b > 0) {
                    int[] f = q.peek();
                    if (f[1] <= b) {
                        b -= f[1];
                        q.poll();
                    } else {
                        f[1] -= b;
                        b = 0;
                    }
                }
                int c = i - D;
                while (!q.isEmpty() && q.peek()[0] <= c)
                    q.poll();
            }
            int ans = 0;
            for (int[] e : q)
                ans += e[1];
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}

// WRITEUP: Simulate a queue of (customer, remaining amount) pairs. Each day,
// add the new customer then serve as many as B can from the front. After D days
// expire, evict old customers. Sum remaining amounts at the end.
