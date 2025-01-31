class Solution {
    public void buildAnswer(Stack<String> st, StringBuilder ans) {
        if (st.isEmpty()) {
            return;
        }
        String minPath = st.pop();
        buildAnswer(st, ans);
        ans.append("/").append(minPath);
    }
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        int i = 0;
        int n = path.length();

        while(i<n){
            int start = i;
            while(i<n && path.charAt(i) != '/'){
                i++;
            }
            String minPath = path.substring(start,i);
            i++;
            if(minPath.equals("") || minPath.equals(".")){
                continue;
            }
            else if(minPath.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(minPath);
            }
        }
        StringBuilder ans = new StringBuilder();
        if (st.isEmpty()) {
            return "/";
        }
        buildAnswer(st, ans);
        return ans.toString();
    }
}