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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;
        for(int i = 1;i<a;i++){
            prevA = prevA.next;
        }
        ListNode nextB = prevA;
        for(int i = a;i<=b+1;i++){
            nextB =nextB.next;
        }
        prevA.next = list2;
        ListNode tailList2 = list2;
        while(tailList2.next != null){
            tailList2 = tailList2.next;
        }
        tailList2.next = nextB;
        return list1;
    }
}