class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int count = 0;
        int left = 0,bitmask = 0;
        for(int i = 0;i<n;i++){
            while((bitmask & nums[i]) != 0){
                bitmask ^= nums[left];
                left++;
            }
            bitmask |= nums[i];
            count = Math.max(count,i-left+1);
        }
        return count;
    }
}