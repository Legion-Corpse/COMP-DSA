class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.merge(n, 1, Integer::sum);

        int[] u = freq.keySet().stream().sorted().mapToInt(i -> i).toArray();

        for (int i = 0; i < u.length; i++)
            for (int j = i + 1; j < u.length; j++)
                if (!freq.get(u[i]).equals(freq.get(u[j])))
                    return new int[] { u[i], u[j] };

        return new int[] { -1, -1 };
    }
}

// WRITEUP:
// We build a frequency map to count how often each number appears, then sort
// the unique keys in ascending order.
// We scan all pairs (i, j) of unique keys and return the first pair whose
// frequencies differ.
// Brute force O(n^2) over unique elements is acceptable here since the number
// of distinct values is bounded.
