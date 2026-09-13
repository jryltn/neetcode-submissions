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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dNode = new ListNode(-1, head);
        ListNode sp = dNode, fp = dNode;

        while(n > 0) {
            fp = fp.next;
            n--;
        }

        while(fp.next != null) {
            sp = sp.next;
            fp = fp.next;
        }

        ListNode temp = sp.next.next;
        sp.next = temp;
        return dNode.next;
    }
}
