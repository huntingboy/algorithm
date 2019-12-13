package com.nomad.jzoffer;

import java.util.regex.Pattern;

public class StrToInt {
    public int strToInt(String str) { //把字符串转换成整数
        long result = 0; //使用long存储，为了后续的越界处理
        if (isOnlyContainNumber(str)) {
            int i = ((str.charAt(0) == '+') || (str.charAt(0) == '-')) ? 1 : 0;
            for (; i < str.length(); i++) {
                //result = result * 10 + str.charAt(i) - '0';
                result = (result << 1) + (result << 3) + (str.charAt(i) & 0xf); //通过移位运算和&元素提高效率
            }
            result = (str.charAt(0) == '-') ? -result : result;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {  //越界处理
                return 0;
            }
        }
        return (int) result;
    }

    private boolean isOnlyContainNumber(String str) {  //通过正则表达式判断str是否只包含正负号和数字
        if (str == null || str.trim().equals("")) {
            return false;
        }
        String regex = "^[+-]?[1-9]\\d*$";  //关键正则表达式
        return Pattern.compile(regex).matcher(str).matches();
    }
}
