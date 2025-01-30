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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        while(--k > 0){
            fast = fast.next;
        }
        ListNode temp1 = fast;
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode temp2 = slow;
        int temp = temp1.val;
        temp1.val = temp2.val;
        temp2.val = temp;
        return head;
    }
}