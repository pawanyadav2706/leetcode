class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        // Base case
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        // Compare values
        if (head1.val <= head2.val) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }
    }
}
