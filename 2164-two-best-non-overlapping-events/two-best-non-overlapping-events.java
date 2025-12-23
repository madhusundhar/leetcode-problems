import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        // Sort by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // prefixMax[i] = max value from i to end
        int[] prefixMax = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            prefixMax[i] = Math.max(prefixMax[i + 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currVal = events[i][2];

            // binary search for first event starting after current ends
            int l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (events[mid][0] > events[i][1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            ans = Math.max(ans, currVal + prefixMax[l]);
        }

        return ans;
    }
}
