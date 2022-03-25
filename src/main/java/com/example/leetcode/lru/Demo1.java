package com.example.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

import com.example.leetcode.node.ListNode;

public class Demo1 {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(1);

        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        cache.put(5,5);

        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(5));

    }
}

class LRUCache {

    private int capacity;
    private ListNode head;
    private ListNode tail;
    private int size;
    private Map<Integer,ListNode> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>((int)(capacity / 0.75));
    }

    public int get(int key) {
        if (map.containsKey(key)){
            ListNode listNode = map.get(key);
            moveNodeToHead(listNode);
            return listNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            ListNode listNode = map.get(key);
            listNode.val=value;
            moveNodeToHead(listNode);
        }else {
            ListNode listNode = new ListNode(key, value);
            map.put(key,listNode);

            if(head==null){
                head=listNode;
                tail=listNode;
            }else {
                head.pre=listNode;
                listNode.next=head;
                head = listNode;
            }

            //元素已满，淘汰队尾元素
            if (size == capacity){
                map.remove(tail.key);
                tail = tail.pre;
                tail.next=null;
                size --;
            }

            size ++;
        }

    }

    /**
     * 将节点移动指链表头部
     * @param listNode
     */
    private void addNodeToHead(ListNode listNode) {

        if (head == null){
            head = listNode;
            tail = listNode;
            return;
        }



    }

    /**
     * 将节点移动指链表头部
     * @param listNode
     */
    private void moveNodeToHead(ListNode listNode) {

        if (head == null){
            head = listNode;
            tail = listNode;
            return;
        }

        if (listNode == head){
            return;
        }

        listNode.pre.next= listNode.next;

        if (tail != listNode){
            listNode.next.pre= listNode.pre;
        }else {
            tail=tail.pre;
        }
        head.pre= listNode;
        listNode.next=head;
        listNode.pre=null;
        head = listNode;
    }
}
