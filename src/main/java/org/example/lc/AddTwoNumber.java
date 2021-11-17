package org.example.lc;

/**
 * 题目出自：https://leetcode-cn.com/problems/add-two-numbers/
 * 题目：给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *  * 输入：l1 = [2,4,3], l2 = [5,6,4]
 *  * 输出：[7,0,8]
 *  * 解释：342 + 465 = 807.
 *
 * 思路与算法
 *
 * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
 * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前两个链表处相应位置的数字为 n1,n2n1,n2，
 * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 0 。
 *
解法参考：
 https://leetcode-cn.com/problems/add-two-numbers/solution/jian-dan-yi-dong-javacpythonjs-pei-yang-y2w6g/
 */

class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class AddTwoNumber {
    public ListNode addTwoNumber(ListNode l1, ListNode l2){
        //空表头dummy，指向新的链表
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int total = x + y + carry;
            //curr指针域指向后面新的节点，起到链接作用
            curr.next = new ListNode(total % 10);
            carry = total/10;
            //指针继续后移
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        if(carry != 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;

    }
}
