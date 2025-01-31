class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Stack<Integer> st = new Stack<>();
        
        // Initialize all collision times to -1
        for(int i = 0;i<n;i++){
            ans[i] = -1;
        }
        for(int i = n - 1; i >= 0; i--){
            int pos = cars[i][0];
            int speed = cars[i][1];
            
            // Process the stack to find the collision time
            while(!st.isEmpty()){
                int topIndex = st.peek();
                int topPos = cars[topIndex][0];
                int topSpeed = cars[topIndex][1];
                
                // If the current car's speed is less than or equal to top car's speed so
                // it will never catch up so we remove the top car from the stack.
                if(speed <= topSpeed) {
                    st.pop();
                    continue;
                }
                // Calculate the collision time with the top car in the stack
                double collisionTime = (double)(topPos - pos)/(speed - topSpeed);
                
                // If the collision time is less than the collision time of the top car
                // with any car in front of it or if the top car has no collision time
                // we update the collision time.
                if (collisionTime < ans[topIndex] || ans[topIndex] == -1) {
                    ans[i] = collisionTime;
                    break;
                }
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}
