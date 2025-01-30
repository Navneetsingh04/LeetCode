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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int ans[] = new int[]{-1,-1};
        ListNode prev = head;
        if(prev == null){
            return ans;
        }
        ListNode curr = head.next;
        if(curr == null){
            return ans;
        }
        ListNode nxt = head.next.next;
        if(nxt == null){
            return ans;
        }
        int firstCP = -1;
        int lastCP = -1;
        int minDist = Integer.MAX_VALUE;
        int i = 1;
        while(nxt != null){
            boolean isCP = ((curr.val > prev.val && curr.val > nxt.val) || 
                            (curr.val < prev.val && curr.val < nxt.val))?true:false;
            if(isCP && firstCP == -1){
                firstCP = i;
                lastCP = i;
            }
            else if(isCP){
                minDist = Math.min(minDist,i-lastCP);
                lastCP = i;
            }
            i++;
            prev = prev.next;
            curr = curr.next;
            nxt = nxt.next;
        }
        if(lastCP == firstCP){
            return ans;
        }
        else{
            ans[0] = minDist;
            ans[1] = lastCP-firstCP;
        }
        return ans;
    }
}