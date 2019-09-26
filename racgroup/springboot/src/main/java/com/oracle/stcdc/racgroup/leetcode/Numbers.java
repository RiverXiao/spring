package com.oracle.stcdc.racgroup.leetcode;

import java.util.*;

/**
 * 实现leetcode代码
 * https://github.com/MisterBooo/LeetCodeAnimation?utm_source=wechat_session&utm_medium=social&utm_oi=865990952404267008
 *
 */
public class Numbers {

    public static void main(String[] args) {

        int[] ints = {9,9};
        int target = 9;

        int[] rc = addone(ints);

        for (int i = 0; i < rc.length; i++) {
            System.out.print(rc[i] + " ");
        }
        System.out.println();

        ints = new int[]{2, 4, 5, 6, 7, -12, -6};
        rc =  threeSum(ints);
        for(int i : rc){
            System.out.println(i);
        }

        int[] dumps = new int[]{0,0,1,1,1,2,2,3,4,5,5,5,5};



        System.out.println("Remove duplicated: " + removeDuplicateNumbers(dumps));

        int[] onlyone = new int[]{0,0,9,9,0,0,7,8,8,4,4,5,6,5,6};

        System.out.println("Only One: " + onlyone(onlyone));


        countOfOne(16);

        onlyone = moveZero(onlyone);
        for(int i : onlyone){
            System.out.println(i);
        }

        System.out.println(countNextStr("112223411"));

        for (int i = 1; i < 10; i++) {
            System.out.println(countAndSay(i));
        }

        int n = 7;
        System.out.println(factorial1(n));
        System.out.println(factorial2(n));

        int[] array = {1,2,3,4,5,6,7,8,9,10};
        n = 3;
        System.out.println(binarySearch(array,n));

        int[] numbers = {0,3,1,1,2,3,2,4,4,8};
        towNumbers(numbers);

    }

    /**
     * 二分查找
     * @param ints
     * @param n
     * @return
     */
    public static int binarySearch(int[] ints, int n){
        if(ints.length == 0 ) return -1;
        int low = 0;
        int high = ints.length - 1;
        int mid = -1;

        while(low < high){
            mid = (high - low) / 2;
            if(ints[mid] > n){
                high = mid;
            }else if(ints[mid] < n){
                low = mid;
            }else{
                return mid;
            }
        }

        return -1;
    }
    /**
     * 38 号问题：报数
     * @param n
     * @return
     */
    public static String countAndSay(int n){
        if(n == 1) {
            return "1";
        }

        return countNextStr(countAndSay(n-1)) ;

    }

    /**
     * 获取下一个整数报数
     * @param pre
     * @return
     */
    private static String countNextStr(String pre){

        int slow = 0;
        int fast = 0;
        int i = 1;  // 计数器
        String rc = "";

        char[] charArr = pre.toCharArray();

        while(slow < charArr.length && fast < charArr.length){
            fast ++;
            if(fast < charArr.length && charArr[fast] == charArr[slow]){
                i ++;
            }else{
                rc += String.valueOf(i) + String.valueOf(charArr[slow]);
                i = 1;
                slow = fast;
            }
        }

        return rc;
    }

    /**
     * 1，数组两数之和
     * @param ints
     * @param target
     * @return
     */
    public static int[] add(int[] ints, int target){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int[] rc = new int[2];

        for(int i = 0; i < ints.length; i ++){
            map.put(ints[i], i);
        }

        for(int key : map.keySet()){
            if(map.containsKey(target - key)){
                rc[0] = map.get(key);
                rc[1] = map.get(target - key);
            }
        }

        return rc;

    }

    /**
     * 2， 两链表数字之和
     * @param n1
     * @param n2
     * @return
     */
    public int add(LinkNode n1, LinkNode n2){
        int carried = 0; // 进位
        LinkNode head1 = n1;
        LinkNode head2 = n2;

        List<Integer> ints = new ArrayList<Integer>();

        int result = 0;
        while(head1 != null || head2 != null){

            int rc = 0;
            if(head1 == null) rc = head2.var;
            if(head2 == null) rc = head1.var;
            rc = head1.var + head2.var;

            if( rc < 10) {
                ints.add(rc + carried);
                carried = 0;
            }else{
                carried = 1;
                ints.add(rc - 10);
            }

            if( head1.next != null) head1 = head1.next;
            if( head2.next != null) head2 = head2.next;
        }

        for(int i = 0 ; i < ints.size(); i ++){
            result += ints.get(i) * Math.pow(10, i);
        }

        return result;
    }

