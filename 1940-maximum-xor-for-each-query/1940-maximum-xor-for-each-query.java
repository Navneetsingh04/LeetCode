class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int ans[] = new int[n];
        int XOR = 0;
        for(int i = 0;i<n;i++){
            XOR ^= nums[i];
        }
        // to find flip,first the mask having all bits set to 1
        int mask =  (1<<maximumBit) - 1;
        for(int i = 0;i<n;i++){
            int k = XOR^mask;  // fliped value of XOR
            ans[i] = k;

            XOR ^=  nums[n-i-1];
        }
        return ans;
    }
}