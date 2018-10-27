package Facebook;

public class LC_23_Merge_K_List {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge
        if (lists == null || lists.length == 0) return null;
        // Init
        return mergeListHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeListHelper(ListNode[] list, int i, int j) {
        // Edge
        if (i == j) return list[i];
        if (i == j - 1) return mergeTwoList(list[i], list[j]);
        // Others
        int mid = i + (j - i) / 2;
        ListNode left = mergeListHelper(list, i, mid);
        ListNode right = mergeListHelper(list, mid + 1, j);
        return mergeTwoList(left, right);
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    head.next = list1;
                    list1 = list1.next;
                }
                else {
                    head.next = list2;
                    list2 = list2.next;
                }
                head = head.next;
            }
            if (list1 == null) {
                head.next = list2;
                break;
            }
            if (list2 == null) {
                head.next = list2;
                break;
            }
        }
        return dummy.next;
    }
}
