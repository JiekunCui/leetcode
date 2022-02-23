package com.example.leetcode.node;

public class ListNodeUtil {

    public static ListNode arrToListNode(int[] nums){
        if (nums==null || nums.length==0){
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int j = 0; j < nums.length; j++) {
            cur.next = new ListNode(nums[j]);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void printListNode(ListNode head){
        StringBuilder builder = new StringBuilder();
        ListNode cur = head;
        while (cur !=null){
            builder.append(cur.val).append("->");
            cur=cur.next;
        }

        if (builder.length()==0){
            System.out.println();
            return;
        }

        int i = builder.lastIndexOf("->");
        builder.replace(i,i+2,"");
        System.out.println(builder.toString());

    }

    public static void main(String[] args) {
        ListNode listNode = arrToListNode(new int[] {1, 2, 3, 4, 5});
        printListNode(listNode);
    }
}
