package org.example.lc;

import java.util.HashMap;

/**
 * 题目描述:给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * 解析:
 * 用这个举例：a b c d e f c g h，重复字符是 c。
 *
 * 官网答案：左指针指向 a，右指针指向 f 时，f 后面字符就是 c，即重复字符，这时开始收缩窗口，依次移动左指针，直到 d ，然后移动 右指针，即，左指针是依次移动。但 [a,f] 区间内已不可能有比该区间更长的字符串，左指针从 a 依次 移动到 d，中间的循环都无意义，可直接把左指针移动到 d，然后继续移动 右指针。
 *
 * 结论：缓存下每个字符及其位置，当出现重复字符时，直接左指针移动到重复字符的后一个位置，可理解为跳跃式收缩窗口，即可减少循环。
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String str){
        //定义一个滑动窗口,存放非重复的元素
        HashMap<Character,Integer> windowmap = new HashMap<>();
        //定义左,右指针--start,end
        int start = 0, max = 0;
        for (int end = 0; end < str.length(); end++) {
            Character ch = str.charAt(end);
            if (windowmap.containsKey(ch)){
                //发现有重复字符时，可以直接把左指针移动到第一个重复字符的下一个位置.不需要左指针依次移动
                start = Math.max(windowmap.get(ch) + 1,start);
            }
            //直接用map记下每个字符的索引，直接进行跳转
            windowmap.put(ch,end);
            max = Math.max(max,end - start + 1);
        }

        return  max;

    }

    public static void main(String[] args) {
        String str = "abcdafghemnca";

        System.out.println("不重复字符的最长字串的长度为: " + lengthOfLongestSubstring(str));
    }
}
