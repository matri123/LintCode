/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode ln = new ListNode(0);
        while(head != null){
            ListNode temp = head.next;
            head.next = ln.next;
            ln.next = head;
            head = temp;
        }
        return ln.next;
    }
}

