/**
 * Definition for singly-linked list.
 */
//   public class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }
 
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int total = n * m;
        for (int i[]: ans) {
            Arrays.fill(i, -1);
        }
        int startingRow = 0;
        int endingCol = n - 1;
        int endingRow = m - 1;
        int startingCol = 0;
      
        while (head != null) {
            // printing the starting row
            for (int i = startingCol; i <= endingCol && head != null; i++) {
                ans[startingRow][i] =  head.val;
                head = head.next;
            }
            startingRow++;
            // printing the ending column
            for (int i = startingRow; i <= endingRow && head != null; i++) {
                ans[i][endingCol] =  head.val;
                head = head.next;
            }
            endingCol--;    
            // printing the ending row
            for (int i = endingCol; i >= startingCol  && head != null; i--) {
                ans[endingRow][i] = head.val;
                head = head.next;
            }
            endingRow--;
            // printing the starting column
            for (int i = endingRow; i >= startingRow && head != null; i--) {
                ans[i][startingCol] =  head.val;
                head = head.next;
            }
            startingCol++;
        }
        return ans;
    }
}
