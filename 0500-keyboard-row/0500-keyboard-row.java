class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        
        List<String> list = new ArrayList<>();

        for(int i = 0;i<words.length;i++){
            String str[] = words[i].toLowerCase().split("");
            boolean flag = true;
            String temp = "";

            if(row1.contains(str[0])){
                temp = row1;
            }
            else if(row2.contains(str[0])){
                temp = row2;
            }
            else{
                temp = row3;
            }
            for(int j = 1;j<str.length;j++){
                if(!temp.contains(str[j])){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(words[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}