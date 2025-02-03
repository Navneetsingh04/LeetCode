class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0,right = 0,zeroCount = 0,maxlen = 0;
        int n = nums.length;
        while(right<n){
            if(nums[right] == 0){
                zeroCount++;
            }
            if(zeroCount>k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            if(zeroCount<=k){
                int len = right-left+1;
                maxlen = Math.max(maxlen,len);
            }
            right++;
        }
        return maxlen;
    }
}