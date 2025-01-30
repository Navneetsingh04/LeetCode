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
        Deque<Integer> st1 = new ArrayDeque<>();
        Deque<Integer> st2 = new ArrayDeque<>();

        while(l1 != null){
            st1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            st2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummyNode = new ListNode();
        int carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty() || carry != 0){
            int num1 = 0;
            int num2 = 0;
            if(!st1.isEmpty()){
                num1 = st1.pop();
            }
            if(!st2.isEmpty()){
                num2 = st2.pop();
            }
            int sum = num1+num2+carry;

            ListNode newNode = new ListNode(sum%10);
            newNode.next = dummyNode.next;
            dummyNode.next = newNode;

            carry = sum/10;
        }
        return dummyNode.next;
    }
}