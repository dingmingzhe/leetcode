package leetcode;

import com.alibaba.fastjson.JSON;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 *
 */
class ListNode{
     int val;
     ListNode next;

    public ListNode(int val) {
        this.val=val;
    }

}

public class _2AddTwoNumbers {


    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(2);
        l2.next=new ListNode(4);
        l2.next.next=new ListNode(3);
        ListNode listNode = addTwoNumbers(l1, l2);
        //这边得到结果是输出，一开始有点理解错题意

    }
    /**
     * 每一位相加/10
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cursor=result;
        int carrynum=0;
        while (l1!=null||l2!=null||carrynum!=0){
            int l1Val= l1!=null?l1.val:0;
            int l2Val= l2!=null?l2.val:0;
            int sumVal=l1Val+l2Val+carrynum;//第一个值+第二个值+进位数
            carrynum=sumVal/10;//进位数

            cursor.next = new ListNode(sumVal % 10);
            cursor = cursor.next;

            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }

        return result.next;
    }
}
