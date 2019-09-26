package com.oracle.stcdc.racgroup.leetcode;

/**
 * 第 167 号问题：两数之和 II - 输入有序数组
 */
public class TwoSum {


    /**
     * 设置左右指针，如果前后指针相加大于targe, 则后指针往前移，如果小于targe，则前指针向后移动
     * 如果相等，则返回前后指针
     * @param ints
     * @param target
     * @return
     */
    public static int[] twoSum(int[] ints, int target){

        int start = 0;
        int end = ints.length - 1;
        boolean flag = false;

        while(start < end){

            int temp = ints[start] + ints[end];

            if(temp > target){
                end --;
            }else if(temp < target){
                start ++;
            }else{
                flag = true;
                break;
            }
        }

        if(flag) return new int[]{start + 1, end + 1};

        return new int[]{};

    }

    public static void main(String[] args) {

        int[] source = new int[]{2,4,5,6,7,8,9,10,12,23};

        int target = 20;

        int[] rc = twoSum(source, target);

        for (int i:rc) {
            System.out.println(i);
        }
    }
}
