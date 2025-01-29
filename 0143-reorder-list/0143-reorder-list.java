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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        // find middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // split list in two halves
        ListNode secondHead = slow.next;
        slow.next = null;  //terminate the firstr half

        // reverse the second half
        ListNode prev = null;
        ListNode curr = secondHead;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        secondHead = prev;

        // merg the two halves
        ListNode p1 = head;
        ListNode p2 = secondHead;
        while(p2 != null){
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;

            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
    }
}