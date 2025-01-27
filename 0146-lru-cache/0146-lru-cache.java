class LRUCache {
    class Node{
        int key,val;
        Node prev,next;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int capacity;
    Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public void addNode(Node newNode){
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }
    public void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int ans = resNode.val;

            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            map.put(key,head.next);
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            map.remove(key);
            deleteNode(curr);
        }
        if(map.size() == capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key,value));
        map.put(key,head.next);
    }
}