    /**
     * 15， 三个数之和等于0
     */
    public static int[] threeSum(int[] ints){
        int[] targets = new int[ints.length];

        int[] tempints = Arrays.copyOf(ints, ints.length);

        int[] rc = new int[3];

        for(int i = 0; i < tempints.length ; i ++){
            int[] temprc = add(ints, 0 - tempints[i]);
            if (temprc[0] != 0 && temprc[1] != 0){
                rc[0] = temprc[0];
                rc[1] = temprc[1];
                rc[2] = i;
            }
        }

        return rc;

    }

    /**
     * 26，删除数组中重复的数字， 快慢指针，如果两数相同，快指针走，如果不同，快慢指针都走，同时替换慢指针的值
     * @param ints
     * @return
     */
    public static int removeDuplicateNumbers(int[] ints){

        int len = ints.length;
        if(len == 0) return 0;

        int slow = 0, fast = 0;

        for(;fast < len;){

            if(ints[slow] == ints[fast]){
                fast ++;
            }else {
                slow ++;
                ints[slow] = ints[fast];
                fast ++;
            }
        }
        for (int i = 0; i <= slow; i++) {
            System.out.println(ints[i]);
        }
        return slow + 1;
    }

    /**
     *  136 : 只出现一次的数字
     * @param ints
     * @return
     */
    public static int onlyone(int[] ints){

        int rc = ints[0];
        for(int i = 1; i < ints.length ; i ++){
            rc = rc ^ ints[i];
        }

        return rc;
    }

    /**
     * 只出现两次的数字，如{1，1，2，2，3，4}， 则输出3，4
     * @param ints
     */
    public static void towNumbers(int[] ints){

        int len = ints.length;

        int ret = 0 ; // 记录异或值

        int pos = 0 ; //记录ret中第一个1的位置

        int x = 0;  //一个不一样的数字

        int y = 0; // 另外一个不一样的数字

        for (int i = 0; i < len ; i++) {
            ret ^= ints[i];
        }

        for (int i = 0; i < 32; i++) {
            if( 1 == (( ret >> i ) & 1 )){
                pos = i;
                break;
            }
        }

        for (int i = 0; i < len ; i++) {
            if( 1 == (( ints[i] >> pos ) & 1 )){
                x ^= ints[i];
            }else{
                y ^= ints[i];
            }
        }
        System.out.println("第一个不一样的数字" +  x);
        System.out.println("第二个不一样的数字" +  y);
    }
    /**
     * 191 号问题：位 1 的个数
     * @param n
     * @return
     */
    public static  int countOfOne( int n){

        int rc = 0;

        while ( n > 0 ){
            if ( n % 2 > 0) rc += 1;
            n = n >> 1;
        }
        System.out.println("Count one: " + rc) ;
        return rc;
    }

    /**
     * 283 号问题：移动零
     * @param ints
     * @return
     */
    public static int[] moveZero(int[] ints){

        int k = 0;

        for(int i = 0; i < ints.length; i ++){
            if(ints[i] != 0){
                ints[k ++ ] = ints[i];
            }
        }

        for(; k < ints.length; k ++){
            ints[k] = 0;
        }
        return ints;

    }

    /**
     * 66 号问题：加一
     * @param ints
     * @return
     */
    public static int[] addone(int[] ints){
        int flag = 0;

        int len = ints.length;

        if(ints[len-1] < 9){
            ints[len - 1] += 1 + flag;
            return ints;
        }

        for (int i = len - 1; i >= 0 ; i--) {
            if( ints[i] == 9){
                ints[i] = 0;
                flag = 1;
            }else{
                ints[i] += flag;
                flag = 0;
                return ints;
            }
        }

        if(flag == 1){
            int[] rc = new int[len + 1];
            rc[0] = 1;
            System.arraycopy(ints, 0, rc, 1, len);
            return rc;
        }

        return  null;
    }

    /**
     * 计算N的阶乘 - 迭代
     * @param n
     * @return
     */
    public static long factorial1(int n){

        if ( n <=0 ) return 0;

        long rc = 1;
        for (int i = 1; i <= n ; i++) {
            rc *= i;
        }
        return rc;
    }

    /**
     * 计算N的阶乘 - 递归
     * @param n
     * @return
     */
    public static long factorial2(int n){

        if(n <= 0) return 0;

        if(n == 1) return 1;

        return n * factorial2(n-1);

    }
}
