class Pair{
    int node;
    long time;
    Pair(int node,long time){
        this.time = time;
        this.node = node;
    }
}
class Solution {
    int MOD = (int)1e9+7;
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i= 0;i<n;i++){
            adjList.add(new ArrayList<>());
        } 
        for(int road[]: roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adjList.get(u).add(new Pair(v,time));
            adjList.get(v).add(new Pair(u,time));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Long.compare(x.time, y.time));
        long ans[] = new long[n];
        int pathCount[] = new int[n];
        Arrays.fill(ans,Long.MAX_VALUE);

        ans[0] = 0;
        pathCount[0] = 1;
        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p  = pq.poll();
            long currTime = p.time;
            int currNode = p.node;

            if(currTime > ans[currNode]) continue;

            for(Pair i: adjList.get(currNode)){
                int adjNode = i.node;
                long roadTime = i.time;

                if(currTime + roadTime < ans[adjNode]){
                    ans[adjNode] = currTime+roadTime;
                    pathCount[adjNode] = pathCount[currNode];
                    pq.add(new Pair(adjNode,ans[adjNode]));
                }
                else if(currTime + roadTime == ans[adjNode]){
                    pathCount[adjNode] = (pathCount[adjNode] + pathCount[currNode])%MOD;
                }
            }
        }
        return pathCount[n-1];
    }
}