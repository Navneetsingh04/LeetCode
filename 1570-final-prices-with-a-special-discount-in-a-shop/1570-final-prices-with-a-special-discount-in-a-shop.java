class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current price is less than or equal to 
            // the price at the index stored at the top of the stack
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        // For any remaining indices in the stack, there is no discount available
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices[index];
        }
        return answer;
    }
}