package com.peng.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2024/12/27 23:33
 * @Description 3-无重复字符的最长子串
 */

public class OneTh {

    public int lengthOfLongestSubstring(String s) {
        int i=0;    // 窗口左侧
        int maxLength=Integer.MIN_VALUE;
        int len=s.length();
        if(len==0){
            return 0;
        }
        Map<Character,Integer> hashMap=new HashMap<>();
        for(int j=0;j<len;j++){
            Character ch=s.charAt(j);
            if(hashMap.containsKey(ch)){
                i=Math.max(i,hashMap.get(ch)+1); // 窗口左侧取最大值：左侧原来值、重复字符的下一位
            }
            hashMap.put(ch,j);
            maxLength=Math.max(maxLength,j-i+1);
        }
        return maxLength;
    }
}
