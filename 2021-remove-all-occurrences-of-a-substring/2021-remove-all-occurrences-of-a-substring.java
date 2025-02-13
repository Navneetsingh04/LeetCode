class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        StringBuilder ans = new StringBuilder(s);
        while(s.contains(part)){
            int i = ans.indexOf(part);
            if(i == -1){
                return s;
            }
            ans = ans.replace(i,i+part.length(),"");
            s = ans.toString();
        }
        return s;
    }
}