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


// Newbie solution

// class Solution {
//     public ListNode sortList(ListNode head) {
//         ListNode newHead3=head;
//         if(head==null)
//         return newHead3;
//         if(head.next!=null)
//         {
//             ListNode slow=head,fast=head;
//             while(fast.next!=null&&fast.next.next!=null)
//             {
//                 slow=slow.next;
//                 fast=fast.next.next;
//             }
//             ListNode temp=slow.next;
//             slow.next=null;
//             ListNode newHead1=sortList(head);
//             ListNode newHead2=sortList(temp);
//             newHead3=mergeList(newHead1,newHead2);
//         }
//         return newHead3;
//     }
//     public ListNode mergeList(ListNode list1,ListNode list2)
//     {
        
//         // Recursive approach 

//          if(list1!=null&&list2!=null)
//         {
//             if(list1.val<list2.val)
//             {
//                 list1.next=mergeList(list1.next,list2);
//                 return list1;
//             }
//             else
//             {
//                 list2.next=mergeList(list1,list2.next);
//                 return list2;
//             }
//         }
//         if(list1==null)
//         return list2;
//         return list1;


//         // Iterative approach 
//         // iterative se toh bilkul mat karna bhot hi bekaar approach hai
        
//         // ListNode head3=null,tail3=null;
//         // if(head1.val<head2.val)
//         // {
//         //     head3=head1;
//         //     tail3=head1;
//         //     head1=head1.next;
//         // }
//         // else
//         // {
//         //     head3=head2;
//         //     tail3=head2;
//         //     head2=head2.next;
//         // }
//         // while(head1!=null&&head2!=null)
//         // {
//         //     if(head1.val<head2.val)
//         //     {
//         //         tail3.next=head1;
//         //         tail3=head1;
//         //         head1=head1.next;
//         //     }
//         //     else
//         //     {
//         //         tail3.next=head2;
//         //         tail3=head2;
//         //         head2=head2.next;
//         //     }
//         // }
//         // if(tail3.next==null&&head2!=null)
//         // {
//         //     tail3.next=head2;
//         //     tail3=head2;
//         // }
//         // if(tail3.next==null&&head1!=null)
//         // {
//         //     tail3.next=head1;
//         //     tail3=head1;
//         // }
//         // return head3;

//     }
// }




// Solution in 1 go

class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head)
    {
        if(head==null||head.next==null)
        return head;
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode head1=mergeSort(head);
        ListNode head2=mergeSort(temp);
        ListNode head3=merge(head1,head2);
        return head3;
    }
    public ListNode merge(ListNode head1,ListNode head2)
    {
        if(head1==null)
        return head2;
        if(head2==null)
        return head1;
        ListNode head3=null;
        if(head1.val<head2.val)
        {
            head3=head1;
            head1.next=merge(head1.next,head2);
        }
        else
        {
            head3=head2;
            head2.next=merge(head1,head2.next);
        }
        return head3;
    }
}







