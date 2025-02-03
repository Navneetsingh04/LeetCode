class RecentCounter {
    Queue<Integer> q = new ArrayDeque<>();
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        q.add(t);
        // pop invalid request older than t-3000
        while(!q.isEmpty() && q.peek() < (t-3000)){
            q.poll();
        }
        // Now queue have only number of recents calls
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */