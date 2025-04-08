class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;    
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i= 0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected,vis,i,n);
                count++;
            }
        }
        return count;
    }
    public void dfs(int[][] isConnected,boolean vis[],int node,int n){
        vis[node] = true;
        for(int i = 0;i<n;i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(isConnected,vis,i,n);
                vis[i] = true;
            }
        }
    }
}