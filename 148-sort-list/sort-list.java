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

// class Solution {
//     public ListNode sortList(ListNode head) {
//         if (head == null) return head;

//         // Step 1: Store values in array
//         List<Integer> list = new ArrayList<>();
//         ListNode temp = head;

//         while (temp != null) {
//             list.add(temp.val);
//             temp = temp.next;
//         }

//         // Step 2: Sort array
//         Collections.sort(list);

//         // Step 3: Put back into linked list
//         temp = head;
//         int i = 0;

//         while (temp != null) {
//             temp.val = list.get(i++);
//             temp = temp.next;
//         }

//         return head;
//     }
// }
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) return head;

        // Step 1: Find middle
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // Step 2: Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Step 3: Merge
        return merge(left, right);
    }

    // Find middle (left middle)
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        // attach remaining
        if (l1 != null) temp.next = l1;
        if (l2 != null) temp.next = l2;

        return dummy.next;
    }
}