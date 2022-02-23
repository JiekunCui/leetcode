package com.example.leetcode;

import com.example.leetcode.node.ListNode;
import com.example.leetcode.node.ListNodeUtil;

public class P_0876_middleNode {

    public static void main(String[] args) {
        P_0876_middleNode middleNode = new P_0876_middleNode();
        System.out.println(
                middleNode.middleNode(ListNodeUtil.arrToListNode(new int[] {1, 2, 3, 4, 5, 6, 7}))
        );
        System.out.println(
                middleNode.middleNode(ListNodeUtil.arrToListNode(new int[] {1}))
        );
        System.out.println(
                middleNode.middleNode(ListNodeUtil.arrToListNode(new int[] {1, 2}))
        );
        System.out.println(
                middleNode.middleNode(ListNodeUtil.arrToListNode(new int[] {1, 2,3}))
        );
        System.out.println(
                middleNode.middleNode(ListNodeUtil.arrToListNode(new int[] {1, 2,3,4}))
        );
        System.out.println(
                middleNode.middleNode(ListNodeUtil.arrToListNode(new int[] {1, 2,3,4,5}))
        );
        System.out.println(
                middleNode.middleNode(ListNodeUtil.arrToListNode(new int[] {1, 2,3,4,5,6}))
        );
    }
    public ListNode middleNode(ListNode head) {
        ListNode curLow = head;
        ListNode curfast = head;
        while (curfast!=null && curfast.next!=null){
            curfast = curfast.next.next;
            curLow = curLow.next;
        }
        return curLow;
    }

    public ListNode middleNode2(ListNode head) {
        if (head.next==null){
            return head;
        }
        ListNode curLow = head;
        ListNode curfast = head;
        while (curfast.next!=null && curfast.next.next!=null){
            curfast = curfast.next.next;
            curLow = curLow.next;
        }

        if (curfast.next==null){
            return curLow;
        }
        return curLow.next;
    }
}
