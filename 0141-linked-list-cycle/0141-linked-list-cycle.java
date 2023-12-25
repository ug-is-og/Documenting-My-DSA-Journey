/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// first approach that came to my mind
// O(n) Tc and O(n) space
// ek cheez yeh dhyan dena ki SC is O(n) for both list and hashmap but the thing is 
// hashmap ke containsKey ki complexity is O(1) in averag case but list ke case mein O(n) ki
// complexity hai for contains() operation, it performs linear search

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         List<ListNode> visited=new ArrayList();
//         ListNode temp=head;
//         while(temp!=null)
//         {
//             if(!visited.contains(temp))
//             visited.add(temp);
//             else
//             return true;
//             temp=temp.next;
//         }
//         return false;
//     }
// }

// let's optimize this approach further
// since we are given that the number of nodes can be maximum of 10000, toh agar ek loop counter rakh le and agar woh 10,000 se zaada baar chal gaya matlab cycle hai
// kar toh diya O(1) space mein and O(n) TC mein

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode temp=head;
//         int count=0;
//         while(temp!=null)
//         {
//             if(count>10000)
//             return true;
//             temp=temp.next;
//             count++;
//         }
//         return false;
//     }
// }

// there is still a limitation in the above approach, aur woh yeh hai ki 
// kaafi naive si approach hai matlab tumhe question mein bola tha 10000 nodes
// toh tumne uske basis pe apna code likha, yeh galat baat hai, tumhara code universal
// hona chahiye, shouldn't depend on no of nodes given in question

// slow , fast pointer approach told by striver
// agar slow and fast never collide, toh cycle doesn't exist, if slow, fast collide cycle exists
// https://youtu.be/354J83hX7RI

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         if(head==null||head.next==null) // number of nodes kya hai uske basis pe kya kya
//         // edge cases ban sakte dhyan se soch liya karo
//         return false;
//         ListNode slow=head;
//         ListNode fast=head.next.next;
//         while(fast!=null&&fast.next!=null) // pehli condition false ho gayi toh agli condition
//         // check hi nahi hogi, this is the importance of order here
//         {
//             if(slow==fast)
//             return true;
//             slow=slow.next;
//             fast=fast.next.next;
//         }
//         return false;
//     }
// }


// upar wali approach ko thoda sa aur optimize karenge bas ham

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode slow=head;
//         ListNode fast=head;
//         while(fast!=null&&fast.next!=null) // pehli condition false ho gayi toh agli condition
//         // check hi nahi hogi, this is the importance of order here
//         {
//             slow=slow.next;
//             fast=fast.next.next;
//             if(slow==fast) // yeh condition just upar likhne mein dikkat thi kyunki loop mein ghuste hi condition true ho ja ri bina traverse kare ...pehle aur usko
//             // sahi karne ke chakkar mein aur zaada complications kar di thi humne
//             return true;
//         }
//         return false;
//     }
// }

















public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
            {
                return true;
            }
        }
        return false;
    }
}