class Solution {
    public String intToRoman(int num) {
        String romanSymbol[] = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[] = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuffer ans = new StringBuffer();
        for(int i = 0;i<romanSymbol.length;i++){
            while(num>=value[i]){
                ans.append(romanSymbol[i]);
                num -= value[i];
            }
        }
        return ans.toString();
    }
}