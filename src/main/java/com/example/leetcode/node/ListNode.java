package com.example.leetcode.node;

public class ListNode {
    public int val;
    public int key;
    public ListNode next;
    public ListNode pre;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int key,int val) { this.val = val;this.key=key; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode(int val, ListNode pre,ListNode next) { this.val = val; this.next = next; this.pre = pre;}

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
