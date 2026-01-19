class Solution {
public int nthSuperUglyNumber(int n, int[] primes) {
    long[] dp = new long[n];
    dp[0] = 1;

    int k = primes.length;
    int[] idx = new int[k];

    for (int i = 1; i < n; i++) {
        long min = Long.MAX_VALUE;

        for (int j = 0; j < k; j++) {
            min = Math.min(min, dp[idx[j]] * primes[j]);
        }

        dp[i] = min;

        for (int j = 0; j < k; j++) {
            if (dp[idx[j]] * primes[j] == min) {
                idx[j]++;
            }
        }
    }

    return (int) dp[n - 1];
}

}
