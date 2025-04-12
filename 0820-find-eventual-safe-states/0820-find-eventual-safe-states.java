class Solution {
    public boolean dfs(int node,int[][] graph,boolean vis[], 
    boolean pathVis[],int check[]){
        vis[node] = true;
        pathVis[node] =  true;
        check[node] = 0;
        for(int i: graph[node]){
            if(!vis[i]){
                if(dfs(i,graph,vis,pathVis,check)){
                    return true;
                }
            }
            else if(pathVis[i]){
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] =  false;
        return false; 
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        int check[] = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,graph,vis,pathVis,check);
            }
        }
        for(int i = 0;i<n;i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }
        return ans;
    }
}