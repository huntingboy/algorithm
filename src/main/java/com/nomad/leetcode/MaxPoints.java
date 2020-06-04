package com.nomad.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPoints {
    public int maxPoints(Point[] points) { //max-points-on-a-line
        if (points.length < 2) {
            return points.length;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> num = new HashMap<>();
            int dup = 1, vtl = 0; //相同点的个数和垂直点的个数
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) { //相同的点
                    dup++;
                } else if (points[i].x == points[j].x) {  //垂直的点
                    vtl++;
                } else { //斜率作为key
                    double k = (double) (points[i].x - points[j].x) / (points[i].y - points[j].y);
                    if (num.get(k) == null) {
                        num.put(k, 1);
                    } else {
                        num.put(k, num.get(k) + 1);
                    }
                }
            }
            //得到此次的最大值
            int tmpMax = vtl;
            for (Double k : num.keySet()) {
                tmpMax = Math.max(tmpMax, num.get(k));
            }
            res = Math.max(tmpMax + dup, res);
        }

        return res;
    }
}
