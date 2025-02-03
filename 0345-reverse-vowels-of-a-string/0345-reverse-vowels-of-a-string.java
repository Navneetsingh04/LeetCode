class Solution {
    public boolean isVowel(char c){
        return c == 'a' ||c == 'e'||c == 'i' ||c == 'o' || c == 'u'
        ||c == 'A' ||c == 'E'||c == 'I' ||c == 'O' || c == 'U';
    }
    public String reverseVowels(String s) {
    int start = 0;
    int end = s.length()-1;
    char[] arr = s.toCharArray();
    while(start<end){
        if(isVowel(arr[start])){
            if(isVowel(arr[end])){
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            else{
                end--;
            }
        }
        else{
            start++;
            }
    }

    return new String(arr);
    }
}