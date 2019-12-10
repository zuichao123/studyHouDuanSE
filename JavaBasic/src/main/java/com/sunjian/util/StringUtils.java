package com.sunjian.util;

public class StringUtils {
    /**
     * 去掉字符串中的所有空格
     * @param str
     * @return
     */
    public static String trimAll(String str){
        StringBuilder sb = new StringBuilder();
        char[] strs = str.toCharArray();
        for(int i = 0; i<strs.length; i++){
            if(strs[i] == ' '){
                continue;
            }
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    /**
     * 字符串反转
     * @param str
     * @return
     */
    public static String reverse(String str){
        StringBuilder sb = new StringBuilder();
        char[] strs = str.toCharArray();
        for(int i=strs.length-1; i>=0; i--){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
