class BrowserHistory {
    Stack<String> browserStack = new Stack<>();
    Stack<String> fwdStack = new Stack<>();
    public BrowserHistory(String homepage) {
        browserStack.push(homepage);
    }
    
    public void visit(String url) {
        // clear all forward History
        while(!fwdStack.isEmpty()){
            fwdStack.pop();
        }
        browserStack.push(url);
    }
    
    public String back(int steps) {
        while(steps-- > 0){
            // back one time
            if(browserStack.size() > 1){
                fwdStack.push(browserStack.peek());
                browserStack.pop();
            }
            else{
                // only homePage is Present so back is not possible
                break;
            }
        }
        return browserStack.peek();
    }
    
    public String forward(int steps) {
        while(steps-- > 0){
            if(!fwdStack.isEmpty()){
                browserStack.push(fwdStack.peek());
                fwdStack.pop();
            }
            else{
                break;
            }
        }
        return browserStack.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */