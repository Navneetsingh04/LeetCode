class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        int index = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);
            
            if (Character.isDigit(ch)) {
                // Build the full number
                StringBuilder num = new StringBuilder();
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num.append(s.charAt(index));
                    index++;
                }
                st.push(num.toString());
            } 
            else if (ch == '[') {
                st.push("[");
                index++;
            } 
            else if (ch == ']') {
                // Extract the string to be repeated
                StringBuilder stringToRepeat = new StringBuilder();
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    stringToRepeat.insert(0, st.pop());
                }
                // Pop the '[' from the stack
                st.pop();
                
                // Extract the number of times to repeat
                int repeatTimes = Integer.parseInt(st.pop());
                
                // Create the repeated string
                StringBuilder currentDecodeString = new StringBuilder();
                for (int i = 0; i < repeatTimes; i++) {
                    currentDecodeString.append(stringToRepeat);
                }
                
                // Push the repeated string back onto the stack
                st.push(currentDecodeString.toString());
                index++;
            } else {
                // Push the character as a string onto the stack
                st.push(Character.toString(ch));
                index++;
            }
        }

        // Build the final result from the stack
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }

        return result.toString();
    }
}