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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: find length
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Step 2: reduce k
        k = k % n;
        if (k == 0) return head;

        // Step 3: go to (n - k - 1) node
        int steps = n - k;
        ListNode curr = head;

        for (int i = 1; i < steps; i++) {
            curr = curr.next;
        }

        // Step 4: split into 2 lists
        ListNode secondHead = curr.next; // last k nodes
        curr.next = null; // break

        // Step 5: attach second list in front
        ListNode t = secondHead;
        while (t.next != null) {
            t = t.next;
        }
        t.next = head;

        return secondHead;
    }
}