class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solve(0,-1,nums,dp,n);
    }
    public int solve(int i,int prevI,int nums[],int dp[][],int n){
        if(i == n){
            return 0;
        }
        if(dp[i][prevI+1] != -1){
            return dp[i][prevI+1];
        }
        int len = 0;
        len = solve(i+1,prevI,nums,dp,n);
        if(prevI == -1 || nums[i] > nums[prevI]){
            len = Math.max(len,1+solve(i+1,i,nums,dp,n));
        }
        return dp[i][prevI+1] = len;
    }
}