class Solution {
    int n,m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,boolean vis[][],char[][] grid){
        if(i<0 || i>=n || j<0 || j>=m ||grid[i][j] == '0' || vis[i][j]){
            return;
        }
        vis[i][j] = true;
        dfs(i-1,j,vis,grid);  // up
        dfs(i+1,j,vis,grid);  // down
        dfs(i,j-1,vis,grid);  // left
        dfs(i,j+1,vis,grid);  // right
    }
} 