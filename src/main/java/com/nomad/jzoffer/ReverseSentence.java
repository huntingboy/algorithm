package com.nomad.jzoffer;

public class ReverseSentence {
    public String reverseSentence(String str) {   //翻转单词顺序列
        if (str.trim().equals("")) { //注意空格串的处理  equals和==
            return str;
        }
        String[] words = str.split(" ");
        StringBuffer result = new StringBuffer("");  //使用StringBuffer  内容可变对象
        for (int i = words.length - 1; i >= 0 ; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
