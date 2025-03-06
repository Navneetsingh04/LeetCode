class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(Math.abs(target) > sum) return 0;
        int dp[][] = new int[n+1][2*sum+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return countWays(nums,0,target,dp,n,sum);
    }
    public int countWays(int nums[],int index,int target,int dp[][],int n,int sum){
        if(index == n){
            return target == 0 ? 1:0;
        }
        int newTarget = target+sum;
        if(newTarget < 0 || newTarget > 2*sum) return 0;
        if(dp[index][newTarget] != -1){
            return dp[index][newTarget];
        }
        int add = countWays(nums,index+1,target-nums[index],dp,n,sum);
        int subtract = countWays(nums,index+1,target+nums[index],dp,n,sum);
        return dp[index][newTarget] = add+subtract;
    }
}