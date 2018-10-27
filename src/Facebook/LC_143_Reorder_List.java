package Facebook;

import Utils.ListNode;

public class LC_143_Reorder_List {

    public void reorderList(ListNode head) {
        // Edge
        if (head == null || head.next == null) return;
        // Init, slow fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half of the list
        ListNode prev = slow;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = null;
        // head, prev are the starting points of the two linked list
        curr = head;
        while (curr != slow) {
            System.out.println(curr.val);
            ListNode currNext = curr.next;
            ListNode prevNext = prev.next;
            curr.next = prev;
            prev.next = currNext;
            prev = prevNext;
            curr = currNext;
        }

        return;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LC_143_Reorder_List lc = new LC_143_Reorder_List();
        lc.reorderList(node1);
    }

}
