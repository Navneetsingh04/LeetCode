class Solution {
    private char solveOp(char op, List<Character> values) {
        switch (op) {
            case '!': return values.get(0) == 't' ? 'f' : 't';
            case '&': return values.contains('f') ? 'f' : 't';
            case '|': return values.contains('t') ? 't' : 'f';
            default: return 't';
        }
    }
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ',') continue;
            if (c == ')') {
                List<Character> values = new ArrayList<>();
                while (stack.peek() != '(') values.add(stack.pop());
                stack.pop(); 
                char op = stack.pop(); 
                stack.push(solveOp(op, values));
            } 
            else {
                stack.push(c);
            }
        }
        return stack.peek() == 't';
    }
}
