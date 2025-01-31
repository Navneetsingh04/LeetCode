class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Create pairs of position and speed
        double[][] pair = new double[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        // Sort the pairs based on position in ascending order
        Arrays.sort(pair, (a, b) -> Double.compare(a[0], b[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            double time = (target - pair[i][0]) / pair[i][1];
            // If the stack is not empty and the current car will reach the target
            // earlier or at the same time as the car at the top of the stack, it means
            // the current car will join the fleet of the car at the top of the stack
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }
            stack.push(time);
        }
        return stack.size();
    }
}