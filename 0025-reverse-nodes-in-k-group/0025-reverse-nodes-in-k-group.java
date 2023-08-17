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

// let's first try with brute force approach
// values ke saath chhed chaad + extra space for array use kar re

// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         // count the nodes
//         int count=0;
//         ListNode temp=head;
//         while(temp!=null)
//         {
//             temp=temp.next;
//             count++;
//         }
//         int arr[]=new int[count];
//         temp=head;
//         int p=0;
//         while(temp!=null)
//         {
//             arr[p++]=temp.val;
//             temp=temp.next;
//         }
//         // swap the values
//         int m=count/k;
//         int k1=0;
//         for(int i=1;i<=m;i++) 
//         {
//             p=0;
//             for(int j=k1;j<k1+(k)/2;j++) // bhai yeh kahan se kahan tak loop chalana hai ...please please bhot dhyan se dekhna, this can really mess you up, agar sahi nahi kiya toh
//             {
//                 int temp1=arr[j];
//                 arr[j]=arr[k1+k-1-p];
//                 arr[k1+k-1-p]=temp1;
//                 p++;
//             }
//             k1=k1+k;
//         }
//         temp=head;
//         for(int i=0;i<arr.length;i++)
//         {
//             temp.val=arr[i];
//             temp=temp.next;
//         }
//         return head;
//     }
// }

// Trying Striver's approach as an optimization for this problem
// very very important question, dry run along with Striver's video if you don't understand it in 1 go
// https://www.youtube.com/watch?v=Of0HPkk3JgI&t=1072s

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // count the nodes in Linked List
        int count=0;
        ListNode temp=head;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode prevNode=dummy,currNode=dummy,nextNode=dummy;
        while(count>=k)
        {
            currNode=prevNode.next;
            nextNode=currNode.next;
            for(int i=1;i<=k-1;i++)
            {
                currNode.next=nextNode.next;
                nextNode.next=prevNode.next;
                prevNode.next=nextNode;
                nextNode=currNode.next;
            }
            count=count-k;
            prevNode=currNode;

            // yeh dono statements mein yaha pe likh ra tha pehle and null pointer exception
            // aa gaya samjho kyun
            // 1,2,3,4,5 and k=3 hai toh currNode ek point pe null pe aayega bilkul last mein
            // matlab jab count<k ho gaya hai toh tum null.next kar re to find nexNode which 
            // iss liye upar jaake pehle condition check karenge uske baad karenge currNode, nextNode ko update

            // currNode=prevNode.next;
            // nextNode=currNode.next;
        }
        return dummy.next;
    }
}