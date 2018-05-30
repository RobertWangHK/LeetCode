package Facebook;

import Utils.ListNode;

public class LC_206_Reverse_LL {
    /**
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     *
     * Notice the null that is appended to 1 (pre)
     *
     * @param head head
     * @return reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;
        ListNode nextNode;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        return preNode;
    }
}
