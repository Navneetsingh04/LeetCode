class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i= 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int it[] : prerequisites){
            adj.get(it[1]).add(it[0]);
        }
        int indegree[] = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int ans[] = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[i++] = node;
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(i != numCourses) return new int[0];
        return ans;
    }
}