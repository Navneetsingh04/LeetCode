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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev= curr;
            curr = temp;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        if(head == null){
            return head;
        }
        // reverse linked list
        ListNode reverseHead = reverse(head);
        // remove the nodes that have a greater value of their left
        int max = reverseHead.val;
        ListNode prev = reverseHead;
        ListNode curr = reverseHead.next;
        while(curr != null){
            if(curr.val >= max){
                max = curr.val;
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }
        prev.next = null; //Terminate the list
        return reverse(reverseHead);
    }
}