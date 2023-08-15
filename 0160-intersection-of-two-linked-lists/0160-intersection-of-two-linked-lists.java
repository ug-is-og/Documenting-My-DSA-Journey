/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Brute force approach O(m*n)
// Works

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode temp=headA;
//         while(temp!=null)
//         {
//             ListNode temp1=headB;
//             while(temp1!=null)
//             {
//                 if(temp==temp1)
//                 return temp;
//                 temp1=temp1.next;
//             }
//             temp=temp.next;
//         }
//         return null;
//     }
// }

// another approach that we can use here is hashmap, store node references in hashmap for list a , now when you traverse list b just check whether node reference is present in hashmap
// means its the intersection point
// SC O(n) and TC O(m+n)

// Let's do a more optimized approach
// Yaar dimaag lagake O(m+n) mein kar toh diya hai but I am not sure ki yeh most optimized hai ya nahi, but badhiya approach sochi hai

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         // a1 to c3 distance find (a)
//         ListNode temp=headA;
//         int a=0;
//         while(temp!=null)
//         {
//             a++;
//             temp=temp.next;
//         }
//         // b1 to c3 distance find(b)
//         temp=headB;
//         int b=0;
//         while(temp!=null)
//         {
//             b++;
//             temp=temp.next;
//         }
//         // reverse the links of a1 to c3
//         ListNode prev=headA;
//         ListNode slow=headA.next;
//         prev.next=null;
//         while(slow!=null)
//         {
//             ListNode temp1=slow.next;
//             slow.next=prev;
//             prev=slow;
//             slow=temp1;
//         }
//         ListNode newHead=prev;
//         // b1 to a1 chale jao and find the distance (c)
//         int c=0;
//         temp=headB;
//         while(temp!=null)
//         {
//             c++;
//             temp=temp.next;
//         }
//         // b1 to b3 distance is 1/2(b+c-a)
//         int dist=(b+c-a)/2;
//         temp=headB;
//         for(int i=1;i<=dist;i++)
//         {
//             temp=temp.next;
//         }
//         // retain the original structure means reverse the links from a1 to c3 again
//         prev=newHead;
//         slow=newHead.next;
//         prev.next=null;
//         while(slow!=null)
//         {
//             ListNode temp1=slow.next;
//             slow.next=prev;
//             prev=slow;
//             slow=temp1;
//         }
//         newHead=prev;
//         // a1 to a2 distance from (a-(b-dist))
//         int dist1=a-(b-dist);
//         ListNode temp1=headA;
//         for(int i=1;i<=dist1;i++)
//         temp1=temp1.next;
//         if(temp==temp1)
//         return temp;
//         return null;
//     }
// }

// Let's do a better approach to solve this question

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         int countA=0;
//         ListNode tempA=headA;
//         // length of list A
//         while(tempA!=null)
//         {
//             countA++;
//             tempA=tempA.next;
//         }
//         int countB=0;
//         ListNode tempB=headB;
//         // length of list B
//         while(tempB!=null)
//         {
//             countB++;
//             tempB=tempB.next;
//         }
//         tempA=headA;
//         tempB=headB;
//         int diff=0;
//         if(countA>countB)
//         {
//             diff=countA-countB;
//             for(int i=1;i<=diff;i++)
//             tempA=tempA.next;
//         }
//         else
//         {
//             diff=countB-countA;
//             for(int i=1;i<=diff;i++)
//             tempB=tempB.next;
//         }
//         while(tempA!=tempB&&tempA!=null)
//         {
//             tempA=tempA.next;
//             tempB=tempB.next;
//         }
//         if(tempA==tempB)
//         return tempA;
//         return null;

//     }
// }

// Best approach for this question
// https://youtu.be/u4FWXfgS8jw
// samajh na aaye toh striver bhaiya ka solution dekh lena
// somewhat based on above approach but quite crisp and clean code

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b)
        {
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a;
    }
}