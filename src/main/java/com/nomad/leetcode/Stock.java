package com.nomad.leetcode;

/**
 * @author nomad
 * @create 2020-08-25 10:47 PM
 * 股票的最佳买卖时机  原则：低买高抛
 * leetcode 121-123
 */
public class Stock {
    public static void main(String[] args) {
        System.out.println(new Stock().maxProfit2(new int[]{1,2,3,4,5}));
    }

    /**
     * 最多一笔交易，即一次买卖
     * 最大高度差
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int i = 0; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]); //买入状态（本金0, 类似涉账） 绝对值尽可能小 低买
            sell = Math.max(sell, prices[i] + buy); //卖出状态（净收益） 高抛
        }
        return sell;
    }

    /**
     * 可以依次多笔交易
     */
    public int maxProfit2(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int i = 0; i < prices.length; i++) {
            buy = Math.max( buy,sell - prices[i]); //因为可以是多次买卖，所以买入状态sell - prices[i]
            sell = Math.max(sell, prices[i] + buy);
        }
        return sell;
    }

    /**
     * 最多2笔交易
     * 4种（2对）状态
     */
    public int maxProfit3(int[] prices) {
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for(int i = 0; i < prices.length; i++) {
            fstBuy = Math.max(fstBuy, -prices[i]); //第一次买入状态
            fstSell = Math.max(fstSell, fstBuy + prices[i]); //第一次卖出状态
            secBuy = Math.max(secBuy, fstSell -  prices[i]); //第二次买入状态
            secSell = Math.max(secSell, secBuy +  prices[i]); //第二次卖出状态
        }
        return secSell;
    }
}
