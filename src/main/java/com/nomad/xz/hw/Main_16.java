package com.nomad.xz.hw;

import java.util.*;

/**
 * @author nomad
 * @create 2020-09-02 7:35 PM
 */
public class Main_16 {
    public static void main(String[] args) {
        new Main_16().errorRecord();
    }

    class ErrorRecord implements Comparable<ErrorRecord>{
        String fileName;
        String line;
        int counts;

        public ErrorRecord(String fileName, String line, int counts) {
            this.fileName = fileName;
            this.line = line;
            this.counts = counts;
        }

        @Override
        public int compareTo(ErrorRecord o) {
            return counts - o.counts;
        }

        @Override
        public String toString() {
            return fileName + " " + line + " " + counts;
        }
    }
    public void errorRecord(){
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> res = new LinkedHashMap<>(30, 1, true);
        Queue<ErrorRecord> ret = new PriorityQueue<>(Comparator.reverseOrder());
        while (!sc.hasNext("eof")) {
            String path = sc.next();
            int line = sc.nextInt();
            String fileName = path.substring(path.lastIndexOf('\\') + 1);
            res.put(fileName + " " + line, res.getOrDefault(fileName + " " + line, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            String[] key = entry.getKey().split(" ");
            if (key[0].length() > 16) {
                key[0] = key[0].substring(key[0].length() - 16);
            }
            ret.add(new ErrorRecord(key[0], key[1], entry.getValue()));
        }

        int nums = 0;
        int size = ret.size();
        for (int i = 0; i < size; i++) {
            System.out.println(ret.poll());
            nums++;
            if (nums == 8) {
                break;
            }
        }

        /*for (ErrorRecord errorRecord : ret) {
            System.out.println(errorRecord);
            nums++;
            if (nums == 8) {
                break;
            }
        }*/
    }

    public void maxScore(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            char c = sc.next().charAt(0);
            if (c == 'Q') {
                System.out.println(max(scores, sc.nextInt(), sc.nextInt()));
            } else { //U
                scores[sc.nextInt()] = sc.nextInt();
            }
        }
    }

    private int max(int[] scores, int l, int r) {
        int res = scores[l++];
        while (l <= r) {
            res = Math.max(res, scores[l++]);
        }

        return res;
    }
}
