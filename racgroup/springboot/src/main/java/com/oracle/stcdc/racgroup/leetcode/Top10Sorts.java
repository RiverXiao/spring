package com.oracle.stcdc.racgroup.leetcode;

/**
 * 实现10大排序算法
 * @author junhe
 * @date 09/03/2019
 */
public class Top10Sorts {

    /**
     * 冒泡排序
     * @param ints 输入无序数组
     */
    public static void bubbleSort(int[] ints){

        int lenth = ints.length;
        System.out.println("冒泡排序：");
        for (int i = 0; i < lenth; i++) {

            for (int j = i + 1; j < lenth; j++) {

                if(ints[i] > ints[j]){
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }

            }
        for (int t: ints) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * 选择排序
     * @param ints
     */
    public static void selectionSort(int[] ints){

        int len = ints.length;
        int min;

        System.out.println("选择排序：");
        for (int i = 0; i < len; i++) {

            min = i;

            for(int j = i + 1; j < len; j ++){
                if (ints[min] > ints[j]){
                   min = j;
                }
            }

            int temp = ints[i];
            ints[i] = ints[min];
            ints[min] = temp;
        }

        for (int t: ints) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * 插入排序
     * @param ints
     */
    public static void insertSort(int[] ints){

        int len = ints.length;
        System.out.println("插入排序：");
        for (int i = 1; i < len; i++) {

            int j = i;
            int temp = ints[i];
            while(j > 0 && temp < ints[j]){
                ints[j] = ints[j-1];
                j --;
            }
            ints[j] = temp;

        }

        for (int t: ints) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    /**
     * 希尔排序
     * @param ints
     */
    public static void shellSort(int[] ints){


        System.out.println("希尔排序：");

        for (int t: ints) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
    /**
     * 快速排序
     * @param ints
     */
    public static void quickSort(int[] ints){

        int len = ints.length;

        int mid = ints[len/2+1];


//        quickSortParts(ints, left, mid);
//        quickSortParts(ints, mid, right);

        System.out.println("快速排序：");

        for (int t: ints) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private static void quickSortParts(int[] array, int left, int right){

        int mid = array[(right - left)/2 + 1];

        for(int i = left; i < right; i ++){

            if(array[i] > mid){
                int temp = mid;
                array[(right - left)/2 + 1] = array[i];
                array[i] = mid;
            }
        }
    }

    public static void main(String[] args) {

        int[] source = {3,4,6,45,4,7,8,23,5,1,9,34,0,39,100,99};

        bubbleSort(source);

        selectionSort(source);

        insertSort(source);
    }
}
