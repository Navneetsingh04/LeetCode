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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummynode = new ListNode(-1);
        ListNode current = dummynode;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            current.next = newNode;
            current = current.next;
        }
        if(carry>0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        return dummynode.next;
    }
}