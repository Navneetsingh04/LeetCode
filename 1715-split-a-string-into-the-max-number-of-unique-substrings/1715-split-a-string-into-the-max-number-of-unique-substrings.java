class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return backtrack(s,0,set);
    }
    public int backtrack(String s,int index,Set<String> set){
        int maxCount = 0;
        int n = s.length();
        if(index == n){
            return set.size();
        }
        for(int i = index;i<n;i++){
            String subString = s.substring(index,i+1);
            if(!set.contains(subString)){
                set.add(subString);
                maxCount = Math.max(maxCount,backtrack(s,i+1, set));
                set.remove(subString);
            }
        }
        return maxCount;
    }
}