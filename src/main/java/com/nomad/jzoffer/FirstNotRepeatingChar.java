package com.nomad.jzoffer;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) { //第一个只出现一次的字符
        int[] words = new int[58];
        for(int i = 0;i<str.length();i++){
            words[((int)str.charAt(i))-65] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }
}
