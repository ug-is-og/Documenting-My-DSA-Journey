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

// dekh ek toh brute approach aa ra samajh, ki matlab hashmap lelo, uski key mein nodes bhardena agar pehle se na ho toh aur true bhar dena as value, jaise hi containsKey true ho uss key ko return kar dena 
// TC O(n) and SC O(n)

// ek aur approach aa ri dimaag mein, ki nodes ki value ko Integer.min value karte jao agar pehle se na ho, and jaise hi kisi node ki value loop mein ghuste hi mi value ke equal mil jaaye tab usko return kardo, agar na mile cycle toh return null
// iss approach mein yeh dikkat hai ki linked list modify kar de rahe jo apne ko allowed nahi hai

// Striver bhaiya ne jo algo batayi hai yaad rakhna woh
// refer to this image for much more clarity
// https://drive.google.com/file/d/1TuxZyIrerACYtvm6z8b1bgHkdwv2Fph2/view?usp=sharing
// https://youtu.be/QfbOhn0WZ88

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        boolean found=false;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                found=true;
                break;
            }
        }
        if(found==false)
        return null;
        ListNode entry=head;
        while(entry!=slow)
        {
            slow=slow.next;
            entry=entry.next;
        }
        return entry;
    }
}