class Solution {
    public String swap(String s,int i,int j){
        char ch[] = s.toCharArray();
        char temp = ch[i];
        ch[i]= ch[j];
        ch[j]= temp;
        return new String(ch);
    }
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int count = 0;
        int first = -1,second = -1;
        if(n != m) return false;
        for(int i = 0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 2) return false;
                if(first == -1){
                    first = i;
                }
                else{
                    second = i;
                }
            }
        }
        if(count == 0) return true;
        if(count != 2) return false;
        return swap(s1,first,second).equals(s2);
    }
}