package com.example.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.leetcode.node.ListNode;
import com.example.leetcode.node.ListNodeUtil;

public class Demo7 {

    public static void main(String[] args) throws ParseException {
        ListNode listNode = ListNodeUtil.arrToListNode(new int[] {1, 2, 3, 4, 5, 6});
        ListNodeUtil.printListNode(listNode);
        ListNodeUtil.printListNode(new Demo7().reverseList( listNode ));
    }

    public ListNode reverseList(ListNode listNode){
        ListNode dummy = new ListNode();
        while (listNode!=null){
            ListNode dnext = dummy.next;
            ListNode lnext = listNode.next;

            listNode.next = dnext;
            dummy.next = listNode;

            listNode = lnext;
        };
        return dummy.next;
    }
}
