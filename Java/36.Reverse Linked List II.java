/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode first = head, last1 = head, last2 = head;
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode temp1 = temp;
        for(int i = 0; i <= n; i ++){
            if(i == m - 1){
                last1 = temp;
            }
            if(i == m){
                first = temp;
            }
            if(i == n){
                last2 = temp.next;
                temp.next = null;
            }
            temp = temp.next;
        }
        last1.next = reverse(first);
        while(last1.next != null){
            last1 = last1.next;
        }
        last1.next = last2;
        return temp1.next;
    }
    
    private ListNode reverse(ListNode head) {
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
