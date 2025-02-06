class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int countTuple = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i= 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int p = nums[i]*nums[j];
                map.put(p,map.getOrDefault(p,0)+1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            if (freq > 1) {
               countTuple += (freq*(freq-1))/2; 
            }
        }
        return countTuple*8;
    }
}