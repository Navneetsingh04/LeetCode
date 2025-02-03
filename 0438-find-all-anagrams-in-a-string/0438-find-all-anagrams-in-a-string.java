class Solution {
    public boolean matches(int smap[],int pmap[]){
        for(int i = 0;i<smap.length;i++){
            if(smap[i] != pmap[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;
        int pmap[] = new int[26];
        int smap[] = new int[26];

        for(char ch : p.toCharArray()){
            pmap[ch -'a']++;
        }
        for(int i = 0;i<p.length();i++){
            smap[s.charAt(i)-'a']++;
        }
        if(matches(smap,pmap)){
            ans.add(0);
        }
        for(int i = p.length();i<s.length();i++){
            smap[s.charAt(i)-'a']++;
            smap[s.charAt(i-p.length())- 'a']--;
            if(matches(smap,pmap)){
                ans.add(i-p.length()+1);
            }
        }
         return ans;
    }
}