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

// Took time bat bhot badhiya solution likha hai, keep it up
// go through all test cases like
// 1,1,1,2,3
// 1,1,1,2,2
// 4,1,1,2,3,3
// 2,2,2,1,3,3,4,5

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode prevNode=null,currNode=head,forNode=head.next;
        while(forNode!=null&&currNode!=null)
        {
            if(currNode.val==forNode.val)
            {
                while(currNode!=null&&currNode.val==forNode.val)
                {
                    if(head==currNode)
                    {
                        head=head.next;
                        prevNode=head;
                    }
                    currNode=currNode.next;
                }
                if(prevNode!=currNode)
                prevNode.next=currNode;
                if(currNode!=null)
                forNode=currNode.next;
            }
            else
            {
                prevNode=currNode;
                currNode=forNode;
                forNode=forNode.next;
            }
        }
        return head;
    }
}