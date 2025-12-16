import java.util.*;

class Solution {
    static final int NEG = -1_000_000_000;

    List<Integer>[] tree;
    int[] present, future;
    int B;

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.present = present;
        this.future = future;
        this.B = budget;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] e : hierarchy) {
            tree[e[0] - 1].add(e[1] - 1);
        }

        int[][] res = dfs(0);

        int ans = 0;
        for (int b = 0; b <= B; b++) {
            ans = Math.max(ans, res[0][b]); // root has NO parent
        }
        return ans;
    }

    // returns {dp0, dp1}
    int[][] dfs(int u) {
        int[] dp0 = new int[B + 1];
        int[] dp1 = new int[B + 1];
        Arrays.fill(dp0, NEG);
        Arrays.fill(dp1, NEG);
        dp0[0] = dp1[0] = 0;

        // child merges
        int[] skip = new int[B + 1];
        int[] buy  = new int[B + 1];
        Arrays.fill(skip, NEG);
        Arrays.fill(buy, NEG);
        skip[0] = buy[0] = 0;

        for (int v : tree[u]) {
            int[][] child = dfs(v);
            skip = merge(skip, child[0]);
            buy  = merge(buy,  child[1]);
        }

        // u skips
        for (int b = 0; b <= B; b++) {
            dp0[b] = skip[b];
            dp1[b] = skip[b];
        }

        int cost0 = present[u];
        int cost1 = present[u] / 2;
        int profit0 = future[u] - cost0;
        int profit1 = future[u] - cost1;

// u buys
for (int b = B; b >= 0; b--) {
    if (b >= cost0 && buy[b - cost0] != NEG) {
        dp0[b] = Math.max(dp0[b], buy[b - cost0] + profit0);
    }
    if (b >= cost1 && buy[b - cost1] != NEG) {
        dp1[b] = Math.max(dp1[b], buy[b - cost1] + profit1);
    }
}


        return new int[][] { dp0, dp1 };
    }

    int[] merge(int[] a, int[] b) {
        int[] res = new int[B + 1];
        Arrays.fill(res, NEG);

        for (int i = 0; i <= B; i++) {
            if (a[i] == NEG) continue;
            for (int j = 0; i + j <= B; j++) {
                if (b[j] == NEG) continue;
                res[i + j] = Math.max(res[i + j], a[i] + b[j]);
            }
        }
        return res;
    }
}
