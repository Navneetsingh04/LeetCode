class Solution {
    public int func(int i ,int j,int cuts[],int dp[][]){
        int mini = Integer.MAX_VALUE;
        if(i>j) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int idx = i;idx<=j;idx++){
            int cost = (cuts[j+1] - cuts[i-1])+
            func(i,idx-1,cuts,dp)+func(idx+1,j,cuts,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int newCuts[] = new int[m+2];
        newCuts[0] = 0;
        newCuts[m+1] = n;  

        for(int i = 0;i<m;i++){
            newCuts[i+1] = cuts[i];
        }
        Arrays.sort(newCuts);
        int dp[][] = new int[m+2][m+2];
        for(int i = m;i>=1;i--){
            for(int j = 1;j<=m;j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int idx = i;idx<=j;idx++){
                    int cost = (newCuts[j+1]-newCuts[i-1])+
                    dp[i][idx-1] +dp[idx+1][j];
                    mini = Math.min(mini,cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][m];
    }
}