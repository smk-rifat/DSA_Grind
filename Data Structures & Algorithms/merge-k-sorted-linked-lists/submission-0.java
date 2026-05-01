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
        List<Integer> nodes = new ArrayList<>();
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        for(ListNode l : lists){
            while(l != null){
                nodes.add(l.val);
                l = l.next;
            }
        }

        Collections.sort(nodes);

        for(int node : nodes){
            temp.next = new ListNode(node);
            temp = temp.next;
        }

        return dummy.next;
    }
}
