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
    public int gcd(int a,int b){
        while(a >0 && b>0){
            if(a > b){
                a = a%b;
            }
            else{
                b = b%a;
            }
            if(a == 0){
                return b;
            }
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head.next;

        while(node2 != null){
            int gcd = gcd(node1.val,node2.val);
            ListNode gcdNode = new ListNode(gcd);
            node1.next = gcdNode;
            gcdNode.next = node2;

            node1 = node2;
            node2 = node2.next;
        }
        return head;
    }
}