package com.nomad.jzoffer;

public class LeftRotateString {
    public String leftRotateString(String str,int n) { //左旋转字符串  队列  数组
        if (str == null || str.length() == 0) {  //合法性验证
            return "";
        }
        char[] chs = new char[str.length()];
        int index = 0;
        for (int i = n % str.length(); i < str.length(); i++) {  //注意对长度取余
            chs[index++] = str.charAt(i);
        }
        for (int i = 0; i < n % str.length(); i++) { //注意对长度取余
            chs[index++] = str.charAt(i);
        }

        return String.copyValueOf(chs);
    }
}
