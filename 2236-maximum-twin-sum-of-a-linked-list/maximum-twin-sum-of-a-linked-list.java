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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast  = head;

        //find middle;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

        }
        //reverse second hale;
        ListNode prev = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        //claculate max sum;
        int max = 0;
        ListNode first = head;
        ListNode second = prev;
        while(second!=null){
            max = Math.max(max, first.val+second.val);
            first = first.next;
            second = second.next;
        }
        return max;
        
    }
}