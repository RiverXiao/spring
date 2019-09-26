package com.oracle.stcdc.racgroup.leetcode;

/**
 * ListNode {@Numbers}
 * 存储int的链表
 */
public class LinkNode {

    int var;

    LinkNode next;

    LinkNode head;

    public LinkNode(int var){
        this.var = var;
    }

    /**
     * add node
     * @param n
     * @return
     */
    public boolean addNode(int n){

        if(head == null){
            head = new LinkNode(n);
            return true;
        }

        LinkNode tmpHead = head;
        while(tmpHead != null){
            if(tmpHead.next != null)
                tmpHead = tmpHead.next;
            else{
                tmpHead.next= new LinkNode(n);
                return true;
            }
        }
        return false;
    }

    /**
     * print the whole link list
     */
    public void printLink(LinkNode tmpHead){
        System.out.println("打印整个link list:");
        while(tmpHead != null){
            System.out.print(tmpHead.var + " ");
            tmpHead = tmpHead.next;
        }
        System.out.println("打印完成");
    }
}
