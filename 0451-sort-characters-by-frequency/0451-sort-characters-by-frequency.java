class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)-> map.get(b)- map.get(a));
        StringBuilder str = new StringBuilder();
        for(char c : list){
            str.append(String.valueOf(c).repeat(map.get(c)));
        }
        return str.toString();
    }
}