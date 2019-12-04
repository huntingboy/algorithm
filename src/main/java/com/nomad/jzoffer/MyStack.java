package com.nomad.jzoffer;

import java.util.Arrays;
import java.util.Stack;

public class MyStack {

    private Integer[] elements = new Integer[10]; //存储所有的元素
    private int size; //元素个数
    private Stack<Integer> stack = new Stack<>(); //作为辅助，存储min值
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        ensureCapacity(size + 1); //数组每次插入数据之前保证空间足够，否则可能出现内存溢出。
        elements[size++] = node;
        if (node <= min) {
            stack.push(node);
            min = stack.peek();
        } else {
            stack.push(min);
        }
    }

    private void ensureCapacity(int i) {
        int len = elements.length;
        if (len < size) {
            int newLen = (3 * len) / 2 + 1; //每次扩容让是 空间预分配策略
            elements = Arrays.copyOf(elements, newLen);
        }
    }

    public void pop() {
        Integer t = top();
        if (t != null) {
            elements[size - 1] = (Integer)null; //空间懒释放策略
            size--;
            stack.pop();
            min = stack.peek();
        }
    }

    public int top() {
        if (!empty()) {
            if (size >= 1) {
                return elements[size - 1];
            }
        }
        return (Integer)null;
    }

    private boolean empty() {
        return (size == 0);
    }

    public int min() {
        return min;
    }


    public boolean isPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < popA.length; i++) {
            if (!stack.empty() && popA[i] == stack.peek()) {
                stack.pop();
                continue;
            }
            while (j < pushA.length && popA[i] != pushA[j]) {
                stack.push(pushA[j]);
                j++;
            }
            if (j == pushA.length) {
                return false;
            }
            j++;
        }

        return true;
    }
}
