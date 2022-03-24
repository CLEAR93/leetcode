package com.hzz.q1_q10;

import java.util.HashMap;
import java.util.Map;

/**
 * User: hzz Date: 2022/3/21 Time: 下午4:47 Description: 
 *
 * 3. 无重复字符的最长子串
 *
 * 示例 1: 输入: s = "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2: 输入: s = "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3: 输入: s = "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。      请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。   提示：
 *
 * 0 <= s.length <= 5 * 104 s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q3LengthOfLongestSubstring {


  /**
   * 滑动窗口的形式，逐一移动右侧角标，发现重复移动左侧角标。
   *
   * @param s
   * @return
   */
  public static int lengthOfLongestSubstring(String s) {
    // 字符串为空，或者长度小于1 直接返回0
    if (s == null || s.length() < 1) {
      return 0;
    }
    // 转化为字符数组
    char[] c = s.toCharArray();
    // key: 字符   value：角标
    HashMap<Character, Integer> map = new HashMap<>();
    // 返回值 无重复字符的最长子串 长度
    int max = 0;
    // 滑动窗口 左侧角标
    int left = 0;

    for (int i = 0; i < c.length; i++) {
      // 发现重复字符
      if (map.containsKey(c[i])) {
        // 窗口左侧右移1个角标（ 将发生重复的字符移出窗口 ）
        left = Math.max(left, map.get(c[i]) + 1);
      }
      // 把字符与角标放入map，发生重复的话，会替换掉旧的角标
      map.put(c[i], i);
      // 计算当前字符长度，调整字符长度最大值
      max = Math.max(max, i - left + 1);
    }
    return max;
  }

  public static void main(String[] args) {
    String str = "abccba"; // 01234012345
    System.out.println(lengthOfLongestSubstring(str));
  }

}
