package com.peng.code.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author haipeng_lin
 * @Mailbox haipeng_lin@163.com
 * @Date 2025/1/2 16:23
 * @Description 复原IP地址-93
 */

public class RestoreIP {
    public List<String> restoreIpAddresses(String s) {
    List<String> ans=new ArrayList<>();
    if(s.length()>12 || s.length()<4){
        return ans;
    }
    StringBuffer path=new StringBuffer();
    back(ans,path,s,0,1);
    return ans;
}

// startIndex：从下标startIndex找；count：ip地址此时合法的有几个
public static void back(List<String> ans, StringBuffer path, String s, int startIndex, int count ){
    // 1、终止条件
    // 起始点到达末尾空，并且刚好找到四个合法整数
    if(startIndex == s.length() && count==5){
        ans.add(path.toString());
        return;
    }
    // 起始点到达末尾空，或者 已找到4个合法整数
    if(startIndex==s.length() || count>4){
        return;
    }
    // 2、从当前位置到+3
    for(int i=startIndex;i<startIndex+3 && i<s.length() ;i++){
        // 取出当前段
        String segment=s.substring(startIndex,i+1); // 左闭右开
        if( segment.startsWith("0") && segment.length()>1 ){
            // 前导0，非法
            continue;
        }
        if( Integer.parseInt(segment)>255){
            // 数字超过255，非法
            continue;
        }
        // 保留历史长度
        int len=path.length();
        if(count==4){
            // 最后一个，第4个，不用加.
            path.append(segment);
        }else{
            path.append(segment).append(".");
        }
        // 寻找下一个合法段
        back(ans,path,s,i+1,count+1);
        // 回溯
        path.setLength(len);
    }

}
}
