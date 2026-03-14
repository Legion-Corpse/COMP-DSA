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

// WRITEUP: Build a frequency map, sort unique keys, then scan all pairs to find
// the first two with different frequencies. Brute force O(n^2) over unique
// elements is fine since distinct values are bounded.
