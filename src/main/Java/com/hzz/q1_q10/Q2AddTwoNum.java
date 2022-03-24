package com.hzz.q1_q10;

/**
 * User: hzz Date: 2022/3/21 Time: 上午9:20 Description: 
 *
 * 2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1： 2 --> 4 --> 3 5 --> 6 --> 4 --------------------- 7 --> 0 --> 8
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
 *
 *
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0] 输出：[0] 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内 0 <= Node.val <= 9 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q2AddTwoNum {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // 记录进位
    int carry = 0;
    // 开辟一块内存， 用于储存最终结果
    ListNode pre = new ListNode(0);
    // 创建临时变量 每次循环重新赋值next， 初始值与result指向同一块内存区域
    ListNode tmp = pre;

    // 只有 l1 l2 的next 都为null 且 进位为0 的时候才终止循环。
    while (l1 != null || l2 != null) {
      // 如果为空，则赋值为0
      int v1 = l1 == null ? 0 : l1.val;
      int v2 = l2 == null ? 0 : l2.val;

      //相同位数相加加上进位值
      int sum = v1 + v2 + carry;
      // 重新赋值进位
      carry = sum / 10;

      // 计算结果赋值
      tmp.next = new ListNode(sum % 10);
      // 将实例化好的tmp.next 重新赋值给tmp
      tmp = tmp.next;

      // 直至l1取到链表尾结点，则不在取next
      if (l1 != null) {
        l1 = l1.next;
      }
      // 直至l2取到链表尾结点，则不在取next
      if (l2 != null) {
        l2 = l2.next;
      }
    }

    // 循环结束， 将余数补位
    if (carry != 0) {
      tmp.next = new ListNode(carry);
    }

    return pre.next;
  }



  public static void main(String[] args) {
    ListNode l1 = new ListNode(9, new ListNode(9));
    ListNode l2 = new ListNode(9);
// 9999+9 = 10000+10-2 = 10000-2 = 10008
    ListNode listNode = addTwoNumbers(l1, l2);

    System.out.println(listNode.toString());

  }

}

class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }
}