/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        // min no. of of nodes in each parts
        int minNodes = len/k;
        // extra Nodes 
        int extraNodes = len%k;

        ListNode ans[] = new ListNode[k];
        curr = head;
        // dividing LL into k parts
        for(int i = 0;i<k;i++){
            ListNode pHead = curr;
            //  Determine the size of the current part
            // and Add an extra node to the first      extraNodes parts
            int currPartSize = minNodes+(i < extraNodes?1:0);

            // Traversing to the end of the current part
            for(int j = 0;j<currPartSize-1;j++){
                if(curr != null){
                    curr = curr.next;
                }
            }
           // Detaching the current part from the remainder of LL
            if(curr != null){
                ListNode nextPartHead = curr.next;
                curr.next = null;
                curr = nextPartHead;
            }
            ans[i] = pHead;
        }
        return ans;
    }
}