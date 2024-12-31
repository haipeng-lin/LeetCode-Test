package com.peng.code.dynamicProgramming;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/31 23:23
 * @Description 买卖股票的最佳时机-123
 */

public class GuPiao3 {

    /**
     * 1、dp数组含义：dp[i][0]：第i天不持有股票的最大利润
     *              dp[i][1]：第i天股票第一次买入的最大利润
     *              dp[i][2]：第i天股票第一次卖出的最大利润
     *              dp[i][3]：第i天股票第二次买入的最大利润
     *              dp[i][4]：第i天股票第二次卖出的最大利润
     * 2、dp公式：dp[i][1]：前一天股票第一次买入股票的最大利润 和 前一天不持有股票的最大利润利润（减去）买入今天的股票 的最大值（因为一支股票可以买入买出多次）
     *          dp[i][2]：前一天股票第一次卖出股票的最大利润 和 前一天持有股票的最大利润（加）卖出今天的股票 的最大值
     * 3、初始化：第0天第一次买入、第二次买入股票：-prices[0]
     * 4、遍历顺序：从前往后
     */
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int[][] dp=new int[len][5];
        //4个状态：
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];
        for(int i=1;i<len;i++){
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[len-1][4];
    }
}
