class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxi = 0,mini = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            maxi = Math.max(maxi,sum);
            mini = Math.min(mini,sum);
        }
        return maxi-mini;
    }
}