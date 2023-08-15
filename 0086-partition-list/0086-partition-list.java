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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1=new ListNode(Integer.MIN_VALUE);
        ListNode dummy2=new ListNode(Integer.MIN_VALUE);
        ListNode head1=dummy1,head2=dummy2;
        ListNode temp1=head1,temp2=head2;
        // yeh bhot important code section hai while loop wala
        // similar snippet hamne use kiya tha for segretating odd even nodes question
        // so keep in mind
        while(head!=null)
        {
            if(head.val<x)
            {
                temp1.next=head;
                temp1=temp1.next;
            }
            else
            {
                temp2.next=head;
                temp2=temp2.next;
            }
            head=head.next;
        }
        head2=head2.next;
        head1=head1.next;
        temp2.next=null;// yeh nahi karoge toh cycle aa sakti linked list mein
        if(temp1==dummy1) // yeh sochna bhot zaruri hai ki agar dono mein se ek bhi list khali hui ya dono hi list khali hui toh kya karoge
        return head2;
        temp1.next=head2;
        return head1;
    }
}