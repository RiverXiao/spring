package com.oracle.stcdc.racgroup.leetcode;

/**
 * 75 号问题：颜色分类
 */
public class ColorCategory {

    /**
     * 重组数组
     * @param ints
     * @return
     */
    public static int[] sortColors(int[] ints){
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < ints.length ; i++) {
            if(ints[i] == 0) count0 ++;
            if(ints[i] == 1) count1 ++;
            if(ints[i] == 2) count2 ++;
        }

        int[] rc = new int[ints.length];
        for(int i = 0; i < ints.length ; i ++){
            if(i < count0 ) rc[i] = 0;
            else if ( i < count0 + count1 ){
                rc[i] = 1;
            }else
                rc[i] = 2;
        }

        return rc;
    }


    public static void swap(int[] ints, int i , int j ){

        if(ints[i] != ints[j]) {
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
        }
    }
    /**
     * 遍历交换
     * 如果遍历到1，i ++
     * 如果遍历到2， two -- , 交换i , two, 注意 i 的位置保持不变
     * 如果遍历到0， zero ++ , 交换i, zero, i ++
     * @param ints
     * @return
     */
    public static int[] sortColorsSwap(int[] ints){

        int zero = -1;
        int two = ints.length;
        for (int i = 0; i < two;) {

            if(ints[i] == 1){
                i ++;
            }else if(ints[i] == 2){
                two --;
                swap(ints, i, two);
            }else{
                zero ++;
                swap(ints, zero, i);
                i ++;
            }
        }

        return  ints;
    }


    public static void printints(int[] ints){

        System.out.println("Begin output");
        for (int i: ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] ints = {0,1,2,0,1,2,2,2,1,2,0,0,1,1};
        printints(ints);

        int[] rc = sortColors(ints);
        printints(rc);

        printints(sortColorsSwap(ints));
    }
}
