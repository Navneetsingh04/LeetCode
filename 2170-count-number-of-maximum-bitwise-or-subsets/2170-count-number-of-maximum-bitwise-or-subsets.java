class Solution {
    public int countSubsets(int index,int currOr,int nums[],int maxOr,int dp[][]){
        if(index == nums.length){
            if(currOr == maxOr){
                return dp[index][currOr] = 1;
            }
            return dp[index][currOr] = 0;
        }
        if(dp[index][currOr] != -1){
            return dp[index][currOr];
        }
        int take = countSubsets(index+1,currOr | nums[index],nums,maxOr,dp);
        int notTake = countSubsets(index+1,currOr,nums,maxOr,dp);
        return dp[index][currOr] = take+notTake;

    }
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;
        for(int num : nums){
            maxOr |= num;
        }
        int dp[][] = new int[n+1][maxOr+1];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        int currOr = 0;
        return countSubsets(0,currOr,nums,maxOr,dp);
    }
}