class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums){ 
        count += ((int) Math.log10(num)) & 1;
        }
        return count;
    }
}