class Solution {
    public int findTheWinner(int n, int k) {
        // all player should go into a queue
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1;i<=n;i++){
            q.add(i);
        }
        while(q.size() > 1){
            // simulate the Game
            for(int i = 1;i<k;i++){
                int player = q.peek();
                q.poll();
                // this player is not elimminated yet
                q.add(player);
            }
            // kth player must be elinimated
            q.poll();
        }
        return q.peek();
    }
}