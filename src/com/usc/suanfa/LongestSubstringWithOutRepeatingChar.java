package com.usc.suanfa;

/**
 * Created by xuqiang on 2017/12/9.
 *
 * 在一个字符串中寻找没有重复字母的最长字串
 * 例如：abcabcbb 结果为abc
 * 滑动窗口思路
 */
public class LongestSubstringWithOutRepeatingChar {

    public static int lengthOfLongestSubstring(String s){
        int[] freq = new int[256];
        for (int i=0;i<freq.length;i++){
            freq[i] = 0;
        }
        int l=0,r=-1;
        int res = 0;

        while (l<s.length()){
            if(r+1<s.length() && freq[s.charAt(r+1)]==0){
                freq[s.charAt(++r)]++;
            }else {
                freq[s.charAt(l++)]--;
            }

            res = Math.max(res,r-l+1);
        }

        return res;
    }
}
