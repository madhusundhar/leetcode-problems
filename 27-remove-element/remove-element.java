class Solution {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        int n=0;
        for(int i=0;i<len;i++){
            if(val!=nums[i]){
                nums[n]=nums[i];
            n++;
            }
        }   
        return n;
    }
}