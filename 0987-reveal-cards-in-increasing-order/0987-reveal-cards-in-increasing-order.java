class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new ArrayDeque<>();
        int[] ans = new int[deck.length];

        // put indices of ans into Queue
        for(int i = 0;i<ans.length;i++){
            q.add(i);
        }
        // reverse simulation - filling using sorted deck
        for(int i = 0;i<deck.length;i++){
            // Reveal
            ans[q.peek()] = deck[i];
            q.poll();

            // push front to bottom
            if(!q.isEmpty()){
                int f = q.peek();
                q.poll();
                q.add(f);
            } 
        }
        return ans;
    }
}