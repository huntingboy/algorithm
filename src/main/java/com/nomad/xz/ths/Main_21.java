package com.nomad.xz.ths;

public class Main_21 {
    //30道题
    //基础题（开放题，问答题）+选择题+编程题
    //LRU通过继承LinkedHashMap，重写removeEldestEntry方法
    //String的下一个排列
    //递归(问题细分为子问题+一个递归出口)
    //从集合中依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理，从而得到所有元素的全排列。以对字符串abc进行全排列为例，我们可以这么做：以abc为例
    //固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
    //固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
    //固定c，求后面ba的排列：cba，cab。
    public static void main(String[] args) {
        char[] perm = "abcd".toCharArray();
        new Main_21().CalcAllPermutation(perm, 0, perm.length - 1);
    }

    void CalcAllPermutation(char[] perm, int from, int to) {
        if (to <= 1) {
            return;
        }

        if (from == to) {
            for (int i = 0; i <= to; i++)
                System.out.print(perm[i]);
            System.out.println();
        } else {
            for (int j = from; j <= to; j++) {
                swap(perm, j, from);
                CalcAllPermutation(perm, from + 1, to);
                swap(perm, j, from);
            }
        }
    }

    private void swap(char[] perm, int j, int from) {
        char t = perm[j];
        perm[j] = perm[from];
        perm[from] = t;
    }
}
