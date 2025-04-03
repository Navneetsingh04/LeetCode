class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxi = 0;
        if(n<3) return 0;
        for(int k = 2;k<n;k++){
            int maxPrefix = nums[0];
            for(int j = 1;j<k;j++){
                long res = (long)(maxPrefix-nums[j])*nums[k];
                maxi = Math.max(maxi,res);
                maxPrefix = Math.max(maxPrefix,nums[j]);
            }
        }
        return maxi;
    }
}