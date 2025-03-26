class Solution {
    public int solve(int i,int arr[],int k,int n,int dp[]){
        if(i == n) return 0;
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        if(dp[i] != -1){
            return dp[i];
        }
        for(int j = i;j<Math.min(i+k,n);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = (len*maxi)+solve(j+1,arr,k,n,dp);
            maxAns = Math.max(sum,maxAns);
        }
        return dp[i] = maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,arr,k,n,dp);
    }
}