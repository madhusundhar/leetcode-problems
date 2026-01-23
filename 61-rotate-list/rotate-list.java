/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        ListNode temp;

        int len=0;
        temp=head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        k=k%len;
        if(k==0){
            return head;
        }
        int count=0;
        ListNode temp1;
        while(count<k){
            temp=head;
            temp1=head.next;
            while(temp.next.next!=null){
                temp=temp1;
                temp1=temp1.next;
            }
            temp1.next=head;
            temp.next=null;
            head=temp1;
            count++;
        }
        return head;
    }
}