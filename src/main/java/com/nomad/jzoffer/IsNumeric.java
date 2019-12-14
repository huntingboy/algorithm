package com.nomad.jzoffer;

import java.util.regex.Pattern;

public class IsNumeric {
    public boolean isNumeric(char[] str) { //表示数值的字符串
        String ptnInt = "[+-]?[1-9]\\d*";  //整数正则表达式
        String ptnDoub = "[+-]?\\d*\\.\\d+";  //小数正则表达式
        String ptnExpo = "([+-]?[1-9]\\d*[eE][+-]?[1-9]\\d*)|([+-]?\\d*\\.\\d+[eE][+-]?[1-9]\\d*)"; //指数正则表达式  （整数/小数）e/E整数

        return Pattern.compile("(" + ptnInt + ")|" + "(" + ptnDoub + ")|" + "(" + ptnExpo + ")").matcher(String.valueOf(str)).matches();
    }
}
