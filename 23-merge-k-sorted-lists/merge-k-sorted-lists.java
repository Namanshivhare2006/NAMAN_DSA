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
    public ListNode mergeKLists(ListNode[] lists) {
        //min heap
       PriorityQueue<ListNode> qu = new PriorityQueue<>(
        (a,b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node!=null){
                qu.add(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode ans = dummy;
        while(!qu.isEmpty()){
            ListNode cur = qu.poll();
            ans.next = cur;
            ans = ans.next;
        
        if(cur.next!=null){  //
            qu.offer(cur.next);                 
        }
        }
        return dummy.next;

    }
}