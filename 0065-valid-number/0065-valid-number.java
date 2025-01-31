class Solution {
    public boolean isNumber(String s) {
        int index = -1;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'e' || c == 'E'){
                if(index != -1){
                    return false;
                }
                index = i;
            }
        }
        if(index != -1){
            String left = s.substring(0,index);
            String right = s.substring(index+1);
            boolean leftValid = isDecimal(left) || isInteger(left);
            boolean rightValid = isInteger(right);
            return leftValid && rightValid;
        }
        else{
            return isDecimal(s) || isInteger(s);
        }
    }
    public boolean isInteger(String s){
        if(s.isEmpty()){
            return false;
        }
        int i = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            i = 1;
        }
        if(i == s.length()){
            return false;
        }
        for(;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public boolean isDecimal(String s){
        if(s.isEmpty()){
            return false;
        }
        int i = 0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            i = 1;
        }
        String rem = s.substring(i);
        if(rem.isEmpty()){
            return false;
        }
        int dotIndex = rem.indexOf('.');
        if(dotIndex == -1){
            return false;
        }
        if(rem.indexOf('.',dotIndex+1) != -1){
            return false;
        }
        String beforDot = rem.substring(0,dotIndex);
        String afterDot = rem.substring(dotIndex+1);
        boolean beforDigit = beforDot.isEmpty() || isAllDigit(beforDot);
        boolean afterDigit = afterDot.isEmpty() || isAllDigit(afterDot);
        if(!beforDigit || !afterDigit){
            return false;
        }
        if(beforDot.isEmpty() && afterDot.isEmpty()){
            return false;
        }
        return true;
    }
    public boolean isAllDigit(String s){
        if(s.isEmpty()){
            return true;
        }
        for(int i = 0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}