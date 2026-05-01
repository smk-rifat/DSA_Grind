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

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return solve(head, k);
    }

    public ListNode solve(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;

        // Check if there are at least k nodes left
        while (cur != null && count != k) {
            count++;
            cur = cur.next;
        }

        if (count != k) {
            // If less than k nodes are left, return the head as is
            return head;
        }

        // Reverse the first k nodes
        ListNode reversedHead = reverse(head, k);

        // Recursively reverse the remaining list and connect
        head.next = solve(cur, k);

        return reversedHead;
    }

    public ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while (k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }

        return prev; // The new head of the reversed group
    }
}


