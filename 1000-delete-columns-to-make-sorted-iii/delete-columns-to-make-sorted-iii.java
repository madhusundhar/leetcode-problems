class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];
        int maxLen = 1;

        Arrays.fill(dp, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                boolean valid = true;
                for (int r = 0; r < n; r++) {
                    if (strs[r].charAt(j) > strs[r].charAt(i)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return m - maxLen;
    }
}
