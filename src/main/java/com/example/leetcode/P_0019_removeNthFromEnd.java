package com.example.leetcode;

import com.example.leetcode.node.ListNode;
import com.example.leetcode.node.ListNodeUtil;

public class P_0019_removeNthFromEnd {

    public static void main(String[] args) {
        P_0019_removeNthFromEnd removeNthFromEnd = new P_0019_removeNthFromEnd();
        ListNodeUtil.printListNode(
                removeNthFromEnd.removeNthFromEnd(
                        ListNodeUtil.arrToListNode(new int[] {1, 2, 3, 4, 5, 6, 7}),1)
        );
        ListNodeUtil.printListNode(
                removeNthFromEnd.removeNthFromEnd(ListNodeUtil.arrToListNode(new int[] {1,2,3}),2)
        );
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(),low = dummy,fast=head;
        dummy.next=head;
        while(n>1){
            fast=fast.next;
            n--;
        }
        while (fast.next!=null){
            fast=fast.next;
            low=low.next;
        }
        if (low.next!=null){
            low.next = low.next.next;
        }
        return dummy.next;
    }
}
