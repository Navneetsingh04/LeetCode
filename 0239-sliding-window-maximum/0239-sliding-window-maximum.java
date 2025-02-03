class Solution {
    class Pair implements Comparable<Pair>{
        int val;
        int index;
        Pair(int val,int index){
            this.val = val;
            this.index = index;
        }
        public int compareTo(Pair o){
            return Integer.compare(o.val,this.val);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[] = new int[nums.length-k+1];
        for(int i = 0;i<k;i++){
            pq.add(new Pair(nums[i],i));
        }
        ans[0] = pq.peek().val;
        // consider rest of window
        for(int i = k;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
            // remove if max is from previous window
            while(pq.peek().index <= i-k){
                pq.poll();
            }
            ans[i-k+1] = pq.peek().val;
        }
        return ans;
    }
}