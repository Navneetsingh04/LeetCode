class Solution {
    int MOD = (int)1e9+7;
    public int countPaths(int n, int[][] roads) {
        Map<Integer,List<int[]>> adjList = new HashMap<>();
        for(int i= 0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        } 
        for(int road[]: roads){
            int u = road[0],v = road[1],time = road[2];
            adjList.get(u).add(new int[]{v,time});
            adjList.get(v).add(new int[]{u,time});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long ans[] = new long[n];
        int pathCount[] = new int[n];
        Arrays.fill(ans,Long.MAX_VALUE);

        ans[0] = 0;
        pathCount[0] =1;
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long currTime = curr[0];
            int currNode = (int) curr[1];

            if(currTime > ans[currNode]) continue;

            for(int neighour[] : adjList.get(currNode)){
                int adjNode = neighour[0];
                int roadTime = neighour[1];

                if(currTime + roadTime < ans[adjNode]){
                    ans[adjNode] = currTime+roadTime;
                    pathCount[adjNode] = pathCount[currNode];
                    pq.add(new long[]{ans[adjNode],adjNode});
                }
                else if(currTime + roadTime == ans[adjNode]){
                    pathCount[adjNode] = (pathCount[adjNode] + pathCount[currNode])%MOD;
                }
            }
        }
        return pathCount[n-1];
    }
}