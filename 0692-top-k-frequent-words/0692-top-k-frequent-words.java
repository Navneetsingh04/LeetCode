class Solution {
    class MyComparator implements Comparator<Map.Entry<String,Integer>> {
        public int compare(Map.Entry<String,Integer> a,Map.Entry<String,Integer> b) {
            if(a.getValue().equals(b.getValue())){
                return b.getKey().compareTo(a.getKey());
            }
            return a.getValue() - b.getValue();
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(new MyComparator());
        for(Map.Entry<String,Integer> e : map.entrySet()){
            minHeap.offer(e);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            ans.add(minHeap.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
}