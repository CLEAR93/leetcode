package com.hzz.day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: hzz Date: 2022/3/21 Time: 下午3:32 Description: 
 *
 * 653. 两数之和 IV - 输入 BST
 *
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 *
 * 示例 1： 5 / \ 3   6 / \   \ 2   4   7 输入: root = [5,3,6,2,4,null,7], k = 9 输出: true
 *
 * 示例 2： 5 / \ 3   6 / \   \ 2   4   7 输入: root = [5,3,6,2,4,null,7], k = 28 输出: false  
 *
 * 提示:
 *
 * 二叉树的节点个数的范围是  [1, 104]. -104 <= Node.val <= 104 root 为二叉搜索树 -105 <= k <= 105
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day0322FindTarget {

  static  Set<Integer>  set = new HashSet<>();

  public static boolean findTarget(TreeNode root, int k) {

    if (root == null) {
      return false;
    }

    if (set.contains(root.val)) {
      return true;
    }
    set.add(k - root.val);

    return findTarget(root.left, k) || findTarget(root.right, k);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(5,
        new TreeNode(3, new TreeNode(2 ), new TreeNode(4)),
        new TreeNode(6, null, new TreeNode(7)));
    int target = 9;
    System.out.println(findTarget(root, 9));
  }

}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        ", left=" + left +
        ", right=" + right +
        '}';
  }
}
