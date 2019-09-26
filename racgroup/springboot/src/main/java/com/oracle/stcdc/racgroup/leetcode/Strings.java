package com.oracle.stcdc.racgroup.leetcode;

import java.util.*;

/**
 * 实现leetcode代码
 * https://github.com/MisterBooo/LeetCodeAnimation?utm_source=wechat_session&utm_medium=social&utm_oi=865990952404267008
 *
 */
public class Strings {


    /**
     * 第 3 号问题：无重复字符的最长子串
     * @param s - source string
     * @return
     */
    public static String lengthOfLongestSubstring(String s){

        char[] chars = s.toCharArray();

        int slow = 0;
        int fast = 0;
        int len = chars.length;
        int max = 0;
        String maxstr = "";
        String maxtemp = "";

        while(fast < len ) {

            String sf = String.valueOf(chars[fast]);
            int index = maxtemp.indexOf(sf);
            if(index >= 0){
                if(max < maxtemp.length()){
                    max = maxtemp.length();
                    maxstr = maxtemp;
                }
                slow = fast = slow + index + 1;
                maxtemp = "";
            }else{
                fast ++;
                maxtemp = maxtemp.concat(sf);
            }

        }

        if(max < maxtemp.length()){
            max = maxtemp.length();
            maxstr = maxtemp;
        }
        System.out.println("最长子串长度" + max);

        return maxstr;

    }

    /**
     * 125 号问题：验证回文串
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str){
        char[] strary = str.toCharArray();

        int l = 0;
        int r = str.length() - 1;

        while (l <= r){

            if(!Character.isLetterOrDigit(strary[l])){
                l ++;
            }

            else  if(!Character.isLetterOrDigit(strary[r])){
                r --;
            }

            else {
                if(Character.toUpperCase(strary[l]) != Character.toUpperCase(strary[r])){
                    return false;
                }
                l ++;
                r --;
            }

        }

        return  true;
    }

    /**
     * 131 号问题：分割回文串
     * @param str
     */
    public static Set<String> splitStrings(String str){

        Set<String> list = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {

            for(int j = i+1 ; j < str.length() + 1; j ++){
                list.add(str.substring(i,j));
            }
        }

        for (String s: list) {
            if(isPalindrome(s)){
                System.out.println(s);
            }
        }

        return  list;

    }

    /**
     * 第 187 号问题：重复的 DNA 序列
     * 字符串查找
     * @param sourceDNA
     * @return
     */
    public static List<String> findRepeatedDnaSequences1(String sourceDNA){

        List<String> strlist = new ArrayList<>();
        for(int index = 0; index < sourceDNA.length() - 10; index ++){
            String pattern = sourceDNA.substring(index, index + 10);
            int in = sourceDNA.indexOf(pattern, index + 10);
            if(in >= 0){
                strlist.add(pattern);
            }

        }

        return strlist;
    }

    /**
     * 第 187 号问题：重复的 DNA 序列
     * Hash表
     * @param sourceDNA
     * @return
     */
    public static List<String> findRepeatedDnaSequences2(String sourceDNA){

        List<String> strlist = new ArrayList<>();
        Map<String,Integer> tempmap = new HashMap<>();

        for (int i = 0; i < sourceDNA.length() - 10; i++) {
            String pattern = sourceDNA.substring(i, i + 10);
            if(tempmap.containsKey(pattern)){
                if(tempmap.get(pattern) < 2) strlist.add(pattern);
                tempmap.put(pattern,2);
            }else{
                tempmap.put(pattern, 1);
            }

        }

        return strlist;
    }

    public static void main(String[] args) {

        String s = "abcabde";

        System.out.println("最长不重复子串");
        System.out.println(lengthOfLongestSubstring(s));


        String str = "abcdddcba";
        System.out.println("是否回文字符串");
        System.out.println(isPalindrome(str));

        splitStrings("abcdddcba");

        System.out.println("adbc".substring(0,4));

        List<String> strlist = new ArrayList<>();
        String dna = "ACTTGGTTACAATTCCGACTTGGTTACACTG";
        strlist = findRepeatedDnaSequences1(dna);

        System.out.println("重复的 DNA 序列 1");
        for(String st : strlist){
            System.out.println(st);
        }

        strlist = findRepeatedDnaSequences2(dna);
        System.out.println("重复的 DNA 序列 2 ");
        for(String st : strlist){
            System.out.println(st);
        }


        System.out.println("是否为奇数");
        System.out.println( (1993 & 1) == 1 );
    }
}
