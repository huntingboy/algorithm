package com.nomad.jzoffer;

public class InversePairs {

    private int count = 0;
    public int inversePairs(int [] array) { //数组中的逆序对个数  <==> 归并排序+二路归并交换的次数
        if (array == null || array.length == 0) {
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private void mergeSort(int[] array, int l, int h) {
        if (l == h) { //出口
            return;
        }
        int m = (l + h) / 2;
        mergeSort(array, l, m);
        mergeSort(array, m + 1, h);
        merge(array, l, m, h);//二路归并
    }

    private void merge(int[] array, int l, int m, int h) {
        int[] tmp = new int[h - l + 1];
        int i = 0;
        int li = l, hi = m + 1;
        while (li <= m && hi <= h) {
            if (array[li] > array[hi]) {
                count += m + 1 - li;  //array[li~m]之间的数都大于array[hi]
                count %= 1000000007;  //注意此处要求余，不然只通过50%
                tmp[i++] = array[hi++];
            } else {
                tmp[i++] = array[li++];
            }
        }

        while (li <= m) {
            tmp[i++] = array[li++];
        }
        while (hi <= h) {
            tmp[i++] = array[hi++];
        }

        for (int j = 0; j < i; j++) {
            array[l + j] = tmp[j];
        }
    }
}
