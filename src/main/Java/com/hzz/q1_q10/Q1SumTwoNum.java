package com.hzz.q1_q10;

import java.util.HashMap;
import java.util.Map;

/**
 * User: hzz Date: 2022/3/18 Time: 下午4:02 Description:  1. 两数之和 给定一个整数数组 nums 和一个整数目标值
 * target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9 输出：[0,1] 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6 输出：[1,2] 示例 3：
 *
 * 输入：nums = [3,3], target = 6 输出：[0,1]  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104 -109 <= nums[i] <= 109 -109 <= target <= 109 只会存在一个有效答案
 *
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1SumTwoNum {


  /**
   * 双重循环基础版
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      for (int j = i + 1; j < length; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i;
          result[1] = j;
          return result;
        }
      }
    }
    return result;
  }

  /**
   * 采用HashMap  hash结构查询较快
   * 思路是一个k,v结构放入 k+v = target
   *
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum2(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int otherNum = target - nums[i];
      // 找到另一个值则返回
      if (map.containsKey(otherNum)) {
        result[0] = map.get(otherNum);
        result[1] = i;
        return result;
      }
      // 把当前数值当KEY，index当value
      map.put(nums[i], i);
    }
    return result;
  }


  public static void main(String[] args) {

    int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int target = 17;
    int[] sum = twoSum2(nums, target);
    System.out.println(sum[0] + ", " + sum[1]);

  }

}
