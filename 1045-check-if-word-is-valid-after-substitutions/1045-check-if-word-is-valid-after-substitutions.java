class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        int found = s.indexOf("abc");
        if(found != -1){
            String tleft = s.substring(0,found);
            String tright = s.substring(found+3,s.length());
            return isValid(tleft+tright);
        }
        return false;
    }
}