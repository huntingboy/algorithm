package com.nomad.jzoffer;

import java.util.HashMap;

public class FirstAppearingOnce {  //字符流中第一个不重复的字符  输入不是固定的数组，而是在动态变化

    StringBuffer buffer = new StringBuffer("");

    //Insert one char from stringstream
    public void insert(char ch)
    {
        buffer.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce()
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < buffer.length(); i++) {
            if (map.containsKey(buffer.charAt(i))) {
                map.put(buffer.charAt(i), map.get(buffer.charAt(i)) + 1);
            } else {
                map.put(buffer.charAt(i), 1);
            }
        }

        for (int i = 0; i < buffer.length(); i++) {
            if (map.get(buffer.charAt(i)) == 1) {
                return buffer.charAt(i);
            }
        }
        return '#';
    }
}
