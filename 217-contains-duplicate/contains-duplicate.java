class Solution {
    public boolean containsDuplicate(int[] nums) {

        int n = nums.length;
        int size = 2 * n + 1;  

        Integer[] table = new Integer[size];

        for (int x : nums) {

            int idx = (x % size + size) % size;  

            while (table[idx] != null) {
                if (table[idx] == x) {
                    return true;
                }

                idx++;
                if (idx == size) idx = 0;
            }

            table[idx] = x;
        }

        return false;
    }
}
