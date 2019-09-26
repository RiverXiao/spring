package com.oracle.stcdc.racgroup.leetcode;

/**
 * 118号问题：杨辉三角.md
 * @author junhexiao
 * @date 09/06/2019
 */
public class YangHuiTriangle {


    public static int[] describeTriangle(int n){
        if( n < 1) return new int[0];
        if(n == 1) return new int[]{1};

        return getNlines(describeTriangle(n-1));

    }

    /**
     * 根据第N-1行get第N行数据
     * @param ints
     * @return
     */
    public static int[] getNlines(int[] ints){

        int olen = ints.length;


        int[] rc = new int[olen + 1];

        rc[0] = 1;
        rc[olen] = 1;

        for (int i = 1; i < olen; i++) {
            rc[i] = ints[i-1] + ints[i];
        }

        for (int i : rc) {
            System.out.print(i + " ");
        }
        System.out.println();
        return  rc;
    }

    /**
     * 119 号问题：杨辉三角II, 程序只能使用 O(k) 的额外空间
     * 这里依旧使用杨辉三角的规律，很隐藏的规律：对于杨辉三角的同一行，第 ( i + 1) 项是第 i 项的 ( k - i ) /( i + 1 ) 倍。
     * @param k
     * @return
     */
    public static int[] getNlines(int k){

        int[] rc = new int[k];
        rc[0] = rc[k-1] = 1;
        int mid = k % 2 == 0 ? k/2 : (k/2 + 1);

        for (int i = 1; i < mid; i++) {
            rc[i] = rc[k - 1 - i] = (rc[i-1] * (k - i) / i);
        }

        System.out.println("第" + k + "行的值");
        for (int j : rc) {
            System.out.print(j + " ");
        }
        return  rc;
    }


    public static void main(String[] args) {
        System.out.println("杨辉三角");

        int[] rc = describeTriangle(10);

        getNlines(10);
    }
}
