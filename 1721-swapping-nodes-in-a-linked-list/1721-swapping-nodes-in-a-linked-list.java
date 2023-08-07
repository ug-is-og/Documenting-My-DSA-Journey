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

// bhot hi bekaar approach lagayi hai yahan pe, bas respective nodes ke pass jaake pehle dono values nikali hai 2 loops use karke uske baad, do loops firse use karke swapping kari hai

// sabse pehli bat toh question mein values swap karne ko bola tha , tumne sahi se padha nahi aur nodes swap karne ka sochte rahe start mein

// class Solution {
//     public ListNode swapNodes(ListNode head, int k) {
//         ListNode temp=head;
//         int count=0; // total nodes
//         while(temp!=null)
//         {
//             count++;
//             temp=temp.next;
//         }
//         temp=head;
//         int a=k,b=count-k+1;
//         int i=0;
//         while(i<a-1)
//         {
//             temp=temp.next;
//             i++;
//         }
//         int val1=temp.val;
//         temp=head;
//         i=0;
//         while(i<b-1)
//         {
//             temp=temp.next;
//             i++;
//         }
//         int val2=temp.val;
//         i=0;
//         temp=head;
//         while(i<a-1)
//         {
//             temp=temp.next;
//             i++;
//         }
//         temp.val=val2;
//         i=0;
//         temp=head;
//         while(i<b-1)
//         {
//             temp=temp.next;
//             i++;
//         }
//         temp.val=val1;
//         return head;
//     }
// }


// optimizing the approach

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // counting the nodes
        ListNode temp=head;
        int count=0; // total nodes
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        // i1 store kar ra chhota wala index and i2 store kar ra bada wala index
        int i1=0,i2=0;
        if(k>count/2) // yeh bhot dhyan se socho kyun kiya pehle yeh condition lagana bhul gaya tha and [90,100] k=2 pe error dene laga
        {
            i1=count-k+1;
            i2=k;
        }
        else
        {
            i1=k;
            i2=count-k+1;
        }
        // using slow and fast pointer approach
        ListNode slow=head;
        ListNode fast=head;
        // setting the fast pointer at its initial position
        for(int j=i1;j<i2;j++)
        {
            fast=fast.next;
        }
        // traversing the loop to bring both slow and fast at correct point
        for(int j=1;j<i1;j++) // yahan pehle k le rakha tha jab i1=k fix kar rakha tha
        // par baad mein realize kiya ki i1 k bhi ho sakta count-k+1 bhi kyunki i1 chhoti 
        // wali value store kar ra apne pas matlab mera slow node finally i1 position pe hoga
        // and fast node finally count-k+1 position pe hoga
        {
            slow=slow.next;
            fast=fast.next;
        }
        // swapping the values
        int bridge=slow.val;
        slow.val=fast.val;
        fast.val=bridge;
        return head;
    }
}