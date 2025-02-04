class Solution {
    public int solveUsingSO(int n,int m,int[][] grid){
        int prev[] = new int[m];
        for(int i = 0;i<n;i++){
            int curr[] = new int[m];
            for(int j = 0;j<m;j++){
                if(i == 0 &&  j == 0) curr[j] = grid[i][j];
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i>0) up = prev[j]+grid[i][j];
                    if(j>0) left = curr[j-1]+grid[i][j];
                    curr[j] = Math.min(left,up);
                }
            }
            prev = curr;
        }
        return prev[m-1];
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int ans = solveUsingSO(n,m,grid);
        return ans;
    }
}