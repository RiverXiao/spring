package com.oracle.stcdc.racgroup.leetcode;

public class LinkList {

    /**
     * 86 号问题：分割链表
     * @param head
     * @return
     */
    public static LinkNode splitLinkList(LinkNode head, int x){

        LinkNode smallHead = new LinkNode(-1);
        LinkNode bigHead  = new LinkNode(-1);
        LinkNode small = smallHead;
        LinkNode big = bigHead;


        while(head != null){


            if(head.var < x){
                small.next = head;
                small = small.next;
                head = head.next;
                small.next = null;
            }else {
                big.next = head;
                big = big.next;
                head = head.next;
                big.next = null;
            }
        }

        small.next = bigHead.next;

        return smallHead.next;
    }

    /**
     * LeetCode 206. Reverse Linked List —— 反转链表
     * @param head
     * @return
     */
    public static LinkNode resverList(LinkNode head) {
        
        LinkNode tail = null;

        if(head == null || head.next == null){
            return head;
        }
        
        while(head != null){
            LinkNode current = head;
            head = head.next;
            current.next = tail;
            tail = current;
        }
        
        return tail;
    }

    /**
     * 第 21 号问题：合并两个有序链表
     * @param link1
     * @param link2
     * @return
     */
    public static LinkNode mergeTwoOrderedLists(LinkNode link1, LinkNode link2){
        LinkNode link = new LinkNode(-1);

        LinkNode current = null;

        if(link1 == null) return link2;

        if(link2 == null) return  link1;

        current = link;

        while(link1 != null && link2 != null){
            if(link1.var < link2.var){
                current.next = link1;
                link1 = link1.next;
                current = current.next;
            }else{
                current.next = link2;
                link2 = link2.next;
                current = current.next;
            }
        }

        if(link1 == null && link2 != null){
            current.next = link2;
        }
        if(link2 == null && link1 != null){
            current.next = link1;
        }

        return  link.next;

    }

    /**
     * 24 号问题：两两交换链表中的节点
     * @param head
     * @return
     */
    public static LinkNode swapPairs(LinkNode head){

        LinkNode slow = head;
        LinkNode fast = head;
        LinkNode newHead = null;

        if(head == null || head.next == null){
            return head;
        }

        newHead = head.next;

        while(head != null){
            fast = fast.next;
            head = head.next;
            slow.next = fast.next;
            fast.next = slow;


            if(head != null && head.next != null){
                fast = head.next;
                slow = fast;
            }else{
                break;
            }

        }

        return newHead;
    }

    public static void main(String[] args) {
        LinkNode link = new LinkNode(-1);
        link.addNode(10);
        link.addNode(9);
        link.addNode(4);
        link.addNode(7);
        link.addNode(2);
        link.addNode(8);
        link.addNode(3);

        link.printLink(link.head);

        //LinkNode s = splitLinkList(link.head , 7);
        //link.printLink(s);

        LinkNode tail = resverList(link.head);
        link.printLink(tail);

        LinkNode link1 = new LinkNode(-1);
        LinkNode link2 = new LinkNode(-1);
        link1.addNode(1);
        link1.addNode(5);
        link1.addNode(8);
        link1.addNode(9);
        link1.addNode(9);
        link1.addNode(9);
        link.printLink(link1.head);

        link2.addNode(2);
        link2.addNode(3);
        link2.addNode(4);
        link.printLink(link2.head);

        link.printLink(mergeTwoOrderedLists(link1.head,link2.head));

        link.printLink(link1.head);
        link.printLink(swapPairs(link1.head));

    }
}
