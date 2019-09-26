package com.oracle.stcdc.racgroup.leetcode;

/**
 * 堆排序
 * 堆的特质： 一棵完全二叉树，且所有父节点的值大于左右节点
 * 完全二叉树： 从上到下，从左到右完全排列，中间没有空余节点, 因此可以用一元数组来表示
 *          5
 *     4         8
 * 1      3   7      9
 * 根据特质可以知道：
 *  left = 2*root + 1
 *  right = 2 * root + 2
 *  root = ( child - 1 ) / 2
 */
public class HeapSort {


    /**
     * 交换数组里面的值
     * @param ints
     * @param i
     * @param j
     */
    public static void swap(int[] ints, int i, int j){
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    /**
     * 堆化某个节点及其子节点
     * @param ints
     * @param current  当前位置
     * @param len 堆的长度
     * @return
     */
    public static int[] heapify(int[] ints, int current, int len){

        if(len <= 0) return null;
        int max = current;
        int left = 2 * current + 1;
        int right = 2 * current + 2;
        int lastparent = (len - 2) / 2;

        if(left < len && ints[left] > ints[max]){
            max = left;
        }

        if(right < len && ints[right] > ints[max]){
            max = right;
        }
        if(max != current){
            swap(ints, max, current);
            heapify(ints, max, len);
        }

        return ints;

    }

    /**
     * 创建一个堆
     * @param ints 输入数组
     * @return
     */
    public static void build_heap(int[] ints, int len){

        int lastParent = (len - 2) / 2;

        for(int i = lastParent; i >= 0; i --){
            heapify(ints, i, len);
        }

    }

    /**
     * 堆排序
     * @param ints
     */
    public static void head_sort(int[] ints){

        //首先创建堆
        build_heap(ints, ints.length);

        int len = ints.length;

        for (int i = len - 1; i >= 0; i--) {
            swap(ints, i , 0);
            build_heap(ints, i);
        }

    }
    public static void main(String[] args) {

        int[] ints = {8,4,7,12,5,15,11,9};

        build_heap(ints,ints.length);
        System.out.println("建堆");
        for (int element: ints) {
            System.out.println(element);
        }
        System.out.println("排序");
        head_sort(ints);
        for (int element: ints) {
            System.out.println(element);
        }
    }
}
