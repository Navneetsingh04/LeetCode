class Solution {
    public boolean check(int i,int sum,String s,int num){
        if(i == s.length()){
            return sum == num;
        }
        if(sum>num){
            return false;
        }
        boolean possible = false;
        for(int j = i;j<s.length();j++){
            String sub = s.substring(i,j+1);
            int val = Integer.parseInt(sub);

            possible = possible || check(j+1,sum+val,s,num);

            if(possible == true){
                return true;
            }
        }
        return possible;
    }
    public int punishmentNumber(int n) {
        int num = 0;
        for(int i = 1;i<=n;i++){
            int sq = i*i;
            String s = Integer.toString(sq);
            if(check(0,0,s,i) == true){
                num += sq;
            }
        }
        return num;
    }
}