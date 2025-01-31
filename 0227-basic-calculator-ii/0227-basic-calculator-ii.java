class Solution {
    public int calculate(String s) {
        int n = s.length();
        int lastValue = 0;
        char operation = '+';
        int value = 0;
        int ans = 0;
        for(int i = 0;i<n;i++){
            char currChar = s.charAt(i);

            if(Character.isDigit(currChar)){
                value = value*10+(currChar-'0');
            }

            if(!Character.isDigit(currChar) && currChar != ' ' || i == n-1 ){

                // perform the operation based on the previous sign
                switch(operation){
                    case '+':
                        ans += lastValue;
                        lastValue = value;
                        break;
                    case '-':
                        ans += lastValue;
                        lastValue = -value;
                        break;
                    case '*':
                        lastValue *= value;    //multiply with the top value of the stack
                        break;
                    case '/':
                        lastValue /= value;    //divide with the top value of the stack
                        break;
                }
                // Update the operation for the next iteration
                operation = currChar; 
                value = 0;   // rest the value for the next number
            }
        }
       ans += lastValue;
        return ans;
    }
}