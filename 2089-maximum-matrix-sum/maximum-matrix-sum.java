class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long total = 0;
        int negCount = 0;
        int smallest = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) negCount++;
                int abs = Math.abs(val);
                total += abs;
                smallest = Math.min(smallest, abs);
            }
        }

        if (negCount % 2 == 0) return total;
        return total - 2L * smallest;
    }
}
