package com.nomad.xz.hw;

import java.util.*;

/**
 * @author nomad
 * @create 2020-09-03 7:58 PM
 */
public class Main {
    public static void main(String[] args) {
        new Main().errorRecord();
    }

    /**
     * HJ19
     * 简单错误记录
     */
    class ErrorRecord implements Comparable<ErrorRecord> {
        String fileName;
        int line;
        int count;

        public ErrorRecord(String fileName, int line, int count) {
            this.fileName = fileName;
            this.line = line;
            this.count = count;
        }

        @Override
        public int compareTo(ErrorRecord o) {
            return count - o.count;
        }

        @Override
        public String toString() {
            return fileName + " " + line + " " + count;
        }
    }
    public void errorRecord(){
        Scanner sc = new Scanner(System.in);
        List<ErrorRecord> res = new ArrayList<>();
        while (sc.hasNext()) {
            String path = sc.next();
            if ("eof".equals(path)) {
                break;
            }
            String fileName = path.substring(path.lastIndexOf('\\') + 1);
            int line = sc.nextInt();
            Map<String, Integer> pathIndexMap = new HashMap<>();
            if (pathIndexMap.containsKey(path + " " + line)) {
                int index = pathIndexMap.get(path + " " + line);
                ErrorRecord er = res.get(index);
                res.set(index, new ErrorRecord(er.fileName, er.line, er.count + 1));
            } else {
                if (fileName.length() > 16) {
                    fileName = fileName.substring(fileName.length() - 16);
                }
                res.add(new ErrorRecord(fileName, line, 1));
                pathIndexMap.put(path + " " + line, res.size() - 1);
            }
        }

        Collections.sort(res, Comparator.reverseOrder());
        //Collections.reverse(res);
        for (int i = 0; i < res.size() && i < 8; i++) {
            System.out.println(res.get(i));
        }
    }

    /**
     * HJ5
     * 进制转换
     */
    public void hex2Dec(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String h = sc.next().substring(2);
            int res = 0;
            for (int i = 0; i < h.length(); i++) {
                res = res << 4;
                char ch = h.charAt(i);
                if (Character.isDigit(ch)) {
                    res += ch - '0';
                } else {
                    res += ch - 'A' + 10;
                }
            }

            System.out.println(res);
        }
    }

    /**
     * HJ4
     * 字符串分隔
     */
    public void split(){
        Scanner sc = new Scanner(System.in);
        String[] s = new String[2];
        s[0] = sc.nextLine();
        s[1] = sc.nextLine();
        for (int i = 0; i < 2; i++) {
            String s1 = s[i];
            while (s1.length() >= 8) {
                System.out.println(s1.substring(0, 8));
                s1 = s1.substring(8);
            }
            System.out.print(s1);
            if (s1.length() > 0) {
                for (int j = 0; j < 8 - s1.length(); j++) {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    /**
     * HJ3
     * 明明的随机数
     */
    public void random(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Queue<Integer> res = new PriorityQueue<>();
            int n = sc.nextInt();
            boolean[] flag = new boolean[1001];
            for (int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                if (!flag[tmp]) {
                    flag[tmp] = true;
                    res.offer(tmp);
                }
            }

            int size = res.size();
            for (int i = 0; i < size; i++) {
                System.out.println(res.poll());
            }
        }
    }

    /**
     * HJ2
     * 计算字符个数
     */
    public void calCharNum(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(), ch = sc.next();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (("" + s.charAt(i)).equalsIgnoreCase(ch)) {
                res++;
            }
        }

        System.out.println(res);
    }

    /**
     * HJ1
     * 字符串最后一个单词的长度
     */
    public void lastWordLen(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        System.out.println(s.substring(s.lastIndexOf(' ') + 1).length());
    }
}
