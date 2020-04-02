package com.nomad.xz.tencent.twozero;

import java.util.Scanner;

public class Unzip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            if (str != null && str.length() > 0) {
                System.out.println(unzip(str, 0, str.length()));
            } else {
                System.out.println("");
            }
        }
    }

    public static String unzip(String input, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        while (begin < end) { // [ 前面部分
            if (input.charAt(begin) == '[') {
                break;
            }
            sb.append(input.charAt(begin));
            begin++;
        }
        //普通的串ab
        if (begin == end) {
            return sb.toString();
        }

        //ab[3|bc]de
        int num = 0, end1 = input.lastIndexOf(']', end - 1);
        char ch;
        while ((ch = input.charAt(++begin)) != '|') { //得到数字
            num = num * 10 + ch - '0';
        }
        String middle = unzip(input, begin + 1, end1); //递归取中间部分
        while (num-- > 0) { //num次Middle中间部分
            sb.append(middle);
        }
        sb.append(input.substring(end1 + 1, end)); // ] 后面部分
        return sb.toString();
    }
}
