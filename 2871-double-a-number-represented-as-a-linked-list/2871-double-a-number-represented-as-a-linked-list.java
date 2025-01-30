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
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode current = head;
        int carry = 0;
        while (current != null) {
            int product = 2 * current.val + carry;
            current.val = product % 10;
            carry = product / 10;
            if (current.next == null && carry != 0) {
                current.next = new ListNode(carry);
                carry = -1;
            }
            current = current.next;
        }
        head = reverse(head);
        return head;
    }
}
