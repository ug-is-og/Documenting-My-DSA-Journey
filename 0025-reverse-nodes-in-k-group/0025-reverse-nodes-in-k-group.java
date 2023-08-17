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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // count the nodes
        int count=0;
        ListNode temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        int arr[]=new int[count];
        temp=head;
        int p=0;
        while(temp!=null)
        {
            arr[p++]=temp.val;
            temp=temp.next;
        }
        // swap the values
        int m=count/k;
        int k1=0;
        for(int i=1;i<=m;i++) 
        {
            p=0;
            for(int j=k1;j<k1+(k)/2;j++) // bhai yeh kahan se kahan tak loop chalana hai ...please please bhot dhyan se dekhna, this can really mess you up, agar sahi nahi kiya toh
            {
                int temp1=arr[j];
                arr[j]=arr[k1+k-1-p];
                arr[k1+k-1-p]=temp1;
                p++;
            }
            k1=k1+k;
        }
        temp=head;
        for(int i=0;i<arr.length;i++)
        {
            temp.val=arr[i];
            temp=temp.next;
        }
        return head;
    }
}