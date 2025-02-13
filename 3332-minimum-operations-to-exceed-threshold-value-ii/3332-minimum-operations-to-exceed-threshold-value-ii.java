class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add((long)i);
        }
        int count = 0;
        while(!pq.isEmpty() && pq.peek() <k){
            long min = pq.poll();
            long secondMin = pq.poll();

            pq.add(min*2+secondMin);
            count++;
        }
        return count;
    }
}