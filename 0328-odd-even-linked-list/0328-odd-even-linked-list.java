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

// bohot hi badhiya bhaii, time laga par khudse build karli approach
// iss approach mein hamne values swap karke kaam nikala hai, actual node nahi chedhi

// class Solution {
//     public ListNode oddEvenList(ListNode head) {
//         ListNode prev=head,curr=head;
//         while(curr!=null&&curr.next!=null&&curr.next.next!=null)
//         {
//             prev=prev.next;
//             curr=curr.next.next;
//             int prevData=prev.val;
//             int currData=curr.val;
//             ListNode temp=prev;
//             while(temp!=curr)
//             {
//                 int tempData=temp.next.val;
//                 temp.next.val=prevData;
//                 prevData=tempData;
//                 temp=temp.next;
//             }
//             prev.val=currData;
//         }
//         return head;
//     }
// }

// another approach jisme ham nodes ko pura pura chhedenge

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
        return head;
        ListNode oddHead=head;
        ListNode evenHead=head.next;
        ListNode semi=head.next;
        ListNode traverse=evenHead.next;
        int index=0;
        while(traverse!=null)
        {
            if(index%2==0)
            {
                oddHead.next=traverse;
                oddHead=traverse;
            }
            else
            {
                evenHead.next=traverse;
                evenHead=traverse;
            }
            traverse=traverse.next;
            index++;
        }
        oddHead.next=semi;
        evenHead.next=null;
        return head;
    }
}