class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm
            = new HashMap<>();
            for(String str:strs){
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                String sortedWords = new String(ch);
                if(!hm.containsKey(sortedWords)){
                    hm.put(sortedWords,new ArrayList<>());
                }
                hm.get(sortedWords).add(str);
            }
            return new ArrayList<>(hm.values());
    }
}