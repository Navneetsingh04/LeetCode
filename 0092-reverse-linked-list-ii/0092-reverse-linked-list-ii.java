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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        // move prev to the node before sublist
        for(int i = 1;i<left;i++){
            prev = prev.next;
        }
        // reversing sublist
        ListNode curr = prev.next;
        ListNode nextNode = curr.next;
        
        for(int i = 0;i<right-left;i++){
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
            nextNode = curr.next;
        }
        return dummyNode.next;
    }
}