class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Step 1: Create dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Step 2: Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Step 3: Move both until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Step 4: Delete the nth node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}