class Solution {
    public boolean subsetSum(int index,int n,int target,int nums[],int dp[][]){
        if(target == 0) return true;
        if(index == 0) return (nums[0] == target);
        if(dp[index][target] != -1){
            return dp[index][target] == 1;
        }
        boolean notTake = subsetSum(index-1,n,target,nums,dp);
        boolean take = false;
        if(nums[index] <= target){
            take = subsetSum(index-1,n,target-nums[index],nums,dp);
        }
        dp[index][target] = notTake || take?1:0;
        return dp[index][target] == 1;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
       
        for(int i: nums){
            totalSum += i;
        }
        if(totalSum%2 != 0) return false;
        int target = totalSum/2;
        int dp[][] = new int[n][target+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return subsetSum(n-1,n,target,nums,dp);
    }
}