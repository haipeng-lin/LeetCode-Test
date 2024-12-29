package com.peng.code;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/29 10:32
 * @Description 5-最长回文子串
 */

public class Fifth {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2){
            return s;
        }
        boolean[][] dp=new boolean[len][len];   // dp[i][j]：下标i到下标j的字符串是否为回文子串
        int max=1,begin=0;  // 最长回文子串的长度、起始值
        for(int i=0;i<len;i++){
            dp[i][i]=true;  // 单个字符为回文
        }
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false; // 字符i和字符j不相等，dp[i][j]不为回文子串
                }else if(j-i<3){
                    // 中间0字符、1字符，也为回文子串
                    dp[i][j]=true;
                }else{
                    dp[i][j]=dp[i+1][j-1];
                }
                if(dp[i][j] && j-i+1>max){
                    max=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+max);
    }
}
