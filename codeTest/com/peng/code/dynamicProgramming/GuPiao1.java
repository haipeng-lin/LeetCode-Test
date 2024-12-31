package com.peng.code.dynamicProgramming;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/31 23:13
 * @Description 买卖股票的最佳时机-121
 */

public class GuPiao1 {

    /**
     * 1、dp数组含义：dp[i][0]，第i天持有股票的最大利润；dp[i][1]，第i天不持有股票的最大利润
     * 2、dp公式：dp[i][0]：前一天持有股票的最大利润 和 买入今天的股票 的最大值（因为同一支股票只能买入买出一次）
     *          dp[i][1]：前一天不持有股票的最大利润 和 前一天持有股票的最大利润（加）卖出今天的股票 的最大值
     * 3、初始化：第0天持有股票：-prices[0]；第0天不持有股票为0
     * 4、遍历顺序：从前往后
     */
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int[][] dp=new int[prices.length][2];
        dp[0][0]-=prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
