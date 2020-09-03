package com.nomad.xz.ks;

public class Main_21 {

    //最长滑雪距离
    //递归 or dp
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[][] h = new int[][]{
                {1, 2, 1},
                {0, 5, 4},
                {5, 5, 5}
        };

        System.out.println(new Main_21().getLongestLength(h));
    }

    int[][] dir = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public int getLongestLength(int[][] h){
        int maxLen = 0;
        for(int i = 0; i < h.length; i++){
            for(int j = 0; j < h[0].length; j++){
                for (int k = 0; k < 4; k++) {
                    int xx = dir[k][0] + i, yy = dir[k][1] + j;
                    maxLen = Math.max(maxLen, getLongestLength0(h, xx, yy, h[i][j], 1)); //xx和yy表示即将要访问的横纵坐标，h[i][j]和0表示当前状态
                }
            }
        }

        return maxLen;
    }

    private int getLongestLength0(int[][] h, int i, int j, int lastVal, int len){
        if(i < 0 || i > h.length - 1 || j < 0 || j > h[0].length - 1 || h[i][j] >= lastVal){
            return len;
        }

        int res = 0;
        for (int k = 0; k < 4; k++) {
            int xx = dir[k][0] + i, yy = dir[k][1] + j;
            res = Math.max(res, getLongestLength0(h, xx, yy, h[i][j], len + 1));
        }

        return res;
    }

    //string==>double


    //链表反转
    //abcdeeeefegg==>abcdefeg
}
