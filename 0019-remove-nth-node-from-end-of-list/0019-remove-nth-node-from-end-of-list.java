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


 // linked list ke question mein kewal pointer ka khel hai

 // tum galti pata hai kaha karoge, while dealiing with edge cases like first node ke saath ched chaad kari, ya last nod eke saath cheed chaad kari, ya (next) ko sahi se nahi use kiya toh stack overflow error aa gaya, koi node kisi galat node se jod di etc etc


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // find the size of list
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        // index from start
        int startIndex=count-n+1;
        if(startIndex==1)
        return head.next;
        temp=head;
        // go to respective position
        for(int i=1;i<startIndex-1;i++)
        {
            temp=temp.next;
        }
        // perform the deletion
        temp.next=temp.next.next;
        return head;
    }
}