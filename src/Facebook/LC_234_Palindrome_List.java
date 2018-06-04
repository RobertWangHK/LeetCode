package Facebook;

import Utils.ListNode;

public class LC_234_Palindrome_List {
    public boolean isPalindrome(ListNode head) {
        /**
         * 1. reverse the 2nd half of the list
         * 2. compare node by node of the two lists
         */
        ListNode slowHead = head;
        ListNode fastHead = head;

        while ((fastHead != null) && (fastHead.next != null)) {
            slowHead = slowHead.next;
            fastHead = fastHead.next.next;
        }

        // reverse second half list
        ListNode pre = null;
        ListNode curr = slowHead;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        // validate 2 linked list
        ListNode list1 = head;
        ListNode list2 = pre;

        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) return false;
            list1 = list1.next;
            list2 = list2.next;
        }

        return true;
    }

}
