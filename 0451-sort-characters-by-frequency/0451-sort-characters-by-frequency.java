class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b)-map.get(a));
        StringBuilder sb = new StringBuilder();
        for(char ch : list){
            sb.append(String.valueOf(ch).repeat(map.get(ch)));
        }
        return sb.toString();
    }
}