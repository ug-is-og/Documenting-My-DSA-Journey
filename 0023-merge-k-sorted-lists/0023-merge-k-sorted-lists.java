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


// Extreme brute force is to either build a complete new array of size O(summation of list sizes) then sort it in O(nlogn) and after that build a new list 

// Same brute force can be implemented using min heap 

// leetCode 21- Merge 2 sorted lists TC: O(n+m)
// for this solution : TC : O(K*(summation of sizes))

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode ans=null;
//         for(int i=0;i<lists.length;i++)
//         {
//             ans=leetCode21(ans,lists[i]);
//         }
//         return ans;
//     }
//     public ListNode leetCode21(ListNode list1,ListNode list2)
//     {
//         if(list1!=null&&list2!=null)
//         {
//             if(list1.val<list2.val)
//             {
//                 list1.next=leetCode21(list1.next,list2);
//                 return list1;
//             }
//             else
//             {
//                 list2.next=leetCode21(list1,list2.next);
//                 return list2;
//             }
//         }
//         if(list1==null)
//         return list2;
//         return list1;
//     }
// }

// now an optimization to above approach is to use divide and conquer which will make TC : O((summation of sizes)*logK)

// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode ans=null;
//         if(lists.length==0)
//         return ans;
//         ans=helper(lists,0,lists.length-1);
//         return ans;
//     }
//     public ListNode helper(ListNode[] lists,int left,int right)
//     {
//         if(left==right)
//         {
//             return lists[left];
//         }
//         int mid=(left+right)/2;
//         ListNode leftList=helper(lists,left,mid);
//         ListNode rightList=helper(lists,mid+1,right);
//         return leetCode21(leftList,rightList);
//     }
//     public ListNode leetCode21(ListNode list1,ListNode list2)
//     {
//         if(list1!=null&&list2!=null)
//         {
//             if(list1.val<list2.val)
//             {
//                 list1.next=leetCode21(list1.next,list2);
//                 return list1;
//             }
//             else
//             {
//                 list2.next=leetCode21(list1,list2.next);
//                 return list2;
//             }
//         }
//         if(list1==null)
//         return list2;
//         return list1;
//     }
// }

// Now we'll see a O(summation*log k) solution using priority queue
// https://www.youtube.com/watch?v=E5WSILx1q0Q : Pepcoding's best solution

class Pair{
    int data;
    ListNode dataNode;
    int listIndex;
    public Pair(int data,ListNode dataNode,int listIndex)
    {
        this.data=data;
        this.dataNode=dataNode;
        this.listIndex=listIndex;
    }
}
public class ordering implements Comparator<Pair>{
    public int compare(Pair a,Pair b)
    {
        return a.data-b.data;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(new ordering());
        ListNode ans=null,tempNode=null,tail=null;
        // k elements dalo pehle heap mein
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            pq.add(new Pair(lists[i].val,lists[i],i));
        }
        while(!pq.isEmpty())
        {
            Pair temp=pq.remove();
            if(ans==null)
            {
                ans=new ListNode(temp.data);
                tail=ans;
            }
            else
            {
                tempNode=new ListNode(temp.data);
                tail.next=tempNode;
                tail=tempNode;
            }
            if(temp.dataNode.next!=null)
            {
                pq.add(new Pair(temp.dataNode.next.val,temp.dataNode.next,temp.listIndex));
            }
        }
        return ans;
    }
}
