class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m){
            return false;
        }
        char sortedS1[] = s1.toCharArray();
        Arrays.sort(sortedS1);

        for(int i = 0;i<=m-n;i++){
            String temp = s2.substring(i,i+n);

            char sortedTemp[] = temp.toCharArray();
            Arrays.sort(sortedTemp);

            if(Arrays.equals(sortedTemp,sortedS1)){
                return true;
            }
        }
        return false;
    }
}