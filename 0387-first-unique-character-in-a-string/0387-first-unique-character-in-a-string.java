class Solution {
    public int firstUniqChar(String s) {
        Queue<Character> q = new ArrayDeque<>();
        int freq[] = new int[26];
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            q.add(ch);

            while(!q.isEmpty()){
                char frontChar = q.peek();
                if(freq[frontChar-'a']>1){
                    q.poll();
                }
                else{
                    break;
                }
            } 
        }
        while (!q.isEmpty()) {
            char frontChar = q.poll();
            if (freq[frontChar - 'a'] == 1) {
                return s.indexOf(frontChar);
            }
        }
        return -1;
    }
}