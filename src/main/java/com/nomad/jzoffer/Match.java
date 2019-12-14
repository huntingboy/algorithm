package com.nomad.jzoffer;

import java.util.regex.Pattern;

public class Match {
    public boolean match(char[] str, char[] pattern) // 正则表达式匹配
    {
        return Pattern.compile(String.valueOf(pattern)).matcher(String.valueOf(str)).matches();
    }
}
