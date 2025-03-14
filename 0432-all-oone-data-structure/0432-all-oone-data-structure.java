class AllOne {
    class Node{
        int count;
        LinkedHashSet<String> keys;
        Node next;
        Node prev;
        Node(int count){
            this.count = count;
            keys = new LinkedHashSet<>();
            next = null;
            prev = null;
        }
    }
    public Map<String,Node> map;
    Node head;
    Node last;
    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        last= new Node(0);
        head.next = last;
        last.prev = head;
    }
    public Node addNodeAfter(Node prevNode,int count){
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        return newNode;
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void inc(String key) {
        if(!map.containsKey(key)){
            if(head.next == last || head.next.count != 1){
                addNodeAfter(head,1);
            }
            head.next.keys.add(key);
            map.put(key,head.next);
        }
        else{
            Node currNode = map.get(key);
            int currCount = currNode.count;
            if(currNode.next == last || currNode.next.count != currCount+1){
                addNodeAfter(currNode,currCount+1);
            }
            currNode.next.keys.add(key);
            map.put(key,currNode.next);
            currNode.keys.remove(key);
            if(currNode.keys.isEmpty()){
                removeNode(currNode);
            }
        }
    }
    
    public void dec(String key) {
        if(!map.containsKey(key)){
            return;
        }
        Node currNode = map.get(key);
        int currCount  = currNode.count;

        currNode.keys.remove(key);

        if(currCount == 1){
            map.remove(key);
        }
        else{
            if(currNode.prev == head || currNode.prev.count != currCount-1){
                addNodeAfter(currNode.prev,currCount-1);
            }
            currNode.prev.keys.add(key);
            map.put(key,currNode.prev);
        }
        if(currNode.keys.isEmpty()){
            removeNode(currNode);
        }
    }
    
    public String getMaxKey() {
        return last.prev == head ? "" : last.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        return head.next == last ? "" : head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */