package com.oracle.stcdc.racgroup.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 第169号问题：求众数.md
 */
public class MajorityNumber {

    /**
     * 哈希表法
     * 直接遍历整个 数组 ，将每一个数字（num）与它出现的次数（count）存放在 哈希表 中，同时判断该数字出现次数是否是最大的，动态更新 maxCount，最后输出 maxNum。
     * 借用map空间
     * @param ints
     * @return
     */
    public int marjorityNumHash(int[] ints){

        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = -1;
        int maxCount = 0;

        for (int i = 0; i < ints.length; i++) {

            int count = map.getOrDefault(ints[i], 0) + 1;
            map.put(ints[i], count);

            if(count > maxCount){
                maxCount = count;
                maxNum = ints[i];
            }
        }

        return maxNum;

    }

    /**
     * 摩尔投票法
     * 数组中其他数字出现次数的总和都是比不上这个数字出现的次数 。
     * 即如果把 该众数记为 +1 ，把其他数记为 −1 ，将它们全部加起来，和是大于 0 的。
     * @param ints
     * @return
     */
    private int marjorityNumMor(int[] ints){

        if(ints == null || ints.length == 0)  return -1;
        int maxNum = ints[0];
        int count = 1;

        for (int i = 1; i < ints.length; i++) {
            if(count == 0){
                maxNum = ints[i];
                count = 1;
            }
            else if(ints[i] == maxNum){
                count ++;
            }else {
                count --;
            }
        }

        return maxNum;

    }

    /**
     * 第 172 号问题：阶乘后的零
     * 问题变成了 统计阶乘数里有多少个 5 这个因子。
     * @param n
     * @return
     */
    public static int trailingZeroes1(int n){

        int rc = n / 5;

        while( n >= 5){
            n = n / 5;
            rc ++;
        }

        return --rc ;
    }

    /**
     * 第 172 号问题：阶乘后的零
     * 递归实现
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes2(n / 5);
    }

    public static void main(String[] args) {

        int[] ints = new int[]{2,2,1,6,6,1,1,2,2,3,3,4,5,6,6,6,6};
        MajorityNumber num = new MajorityNumber();

        System.out.println("哈希表法");
        System.out.println(num.marjorityNumHash(ints));

        System.out.println("摩尔投票法");
        System.out.println(num.marjorityNumMor(ints));

        int n = 80;
        System.out.println("阶乘后的零, 非递归");
        System.out.println(trailingZeroes1(n));
        System.out.println("阶乘后的零, 递归");
        System.out.println(trailingZeroes1(n));
    }
}
