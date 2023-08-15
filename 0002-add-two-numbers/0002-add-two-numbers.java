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
// class Solution {

    // first approach failed due to Integer.valueOf() problem

    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     String s1="",s2="";
    //     int ans=0;
    //     while(l1!=null)
    //     {
    //         s1=l1.val+s1;
    //         l1=l1.next;
    //     }
    //     // s1=l1.data+"";
    //     while(l2!=null)
    //     {
    //         s2=l2.val+s2;
    //         l2=l2.next;
    //     }
    //     // s2=l2.data+"";
    //     ans=Integer.valueOf(s1)+Integer.valueOf(s2);
    //     // now build a new list
    //     ListNode l3=null,pointer=null;
    //     int temp=0;
    //     System.out.println(ans);
    //     if(ans==0)
    //     {
    //         l3=new ListNode(0);
    //         return l3;
    //     }
    //     while(ans!=0)
    //     {
    //         temp=ans%10;
    //         if(l3==null)
    //         {
    //             l3=new ListNode(temp);
    //             pointer=l3;
    //         }
    //         else
    //         {
    //             ListNode newNode=new ListNode(temp);
    //             pointer.next=newNode;
    //             pointer=newNode;
    //         }
    //         ans=ans/10;
    //     }
    //     return l3;
    // }


    // second approach using array, since O(1) space mein ho jaega , kewal max 100 nodes ho sakte

    // ArrayList<Integer> first=new ArrayList<>();
    // ArrayList<Integer> second=new ArrayList<>();
    // while(l1!=null)
    // {
    //     first.add(l1.val);
    //     l1=l1.next;
    // }
    // while(l2!=null)
    // {
    //     second.add(l2.val);
    //     l2=l2.next;
    // }
    // int firstNum=0,secondNum=0;
    // for(int i=first.size()-1;i>=0;i--)
    // {
    //     firstNum=firstNum*10+first.get(i);
    // }
    // for(int j=second.size()-1;j>=0;j--)
    // {
    //     secondNum=secondNum*10+second.get(j);
    // }
    // int ans=firstNum+secondNum;

    // wait....wait....wait....
    // yeh bhi approach fail ho jayega coz tum int mein woh number nahi store kar paaoge, bhot bada number hai

    // final method using proper pointer

//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode l3=null,pointer=null;
//         int carry=0,ans=0;
//         while(l1!=null&&l2!=null)
//         {
//             ans=l1.val+l2.val+carry;
//             if(ans>9)
//             carry=1;
//             else
//             carry=0;
//             l1=l1.next;
//             l2=l2.next;
//             if(l3==null)
//             {
//                 l3=new ListNode(ans%10);
//                 pointer=l3;
//             }
//             else
//             {
//                 ListNode newNode=new ListNode(ans%10);
//                 pointer.next=newNode;
//                 pointer=newNode;
//             }
//         }
//         while(l1!=null)
//         {
//             ans=l1.val+carry;
//             if(ans>9)
//             carry=1;
//             else
//             carry=0;
//             ListNode tempNode=new ListNode(ans%10);
//             pointer.next=tempNode;
//             pointer=tempNode;
//             l1=l1.next;
//         }
//         while(l2!=null)
//         {
//             ans=l2.val+carry;
//             if(ans>9)
//             carry=1;
//             else
//             carry=0;
//             ListNode tempNode=new ListNode(ans%10);
//             pointer.next=tempNode;
//             pointer=tempNode;
//             l2=l2.next;
//         }
//         if(carry==1)
//         {
//             ListNode temp=new ListNode(1);
//             pointer.next=temp;
//             pointer=temp;
//         }
//         return l3;
//     }
// }

// upar wale code ko thoda sa clean karke likha hai bas
// ek while loop mein saara kaam nipta diya

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1,temp2=l2;
        int l1Data=0,l2Data=0;
        int carry=0;
        ListNode newHead=new ListNode(Integer.MIN_VALUE); // yeh ek smart move hai
        ListNode temp=newHead;
        while(l1!=null||l2!=null)
        {
            if(l1!=null)
            l1Data=l1.val;
            else
            l1Data=0;
            if(l2!=null)
            l2Data=l2.val;
            else
            l2Data=0;
            int sum=l1Data+l2Data+carry;
            ListNode newNode=null;
            if(sum>9)
            {
                carry=1;
                newNode=new ListNode(sum%10);
            }
            else
            {
                carry=0;
                newNode=new ListNode(sum);
            }
            temp.next=newNode;
            temp=newNode;
            if(l1!=null)
            l1=l1.next;
            if(l2!=null)
            l2=l2.next;
        }
        if(carry==1)
        temp.next=new ListNode(1);
        return newHead.next;
    }
}