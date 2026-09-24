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

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Dummy node handles the case where left == 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Find the node before the reversal section
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // First node of the reversal section
        ListNode curr = prev.next;

        // Move each next node to the front of the reversed section
        for (int i = 0; i < right - left; i++) {

            ListNode temp = curr.next;

            // Remove temp from its current position
            curr.next = temp.next;

            // Insert temp immediately after prev
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}