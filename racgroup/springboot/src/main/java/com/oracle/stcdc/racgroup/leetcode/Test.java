package com.oracle.stcdc.racgroup.leetcode;

public class Test {

    @Override
    public String toString() {
        return super.toString();
    }

    //评测题目: string to int

    // Integer.parseInt()
    public static int string2int(String in) throws Exception{
        int ret = 0;

        if(in == null) {
            throw new Exception("The input string cannot be null");
        }

        int flag = 0;
        char[] chars = in.toCharArray();

        int length = chars.length;

        if(in.startsWith("-")){
            flag = 1;
        }

        for (int i = length - 1; i >= flag; i--) {
            int j = chars[i];

            if( j > 57 || j < 48) {
                throw new Exception("char must be a number from 0 - 9");
            }else {
                ret += (j - 48) * Math.pow(10, (length - i - 1));
            }

        }

        if(flag == 1) {
            ret = 0 - ret;
        }
        return ret;
    }


    public static void main(String[] args) throws Exception {


        String s = "-9999";

        s = "999";

        s = null;

        s = "asdf";

        s = "-9dff4";

        s = "999999999999999999999999";

        System.out.println(string2int(s));

    }
}
